package com.example.assignmentmad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import java.util.Map;
import java.util.HashMap;
import android.util.Log;





import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class ChatTeacher extends Fragment {

    private ListView mMessageListView;
    private EditText mMessageEditText;
    private ImageButton mSendButton;
    private Spinner mTeacherSpinner;
    private Map<String, List<Message>> mConversations;

    private List<Message> mMessages;
    private MessageAdapter mAdapter;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mConversations = new HashMap<>();

        // Add some sample conversations
        List<Message> conversation1 = new ArrayList<>();
        conversation1.add(new Message("Hello!", "Mr Pirvin", "Asifah"));
        conversation1.add(new Message("Hi Sir Pirvin!", "Asifah", "Mr Pirvin"));
        conversation1.add(new Message("I've received the complaint you sent to management about the school safety. Can we discuss about the complaint?", "Mr Pirvin", "Asifah"));
        conversation1.add(new Message("Sure Sir! Happy to help.", "Asifah", "Mr Pirvin"));
        mConversations.put("Asifah", conversation1);

        List<Message> conversation2 = new ArrayList<>();
        conversation2.add(new Message("Hey there! Are you the parent of student named Amsyar?", "Mr Pirvin", "Ammar Amaer"));
        conversation2.add(new Message("Hello, Sir. Yes, that is my son. Is there anything that I can help you?", "Ammar Amaer", "Mr Pirvin"));
        mConversations.put("Ammar Amaer", conversation2);

        // Add more conversations here
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat_teacher, container, false);

        // Initialize the ListView
        mMessageListView = view.findViewById(R.id.list_view_messages);

        // Initialize the Adapter
        mAdapter = new MessageAdapter(getContext(), mMessages);

        mMessages = new ArrayList<>();

        // Set up the ListView and Adapter
        mMessageListView = view.findViewById(R.id.list_view_messages);
        mAdapter = new MessageAdapter(getContext(), mMessages);
        mMessageListView.setAdapter(mAdapter);

        // Set the Adapter for the ListView if it is not null
        if (mMessageListView != null && mAdapter != null) {
            mMessageListView.setAdapter(mAdapter);
        }
        Log.d("ChatFragment", "mMessages: " + mMessages);

        // Set the Adapter for the ListView
        mMessageListView.setAdapter(mAdapter);

        // Set up the spinner
        mTeacherSpinner = view.findViewById(R.id.spinner_teachers);

        // Create a list of teacher names
        List<String> teacherNames = new ArrayList<>(mConversations.keySet());

        // Create an adapter for the spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, teacherNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the adapter on the spinner
        mTeacherSpinner.setAdapter(adapter);

        // Set an item selected listener on the spinner
        mTeacherSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected teacher's name
                String selectedTeacher = (String) parent.getItemAtPosition(position);
                // Get the conversation for the selected teacher
                List<Message> conversation = mConversations.get(selectedTeacher);

                // Update the messages displayed in the list view
                mMessages.clear();
                mMessages.addAll(conversation);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        // Set up the EditText and Button
        mMessageEditText = view.findViewById(R.id.edit_text_message);
        mSendButton = view.findViewById(R.id.button_send);
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = mMessageEditText.getText().toString();
                if (!message.isEmpty()) {
                    // Get the name of the currently selected teacher
                    String selectedTeacher = (String) mTeacherSpinner.getSelectedItem();
                    // Get the conversation for the selected teacher
                    List<Message> conversation = mConversations.get(selectedTeacher);
                    // Add the message to the conversation and update the list view
                    conversation.add(new Message(message, "Mr Pirvin", selectedTeacher));
                    //mMessages.clear();
                    //mMessages.addAll(conversation);
                    mAdapter.notifyDataSetChanged();
                    mMessageEditText.setText("");
                }
            }
        });

    /*public static Chat newInstance(String teacherEmail) {
        Chat fragment = new Chat();
        Bundle args = new Bundle();
        args.putString("teacher_email", teacherEmail);
        fragment.setArguments(args);
        return fragment;
    }*/

return view;
}}



