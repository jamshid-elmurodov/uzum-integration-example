package uz.uzumintegrationexample.domain.uzum.dto.response;

import lombok.*;
import uz.uzumintegrationexample.domain.uzum.dto.request.BaseRequest;
import uz.uzumintegrationexample.domain.uzum.enums.UzumStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConfirmResponse {
    private String serviceId;
    private String transId;
    private UzumStatus status;
    private Long amount;
    private String confirmTime;

    public static ConfirmResponse from(BaseRequest request, Long amount) {
        return ConfirmResponse.builder()
                .serviceId(request.getServiceId())
                .transId(request.getTransId())
                .status(UzumStatus.CONFIRMED)
                .amount(amount)
                .confirmTime(System.currentTimeMillis() + "")
                .build();
    }
}
