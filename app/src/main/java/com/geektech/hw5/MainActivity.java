package com.geektech.hw5;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements IStudentClick {

    static private final int ADD_CODE = 67;
    static private final int INFO_CODE = 88;
    public static final String PUT_EXTRA_MAIN_ACTIVITY = "key_for_put_extra_MainActivity";

    AdapterForListStudents adapter = new AdapterForListStudents();
    Button addNewStudent;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview_students_list);
        adapter.listener = this;
        recyclerView.setAdapter(adapter);
        addNewStudent = findViewById(R.id.addStudent);

        addNewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addNewStudent = new Intent(MainActivity.this, ActivityForAddStudents.class);
                startActivityForResult(addNewStudent, ADD_CODE);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_CODE) {
            if (resultCode == RESULT_OK) {
                assert data != null;
                int position = adapter.putElement((Student) Objects.requireNonNull(data.getSerializableExtra(PUT_EXTRA_MAIN_ACTIVITY)));
                recyclerView.scrollToPosition(position);
            }
        } else if (requestCode == INFO_CODE){
            if (resultCode == RESULT_OK){
                assert data != null;
                adapter.studentReplacement((Student) Objects.requireNonNull(data.getSerializableExtra(PUT_EXTRA_MAIN_ACTIVITY)));
            }
        }
    }

    @Override
    public void onStudentClick(Student student) {
        Intent intent = new Intent(this, ActivityForStudentInfo.class);
        intent.putExtra(ActivityForStudentInfo.KEY_FOR_STUDENT_ACTIVITY_VIEWING_STUDENT_INFORMATION, student);
        startActivityForResult(intent, ADD_CODE);
    }
}