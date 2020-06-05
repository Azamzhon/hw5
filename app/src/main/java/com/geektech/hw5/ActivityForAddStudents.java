package com.geektech.hw5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityForAddStudents extends AppCompatActivity {
    EditText addName;
    EditText addPhone;
    EditText addGroup;
    Button saveStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_add_students);
        addName = findViewById(R.id.addName);
        addPhone = findViewById(R.id.addNumberOfPhone);
        addGroup = findViewById(R.id.addGroup);
        saveStudent = findViewById(R.id.saveStudent);
        final Intent intent = getIntent();
        if (intent == null)
            finish();

        saveStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(addName.getText().toString(), addPhone.getText().toString(), addGroup.getText().toString());
                assert intent != null;
                intent.putExtra(MainActivity.PUT_EXTRA_MAIN_ACTIVITY, student);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}