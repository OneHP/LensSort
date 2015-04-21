package lenssort;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect
public class MetadataCounts {

    private List<MetadataCount<Float>> apertureCounts;
    private List<MetadataCount<String>> cameraMakeCounts;
    private List<MetadataCount<String>> cameraModelCounts;
    private List<MetadataCount<String>> exposureTimeCounts;
    private List<MetadataCount<Float>> focalLengthCounts;
    private List<MetadataCount<Integer>> isoSpeedCounts;
    private List<MetadataCount<String>> lensCounts;

    public MetadataCounts(){

    }

    public List<MetadataCount<Float>> getApertureCounts() {
        return apertureCounts;
    }

    public void setApertureCounts(List<MetadataCount<Float>> apertureCounts) {
        this.apertureCounts = apertureCounts;
    }

    public List<MetadataCount<String>> getCameraMakeCounts() {
        return cameraMakeCounts;
    }

    public void setCameraMakeCounts(List<MetadataCount<String>> cameraMakeCounts) {
        this.cameraMakeCounts = cameraMakeCounts;
    }

    public List<MetadataCount<String>> getCameraModelCounts() {
        return cameraModelCounts;
    }

    public void setCameraModelCounts(List<MetadataCount<String>> cameraModelCounts) {
        this.cameraModelCounts = cameraModelCounts;
    }

    public List<MetadataCount<String>> getExposureTimeCounts() {
        return exposureTimeCounts;
    }

    public void setExposureTimeCounts(List<MetadataCount<String>> exposureTimeCounts) {
        this.exposureTimeCounts = exposureTimeCounts;
    }

    public List<MetadataCount<Float>> getFocalLengthCounts() {
        return focalLengthCounts;
    }

    public void setFocalLengthCounts(List<MetadataCount<Float>> focalLengthCounts) {
        this.focalLengthCounts = focalLengthCounts;
    }

    public List<MetadataCount<Integer>> getIsoSpeedCounts() {
        return isoSpeedCounts;
    }

    public void setIsoSpeedCounts(List<MetadataCount<Integer>> isoSpeedCounts) {
        this.isoSpeedCounts = isoSpeedCounts;
    }

    public List<MetadataCount<String>> getLensCounts() {
        return lensCounts;
    }

    public void setLensCounts(List<MetadataCount<String>> lensCounts) {
        this.lensCounts = lensCounts;
    }
}
