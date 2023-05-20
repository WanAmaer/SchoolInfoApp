package com.example.assignmentmad;

// The Contact class represents a teacher's contact information, including their name and phone number.

public class ContactTeacher {
    private String name;
    private String phoneNumber;

    public ContactTeacher(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}