package com.example.thirdassignment.ui.add_student;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.thirdassignment.R;
import com.example.thirdassignment.model.Student;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    Button btnSave;
    EditText etFullname, etAge, etAddress;
    RadioGroup rgGender;
    String fullname, age, gender, address;

    public static List<Student> studentList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard,container,false);

        btnSave = root.findViewById(R.id.btnSave);
        etFullname = root.findViewById(R.id.etFullName);
        etAge = root.findViewById(R.id.etAge);
        etAddress = root.findViewById(R.id.etAddress);
        rgGender = root.findViewById(R.id.rgGender);

        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.RBMale){
                    gender = "Male";
                }

                if (checkedId == R.id.RBFemale){
                    gender = "Female";
                }

                if (checkedId == R.id.RBOthers){
                    gender = "Others";
                }
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fullname = etFullname.getText().toString();
                age = etAge.getText().toString();
                address = etAddress.getText().toString();

                if (validate()){
                    studentList.add(new Student(fullname,age,gender,address));
                    Toast.makeText(getContext(), "Student Added Successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;
    }

    public boolean validate(){
        if (TextUtils.isEmpty(fullname)){
            etFullname.setError("Enter Full Name!");
            return false;
        }

        if (TextUtils.isEmpty(age)){
            etAge.setError("Enter Age!");
            return false;
        }

        if (TextUtils.isEmpty(address)){
            etAddress.setError("Enter Address!");
            return false;
        }
        if (TextUtils.isEmpty(gender)){
            Toast.makeText(getContext(), "Select Gender!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}