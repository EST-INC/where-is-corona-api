package where.corona.infected.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import where.corona.infected.model.entity.Infected;
import where.corona.infected.model.vo.InfectedVo;
import where.corona.infected.repository.InfectedRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InfectedService {

    private final InfectedRepository infectedRepository;

    public List<Infected> getInfectedBoundaries() {
        return infectedRepository.findAll();
    }

    public Infected updateInfectedBoundary(InfectedVo infectedVo) {
        Optional<Infected> infectedOptional = infectedRepository.findByBoundaryId(infectedVo.getBoundaryId());
        if (infectedOptional.isPresent()) {
            Infected infected = updateInfectedPeopleData(infectedVo, infectedOptional.get());
            return infectedRepository.save(infected);
        } else {
            return infectedRepository.insert(createInfectedPeopleData(infectedVo));
        }
    }

    private Infected updateInfectedPeopleData(final InfectedVo infectedVo, final Infected infected) {
        infected.setInfectedPeople(calculatePeopleValue(
            infected.getInfectedPeople(),
            infectedVo.getInfectedPeople()
        ));
        infected.setRecoveredPeople(calculatePeopleValue(
            infected.getRecoveredPeople(),
            infectedVo.getRecoveredPeople()
        ));
        infected.setDeadPeople(calculatePeopleValue(
            infected.getDeadPeople(),
            infectedVo.getDeadPeople()
        ));
        return infected;
    }

    private Infected createInfectedPeopleData(final InfectedVo infectedVo) {
        int defaultPeopleValue = 0;
        Infected infected = new Infected();
        infected.setInfectedPeople(calculatePeopleValue(
            defaultPeopleValue,
            infectedVo.getInfectedPeople()
        ));
        infected.setRecoveredPeople(calculatePeopleValue(
            defaultPeopleValue,
            infectedVo.getRecoveredPeople()
        ));
        infected.setDeadPeople(calculatePeopleValue(
            defaultPeopleValue,
            infectedVo.getDeadPeople()
        ));
        infected.setBoundaryId(infectedVo.getBoundaryId());
        return infected;
    }

    private Integer calculatePeopleValue(Integer fromInfected, Integer fromVO) {
        return fromVO == null ? fromInfected : fromInfected + fromVO;
    }
}
