package com.example.approvalmatrix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText name, feature, min, max, total;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = findViewById(R.id.name_input);
        feature = findViewById(R.id.feature_input);
        min = findViewById(R.id.min_input);
        max = findViewById(R.id.max_input);
        total = findViewById(R.id.total_input);
        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabaseHandler myDB = new SQLiteDatabaseHandler(AddActivity.this);
                Matrix matrix = new Matrix();
                matrix.setName(name.getText().toString().trim());
                matrix.setFeature(feature.getText().toString().trim());
                matrix.setMinApproval(Long.valueOf(min.getText().toString().trim()));
                matrix.setMaxApproval(Long.valueOf(max.getText().toString().trim()));
                matrix.setNumOfApproval(Long.valueOf(total.getText().toString().trim()));

                myDB.addMatrix(matrix);
            }
        });
    }
}