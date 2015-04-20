package lenssort;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.google.api.services.drive.model.File;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@JsonAutoDetect
@Entity(name="photo")
public class Photo {

    @Id
    @GeneratedValue
    private long id;

    private String driveId;
    private String title;
    private String thumbnailLink;
    private float aperture;
    private String cameraMake;
    private String cameraModel;
    private float exposureTime;
    private float focalLength;
    private int isoSpeed;
    private String lens;
    private int rotation;

    protected Photo(){

    }

    public String getDriveId() {
        return driveId;
    }

    public void setDriveId(String driveId) {
        this.driveId = driveId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailLink() {
        return thumbnailLink;
    }

    public void setThumbnailLink(String thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
    }

    public float getAperture() {
        return aperture;
    }

    public void setAperture(float aperture) {
        this.aperture = aperture;
    }

    public String getCameraMake() {
        return cameraMake;
    }

    public void setCameraMake(String cameraMake) {
        this.cameraMake = cameraMake;
    }

    public String getCameraModel() {
        return cameraModel;
    }

    public void setCameraModel(String cameraModel) {
        this.cameraModel = cameraModel;
    }

    public float getExposureTime() {
        return exposureTime;
    }

    public void setExposureTime(float exposureTime) {
        this.exposureTime = exposureTime;
    }

    public float getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(float focalLength) {
        this.focalLength = focalLength;
    }

    public int getIsoSpeed() {
        return isoSpeed;
    }

    public void setIsoSpeed(int isoSpeed) {
        this.isoSpeed = isoSpeed;
    }

    public String getLens() {
        return lens;
    }

    public void setLens(String lens) {
        this.lens = lens;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public static Photo fromFile(File file){

        Photo photo = new Photo();

        photo.setDriveId(file.getId());
        photo.setTitle(file.getTitle());
        photo.setThumbnailLink(file.getThumbnailLink());

        final File.ImageMediaMetadata metadata = file.getImageMediaMetadata();

        photo.setAperture(metadata.getAperture());
        photo.setCameraMake(metadata.getCameraMake());
        photo.setCameraModel(metadata.getCameraModel());
        photo.setExposureTime(metadata.getExposureTime());
        photo.setFocalLength(metadata.getFocalLength());
        photo.setIsoSpeed(metadata.getIsoSpeed());
        photo.setLens(metadata.getLens());
        photo.setRotation(metadata.getRotation());

        return photo;
    }
}
