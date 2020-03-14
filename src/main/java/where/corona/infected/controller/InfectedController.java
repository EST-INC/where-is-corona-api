package where.corona.infected.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import where.corona.infected.model.entity.Infected;
import where.corona.infected.model.vo.InfectedVo;
import where.corona.infected.model.vo.TotalStatistics;
import where.corona.infected.service.InfectedService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/infection")
public class InfectedController {

    private final InfectedService infectedService;

    @GetMapping
    public ResponseEntity<List<TotalStatistics>> getStatisticsForAllBoundaries() {
        return ResponseEntity.ok(infectedService.getStatisticsForAllBoundaries());
    }

    @GetMapping("/{boundaryId}")
    public ResponseEntity<TotalStatistics> getInfectionsForBoundary(@PathVariable Integer boundaryId) {
        return ResponseEntity.ok(infectedService.getTotalInfectedDataForBoundary(boundaryId));
    }

    @PostMapping
    public ResponseEntity<Infected> updateInfectedData(@RequestBody @Valid InfectedVo infectedVo) {
        return ResponseEntity.ok(infectedService.updateInfectedBoundary(infectedVo));
    }
}
