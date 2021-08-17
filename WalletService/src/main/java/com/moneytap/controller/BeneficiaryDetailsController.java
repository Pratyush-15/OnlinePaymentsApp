package com.moneytap.controller;

import com.moneytap.exceptions.WalletNotFoundException;
import com.moneytap.model.BeneficiaryDetails;
import com.moneytap.model.Wallet;
import com.moneytap.service.BeneficiaryDetailsService;
import com.moneytap.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class BeneficiaryDetailsController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BeneficiaryDetailsService beneficiaryDetailsService;

    @Autowired
    WalletService walletService;

    @GetMapping("/beneficiaries")
    List<BeneficiaryDetails> getAllBeneficiaries(){
        return beneficiaryDetailsService.getAllBeneficiaries();
    }

    @PostMapping("/beneficiaries")
    void addBeneficiaryDetails(@RequestBody BeneficiaryDetails beneficiaryDetails, @RequestParam String walletId){
        try {
            beneficiaryDetails.setWallet(walletService.getWalletById(walletId));
        } catch (WalletNotFoundException e) {
            e.printStackTrace();
        }
        beneficiaryDetailsService.addBeneficiaryDetails(beneficiaryDetails);
    }

    @GetMapping("/beneficiaries/{id}")
    BeneficiaryDetails viewBeneficiaryDetails(@PathVariable String id){
        return beneficiaryDetailsService.viewBeneficiaryDetails(id);
    }

    @DeleteMapping("/beneficiaries/{id}")
    void deleteBeneficiaryDetails(String id){
        beneficiaryDetailsService.deleteBeneficiaryDetails(id);
    }
}
