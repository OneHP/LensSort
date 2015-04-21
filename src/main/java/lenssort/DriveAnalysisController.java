package lenssort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriveAnalysisController {

    @Autowired
    private DriveAnalysisService driveAnalysisService;

    @RequestMapping("/metadata-counts")
    public MetadataCounts getMetaDataCounts(@RequestBody FilterRequest filterRequest){
        return this.driveAnalysisService.getMetaDataCounts(filterRequest);
    }

    @RequestMapping("/filtered-photos")
    public List<Photo> getFilteredPhotos(@RequestBody FilterRequest filterRequest){
        return this.driveAnalysisService.getFilteredPhotos(filterRequest);
    }
}
