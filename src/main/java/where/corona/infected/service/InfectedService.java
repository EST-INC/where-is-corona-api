package where.corona.infected.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import where.corona.infected.model.entity.Infected;
import where.corona.infected.model.vo.InfectedVo;
import where.corona.infected.repository.InfectedRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InfectedService {

    private final InfectedRepository infectedRepository;

    public List<Infected> getInfectedBoundaries() {
        return infectedRepository.findAll();
    }

    public Infected updateInfectedBoundary(InfectedVo infectedVo) {

        return infectedRepository.insert(Infected.builder()
                .boundaryId(infectedVo.getBoundaryId())
                .boudaryName(infectedVo.getBoudaryName())
                .build());
    }
}
