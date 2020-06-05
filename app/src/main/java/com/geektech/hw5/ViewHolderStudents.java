package com.geektech.hw5;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ViewHolderStudents extends RecyclerView.ViewHolder {
    private TextView fullName;
    private TextView phoneNumber;
    private TextView group;
    private Student theStudent;
    IStudentClick listener;

    ViewHolderStudents(@NonNull View itemView) {
        super(itemView);
        fullName = itemView.findViewById(R.id.vh_student_full_name);
        phoneNumber = itemView.findViewById(R.id.vh_student_phone_number);
        group = itemView.findViewById(R.id.vh_student_group);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(fullName.getText().toString(), phoneNumber.getText().toString(), group.getText().toString());
                student.setID(student.getId());
                listener.onStudentClick(student);
            }
        });
    }

    void onBind(Student student){
        theStudent = student;
        putStudentInXmlFile(student);

    }

    private void putStudentInXmlFile(@NonNull Student student){
        fullName.setText(student.getFullName());
        phoneNumber.setText(student.getPhoneNumber());
        group.setText(student.getGroup());
        if (fullName.getText() != null && phoneNumber.getText() != null) {
            group.getText();
        }
    }
}