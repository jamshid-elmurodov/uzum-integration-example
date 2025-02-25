package uz.uzumintegrationexample.domain.uzum.dto.response;

import lombok.*;
import uz.uzumintegrationexample.domain.uzum.dto.request.BaseRequest;
import uz.uzumintegrationexample.domain.uzum.enums.UzumStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatusResponse {
    private String serviceId;
    private String transId;
    private UzumStatus status;
    private String transTime;

    public static StatusResponse from(BaseRequest request, String createTime) {
        return StatusResponse.builder()
                .serviceId(request.getServiceId())
                .transId(request.getTransId())
                .status(UzumStatus.CONFIRMED)
                .transTime(createTime)
                .build();
    }
}
