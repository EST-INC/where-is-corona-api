package where.corona.boundary.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "nazwa"
})
public class BoundaryProperties {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nazwa")
    private String nazwa;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("nazwa")
    public String getNazwa() {
        return nazwa;
    }

    @JsonProperty("nazwa")
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}