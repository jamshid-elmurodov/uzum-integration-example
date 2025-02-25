package uz.uzumintegrationexample.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import uz.uzumintegrationexample.domain.enums.TransactionState;
import uz.uzumintegrationexample.domain.uzum.dto.request.CreateRequest;

@Entity(name = "uzum_transactions")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UzumTransaction {
    @Id
    private String id;

    private Long orderId;

    private Long amount;

    private TransactionState state;

    private String createTime;

    private String confirmTime;

    private String reverseTime;

    public static UzumTransaction from(CreateRequest request) {
        return UzumTransaction.builder()
                .id(request.getTransId())
                .orderId(request.getParams().getOrderId())
                .amount(request.getAmount())
                .state(TransactionState.PENDING)
                .createTime(System.currentTimeMillis() + "")
                .build();
    }
}
