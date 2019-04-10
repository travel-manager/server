package components;

import models.PaymentRequest;
import models.Transaction;
import models.Traveller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionComponent {

    public PaymentRequest calcPaymentRequest(List<Transaction> transactions, Traveller traveller){
        PaymentRequest paymentRequest = new PaymentRequest(traveller);
        HashMap<Traveller, HashMap<Traveller, Double>> amounts = new HashMap<>();

        for (Transaction transaction: transactions){
            //if the debt collector doesnt exist
            amounts.putIfAbsent(transaction.getPayer(), new HashMap<>());
            for (Traveller t:transaction.getFreeloaders()){
                //if the freeloader doesnt exist
                amounts.putIfAbsent(t, new HashMap<>());

                //create if not exists an record for the debt collector with the freeloader
                amounts.get(transaction.getPayer()).putIfAbsent(t, 0.00);

                //create if not exists an record for the freeloader with the deb collector
                amounts.get(t).putIfAbsent(transaction.getPayer(), 0.00);

                Double paymentPerUser = transaction.getAmount() / transaction.getFreeloaders().size();

                //make the debt collector go in the + with the freeloader
                amounts.get(transaction.getPayer()).put(t, amounts.get(transaction.getPayer()).get(t) + paymentPerUser);

                //make the freeloader go in the - with the debt collector
                amounts.get(t).put(transaction.getPayer(), amounts.get(t).get(transaction.getPayer()) - paymentPerUser);

            }
        }


        //loop through the hashmap by key of the current traveller and get all the debts/loans
        for (Map.Entry<Traveller, Double> entry : amounts.get(traveller).entrySet()){
            if (entry.getValue() > 0.00)
                paymentRequest.addPayment(entry.getKey(), entry.getValue());
            if (entry.getValue() < 0.00)
                paymentRequest.addDebt(entry.getKey(), entry.getValue());
        }

        return paymentRequest;
    }

}
