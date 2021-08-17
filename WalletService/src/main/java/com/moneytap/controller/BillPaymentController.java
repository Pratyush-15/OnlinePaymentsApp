package com.moneytap.controller;

import com.moneytap.model.BillPayment;
import com.moneytap.model.Transaction;
import com.moneytap.service.BillPaymentService;
import com.moneytap.service.WalletService;
import com.sun.net.httpserver.HttpsParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillPaymentController {

    @Autowired
    BillPaymentService billPaymentService;

    @Autowired
    WalletService walletService;

    public static final String walletServiceURL = "http://wallet-service/";

    @PostMapping("/bill")
    void addBillPayment(@RequestBody BillPayment bill, @RequestParam String walletId,
                        @RequestHeader("Authorization") String token){
        billPaymentService.addBillPayment(bill);
        walletService.payMoney(walletId,bill.getAmount());

    }

    @GetMapping("/bill/{id}")
    BillPayment viewBillPayment(@PathVariable String id){
        return billPaymentService.viewBillPayment(id);
    }
}
