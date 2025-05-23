
package com.company.module.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;

import com.company.module.service.AppModuleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/popup")
public class PopUpBean {
    private static final Logger logger = LoggerFactory.getLogger(PopUpBean.class);

    private final AppModuleService appModuleService;

    public PopUpBean(AppModuleService appModuleService) {
        this.appModuleService = appModuleService;
    }

    public void setMatTable(RichTable matTable) {
        this.matTable = matTable;
    }

    public RichTable getMatTable() {
        return matTable;
    }

    public void editDialogListenerNew(DialogEvent dialogEvent) {
        if (dialogEvent.getOutcome().name().equals("ok")) {
            fillMaterial();
        } else if (dialogEvent.getOutcome().name().equals("cancel")) {
            // Handle cancel
        }
    }

    public void fillMaterial() {
        appModuleService.callMatFetch();
    }

    public void createPoDff(ActionEvent actionEvent) {
        String orgId = appModuleService.getOrgId();
        String currentBomId = appModuleService.getCurrentBomId();
        
        appModuleService.createPoDff(currentBomId, orgId);
    }

    public void saveAndCreatePo(ActionEvent actionEvent) {
        appModuleService.commitTransaction();
        
        String orgId = appModuleService.getOrgIdFromCurrentRow();
        String userId = appModuleService.getUserIdFromCurrentRow();
        String prNo = appModuleService.getPrNoFromCurrentRow();

        appModuleService.createAutoPo(prNo, userId, orgId);
    }
}
