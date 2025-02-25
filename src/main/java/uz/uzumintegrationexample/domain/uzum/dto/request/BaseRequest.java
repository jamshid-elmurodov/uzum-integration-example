package uz.uzumintegrationexample.domain.uzum.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseRequest {
    private String serviceId;
    private String transId;
}
