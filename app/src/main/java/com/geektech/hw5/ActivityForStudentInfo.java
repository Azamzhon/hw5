package com.geektech.hw5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityForStudentInfo extends AppCompatActivity {
    static final String KEY_FOR_STUDENT_ACTIVITY_VIEWING_STUDENT_INFORMATION = "key_for_student_activity_viewing_student_information";
    public static final String PUT_EXTRA_FOR_STUDENT_ACTIVITY_VIEWING_STUDENT_INFORMATION = "key_for_put_extra_MainActivity";
    private final int REQUEST_CODE_FOR_STUDENT_EDITING = 42;

    Button save;
    Button edit;
    TextView name;
    TextView pn;
    TextView group;
    Student student;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_info);

        if (getIntent() != null)
            intent = getIntent();
            initialization();
            fillingInInformation(student);
            setOnClickListeners();
    }

    public void initialization() {
        student = (Student) getIntent().getSerializableExtra(KEY_FOR_STUDENT_ACTIVITY_VIEWING_STUDENT_INFORMATION);
        name = findViewById(R.id.nameStudent);
        pn = findViewById(R.id.pnStudent);
        group = findViewById(R.id.groupStudent);
        edit = findViewById(R.id.btn_edit);
        save = findViewById(R.id.btn_save);
    }

    public void fillingInInformation(Student student) {
        assert student != null;
        name.setText(student.getFullName());
        pn.setText(student.getPhoneNumber());
        group.setText(student.getGroup());
    }


    public void setOnClickListeners() {
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityForStudentInfo.this, EditActivity.class);
                intent.putExtra(EditActivity.PUT_EXTRA_FOR_STUDENT_EDIT, student);
                startActivityForResult(intent, REQUEST_CODE_FOR_STUDENT_EDITING);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Student student = new Student(name.getText().toString(), pn.getText().toString(), group.getText().toString());
                    student.setID(student.getId());
                    assert intent != null;
                    intent.putExtra(MainActivity.PUT_EXTRA_MAIN_ACTIVITY, student);
                    setResult(RESULT_OK, intent);
                    finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_FOR_STUDENT_EDITING) {
            if (resultCode == RESULT_OK) {
                assert data != null;
                student = (Student) data.getSerializableExtra(PUT_EXTRA_FOR_STUDENT_ACTIVITY_VIEWING_STUDENT_INFORMATION);
                assert student != null;
                fillingInInformation(student);
            }
        }
    }
}
