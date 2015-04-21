package lenssort;

import java.util.List;

public interface PhotoRepositoryCustom {

    List<MetadataCount<Float>> getApertureCounts(FilterRequest filterRequest);
    List<MetadataCount<String>> getCameraMakeCounts(FilterRequest filterRequest);
    List<MetadataCount<String>> getCameraModelCounts(FilterRequest filterRequest);
    List<MetadataCount<Float>> getExposureTimeCounts(FilterRequest filterRequest);
    List<MetadataCount<Float>> getFocalLengthCounts(FilterRequest filterRequest);
    List<MetadataCount<Integer>> getIsoSpeedCounts(FilterRequest filterRequest);
    List<MetadataCount<String>> getLensCounts(FilterRequest filterRequest);

}
