package where.corona.infected.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class InfectedVo {

    @NotNull
    private Integer boundaryId;
    private Integer infectedPeople;
    private Integer recoveredPeople;
    private Integer deadPeople;
}
