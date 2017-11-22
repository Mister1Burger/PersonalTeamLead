package com.example.burger.personalteamlead.Fragments;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.example.burger.personalteamlead.Classes.PTLClass;
import com.example.burger.personalteamlead.Classes.PTLClassAdapter;
import com.example.burger.personalteamlead.Controller.MainActivityControllerImpl;
import com.example.burger.personalteamlead.MainActivity;
import com.example.burger.personalteamlead.R;
import com.example.burger.personalteamlead.R2;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClassFragment extends Fragment {
    @BindView(R2.id.add_button_class)
    Button add_button_class;
    @BindView(R2.id.path_in_class_tv)
    TextView pathTV;
    @BindView(R2.id.classes_list)
    RecyclerView classes_list;
    MainActivityControllerImpl mAC;
    PTLClassAdapter adapter;
    List<PTLClass> classes;
    PTLClass ptlClass;



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.class_fragment, container,false);
       ButterKnife.bind(this,view);
//       mAC = ((MainActivity)getActivity()).getmAC();
//       ptlClass = mAC.getClassModule().getPtlClass();
//        LinearLayoutManager llm = new LinearLayoutManager(getContext());
//        classes_list.setLayoutManager(llm);
//        classes = mAC.getClassModule().getClasses(ptlClass);
//        adapter = new PTLClassAdapter(classes,ptlClass1 ->  {
//        });
       return  view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
