
package com.company.module.view;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustMnjOntBomRmlineLinesViewImpl {

    public CustMnjOntBomRmlineLinesViewImpl() {
    }

    @Transactional
    public void insertRow(Row row) {
        Row lastRow = this.last();
        if (lastRow != null) {
            // insert new row at the end and make it current
            int indx = this.getRangeIndexOf(lastRow) + 1;
            this.insertRowAtRangeIndex(indx, row);
            this.setCurrentRow(row);
        } else { // empty Rowset
            super.insertRow(row);
        }
    }

    // TODO: Implement methods last(), getRangeIndexOf(), insertRowAtRangeIndex(), setCurrentRow(), and super.insertRow() as needed
}
