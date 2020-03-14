package where.corona.boundary.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import where.corona.boundary.entity.Boundary;
import where.corona.boundary.entity.BoundaryCollection;
import where.corona.boundary.repository.BoundaryRepository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoundaryService {

    private final BoundaryRepository boundaryRepository;
    private final ObjectMapper mapper;

    public List<Boundary> getAllBoundaries() {
        return boundaryRepository.findAll();
    }


    public void prepareData(List<Boundary> boundaries) {
        boundaryRepository.deleteAll();

        boundaryRepository.saveAll(boundaries);
    }


    @PostConstruct
    private void init() throws IOException {
        InputStream inputStream = new ClassPathResource("poland-boundaries.json").getInputStream();

        try {
            BoundaryCollection boundaries = mapper.readValue(inputStream, BoundaryCollection.class);
            prepareData(boundaries.getFeatures());
            log.info("Saved boundaries");
        } catch (IOException e) {
            log.error("Unable to save boundaries: " + e.getMessage());
        }
    }
}

