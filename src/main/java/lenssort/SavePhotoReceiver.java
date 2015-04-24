package lenssort;

import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class SavePhotoReceiver {

    @Autowired
    private PhotoRepository photoRepository;

    private JacksonFactory jacksonFactory = new JacksonFactory();

    @JmsListener(destination = Constants.SAVE_PHOTO_QUEUE)
    @Transactional
    public void receive(Photo photo) throws Exception{
        this.photoRepository.save(photo);
    }
}
