package com.geektech.hw5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterForListStudents extends RecyclerView.Adapter<ViewHolderStudents> {

    static ArrayList<Student> listStudents = new ArrayList<>();
    IStudentClick listener;

    void studentReplacement(@NonNull Student student) {
        for (int i = 0; i <= listStudents.size() - 1; i++) {
            if (student.getId() == listStudents.get(i).getId()) {
                listStudents.remove(i);
                listStudents.add(i, student);
                notifyDataSetChanged();
                break;
            }
        }
    }

    int putElement(@NonNull Student student) {
        student.setID(student.hashCode());
        listStudents.add(student);
        notifyDataSetChanged();
        return listStudents.size() - 1;
    }

    @NonNull
    @Override
    public ViewHolderStudents onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.view_holder_main, parent, false);
        ViewHolderStudents vh = new ViewHolderStudents(v);
        vh.listener = listener;
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderStudents holder, int position) {
        Student dataByPosition = listStudents.get(position);
        holder.onBind(dataByPosition);
    }

    @Override
    public int getItemCount() {
        return listStudents.size();
    }
}