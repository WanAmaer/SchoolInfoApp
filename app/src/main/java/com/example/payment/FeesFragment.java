package com.example.payment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FeesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FeesFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FeesFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FeesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FeesFragment newInstance(String param1, String param2) {
        FeesFragment fragment = new FeesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fees, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstancesState){

        ImageButton BtnFPX = getView().findViewById(R.id.BtnFPX);
        ImageButton BtnCreditCard = getView().findViewById(R.id.BtnCreditCard);
        EditText ETPutYourAmountHere = getView().findViewById(R.id.ETPutYourAmountHere);

        View.OnClickListener OCLFPX =new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String input = ETPutYourAmountHere.getText().toString();
            if (!input.isEmpty()) {
                // Proceed to the next page
                Navigation.findNavController(view).navigate(R.id.DestBankList);
            } else {
                // Display an error message
                Toast.makeText(getActivity(), "Please enter a number", Toast.LENGTH_SHORT).show();
            }
        }
    };
        BtnFPX.setOnClickListener(OCLFPX);

        View.OnClickListener OCLCreditCard =new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = ETPutYourAmountHere.getText().toString();
                if (!input.isEmpty()) {
                    // Proceed to the next page
                    Navigation.findNavController(view).navigate(R.id.DestCardInfo);
                } else {
                    // Display an error message
                    Toast.makeText(getActivity(), "Please enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        };
        BtnCreditCard.setOnClickListener(OCLCreditCard);



    }
}