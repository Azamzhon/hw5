package com.geektech.hw5;

import java.io.Serializable;

public class Student implements Serializable{
    private String fullName;
    private String phoneNumber;
    private String group;
    private int ID;

    Student(String fullName, String phoneNumber, String group) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.group = group;
    }

    void setID(int ID) {
        this.ID = ID;
    }

    public int getId() {
        return ID;
    }

    String getFullName() {
        return fullName;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    String getGroup() {
        return group;
    }
}