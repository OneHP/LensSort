package lenssort;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import javafx.util.Pair;

import java.util.List;

@JsonAutoDetect
public class MetadataCounts {

    private List<Pair<Float, Integer>> apertureCounts;
    private List<Pair<String, Integer>> cameraMakeCounts;
    private List<Pair<String, Integer>> cameraModelCounts;
    private List<Pair<Float, Integer>> exposureTimeCounts;
    private List<Pair<Float, Integer>> focalLengthCounts;
    private List<Pair<Integer, Integer>> isoSpeedCounts;
    private List<Pair<String, Integer>> lensCounts;

    public MetadataCounts(){

    }

    public List<Pair<Float, Integer>> getApertureCounts() {
        return apertureCounts;
    }

    public void setApertureCounts(List<Pair<Float, Integer>> apertureCounts) {
        this.apertureCounts = apertureCounts;
    }

    public List<Pair<String, Integer>> getCameraMakeCounts() {
        return cameraMakeCounts;
    }

    public void setCameraMakeCounts(List<Pair<String, Integer>> cameraMakeCounts) {
        this.cameraMakeCounts = cameraMakeCounts;
    }

    public List<Pair<String, Integer>> getCameraModelCounts() {
        return cameraModelCounts;
    }

    public void setCameraModelCounts(List<Pair<String, Integer>> cameraModelCounts) {
        this.cameraModelCounts = cameraModelCounts;
    }

    public List<Pair<Float, Integer>> getExposureTimeCounts() {
        return exposureTimeCounts;
    }

    public void setExposureTimeCounts(List<Pair<Float, Integer>> exposureTimeCounts) {
        this.exposureTimeCounts = exposureTimeCounts;
    }

    public List<Pair<Float, Integer>> getFocalLengthCounts() {
        return focalLengthCounts;
    }

    public void setFocalLengthCounts(List<Pair<Float, Integer>> focalLengthCounts) {
        this.focalLengthCounts = focalLengthCounts;
    }

    public List<Pair<Integer, Integer>> getIsoSpeedCounts() {
        return isoSpeedCounts;
    }

    public void setIsoSpeedCounts(List<Pair<Integer, Integer>> isoSpeedCounts) {
        this.isoSpeedCounts = isoSpeedCounts;
    }

    public List<Pair<String, Integer>> getLensCounts() {
        return lensCounts;
    }

    public void setLensCounts(List<Pair<String, Integer>> lensCounts) {
        this.lensCounts = lensCounts;
    }

}
