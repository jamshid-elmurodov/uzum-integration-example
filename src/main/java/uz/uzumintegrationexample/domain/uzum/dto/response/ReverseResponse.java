package uz.uzumintegrationexample.domain.uzum.dto.response;

import lombok.*;
import uz.uzumintegrationexample.domain.uzum.dto.request.BaseRequest;
import uz.uzumintegrationexample.domain.uzum.enums.UzumStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReverseResponse {
    private String serviceId;
    private String transId;
    private UzumStatus status;
    private Long amount;
    private String reverseTime;

    public static ReverseResponse from(BaseRequest request, Long amount) {
        return ReverseResponse.builder()
                .serviceId(request.getServiceId())
                .transId(request.getTransId())
                .status(UzumStatus.REVERSED)
                .amount(amount)
                .reverseTime(System.currentTimeMillis() + "")
                .build();
    }
}
