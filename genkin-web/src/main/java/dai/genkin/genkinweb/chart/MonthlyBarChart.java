package dai.genkin.genkinweb.chart;

import java.util.ArrayList;
import java.util.List;

/**
 * Ionut Ciuta on 9/2/2017.
 */
public class MonthlyBarChart {
    private List<Double> data;
    private List<String> labels;

    public MonthlyBarChart() {
        this.data = new ArrayList<>();
        this.labels = new ArrayList<>();
    }

    public List<Double> getData() {
        return data;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
}
