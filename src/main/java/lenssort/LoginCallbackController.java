package lenssort;

import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.util.store.DataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginCallbackController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private JobService jobService;

    @Autowired
    private DataStore<StoredCredential> credentialDataStore;

    @RequestMapping(value="/oauth2callback")
    public String callback(@RequestParam(value = "code", required = false) String code,
                           @RequestParam(value = "error", required = false) String error) throws Exception{
        if(null != error){
            return "redirect:/#/login-error";
        }

        this.authenticationService.authenticate(code);
        this.jobService.startDriveAnalysis();

        return "redirect:/#/login-callback";
    }
}
