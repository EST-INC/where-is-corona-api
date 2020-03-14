package where.corona.boundary.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import where.corona.boundary.entity.Boundary;
import where.corona.boundary.repository.BoundaryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoundaryService {

    private final BoundaryRepository boundaryRepository;

    public List<Boundary> getAllBoundaries() {
        return boundaryRepository.findAll();
    }
}
