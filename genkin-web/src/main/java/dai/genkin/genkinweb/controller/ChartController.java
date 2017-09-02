package dai.genkin.genkinweb.controller;

import dai.genkin.genkinweb.chart.DoughnutChart;
import dai.genkin.genkinweb.chart.MonthlyBarChart;
import dai.genkin.genkinweb.service.ExpenseService;
import dai.genkin.genkinweb.service.UserService;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import model.Expense;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ionut Ciuta on 9/2/2017.
 */
@RestController
@RequestMapping("/chart")
public class ChartController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private UserService userService;

    @GetMapping("/doughnut")
    public DoughnutChart getDoughnutChart(@RequestHeader("Authorization") String accessToken) {
        User user = userService.load(accessToken);

        if(user != null) {
            List<Expense> expenses = expenseService.getExpenses(user);
            return getDoughnutChart(expenses);
        } else {
            throw new UnsupportedOperationException("Unknown user: " + accessToken);
        }
    }

    @GetMapping("/monthlybar")
    public MonthlyBarChart getMonthlyBarChart(@RequestHeader("Authorization") String accessToken) {
        User user = userService.load(accessToken);

        if(user != null) {
            List<Expense> expenses = expenseService.getExpenses(user);
            return getBarChart(expenses);
        } else {
            throw new UnsupportedOperationException("Unknown user: " + accessToken);
        }
    }

    private MonthlyBarChart getBarChart(List<Expense> expenses) {
        Set<String> labels = new HashSet<>();
        Map<String, Double> data = new HashMap<>();

        MonthlyBarChart chart = new MonthlyBarChart();

        String[] monthNames = {
                "January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December"
        };

        expenses.stream().filter(expense -> {
            Calendar ref = Calendar.getInstance();
            int refYear = ref.get(Calendar.YEAR);

            Calendar curr = Calendar.getInstance();
            curr.setTime(expense.getDate());
            int currYear = curr.get(Calendar.YEAR);

            return refYear == currYear;
        }).collect(Collectors.toList()).forEach(expense -> {
            Calendar curr = Calendar.getInstance();
            curr.setTime(expense.getDate());
            String month = monthNames[curr.get(Calendar.MONTH)];
            if(!labels.contains(month)) {
                labels.add(month);
                data.put(month, expense.getAmount().doubleValue());
            } else {
                data.put(month, expense.getAmount().doubleValue() + data.get(month));
            }
        });

        chart.setLabels(Arrays.asList(labels.toArray(new String[labels.size()])));
        Collections.sort(chart.getLabels());

        int i = 0;
        for(String label : chart.getLabels()) {
            chart.getData().add(i, data.get(label));
            i++;
        };

        return chart;
    }

    private DoughnutChart getDoughnutChart(List<Expense> expenses) {
        Set<String> labels = new HashSet<>();
        Map<String, String> colors = new HashMap<>();
        Map<String, Double> data = new HashMap<>();

        DoughnutChart chart = new DoughnutChart();

        expenses.forEach(expense -> {
            String label = expense.getCategory().getName();

            if(!labels.contains(expense.getCategory().getName())) {
                labels.add(label);
                colors.put(label, expense.getCategory().getColor());
                data.put(label, expense.getAmount().doubleValue());
            } else {
                data.put(label, data.get(label) + expense.getAmount().doubleValue());
            }
        });

        int i = 0;
        for(String label : labels) {
            chart.getLabels().add(i, label);
            chart.getData().add(i, data.get(label));
            chart.getColors().add(i, colors.get(label));
            i++;
        }

        return chart;
    }
}
