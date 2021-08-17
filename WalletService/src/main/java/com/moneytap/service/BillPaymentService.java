package com.moneytap.service;

import com.moneytap.model.BillPayment;

public interface BillPaymentService {
    void addBillPayment(BillPayment bill);
    BillPayment viewBillPayment(String id);
}
