package uz.uzumintegrationexample.domain.uzum.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.uzumintegrationexample.domain.uzum.dto.response.CreateResponse;
import uz.uzumintegrationexample.domain.uzum.model.Param;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateRequest {
    private String serviceId;
    private String transId;
    private Param params;
    private Long amount;
}
