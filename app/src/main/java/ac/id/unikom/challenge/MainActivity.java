// NIM  : 10121142
// Nama : Asifa Lestari
// Tugas Convert MVC ke MVVM

package ac.id.unikom.challenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText meter;
    private EditText kilometer;
    private EditText centimeter;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi ViewModel
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        initView();
        observeViewModel();
    }

    private void initView() {
        meter = findViewById(R.id.meter);
        kilometer = findViewById(R.id.kilometer);
        centimeter = findViewById(R.id.centimeter);

        meter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                viewModel.calculateLength(meter.getText().toString());
            }
        });
    }

    private void observeViewModel() {
        viewModel.getKilometer().observe(this, km -> {
            kilometer.setText(km);
        });

        viewModel.getCentimeter().observe(this, cm -> {
            centimeter.setText(cm);
        });
    }
}
