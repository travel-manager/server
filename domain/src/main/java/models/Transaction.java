package models;

import lombok.Getter;

import java.text.DateFormat;
import java.util.List;

@Getter
public class Transaction extends StorableItem{
    private Traveller payer;
    private Double amount;
    private List<Traveller> freeloaders;
    private String subject;
    private DateFormat date;

    public Transaction(int id, Traveller payer, Double amount, List<Traveller> freeloaders, String subject, DateFormat date) {
        super(id);
        this.payer = payer;
        this.amount = amount;
        this.freeloaders = freeloaders;
        this.subject = subject;
        this.date = date;
    }
}
