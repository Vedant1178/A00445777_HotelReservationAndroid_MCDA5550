package com.example.hotel_reservation_system;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

public class ConfirmationFragment extends Fragment {
    View view;
    TextView hotelConfirmationTextView,ConfirmationNumberTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.confirmation_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hotelConfirmationTextView = view.findViewById(R.id.hotel_confirmation_text_view);
        ConfirmationNumberTextView = view.findViewById(R.id.confirmation_number_text_view);

        String hotelName = getArguments().getString("hotel name");
        String confirmationNumber = getArguments().getString("confirmation number");

        hotelConfirmationTextView.setText("Thank you for choosing "+hotelName);
        ConfirmationNumberTextView.setText("Your booking confirmation number is"+confirmationNumber);
    }


}
