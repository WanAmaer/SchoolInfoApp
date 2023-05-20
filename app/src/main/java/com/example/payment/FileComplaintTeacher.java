package com.example.assignmentmad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FileComplaintTeacher extends Fragment {

    private Button mSafetyConcernsButton;
    private Button mTeachingLearningButton;
    private Button mFacilitiesButton;
    private Button mStudentBehaviourButton;
    private Button mAdministrationButton;
    private TextView mTitleTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_file_complaint_teacher, container, false);

        mSafetyConcernsButton = view.findViewById(R.id.BtnSafetyConcerns);
        mTeachingLearningButton = view.findViewById(R.id.BtnTeachingLearning);
        mFacilitiesButton = view.findViewById(R.id.BtnFacilities);
        mStudentBehaviourButton = view.findViewById(R.id.BtnStudentBehaviour);
        mAdministrationButton = view.findViewById(R.id.BtnAdministration);
        mTitleTextView = view.findViewById(R.id.TVTitle3);

        mSafetyConcernsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToComplaintManagementFragment("Safety Concerns");
            }
        });

        mTeachingLearningButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToComplaintManagementFragment("Teaching and Learning");
            }
        });

        mFacilitiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToComplaintManagementFragment("Facilities");
            }
        });

        mStudentBehaviourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToComplaintManagementFragment("Student Behaviour");
            }
        });

        mAdministrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToComplaintManagementFragment("Administration");
            }
        });

        return view;


    }

    private void navigateToComplaintManagementFragment(String title) {
        ComplaintManagementTeacher fragment = new ComplaintManagementTeacher();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
