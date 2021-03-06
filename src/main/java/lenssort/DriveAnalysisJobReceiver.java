package lenssort;

import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.DataStore;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.stereotype.Component;

@Component
public class DriveAnalysisJobReceiver {

    @Autowired
    private DataStore<StoredCredential> credentialDataStore;

    @Autowired
    private JobService jobService;

    @Autowired
    private JmsListenerContainerFactory jmsListenerContainerFactory;

    @JmsListener(destination = Constants.DRIVE_ANALYSIS_TRIGGER_QUEUE)
    public void receive(String message) throws Exception{

        StoredCredential credential = credentialDataStore.get(Constants.DRIVE_CREDENTIAL);
        GoogleCredential googleCredential =  new GoogleCredential().setAccessToken(credential.getAccessToken()).setRefreshToken(credential.getRefreshToken()).
                setExpirationTimeMilliseconds(credential.getExpirationTimeMilliseconds());

        Drive drive = new Drive.Builder(new NetHttpTransport(),new JacksonFactory(),googleCredential).build();

        String nextPageToken = "";
        while(null != nextPageToken){
            FileList fileList = drive.files().list().setQ("mimeType = 'image/jpeg' and trashed = false").setPageToken(nextPageToken).setMaxResults(200).execute();
            fileList.getItems().forEach((File file) -> jobService.savePhoto(Photo.fromFile(file)));
            nextPageToken = fileList.getNextPageToken();
        }



    }
}
