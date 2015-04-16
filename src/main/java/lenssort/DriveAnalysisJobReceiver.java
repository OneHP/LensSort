package lenssort;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class DriveAnalysisJobReceiver {

    @JmsListener(destination = Constants.DRIVE_ANALYSIS_TRIGGER_QUEUE)
    public void receive(String message){
        System.out.println("Received trigger");
    }
}
