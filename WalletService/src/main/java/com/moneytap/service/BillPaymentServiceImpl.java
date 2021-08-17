package com.moneytap.service;

import com.moneytap.model.BillPayment;
import com.moneytap.repository.BillPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillPaymentServiceImpl implements BillPaymentService{

    @Autowired
    BillPaymentRepository billPaymentRepository;

    @Override
    public void addBillPayment(BillPayment bill) {
        billPaymentRepository.save(bill);
    }

    @Override
    public BillPayment viewBillPayment(String id) {
        return billPaymentRepository.findById(id).get();
    }
}
