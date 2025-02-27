package uz.uzumintegrationexample.domain.uzum.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.uzumintegrationexample.domain.uzum.model.Param;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateRequest {
    private String serviceId;
    private String transId;
    private Param params;
    private Long amount;
}
