package lenssort;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class PhotoRepositoryImpl implements PhotoRepositoryCustom {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Pair<Float, Integer>> getApertureCounts() {
        return this.jdbcTemplate.query("SELECT aperture, COUNT(aperture) from Photo GROUP BY aperture",
                (ResultSet rs, int rowNum) -> new Pair<>(rs.getFloat(1),rs.getInt(2)));
    }
}
