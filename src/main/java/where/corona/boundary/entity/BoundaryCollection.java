package where.corona.boundary.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "features"
})
public class BoundaryCollection {

    @JsonProperty("type")
    private String type;
    @JsonProperty("features")
    private List<Boundary> features = null;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("features")
    public List<Boundary> getFeatures() {
        return features;
    }

    @JsonProperty("features")
    public void setFeatures(List<Boundary> features) {
        this.features = features;
    }
}