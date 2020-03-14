package where.corona.boundary.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import where.corona.boundary.entity.Boundary;

public interface BoundaryRepository extends MongoRepository<Boundary, String> {
}
