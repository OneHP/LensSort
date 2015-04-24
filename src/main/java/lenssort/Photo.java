package lenssort;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.google.api.services.drive.model.File;
import org.apache.commons.lang.StringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@JsonAutoDetect
@Entity(name="photo")
public class Photo implements Serializable{

    @Id
    @GeneratedValue
    private long id;

    private String driveId;
    private String title;
    private String thumbnailLink;
    private String aperture;
    private String cameraMake;
    private String cameraModel;
    private String exposureTime;
    private String focalLength;
    private int isoSpeed;
    private String lens;
    private int rotation;

    public Photo(){

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

    public String getAperture() {
        return aperture;
    }

    public void setAperture(String aperture) {
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

    public String getExposureTime() {
        return exposureTime;
    }

    public void setExposureTime(String exposureTime) {
        this.exposureTime = exposureTime;
    }

    public String getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(String focalLength) {
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

        photo.setAperture(parseFloatField(metadata.getAperture()));
        photo.setCameraMake(parseStringField(metadata.getCameraMake()));
        photo.setCameraModel(parseStringField(metadata.getCameraModel()));
        photo.setExposureTime(parseExposureTime(metadata.getExposureTime()));
        photo.setFocalLength(parseFloatField(metadata.getFocalLength()));
        photo.setIsoSpeed(parseIntegerField(metadata.getIsoSpeed()));
        photo.setLens(parseStringField(metadata.getLens()));
        photo.setRotation(parseIntegerField(metadata.getRotation()));

        return photo;
    }

    private static String parseExposureTime(Float exposure){
        return null == exposure ? "Undefined" : ("1/" + Math.round(1.0f/exposure));
    }

    private static String parseFloatField(Float value){
        return null == value ? "Undefined" : Float.toString(value);
    }

    private static String parseStringField(String value){
        return StringUtils.isEmpty(value) ? "Undefined" : value;
    }

    private static int parseIntegerField(Integer value){
        return null == value ? 0 : value;
    }
}
