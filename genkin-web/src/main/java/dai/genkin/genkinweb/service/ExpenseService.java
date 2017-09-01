package dai.genkin.genkinweb.service;

import dai.genkin.genkinweb.repository.ExpenseRepository;
import java.util.List;
import model.Expense;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Ionut Ciuta on 9/1/2017.
 */
@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public void deleteExpense(Expense expense) {
        expenseRepository.delete(expense);
    }

    public List<Expense> getExpenses(User user) {
        return expenseRepository.findAllByUserIdOrderByDateDesc(user.getId());
    }
}
