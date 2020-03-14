package where.corona.infected.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class InfectedVo {

    private String boundaryId;
    private Integer infectedPeople;
}
