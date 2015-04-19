package lenssort;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.util.List;

@JsonAutoDetect
public class FilterRequest {

    private List<String> cameraMake;
    private List<String> cameraModel;
    private List<String> lens;
    private List<Float> aperture;
    private List<Float> focalLength;
    private List<Integer> isoSpeed;
    private List<Float> exposureTime;

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

    public List<Float> getAperture() {
        return aperture;
    }

    public void setAperture(List<Float> aperture) {
        this.aperture = aperture;
    }

    public List<Float> getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(List<Float> focalLength) {
        this.focalLength = focalLength;
    }

    public List<Integer> getIsoSpeed() {
        return isoSpeed;
    }

    public void setIsoSpeed(List<Integer> isoSpeed) {
        this.isoSpeed = isoSpeed;
    }

    public List<Float> getExposureTime() {
        return exposureTime;
    }

    public void setExposureTime(List<Float> exposureTime) {
        this.exposureTime = exposureTime;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}