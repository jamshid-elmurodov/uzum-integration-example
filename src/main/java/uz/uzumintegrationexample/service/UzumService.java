package uz.uzumintegrationexample.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.uzumintegrationexample.domain.entity.Order;
import uz.uzumintegrationexample.domain.entity.UzumTransaction;
import uz.uzumintegrationexample.domain.enums.OrderStatus;
import uz.uzumintegrationexample.domain.enums.TransactionState;
import uz.uzumintegrationexample.domain.uzum.dto.request.BaseRequest;
import uz.uzumintegrationexample.domain.uzum.dto.request.CheckRequest;
import uz.uzumintegrationexample.domain.uzum.dto.request.CreateRequest;
import uz.uzumintegrationexample.domain.uzum.dto.response.*;
import uz.uzumintegrationexample.domain.uzum.enums.UzumStatus;
import uz.uzumintegrationexample.domain.uzum.exception.UzumException;
import uz.uzumintegrationexample.repo.UzumTransactionRepository;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UzumService {
    private final OrderService orderService;
    private final UzumTransactionRepository uzumTransactionRepository;

    public CheckResponse check(CheckRequest request){
        getOrder(request.getParams().getOrderId());

        return CheckResponse.from(request);
    }

    public CreateResponse create(CreateRequest request){
        Order order = getOrder(request.getParams().getOrderId());

        if (!Objects.equals(request.getAmount(), order.getProduct().getPrice())){
            throw new UzumException("ErrorCheckingPaymentData");
        }

        uzumTransactionRepository.save(
                UzumTransaction.from(request)
        );

        return CreateResponse.from(request);
    }

    public ConfirmResponse confirm(BaseRequest request){
        UzumTransaction transaction = getTransaction(request.getTransId());

        if (transaction.getState() != TransactionState.PENDING){
            throw new UzumException("TransactionAlreadyConfirmed");
        }

        transaction.setState(TransactionState.CONFIRMED);
        transaction.setConfirmTime(System.currentTimeMillis() + "");
        uzumTransactionRepository.save(transaction);

        // bu yerda transactionni statusini CONFIRMED qilingandan keyingi sizning logikangiz bo'ladi
        orderService.updateOrderStatus(transaction.getOrderId(), OrderStatus.COMPLETED);

        return ConfirmResponse.from(request, transaction.getAmount());
    }

    public ReverseResponse reverse(BaseRequest request){
        UzumTransaction transaction = getTransaction(request.getTransId());

        transaction.setState(TransactionState.REVERSED);
        transaction.setReverseTime(System.currentTimeMillis() + "");
        uzumTransactionRepository.save(transaction);

        // bu yerda transactionni statusini REVERSED qilingandan keyingi sizning logikangiz bo'ladi
        orderService.updateOrderStatus(transaction.getOrderId(), OrderStatus.CANCELED);

        return ReverseResponse.from(request, transaction.getAmount());
    }

    public StatusResponse status(BaseRequest request){
        UzumTransaction transaction = getTransaction(request.getTransId());

        return StatusResponse.from(request, transaction.getCreateTime());
    }

    private UzumTransaction getTransaction(String transId) {
        UzumTransaction transaction = uzumTransactionRepository.findById(transId).orElse(null);

        if (transaction == null){
            throw new UzumException("TransactionNotFound");
        }

        return transaction;
    }

    private Order getOrder(Long orderId){
        Order order = orderService.getOrder(orderId);

        if (order == null){
            throw new UzumException("ErrorCheckingPaymentData");
        }

        return order;
    }
}
