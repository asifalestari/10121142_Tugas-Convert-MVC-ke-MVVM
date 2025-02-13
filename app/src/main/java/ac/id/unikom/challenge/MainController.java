package ac.id.unikom.challenge;

public class MainController {
    private MainView view;
    private Meter model;

    public MainController(MainView view) {
        this.view = view;
        this.model = Meter.getInstance();
    }

    public void calculateLength() {
        String meter = view.getMeter();
        if (meter.isEmpty())
            meter = "0";

        Meter model = Meter.getInstance();
        double parsedMeter = Double.parseDouble(meter);
        model.setMeter(parsedMeter);

        model.toCentimeter();
        model.toKilometer();
    }
}
