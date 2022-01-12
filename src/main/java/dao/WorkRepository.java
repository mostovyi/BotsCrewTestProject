package dao;


import model.Work;
import org.springframework.data.repository.CrudRepository;

public interface WorkRepository extends CrudRepository<Work, Long>, WorkRepositoryCustom {

}
