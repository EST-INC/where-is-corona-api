package where.corona.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BoundaryProperties {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nazwa")
    private String nazwa;
}