
package com.company.module.listener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class TimeOutListener {

    private static final Logger logger = LoggerFactory.getLogger(TimeOutListener.class);
    private static final String APP_URL = "http://test.adfexpiresession/";

    public TimeOutListener() {
        super();
    }

    public void checkSessionTimeout() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            HttpSession session = request.getSession(false);
            if (session != null) {
                int secsTimeout = session.getMaxInactiveInterval();
                if (secsTimeout > 0) {
                    secsTimeout += 2;
                    String jsCall = "document.acmeStartClientSessionTimers = function()\n" +
                            "{\n" +
                            "  if(document.acmeSessionTimeoutTimer != null)\n" +
                            "    window.clearTimeout(document.acmeSessionTimeoutTimer);\n" +
                            "\n" +
                            "  document.acmeSessionTimeoutTimer = window.setTimeout(\"document.acmeClientSessionTimeout();\", " +
                            secsTimeout * 1000 + ");\n" +
                            "\n" +
                            "}\n" +
                            "document.acmeStartClientSessionTimers();\n" +
                            "\n" +
                            "document.acmeClientSessionTimeout = function()\n" +
                            "{\n" +
                            "    window.location.href = '" + APP_URL + "' \n" +
                            "}";

                    // Assuming a method to add script to the response
                    addScriptToResponse(jsCall);
                }
            }
        }
    }

    private void addScriptToResponse(String script) {
        // Implementation to add the script to the response
        logger.info("Adding script to response: {}", script);
    }
}
