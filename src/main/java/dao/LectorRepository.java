package dao;

import model.Lector;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectorRepository extends CrudRepository<Lector, Long>, LectorRepositoryCustom {
}
