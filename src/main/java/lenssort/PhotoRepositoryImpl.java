package lenssort;

import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Repository
public class PhotoRepositoryImpl implements PhotoRepositoryCustom {

    private final String COUNT_QUERY = "SELECT %s, COUNT(*), SUM(CASEWHEN(%s,1,0)) from Photo GROUP BY %s";

    private static final Map<String,Function<FilterRequest,List>> FIELD_TO_GETTER = Maps.newHashMap();
    static{
        FIELD_TO_GETTER.put("aperture", FilterRequest::getAperture);
        FIELD_TO_GETTER.put("camera_make", FilterRequest::getCameraMake);
        FIELD_TO_GETTER.put("camera_model", FilterRequest::getCameraModel);
        FIELD_TO_GETTER.put("exposure_time", FilterRequest::getExposureTime);
        FIELD_TO_GETTER.put("focal_length", FilterRequest::getFocalLength);
        FIELD_TO_GETTER.put("iso_speed", FilterRequest::getIsoSpeed);
        FIELD_TO_GETTER.put("lens", FilterRequest::getLens);
    }
    private static final Map<String,Function<List,String>> FIELD_TO_STRING_JOINER = Maps.newHashMap();
    static{
        FIELD_TO_STRING_JOINER.put("aperture", PhotoRepositoryImpl::commaSeperatedDelimitedValues);
        FIELD_TO_STRING_JOINER.put("camera_make", PhotoRepositoryImpl::commaSeperatedDelimitedValues);
        FIELD_TO_STRING_JOINER.put("camera_model", PhotoRepositoryImpl::commaSeperatedDelimitedValues);
        FIELD_TO_STRING_JOINER.put("exposure_time", PhotoRepositoryImpl::commaSeperatedDelimitedValues);
        FIELD_TO_STRING_JOINER.put("focal_length", PhotoRepositoryImpl::commaSeperatedDelimitedValues);
        FIELD_TO_STRING_JOINER.put("iso_speed", PhotoRepositoryImpl::commaSeperatedValues);
        FIELD_TO_STRING_JOINER.put("lens", PhotoRepositoryImpl::commaSeperatedDelimitedValues);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private List<MetadataCount<Integer>> queryCountsForIntField(String field, String filterCountClause){
        return this.jdbcTemplate.query(String.format(COUNT_QUERY,field,filterCountClause,field),
                (ResultSet rs, int rowNum) -> new MetadataCount(rs.getInt(1),rs.getInt(2),rs.getInt(3)));
    }

    private List<MetadataCount<String>> queryCountsForStringField(String field, String filterCountClause){
        return this.jdbcTemplate.query(String.format(COUNT_QUERY, field, filterCountClause, field),
                (ResultSet rs, int rowNum) -> new MetadataCount(rs.getString(1), rs.getInt(2), rs.getInt(3)));
    }

    @Override
    public List<MetadataCount<String>> getApertureCounts(FilterRequest filterRequest){
        StringBuilder clause = new StringBuilder("TRUE ");
        String field = "aperture";
        appendInClauses(clause, filterRequest, field);
        return queryCountsForStringField(field, clause.toString());
    }

    @Override
    public List<MetadataCount<String>> getCameraMakeCounts(FilterRequest filterRequest) {
        StringBuilder clause = new StringBuilder("TRUE ");
        String field = "camera_make";
        appendInClauses(clause, filterRequest, field);
        return queryCountsForStringField(field, clause.toString());
    }

    @Override
    public List<MetadataCount<String>> getCameraModelCounts(FilterRequest filterRequest) {
        StringBuilder clause = new StringBuilder("TRUE ");
        String field = "camera_model";
        appendInClauses(clause, filterRequest, field);
        return queryCountsForStringField(field, clause.toString());
    }

    @Override
    public List<MetadataCount<String>> getExposureTimeCounts(FilterRequest filterRequest) {
        StringBuilder clause = new StringBuilder("TRUE ");
        String field = "exposure_time";
        appendInClauses(clause, filterRequest, field);
        return queryCountsForStringField(field, clause.toString());
    }

    @Override
    public List<MetadataCount<String>> getFocalLengthCounts(FilterRequest filterRequest) {
        StringBuilder clause = new StringBuilder("TRUE ");
        String field = "focal_length";
        appendInClauses(clause, filterRequest, field);
        return queryCountsForStringField(field, clause.toString());
    }

    @Override
    public List<MetadataCount<Integer>> getIsoSpeedCounts(FilterRequest filterRequest) {
        StringBuilder clause = new StringBuilder("TRUE ");
        String field = "iso_speed";
        appendInClauses(clause, filterRequest, field);
        return queryCountsForIntField(field, clause.toString());
    }

    @Override
    public List<MetadataCount<String>> getLensCounts(FilterRequest filterRequest) {
        StringBuilder clause = new StringBuilder("TRUE ");
        String field = "lens";
        appendInClauses(clause, filterRequest, field);
        return queryCountsForStringField(field, clause.toString());
    }

    private static String commaSeperatedValues(List values){
        return StringUtils.join(values,",");
    }

    private static String commaSeperatedDelimitedValues(List values){
        return "'" + StringUtils.join(values,"','") + "'";
    }

    /**
     * Construct an IN clause for the given field and add it to the existing clause
     *
     * @param clause
     * @param filterRequest
     * @param field
     */
    private void appendInClause(StringBuilder clause, FilterRequest filterRequest, String field){
        final Function<FilterRequest, List> getter = FIELD_TO_GETTER.get(field);
        if(!CollectionUtils.isEmpty(getter.apply(filterRequest))){
            clause.append(String.format("AND %s IN (%s) ", field, FIELD_TO_STRING_JOINER.get(field).apply(getter.apply(filterRequest))));
        }
    }

    /**
     * Append IN clauses for all fields except the given one
     *
     * @param clause
     * @param filterRequest
     * @param exclude
     */
    private void appendInClauses(StringBuilder clause, FilterRequest filterRequest, String exclude) {
        FIELD_TO_GETTER.keySet().stream()
                .filter((String ignore) -> !ignore.equals(exclude))
                .forEach((String field) -> appendInClause(clause, filterRequest, field)
                );
    }
}
