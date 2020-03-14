package where.corona.infected.model.vo;

import lombok.Getter;

@Getter
public class TotalStatistics {

    private Integer totalInfectedPeople;
    private Integer totalRecoveredPeople;
    private Integer totalDeadPeople;
    private Integer boundaryId;

    public TotalStatistics(Integer boundaryId) {
        this.totalInfectedPeople = 0;
        this.totalDeadPeople = 0;
        this.totalRecoveredPeople = 0;
        this.boundaryId = boundaryId;
    }

    public void addTotalInfectedPeople(Integer value) {
        this.totalInfectedPeople += value;
    }

    public void addTotalRecoveredPeople(Integer value) {
        this.totalRecoveredPeople += value;
    }

    public void addTotalDeadPeople(Integer value) {
        this.totalDeadPeople += value;
    }
}
