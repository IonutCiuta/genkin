package dai.genkin.genkinweb.controller;

import dai.genkin.genkinweb.service.ExpenseService;
import dai.genkin.genkinweb.service.UserService;
import java.util.List;
import model.Expense;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ionut Ciuta on 9/1/2017.
 */
@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<Expense> getExpenses(@RequestHeader("Authorization") String accessToken) {
        User user = userService.load(accessToken);

        if(user != null) {
            return expenseService.getExpenses(user);
        } else {
            throw new UnsupportedOperationException("Unknown user: " + accessToken);
        }
    }

    @PostMapping("/add")
    public Expense addExpense(@RequestBody Expense expense, @RequestHeader("Authorization") String accessToken) {
        User user = userService.load(accessToken);

        if(user != null) {
            expense.setUserId(user.getId());
            return expenseService.addExpense(expense);
        } else {
            throw new UnsupportedOperationException("Unknown user: " + accessToken);
        }
    }

    @DeleteMapping("/delete")
    public void deleteExpense(@RequestBody Expense expense, @RequestHeader("Authorization") String accessToken) {
        User user = userService.load(accessToken);

        if(user != null) {
            expenseService.deleteExpense(expense);
        } else {
            throw new UnsupportedOperationException("Unknown user: " + accessToken);
        }
    }
}
