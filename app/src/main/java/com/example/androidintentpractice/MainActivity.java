package com.example.androidintentpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void pindahActivity(View view) {
        Intent pindahActivity = new Intent(MainActivity.this, PindahActivity.class);
        startActivity(pindahActivity);
    }

    public void PindahActivityDenganData(View view) {
        Intent pindahActivityDenganDataIntent = new Intent(MainActivity.this, PindahDataActivity.class);
        pindahActivityDenganDataIntent.putExtra("KEY_NAMA", "Muhammad Istianto Ilham");
        pindahActivityDenganDataIntent.putExtra("KEY_EMAIL", "istianto.pahlawan@gmail.com");
        pindahActivityDenganDataIntent.putExtra("KEY_UMUR", 19);
        pindahActivityDenganDataIntent.putExtra("KEY_STATUS", false);
        startActivity(pindahActivityDenganDataIntent);

    }

    public void PindahActivityDenganObject(View view) {
//        Parcelable = from android
//        Serializable = from java
        User user = new User("Muhammad Istianto Ilham", "istianto@gmail.com", 32, true);

        Intent pindahActivityDenganObjectIntent = new Intent(MainActivity.this, PindahDenganObjectActivity.class);
        pindahActivityDenganObjectIntent.putExtra(PindahDenganObjectActivity.KEY_USER, user);
        startActivity(pindahActivityDenganObjectIntent);
    }

    public void PindahActivityDenganResult(View view) {
    }

    public void dialNumber(View view) {
    }

    public void bukaBrowser(View view) {
    }

    public void bukaMaps(View view) {
    }
}