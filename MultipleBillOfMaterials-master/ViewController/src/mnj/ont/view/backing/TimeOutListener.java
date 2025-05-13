
package com.example.demo.listener;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TimeOutListener {

    private static final String APP_URL = "http://test.adfexpiresession/";

    @PostConstruct
    public void init() {
        // Initialization logic if needed
    }

    public void checkSessionTimeout() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession(false);

        if (session != null) {
            int secsTimeout = session.getMaxInactiveInterval();
            if (secsTimeout > 0) {
                secsTimeout += 2;
                String jsCall = String.format(
                    "document.acmeStartClientSessionTimers = function() {\n" +
                    "  if(document.acmeSessionTimeoutTimer != null)\n" +
                    "    window.clearTimeout(document.acmeSessionTimeoutTimer);\n" +
                    "  document.acmeSessionTimeoutTimer = window.setTimeout(\"document.acmeClientSessionTimeout();\", %d);\n" +
                    "}\n" +
                    "document.acmeStartClientSessionTimers();\n" +
                    "document.acmeClientSessionTimeout = function() {\n" +
                    "    window.location.href = '%s';\n" +
                    "};",
                    secsTimeout * 1000, APP_URL
                );

                // Add the script to the response (this part may vary based on your view technology)
                // For example, if using Thymeleaf, you can add it to the model or directly to the HTML.
                log.info("JavaScript for session timeout added: {}", jsCall);
            }
        }
    }
}


### Controller Example

package com.example.demo.controller;

import com.example.demo.listener.TimeOutListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    private final TimeOutListener timeOutListener;

    public SessionController(TimeOutListener timeOutListener) {
        this.timeOutListener = timeOutListener;
    }

    @GetMapping("/checkSession")
    public void checkSession() {
        timeOutListener.checkSessionTimeout();
    }
}


### Application Properties
properties
# application.properties
server.port=8080
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
spring.datasource.username=myuser
spring.datasource.password=mypassword
spring.datasource.driver-class-name=org.postgresql.Driver


### Note
- The JavaScript handling for session timeout should be integrated into your view layer (e.g., Thymeleaf, JSP) as needed.
- Ensure that the `checkSession` endpoint is called appropriately in your frontend to trigger the session timeout check.