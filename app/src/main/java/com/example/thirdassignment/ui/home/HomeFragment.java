package com.example.thirdassignment.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thirdassignment.R;
import com.example.thirdassignment.adapters.StudentAdapter;
import com.example.thirdassignment.model.Student;
import com.example.thirdassignment.ui.add_student.DashboardFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home,container,false);

        recyclerView = root.findViewById(R.id.rvStudent);

        StudentAdapter studentAdapter = new StudentAdapter(DashboardFragment.studentList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(root.getContext());
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(layoutManager);

        return root;
    }
}