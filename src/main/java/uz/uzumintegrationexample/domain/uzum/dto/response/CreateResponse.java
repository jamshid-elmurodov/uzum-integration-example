package uz.uzumintegrationexample.domain.uzum.dto.response;

import lombok.*;
import uz.uzumintegrationexample.domain.uzum.dto.request.CreateRequest;
import uz.uzumintegrationexample.domain.uzum.enums.UzumStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateResponse {
    private String serviceId;
    private String timestamp;
    private UzumStatus status;
    private String transTime;
    private Long amount;
    private String transId;

    public static CreateResponse from(CreateRequest request) {
        return CreateResponse.builder()
                .serviceId(request.getServiceId())
                .timestamp(System.currentTimeMillis() + "")
                .status(UzumStatus.CREATED)
                .transTime(System.currentTimeMillis() + "")
                .amount(request.getAmount())
                .transId(request.getTransId())
                .build();
    }
}
