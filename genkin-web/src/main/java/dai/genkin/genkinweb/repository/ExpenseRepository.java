package dai.genkin.genkinweb.repository;

import java.util.List;
import model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Ionut Ciuta on 9/1/2017.
 */
public interface ExpenseRepository extends MongoRepository<Expense, String> {
    public List<Expense> findAllByUserIdOrderByDateDesc(String userId);
}
