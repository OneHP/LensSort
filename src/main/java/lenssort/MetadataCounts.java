package lenssort;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import javafx.util.Pair;
import org.jgroups.util.Triple;

import java.util.List;

@JsonAutoDetect
public class MetadataCounts {

    private List<MetaDataCount<Float>> apertureCounts;
    private List<MetaDataCount<String>> cameraMakeCounts;
    private List<MetaDataCount<String>> cameraModelCounts;
    private List<MetaDataCount<Float>> exposureTimeCounts;
    private List<MetaDataCount<Float>> focalLengthCounts;
    private List<MetaDataCount<Integer>> isoSpeedCounts;
    private List<MetaDataCount<String>> lensCounts;

    public MetadataCounts(){

    }

    public List<MetaDataCount<Float>> getApertureCounts() {
        return apertureCounts;
    }

    public void setApertureCounts(List<MetaDataCount<Float>> apertureCounts) {
        this.apertureCounts = apertureCounts;
    }

    public List<MetaDataCount<String>> getCameraMakeCounts() {
        return cameraMakeCounts;
    }

    public void setCameraMakeCounts(List<MetaDataCount<String>> cameraMakeCounts) {
        this.cameraMakeCounts = cameraMakeCounts;
    }

    public List<MetaDataCount<String>> getCameraModelCounts() {
        return cameraModelCounts;
    }

    public void setCameraModelCounts(List<MetaDataCount<String>> cameraModelCounts) {
        this.cameraModelCounts = cameraModelCounts;
    }

    public List<MetaDataCount<Float>> getExposureTimeCounts() {
        return exposureTimeCounts;
    }

    public void setExposureTimeCounts(List<MetaDataCount<Float>> exposureTimeCounts) {
        this.exposureTimeCounts = exposureTimeCounts;
    }

    public List<MetaDataCount<Float>> getFocalLengthCounts() {
        return focalLengthCounts;
    }

    public void setFocalLengthCounts(List<MetaDataCount<Float>> focalLengthCounts) {
        this.focalLengthCounts = focalLengthCounts;
    }

    public List<MetaDataCount<Integer>> getIsoSpeedCounts() {
        return isoSpeedCounts;
    }

    public void setIsoSpeedCounts(List<MetaDataCount<Integer>> isoSpeedCounts) {
        this.isoSpeedCounts = isoSpeedCounts;
    }

    public List<MetaDataCount<String>> getLensCounts() {
        return lensCounts;
    }

    public void setLensCounts(List<MetaDataCount<String>> lensCounts) {
        this.lensCounts = lensCounts;
    }
}
