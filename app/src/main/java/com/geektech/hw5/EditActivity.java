package com.geektech.hw5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    public static final String PUT_EXTRA_FOR_STUDENT_EDIT = "put_extra_for_student_edit";

    EditText field_name;
    EditText field_pn;
    EditText field_group;
    Button save;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        field_name = findViewById(R.id.ef_name);
        field_pn = findViewById(R.id.ef_phone_number);
        field_group = findViewById(R.id.ef_group);
        save = findViewById(R.id.save_btn);
        cancel = findViewById(R.id.cancel_btn);


        Intent intent = getIntent();
        final Student student = (Student) intent.getSerializableExtra(PUT_EXTRA_FOR_STUDENT_EDIT);
        assert student != null;
        field_name.setText(student.getFullName());
        field_pn.setText(student.getPhoneNumber());
        field_group.setText(student.getGroup());

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = getIntent();
                    Student student = new Student(field_name.getText().toString(), field_pn.getText().toString(), field_group.getText().toString());
                    student.setID(student.getId());
                    assert intent != null;
                    intent.putExtra(ActivityForStudentInfo.PUT_EXTRA_FOR_STUDENT_ACTIVITY_VIEWING_STUDENT_INFORMATION, student);
                    setResult(RESULT_OK, intent);
                    finish();
            }
        });
    }
}