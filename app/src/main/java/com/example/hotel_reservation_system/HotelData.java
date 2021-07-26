package com.example.hotel_reservation_system;

import java.util.HashSet;
import java.util.Set;

public class HotelData {

    String hotel_name;
    String checkin;
    String checkout;

    Set<GuestData> guests_list = new HashSet<>();

    public HotelData(String hotel_name, String checkin, String checkout) {
        this.hotel_name = hotel_name;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Set<GuestData> getGuests_list() {
        return guests_list;
    }

    public void setGuests_list(Set<GuestData> guests_list) {
        this.guests_list = guests_list;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public void addGuest(GuestData guest){
        this.guests_list.add(guest);
    }
}
