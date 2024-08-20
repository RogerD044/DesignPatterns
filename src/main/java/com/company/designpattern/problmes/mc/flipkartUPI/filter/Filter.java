package com.company.designpattern.problmes.mc.flipkartUPI.filter;

import com.company.designpattern.problmes.mc.flipkartUPI.Transaction;
import java.util.*;

public interface Filter {
    public List<Transaction> filter(List<Transaction> transactions);
}
