package where.corona.infected.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import where.corona.infected.model.entity.Infected;

import java.util.Optional;

public interface InfectedRepository extends MongoRepository<Infected, String> {
    Optional<Infected> findByBoundaryId(String boundaryId);
}
