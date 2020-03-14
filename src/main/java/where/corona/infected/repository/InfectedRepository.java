package where.corona.infected.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import where.corona.infected.model.entity.Infected;

public interface InfectedRepository extends MongoRepository<Infected, String> {
}
