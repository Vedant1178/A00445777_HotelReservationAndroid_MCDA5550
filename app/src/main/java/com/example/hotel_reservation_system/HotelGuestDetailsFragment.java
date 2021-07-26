package com.example.hotel_reservation_system;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HotelGuestDetailsFragment extends Fragment {

    View view;
    Button submitButton, nextButton;
    TextView tempConfirmationNoTextView,hotelNameTextView,checkInDateTextView,checkOutDateTextView,priceTextView;
    //String numberOfGuest = getArguments().getString("number of guests");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.hotel_guest_details_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hotelNameTextView = view.findViewById(R.id.choosen_hotel_name_text_view2);
        checkInDateTextView = view.findViewById(R.id.choosen_check_in_text_view2);
        checkOutDateTextView = view.findViewById(R.id.choosen_check_out_text_view2);
        priceTextView = view.findViewById(R.id.choosen_price_text_view2);
        submitButton = view.findViewById(R.id.guests_information_submit_button);
        nextButton = view.findViewById(R.id.guests_information_next_button);
        tempConfirmationNoTextView = view.findViewById(R.id.temp_confirmation_number_text_view);

        String hotelName = getArguments().getString("hotel name");
        String hotelPrice = "$"+getArguments().getString("hotel price");
        String hotelAvailability = getArguments().getString("hotel availability");
        String checkInDate = getArguments().getString("check in date");
        String checkOutDate = getArguments().getString("check out date");
        String numberOfGuest = getArguments().getString("number of guests");

        hotelNameTextView.setText(hotelName);
        checkInDateTextView.setText(checkInDate);
        checkOutDateTextView.setText(checkOutDate);
        priceTextView.setText(hotelPrice);
        //hotelRecapTextView.setText("You have selected " +hotelName+ ". The cost will be $ "+hotelPrice+ " and availability is " +hotelAvailability+". The number of Guests are "+numberOfGuest);

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i < Integer.valueOf(numberOfGuest); i++)
        {
            list.add(i);
        }

        ArrayList<HotelData> hotelData = new ArrayList<>();
        for(int i=0; i< Integer.valueOf(numberOfGuest);i++)
        {
            hotelData.add(new HotelData(hotelName,checkInDate,checkOutDate));
        }

        // Set up the RecyclerView
        //ArrayList<HotelListData> hotelListData = initHotelListData();
        RecyclerView recyclerView = view.findViewById(R.id.guest_list_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        GuestListAdapter guestListAdapter = new GuestListAdapter(getActivity(),hotelData);
        recyclerView.setAdapter(guestListAdapter);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String confirmation_number = tempConfirmationNoTextView.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("hotel name", hotelName);
                bundle.putString("confirmation number", confirmation_number);

                HotelGuestDetailsFragment hotelGuestDetailsFragment = new HotelGuestDetailsFragment();
                hotelGuestDetailsFragment.setArguments(bundle);

                ConfirmationFragment confirmationFragment = new ConfirmationFragment();
                confirmationFragment.setArguments(bundle);

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_layout,confirmationFragment);
                fragmentTransaction.remove(HotelGuestDetailsFragment.this);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                Log.d("msg ","You need to transfer to confirmation page!!!");
            }
        });


    }




}
