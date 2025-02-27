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
public class CheckRequest {
    private String serviceId;
    private Param params;
}
