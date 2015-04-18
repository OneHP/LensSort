package lenssort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriveAnalysisService {

    @Autowired
    private PhotoRepository photoRepository;

    public MetadataCounts getMetaDataCounts(){

        MetadataCounts metadataCounts = new MetadataCounts();
        metadataCounts.setApertureCounts(photoRepository.getApertureCounts());
        metadataCounts.setCameraMakeCounts(photoRepository.getCameraMakeCounts());
        metadataCounts.setCameraModelCounts(photoRepository.getCameraModelCounts());
        metadataCounts.setExposureTimeCounts(photoRepository.getExposureTimeCounts());
        metadataCounts.setFocalLengthCounts(photoRepository.getFocalLengthCounts());
        metadataCounts.setIsoSpeedCounts(photoRepository.getIsoSpeedCounts());
        metadataCounts.setLensCounts(photoRepository.getLensCounts());

        return metadataCounts;
    }
}
