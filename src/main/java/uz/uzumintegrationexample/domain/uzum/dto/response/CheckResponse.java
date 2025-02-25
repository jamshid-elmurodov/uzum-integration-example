package uz.uzumintegrationexample.domain.uzum.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.uzumintegrationexample.domain.uzum.enums.UzumStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CheckResponse {
    private String serviceId;
    private String timestamp;
    private UzumStatus status;
}
