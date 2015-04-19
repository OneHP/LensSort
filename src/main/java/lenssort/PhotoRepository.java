package lenssort;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhotoRepository extends CrudRepository<Photo,Long>, PhotoRepositoryCustom {

    List<Photo> findAll();

}
