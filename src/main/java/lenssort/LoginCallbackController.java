package lenssort;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginCallbackController {

    @RequestMapping(value="/oauth2callback")
    public String callback(@RequestParam(value = "code", required = false) String code,
                           @RequestParam(value = "error", required = false) String error){
        if(null != error){
            return "redirect:/#/login-error";
        }
        return "redirect:/#/login-callback";
    }
}
