// NIM  : 10121142
// Nama : Asifa Lestari
// Tugas Convert MVC ke MVVM

package ac.id.unikom.challenge;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private Meter model;

    public MainViewModel() {
        model = Meter.getInstance();
    }

    public LiveData<String> getKilometer() {
        return model.getKilometer();
    }

    public LiveData<String> getCentimeter() {
        return model.getCentimeter();
    }

    public void calculateLength(String meterStr) {
        if (meterStr.isEmpty()) {
            meterStr = "0";
        }
        double parsedMeter = Double.parseDouble(meterStr);
        model.setMeter(parsedMeter);
        model.toCentimeter();
        model.toKilometer();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Meter.destroy();
    }
}
