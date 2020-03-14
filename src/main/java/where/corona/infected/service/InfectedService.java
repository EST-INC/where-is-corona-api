package where.corona.infected.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import where.corona.boundary.repository.BoundaryRepository;
import where.corona.infected.model.entity.Infected;
import where.corona.infected.model.vo.InfectedVo;
import where.corona.infected.model.vo.TotalStatistics;
import where.corona.infected.repository.InfectedRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InfectedService {

    private final InfectedRepository infectedRepository;
    private final BoundaryRepository boundaryRepository;

    public List<Infected> getInfectedBoundaries() {
        return infectedRepository.findAll();
    }

    public TotalStatistics getTotalInfectedDataForBoundary(Integer boundaryId) {
        List<Infected> infectionsForBoundary = infectedRepository.findByBoundaryId(boundaryId);
        TotalStatistics totalStatistics = new TotalStatistics(boundaryId);

        infectionsForBoundary.forEach(infected -> {
            totalStatistics.addTotalInfectedPeople(infected.getInfectedPeople());
            totalStatistics.addTotalDeadPeople(infected.getDeadPeople());
            totalStatistics.addTotalRecoveredPeople(infected.getRecoveredPeople());
        });
        return totalStatistics;
    }

    public List<TotalStatistics> getStatisticsForAllBoundaries() {
        List<TotalStatistics> statistics = new ArrayList<>();
        List<Integer> boundaryIds = boundaryRepository.findAll().stream()
            .map(boundary -> boundary.getProperties().getId())
            .collect(Collectors.toList());

        Map<Integer, List<Infected>> infecteds = infectedRepository.findByBoundaryIdIn(boundaryIds).stream()
            .collect(Collectors.groupingBy(Infected::getBoundaryId, Collectors.toList()));
        infecteds.forEach((boundaryId, infection) -> statistics.add(getTotalInfectedDataForBoundary(
            boundaryId,
            infection
        )));
        return statistics;
    }

    private TotalStatistics getTotalInfectedDataForBoundary(Integer boundaryId, List<Infected> infections) {
        TotalStatistics totalStatistics = new TotalStatistics(boundaryId);

        infections.forEach(infected -> {
            totalStatistics.addTotalInfectedPeople(infected.getInfectedPeople());
            totalStatistics.addTotalDeadPeople(infected.getDeadPeople());
            totalStatistics.addTotalRecoveredPeople(infected.getRecoveredPeople());
        });
        return totalStatistics;
    }

    public Infected updateInfectedBoundary(InfectedVo infectedVo) {
        return infectedRepository.insert(createInfectedPeopleData(infectedVo));
    }

    private Infected createInfectedPeopleData(final InfectedVo infectedVo) {
        Infected infected = new Infected();
        infected.setInfectedPeople(calculatePeopleValue(infectedVo.getInfectedPeople()));
        infected.setRecoveredPeople(calculatePeopleValue(infectedVo.getRecoveredPeople()));
        infected.setDeadPeople(calculatePeopleValue(infectedVo.getDeadPeople()));
        infected.setBoundaryId(infectedVo.getBoundaryId());
        return infected;
    }

    private Integer calculatePeopleValue(Integer fromVO) {
        return fromVO == null ? 0 : fromVO;
    }
}
