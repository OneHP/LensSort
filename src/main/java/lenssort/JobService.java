package lenssort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Session;

@Service
public class JobService {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void startDriveAnalysis(){
        this.jmsTemplate.send(Constants.DRIVE_ANALYSIS_TRIGGER_QUEUE,
                (Session session) -> session.createTextMessage("start"));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void savePhoto(Photo photo){
        this.jmsTemplate.convertAndSend(Constants.SAVE_PHOTO_QUEUE,photo);
    }
}
