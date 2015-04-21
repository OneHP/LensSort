package lenssort;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.util.List;

@JsonAutoDetect
public class FilterRequest {

    private List<String> cameraMake;
    private List<String> cameraModel;
    private List<String> lens;
    private List<String> aperture;
    private List<String> focalLength;
    private List<Integer> isoSpeed;
    private List<String> exposureTime;

    public FilterRequest(){

    }

    public List<String> getCameraMake() {
        return cameraMake;
    }

    public void setCameraMake(List<String> cameraMake) {
        this.cameraMake = cameraMake;
    }

    public List<String> getCameraModel() {
        return cameraModel;
    }

    public void setCameraModel(List<String> cameraModel) {
        this.cameraModel = cameraModel;
    }

    public List<String> getLens() {
        return lens;
    }

    public void setLens(List<String> lens) {
        this.lens = lens;
    }

    public List<String> getAperture() {
        return aperture;
    }

    public void setAperture(List<String> aperture) {
        this.aperture = aperture;
    }

    public List<String> getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(List<String> focalLength) {
        this.focalLength = focalLength;
    }

    public List<Integer> getIsoSpeed() {
        return isoSpeed;
    }

    public void setIsoSpeed(List<Integer> isoSpeed) {
        this.isoSpeed = isoSpeed;
    }

    public List<String> getExposureTime() {
        return exposureTime;
    }

    public void setExposureTime(List<String> exposureTime) {
        this.exposureTime = exposureTime;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}