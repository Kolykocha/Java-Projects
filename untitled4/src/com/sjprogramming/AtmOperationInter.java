package com.sjprogramming;

import java.util.HashMap;
import java.util.Map;

public class AtmOperationInter implements AtmOperationInterf{
    ATM atm = new ATM();
    Map<Double,String> ministmt = new HashMap<>();
    @Override
    public void viewBalance() {
        System.out.println("Available Balance is: "+ atm.getBalance());
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if(withdrawAmount<=atm.getBalance()) {
            System.out.println(withdrawAmount + "Withdraw Successfully!!!");
            ministmt.put(withdrawAmount,"Amount Withdrawn");
            atm.setBalance(atm.getBalance() - withdrawAmount);
            viewBalance();
        }else{
            System.out.println("insufficient Balance!!!");
        }
    }

    @Override
    public void depositAmount(double depositAmount) {
        System.out.println(depositAmount+"Deposited Successfully!!!");
        ministmt.put(depositAmount,"Amount Deposited");
        atm.setBalance(atm.getBalance()+depositAmount);
        viewBalance();
    }

    @Override
    public void viewMiniStatement() {
        for(Map.Entry<Double,String> m: ministmt.entrySet()){
            System.out.println(m.getKey()+" "+ m.getValue());
        }
    }
}
