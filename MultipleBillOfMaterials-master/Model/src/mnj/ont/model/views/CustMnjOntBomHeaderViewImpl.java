
package com.company.module.model.views;

import org.springframework.stereotype.Component;

@Component
public class CustMnjOntBomHeaderViewImpl {

    private String p_userId;
    private String buyerName;

    /**
     * Returns the bind variable value for p_userId.
     * @return bind variable value for p_userId
     */
    public String getp_userId() {
        return p_userId;
    }

    /**
     * Sets <code>value</code> for bind variable p_userId.
     * @param value value to bind as p_userId
     */
    public void setp_userId(String value) {
        this.p_userId = value;
    }

    /**
     * Returns the variable value for Buyer_name.
     * @return variable value for Buyer_name
     */
    public String getBuyer_name() {
        return buyerName;
    }

    /**
     * Sets <code>value</code> for variable Buyer_name.
     * @param value value to bind as Buyer_name
     */
    public void setBuyer_name(String value) {
        this.buyerName = value;
    }
}
