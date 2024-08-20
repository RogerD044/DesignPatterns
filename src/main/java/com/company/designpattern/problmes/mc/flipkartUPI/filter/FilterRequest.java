package com.company.designpattern.problmes.mc.flipkartUPI.filter;

import com.company.designpattern.problmes.mc.flipkartUPI.TransactionStatus;
import java.util.*;

public class FilterRequest {
    private List<String> phones;
    private List<TransactionStatus> statuses;

    public FilterRequest(List<String> phones, List<TransactionStatus> statuses) {
        this.phones = phones;
        this.statuses = statuses;
    }

    public List<String> getPhones() {
        return phones;
    }

    public List<TransactionStatus>  getStatuses() {
        return statuses;
    }
}
