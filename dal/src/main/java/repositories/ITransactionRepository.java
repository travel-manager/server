package repositories;

import com.j256.ormlite.dao.Dao;
import models.Transaction;
import models.Traveller;

import java.util.List;

public interface ITransactionRepository extends Dao<Transaction, Integer> {

    List<Transaction> getAllTransactionWhoPaid(Traveller traveller);
}
