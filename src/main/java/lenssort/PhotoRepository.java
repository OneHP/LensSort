package lenssort;

import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo,Long>, PhotoRepositoryCustom {

}
