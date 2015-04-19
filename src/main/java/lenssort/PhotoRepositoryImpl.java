package lenssort;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class PhotoRepositoryImpl implements PhotoRepositoryCustom {

    private final String COUNT_QUERY = "SELECT %s, COUNT(*) from Photo GROUP BY %s";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private List<Pair<Float,Integer>> queryCountsForFloatField(String field){
        return this.jdbcTemplate.query(String.format(COUNT_QUERY,field,field,field),
                (ResultSet rs, int rowNum) -> new Pair<>(rs.getFloat(1),rs.getInt(2)));
    }

    private List<Pair<Integer,Integer>> queryCountsForIntField(String field){
        return this.jdbcTemplate.query(String.format(COUNT_QUERY,field,field,field),
                (ResultSet rs, int rowNum) -> new Pair<>(rs.getInt(1),rs.getInt(2)));
    }

    private List<Pair<String,Integer>> queryCountsForStringField(String field){
        return this.jdbcTemplate.query(String.format(COUNT_QUERY,field,field,field),
                (ResultSet rs, int rowNum) -> new Pair<>(rs.getString(1),rs.getInt(2)));
    }

    @Override
    public List<Pair<Float, Integer>> getApertureCounts(){
        return queryCountsForFloatField("aperture");
    }

    @Override
    public List<Pair<String, Integer>> getCameraMakeCounts() {
        return queryCountsForStringField("camera_make");
    }

    @Override
    public List<Pair<String, Integer>> getCameraModelCounts() {
        return queryCountsForStringField("camera_model");
    }

    @Override
    public List<Pair<Float, Integer>> getExposureTimeCounts() {
        return queryCountsForFloatField("exposure_time");
    }

    @Override
    public List<Pair<Float, Integer>> getFocalLengthCounts() {
        return queryCountsForFloatField("focal_length");
    }

    @Override
    public List<Pair<Integer, Integer>> getIsoSpeedCounts() {
        return queryCountsForIntField("iso_speed");
    }

    @Override
    public List<Pair<String, Integer>> getLensCounts() {
        return queryCountsForStringField("lens");
    }
}
