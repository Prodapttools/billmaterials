
package com.company.module.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.company.module.service.VersionsService;

@Controller
@RequestMapping("/versions")
@SessionAttributes("BOMNO")
public class VersionsBean {
    
    private static final Logger logger = LoggerFactory.getLogger(VersionsBean.class);
    
    @Autowired
    private VersionsService versionsService;

    private String bomId;
    private Number scopeVariable;
    private String showAttachText;

    public VersionsBean() {
        super();
    }

    public void setBomId(String bomId) {
        this.bomId = bomId;
    }

    public String getBomId() {
        return bomId;
    }

    public void versionsActionListener() {
        logger.info("value in bean --->" + getHederno2());
        setScopeVariable(getHederno2());
        logger.info("get value-->" + getScopeVariable());
    }

    public void setScopeVariable(Number scopeVariable) {
        this.scopeVariable = scopeVariable;
    }

    public Number getScopeVariable() {
        return scopeVariable;
    }

    public void setHederno2(String hederno2) {
        this.hederno2 = hederno2;
    }

    public String getHederno2() {
        return hederno2;
    }

    @GetMapping("/callAttachment")
    @ResponseBody
    public String callAttachment() throws IOException {
        String doc = versionsService.getDocumentNumber();
        String newPage = "http://192.168.200.115:7003/FileUploading-ViewController-context-root/faces/view1?doc=CD_Invoice_No&docNo=" + doc;
        logger.info("Opening new page: " + newPage);
        return newPage; // This should be handled in the frontend to open the URL
    }

    @PostMapping("/goPrAction")
    public void goPrAction(HttpSession userSession) {
        userSession.setAttribute("BOMNO", String.valueOf(getHederno2()));
    }

    public void setShowAttachText(String showAttachText) {
        this.showAttachText = showAttachText;
    }

    public String getShowAttachText() {
        return showAttachText;
    }

    public void attachFetchListener() {
        Object methodReturnValue = versionsService.getAttachments();
        if (methodReturnValue != null) {
            showAttachText = methodReturnValue.toString();
        } else {
            logger.error("Error fetching attachments");
        }
    }

    public void cancelListener() {
        // Add event code here...
    }
}
