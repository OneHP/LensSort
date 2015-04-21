package lenssort;

import javafx.util.Pair;

import java.util.List;

public interface PhotoRepositoryCustom {

    List<MetaDataCount<Float>> getApertureCounts();
    List<MetaDataCount<String>> getCameraMakeCounts();
    List<MetaDataCount<String>> getCameraModelCounts();
    List<MetaDataCount<Float>> getExposureTimeCounts();
    List<MetaDataCount<Float>> getFocalLengthCounts();
    List<MetaDataCount<Integer>> getIsoSpeedCounts();
    List<MetaDataCount<String>> getLensCounts();

}
