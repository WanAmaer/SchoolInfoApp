package com.example.assignmentmad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


// ComplaintManagement.java

public class ComplaintManagementTeacher extends Fragment {

    private TextView mTitleTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_complaint_management_teacher, container, false);

        mTitleTextView = view.findViewById(R.id.TVTitle1);

        Bundle args = getArguments();
        if (args != null) {
            String title = args.getString("title");
            mTitleTextView.setText(title);
        }

        // Find the submit button
        Button BtnSubmitComplaint = view.findViewById(R.id.BtnSubmitComplaint);
        /*
        // Set up an OnClickListener for the submit button
        BtnSubmitComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display a toast notification when the button is clicked
                Toast.makeText(getContext(), "Thank you for your submission!", Toast.LENGTH_SHORT).show();
            }
        });*/

        // Find the edit text element
        EditText ETComplaint = view.findViewById(R.id.ETComplaint);

// Set up an OnClickListener for the submit button
        BtnSubmitComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check the value of the edit text
                if (ETComplaint.getText().toString().trim().isEmpty()) {
                    // If the edit text is empty, display a toast message
                    Toast.makeText(getContext(), "You cannot send an empty complaint.", Toast.LENGTH_SHORT).show();
                } else {
                    // If the edit text is not empty, display a different toast message
                    Toast.makeText(getContext(), "Your complaint has been submitted. Sorry for any inconveniences caused.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}
