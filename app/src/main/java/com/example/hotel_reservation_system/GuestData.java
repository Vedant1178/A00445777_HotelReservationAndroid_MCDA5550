package com.example.hotel_reservation_system;

public class GuestData {

    String guest_name;
    int age;
    int gender;

    public GuestData(String guest_name, int age, int gender) {
        this.guest_name = guest_name;
        this.age = age;
        this.gender = gender;
    }

    public String getGuest_name() {
        return guest_name;
    }

    public void setGuest_name(String guest_name) {
        this.guest_name = guest_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
