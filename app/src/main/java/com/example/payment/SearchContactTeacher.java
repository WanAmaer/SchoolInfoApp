package com.example.assignmentmad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

public class SearchContactTeacher extends Fragment {

    private List<Teacher> mTeachers;
    private TeacherAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize the list of teachers
        mTeachers = new ArrayList<>();
        mTeachers.add(new Teacher("Cik Abu", "abupadu@um.edu.my", "013-7896876"));
        mTeachers.add(new Teacher("Cik Mastura", "mastura78@um.edu.my", "013-7855876"));
        mTeachers.add(new Teacher("Dr. Shalom", "shalommanickam@um.edu.my", "017-7896876"));
        mTeachers.add(new Teacher("Dr. Chiam", "chiam@um.edu.my", "011-1996876"));
        mTeachers.add(new Teacher("En. Malik", "malikamir@um.edu.my", "013-9896876"));
        mTeachers.add(new Teacher("En. Ong", "ongchongwei@um.edu.my", "014-7896876"));
        mTeachers.add(new Teacher("Pn. Alia", "aliafariha@um.edu.my", "017-7855875"));
        mTeachers.add(new Teacher("Pn. Saw", "sawpuisze@um.edu.my", "018-7896876"));
        mTeachers.add(new Teacher("Pn. Ranjitha", "ranjitha@um.edu.my", "012-2596876"));
        // Add more teachers here
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_contact_teacher, container, false);

        // Set up the RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new TeacherAdapter(mTeachers);
        recyclerView.setAdapter(mAdapter);

        // Set up the search bar
        androidx.appcompat.widget.SearchView searchView = view.findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return view;
    }

    private class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder> implements Filterable {

        private List<Teacher> mTeachers;
        private List<Teacher> mTeachersFull;

        public TeacherAdapter(List<Teacher> teachers) {
            mTeachers = teachers;
            mTeachersFull = new ArrayList<>(teachers);
        }

        @NonNull
        @Override
        public TeacherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // Inflate the layout for each teacher and return a new ViewHolder
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teacher_teacher, parent, false);
            return new TeacherViewHolder(view);
        }


        @Override
        public void onBindViewHolder(@NonNull TeacherViewHolder holder, int position) {
            // Set the name, email, and phone number for the teacher at the given position
            Teacher teacher = mTeachers.get(position);
            holder.bind(teacher);
        }

        @Override
        public int getItemCount() {
            return mTeachers.size();
        }

        @Override
        public Filter getFilter() {
            return new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    List<Teacher> filteredList = new ArrayList<>();
                    if (constraint == null || constraint.length() == 0) {
                        filteredList.addAll(mTeachersFull);
                    } else {
                        String filterPattern = constraint.toString().toLowerCase().trim();
                        for (Teacher teacher : mTeachersFull) {
                            if (teacher.getName().toLowerCase().contains(filterPattern)
                                    || teacher.getEmail().toLowerCase().contains(filterPattern)
                                    || teacher.getPhoneNumber().toLowerCase().contains(filterPattern)) {
                                filteredList.add(teacher);
                            }
                        }
                    }
                    FilterResults results = new FilterResults();
                    results.values = filteredList;
                    return results;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    mTeachers.clear();
                    mTeachers.addAll((List) results.values);
                    notifyDataSetChanged();
                }
            };
        }

        private class TeacherViewHolder extends RecyclerView.ViewHolder {

            private TextView mNameTextView;
            private TextView mEmailTextView;
            private TextView mPhoneNumberTextView;

            public TeacherViewHolder(@NonNull View itemView) {
                super(itemView);
                mNameTextView = itemView.findViewById(R.id.text_view_name);
                mEmailTextView = itemView.findViewById(R.id.text_view_email);
                mPhoneNumberTextView = itemView.findViewById(R.id.text_view_phone_number);
            }

            public void bind(Teacher teacher) {
                mNameTextView.setText(teacher.getName());
                mEmailTextView.setText(teacher.getEmail());
                mPhoneNumberTextView.setText(teacher.getPhoneNumber());

                /*itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String teacherEmail = teacher.getEmail();
                        Chat chatFragment = Chat.newInstance(teacherEmail);
                        getFragmentManager().beginTransaction().replace(R.id.container, chatFragment).commit();
                    }
                }); */
            }


        }

    }
}