package com.example.androidintentpractice;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PindahDenganObjectActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvEmail;
    private TextView tvAge;
    private TextView tvStatus;

    public static String KEY_USER = "ket_user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pindah_dengan_object);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvName = findViewById(R.id.tv_name);
        tvEmail = findViewById(R.id.tv_email);
        tvAge = findViewById(R.id.tv_age);
        tvStatus = findViewById(R.id.tv_status);

        getDataIntent();
    }

    private void getDataIntent() {
        if (getIntent() != null) {
            User user = getIntent().getParcelableExtra(KEY_USER);
            if (user != null) {
                String finalAge = user.getAge() + " Tahun";
                tvName.setText(user.getName());
                tvEmail.setText(user.getEmail());
                tvAge.setText(finalAge);
                tvStatus.setText(user.isStatus() ? "Oke" : "Tidak");
            }
        }
    }
}