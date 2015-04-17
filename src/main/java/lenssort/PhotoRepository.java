package lenssort;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhotoRepository extends CrudRepository<Photo,Long> {

    List<Photo> findByAperture(float aperture);
}
