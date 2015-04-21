package lenssort;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class PhotoRepositoryImpl implements PhotoRepositoryCustom {

    private final String COUNT_QUERY = "SELECT %s, COUNT(*) from Photo GROUP BY %s";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private List<MetaDataCount<Float>> queryCountsForFloatField(String field){
        return this.jdbcTemplate.query(String.format(COUNT_QUERY,field,field,field),
                (ResultSet rs, int rowNum) -> new MetaDataCount(rs.getFloat(1),rs.getInt(2),0));
    }

    private List<MetaDataCount<Integer>> queryCountsForIntField(String field){
        return this.jdbcTemplate.query(String.format(COUNT_QUERY,field,field,field),
                (ResultSet rs, int rowNum) -> new MetaDataCount(rs.getInt(1),rs.getInt(2),0));
    }

    private List<MetaDataCount<String>> queryCountsForStringField(String field){
        return this.jdbcTemplate.query(String.format(COUNT_QUERY,field,field,field),
                (ResultSet rs, int rowNum) -> new MetaDataCount(rs.getString(1),rs.getInt(2),0));
    }

    @Override
    public List<MetaDataCount<Float>> getApertureCounts(){
        return queryCountsForFloatField("aperture");
    }

    @Override
    public List<MetaDataCount<String>> getCameraMakeCounts() {
        return queryCountsForStringField("camera_make");
    }

    @Override
    public List<MetaDataCount<String>> getCameraModelCounts() {
        return queryCountsForStringField("camera_model");
    }

    @Override
    public List<MetaDataCount<Float>> getExposureTimeCounts() {
        return queryCountsForFloatField("exposure_time");
    }

    @Override
    public List<MetaDataCount<Float>> getFocalLengthCounts() {
        return queryCountsForFloatField("focal_length");
    }

    @Override
    public List<MetaDataCount<Integer>> getIsoSpeedCounts() {
        return queryCountsForIntField("iso_speed");
    }

    @Override
    public List<MetaDataCount<String>> getLensCounts() {
        return queryCountsForStringField("lens");
    }

}
