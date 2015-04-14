package lenssort;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginCallbackController {

    @RequestMapping(value="/oauth2callback")
    public String callback(){
        return "redirect:/#/login-callback";
    }
}
