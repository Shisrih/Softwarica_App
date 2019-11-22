package com.example.softwaricaapp.ui.Students;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.softwaricaapp.Model.Students;
import com.example.softwaricaapp.R;

import java.util.ArrayList;
import java.util.List;

public class StudentFragment extends Fragment {
    public static List<Students> stList = new ArrayList<>();
    EditText nametxt, agetxt, addresstxt;
    RadioGroup gendergrp;
    String name, age, address, gender;
    int img;
    Button addbtn;
    public StudentFragment() {
        // Required empty public constructor
    }

    View root;


    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

         root = inflater.inflate(R.layout.fragment_students,container,false);
        nametxt  = root.findViewById(R.id.fullname);
        agetxt  = root.findViewById(R.id.age);
        gendergrp  = root.findViewById(R.id.gender);
        addresstxt  = root.findViewById(R.id.address);
        addbtn = root.findViewById(R.id.addbtn);



        gendergrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.male){
                    gender = "Male";
                    img = R.drawable.male;
                }
                if(i == R.id.female){
                    gender = "Female";
                    img = R.drawable.female;
                }
                if(i == R.id.others){
                    gender = "Others";
                    img = R.drawable.others;
                }

            }
        });

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addStudents();

            }
        });
        return root;
    }


    public void addStudents(){
        name = nametxt.getText().toString();
        age = agetxt.getText().toString();
        address = addresstxt.getText().toString();

        if(validate()){
            stList.add(new Students(name, age, gender, address, img));
            Toast.makeText(root.getContext(), "Student Added", Toast.LENGTH_SHORT).show();
        }



    }


    public boolean validate(){
        if(TextUtils.isEmpty(name)){
            nametxt.requestFocus();
            nametxt.setError("Name cannot be empty");
            return false;
        }
        if(TextUtils.isEmpty(age)){
            agetxt.requestFocus();
            agetxt.setError("Age cannot be empty");
            return false;
        }
        if(TextUtils.isEmpty(address)){
            addresstxt.requestFocus();
            addresstxt.setError("Address cannot be empty");
            return false;
        }
        if(TextUtils.isEmpty(gender)){
            Toast.makeText(root.getContext(), "Select Gender", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;

    }



}