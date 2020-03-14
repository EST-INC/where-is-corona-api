package where.corona.boundary.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import where.corona.boundary.entity.Boundary;
import where.corona.boundary.service.BoundaryService;

import java.util.List;

@RestController
@RequestMapping("/api/boundaries")
@RequiredArgsConstructor
public class BoundaryController {

    private final BoundaryService boundaryService;

    @GetMapping
    public ResponseEntity<List<Boundary>> getBoundaries() {
        return ResponseEntity.ok(boundaryService.getAllBoundaries());
    }
}
