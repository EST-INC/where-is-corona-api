package where.corona.infected.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Builder
@Getter
@Document
public class Infected {
    @Id
    private String id;
    private String boundaryId;
    private String boudaryName;
}
