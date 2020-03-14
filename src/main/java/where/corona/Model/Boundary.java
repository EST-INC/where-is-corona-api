package where.corona.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Properties;

@Data
public class Boundary {

    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("properties")
    private Properties properties;
}