package where.corona.boundary.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class BoundaryProperties {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nazwa")
    private String nazwa;
}