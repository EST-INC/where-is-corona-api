package where.corona.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BoundaryCollection {

    @JsonProperty("features")
    private List<Boundary> features;
}