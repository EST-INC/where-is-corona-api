package where.corona.infected.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import where.corona.infected.model.entity.Infected;

import java.util.List;

public interface InfectedRepository extends MongoRepository<Infected, String> {
    List<Infected> findByBoundaryId(Integer boundaryId);
}
