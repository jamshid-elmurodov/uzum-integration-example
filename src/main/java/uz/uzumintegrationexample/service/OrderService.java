package uz.uzumintegrationexample.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.uzumintegrationexample.domain.entity.Order;
import uz.uzumintegrationexample.domain.enums.OrderStatus;
import uz.uzumintegrationexample.repo.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public void updateOrderStatus(Long orderId, OrderStatus orderStatus) {
        Order order = getOrder(orderId);

        if (order == null) {
            return;
        }

        order.setStatus(orderStatus);
        orderRepository.save(order);
    }
}
