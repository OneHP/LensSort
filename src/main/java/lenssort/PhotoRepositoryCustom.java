package lenssort;

import javafx.util.Pair;

import java.util.List;

public interface PhotoRepositoryCustom {

    List<Pair<Float,Integer>> getApertureCounts();
    List<Pair<String,Integer>> getCameraMakeCounts();
    List<Pair<String,Integer>> getCameraModelCounts();
    List<Pair<Float,Integer>> getExposureTimeCounts();
    List<Pair<Float,Integer>> getFocalLengthCounts();
    List<Pair<Integer,Integer>> getIsoSpeedCounts();
    List<Pair<String,Integer>> getLensCounts();

}
