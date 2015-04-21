package lenssort;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class DriveAnalysisService {

    @Autowired
    private PhotoRepository photoRepository;

    public MetadataCounts getMetaDataCounts(FilterRequest filterRequest){

        MetadataCounts metadataCounts = new MetadataCounts();
        metadataCounts.setApertureCounts(photoRepository.getApertureCounts(filterRequest));
        metadataCounts.setCameraMakeCounts(photoRepository.getCameraMakeCounts(filterRequest));
        metadataCounts.setCameraModelCounts(photoRepository.getCameraModelCounts(filterRequest));
        metadataCounts.setExposureTimeCounts(photoRepository.getExposureTimeCounts(filterRequest));
        metadataCounts.setFocalLengthCounts(photoRepository.getFocalLengthCounts(filterRequest));
        metadataCounts.setIsoSpeedCounts(photoRepository.getIsoSpeedCounts(filterRequest));
        metadataCounts.setLensCounts(photoRepository.getLensCounts(filterRequest));

        return metadataCounts;
    }

    public List<Photo> getFilteredPhotos(FilterRequest filterRequest){
        List<Photo> photos = this.photoRepository.findAll();

        if(!CollectionUtils.isEmpty(filterRequest.getCameraMake())){
            photos = filterPhotos(photos,filterRequest,FilterRequest::getCameraMake,Photo::getCameraMake);
        }

        if(!CollectionUtils.isEmpty(filterRequest.getCameraModel())){
            photos = filterPhotos(photos,filterRequest,FilterRequest::getCameraModel,Photo::getCameraModel);
        }

        if(!CollectionUtils.isEmpty(filterRequest.getLens())){
            photos = filterPhotos(photos,filterRequest,FilterRequest::getLens,Photo::getLens);
        }

        if(!CollectionUtils.isEmpty(filterRequest.getAperture())){
            photos = filterPhotos(photos,filterRequest,FilterRequest::getAperture,Photo::getAperture);
        }

        if(!CollectionUtils.isEmpty(filterRequest.getFocalLength())){
            photos = filterPhotos(photos, filterRequest, FilterRequest::getFocalLength, Photo::getFocalLength);
        }

        if(!CollectionUtils.isEmpty(filterRequest.getIsoSpeed())){
            photos = filterPhotos(photos,filterRequest,FilterRequest::getIsoSpeed,Photo::getIsoSpeed);
        }

        if(!CollectionUtils.isEmpty(filterRequest.getExposureTime())){
            photos = filterPhotos(photos, filterRequest, FilterRequest::getExposureTime, Photo::getExposureTime);
        }

        return photos;
    }

    private List<Photo> filterPhotos(List<Photo> photos, FilterRequest filterRequest, Function<FilterRequest,List> filterField, Function<Photo,?> photoField){
        return Lists.newArrayList(Collections2.filter(photos,(Photo photo) ->
                filterField.apply(filterRequest).contains(photoField.apply(photo))));
    }
}
