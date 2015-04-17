package lenssort;

import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.MemoryDataStoreFactory;
import org.hornetq.jms.server.config.JMSQueueConfiguration;
import org.hornetq.jms.server.config.impl.JMSQueueConfigurationImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LensSortApplication {

    public static void main(String[] args) {
        SpringApplication.run(LensSortApplication.class, args);
    }

    @Bean
    public static DataStore<StoredCredential> credentialDataStore() throws Exception{
        return MemoryDataStoreFactory.getDefaultInstance().getDataStore("credentialDataStore");
    }
}
