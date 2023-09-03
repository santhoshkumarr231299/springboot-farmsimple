package com.farmsimple.controller.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class ForwardController {
    @GetMapping("/")
    public String redirectHome() {
        log.info("Santhosh is calling santhosh");
        return "redirect:http://localhost:9090/client/login";
    }
    @GetMapping({ "/", "/{x:[\\w\\-]+}", "/{x:^(?!api$).*$}/*/{y:[\\w\\-]+}","/error"  })
    public String clientLoginPage() {
        return "index.html";
    }
}
