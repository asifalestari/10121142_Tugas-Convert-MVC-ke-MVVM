package ac.id.unikom.challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements MainView{

    private EditText meter;
    private EditText kilometer;
    private EditText centimeter;
    private MainController controller;
    private Meter model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new MainController(this);
        model = Meter.getInstance();

        initView();
        observeModel();
    }

    private void observeModel() {
        model.getCentimeter().observe(this, centimeter -> {
            this.centimeter.setText(centimeter);
        });

        model.getKilometer().observe(this, kilometer -> {
            this.kilometer.setText(kilometer);
        });
    }

    private void initView() {
        meter = findViewById(R.id.meter);
        kilometer = findViewById(R.id.kilometer);
        centimeter = findViewById(R.id.centimeter);

        meter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                controller.calculateLength();
            }
        });
    }

    @Override
    protected void onDestroy() {
        controller = null;
        Meter.destroy();
        super.onDestroy();
    }

    @Override
    public String getMeter() {
        return meter.getText().toString();
    }
}