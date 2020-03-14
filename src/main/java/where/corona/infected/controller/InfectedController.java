package where.corona.infected.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import where.corona.infected.model.entity.Infected;
import where.corona.infected.model.vo.InfectedVo;
import where.corona.infected.service.InfectedService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/infection")
public class InfectedController {

    private final InfectedService infectedService;

    @GetMapping
    public ResponseEntity<List<Infected>> getInfectedBoundaries() {
        return ResponseEntity.ok(infectedService.getInfectedBoundaries());
    }

    @PostMapping
    public ResponseEntity<Infected> updateInfectedData(@RequestBody @Valid InfectedVo infectedVo) {
        return ResponseEntity.ok(infectedService.updateInfectedBoundary(infectedVo));
    }

}
