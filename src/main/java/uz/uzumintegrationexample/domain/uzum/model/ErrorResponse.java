package uz.uzumintegrationexample.domain.uzum.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.uzumintegrationexample.domain.uzum.enums.UzumStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String serviceId;
    private String timestamp;
    private UzumStatus status;
    private String errorCode;
}
