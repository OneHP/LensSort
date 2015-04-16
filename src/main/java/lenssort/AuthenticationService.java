package lenssort;

import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.DataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Value("${google.client.id}")
    private String clientId;

    @Value("${google.client.secret}")
    private String clientSecret;

    @Autowired
    private DataStore<StoredCredential> credentialDataStore;

    public void authenticate(String authorisationCode) throws Exception{

        GoogleTokenResponse response = new GoogleAuthorizationCodeTokenRequest(
                new NetHttpTransport(), new JacksonFactory(), clientId, clientSecret, authorisationCode,
                "http://127.0.0.1:8080/oauth2callback").execute();

        StoredCredential credential = new StoredCredential();
        credential.setAccessToken(response.getAccessToken());
        credential.setRefreshToken(response.getRefreshToken());
        credential.setExpirationTimeMilliseconds(response.getExpiresInSeconds()*1000);

        credentialDataStore.set(Constants.DRIVE_CREDENTIAL, credential);
    }
}
