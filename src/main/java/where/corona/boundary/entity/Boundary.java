package where.corona.boundary.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Properties;

@Data
@Builder
@AllArgsConstructor
@Document
public class Boundary {

    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    @Id
    private Integer id;
    @JsonProperty("properties")
    private Properties properties;
}