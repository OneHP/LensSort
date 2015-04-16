package lenssort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Session;

@Service
public class JobService {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void startDriveAnalysis(){
        this.jmsTemplate.send(Constants.DRIVE_ANALYSIS_TRIGGER_QUEUE,
                (Session session) -> session.createTextMessage("start"));
    }
}
