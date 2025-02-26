package uz.uzumintegrationexample.domain.uzum.dto.response;

import lombok.*;
import uz.uzumintegrationexample.domain.uzum.dto.request.CheckRequest;
import uz.uzumintegrationexample.domain.uzum.enums.UzumStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CheckResponse {
    private String serviceId;
    private String timestamp;
    private UzumStatus status;

    public static CheckResponse from(CheckRequest request) {
        return CheckResponse.builder()
                .serviceId(request.getServiceId())
                .timestamp(System.currentTimeMillis() + "")
                .status(UzumStatus.CONFIRMED)
                .build();
    }
}
