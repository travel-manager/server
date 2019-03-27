package components;

import models.PaymentRequest;
import models.Transaction;
import models.Traveller;

import java.util.List;

public class TransactionComponent {

    public PaymentRequest calcPaymentRequest(List<Transaction> transactions, Traveller traveller){
        PaymentRequest paymentRequest = new PaymentRequest(traveller);

        for (Transaction t: transactions) {
            if (t.getPayer() == traveller){
                paymentRequest.addPayment(traveller, t.getAmount());
            }else {
                paymentRequest.addDebt(traveller, t.getAmount(), t.getPayer());
            }
        }
        return paymentRequest;
    }

}
