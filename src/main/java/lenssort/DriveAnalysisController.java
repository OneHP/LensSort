package lenssort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriveAnalysisController {

    @Autowired
    private DriveAnalysisService driveAnalysisService;

    @RequestMapping("/metadata-counts")
    public MetadataCounts getMetaDataCounts(){
        return this.driveAnalysisService.getMetaDataCounts();
    }
}
