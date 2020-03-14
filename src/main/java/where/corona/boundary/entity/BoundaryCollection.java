package where.corona.boundary.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
public class BoundaryCollection {

    @JsonProperty("features")
    private List<Boundary> features;
}