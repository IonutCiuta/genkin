package dai.genkin.genkinweb.chart;

import java.util.ArrayList;
import java.util.List;

/**
 * Ionut Ciuta on 9/2/2017.
 */
public class DoughnutChart {
    private List<Double> data;
    private List<String> labels;
    private List<String> colors;

    public DoughnutChart() {
        this.data = new ArrayList<>();
        this.labels = new ArrayList<>();
        this.colors = new ArrayList<>();
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

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }
}
