package com.pytha.springjpa.utility;

import com.pytha.springjpa.exception.InsuffientBalanceException;

import java.util.HashMap;
import java.util.Map;

public class PaymentGatewaySimulator {

    private static Map<String, Double> accountBalanceMap = new HashMap<>();

    {
        accountBalanceMap.put("acc-890900",2000.08);
        accountBalanceMap.put("acc-890922",4000.18);
        accountBalanceMap.put("acc-890521",2500.48);
    }

    // fare validator
    public static boolean validateFareBalanceCriteria(String accountNo, Double fare) throws InsuffientBalanceException {

        if(fare > accountBalanceMap.get(accountNo)){
            //exception
            throw new InsuffientBalanceException("You do not have suffient balance");
        }
        return true;
    }
}
