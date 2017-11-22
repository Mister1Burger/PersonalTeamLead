package com.example.burger.personalteamlead.Fragments;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.burger.personalteamlead.Classes.PTLClass;
import com.example.burger.personalteamlead.Controller.MainActivityControllerImpl;
import com.example.burger.personalteamlead.MainActivity;
import com.example.burger.personalteamlead.Methods.PTLMethod;
import com.example.burger.personalteamlead.Projects.PTLProject;
import com.example.burger.personalteamlead.R;
import com.example.burger.personalteamlead.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by java on 15.11.2017.
 */

public class AddFragment extends Fragment {
    @BindView(R2.id.name_et)
    EditText name_et;
    @BindView(R2.id.description_et)
    EditText description_et;
    @BindView(R2.id.cancel_btn)
    Button cancel_btn;
    @BindView(R2.id.add_btn)
    Button add_btn;
    MainActivityControllerImpl mAC;
    int id;
    String parentName;
    FragmentsFalgs falg;
    FragmentsMap fragmentsMap =  new FragmentsMap();


    public AddFragment() {
    }



    @SuppressLint("ValidFragment")
    public AddFragment(int id, String parentName, FragmentsFalgs falg) {
        this.id = id;
        this.parentName = parentName;
        this.falg = falg;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.class_fragment, container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem(id, parentName);
                fragmentsMap.addFlag(falg,id,parentName);
                ((MainActivity)getActivity()).getFragment(fragmentsMap.previousFragmet().getFlag(),fragmentsMap.previousFragmet().getId(),fragmentsMap.previousFragmet().getParentName());
            }
        });


    }

    public void addItem(int id, String parentName){
        PTLProject ptlProject = new PTLProject();
        PTLClass ptlClass =  new PTLClass();
        PTLMethod ptlMethod = new PTLMethod();
        switch (id){
            case 1:
            addProject(ptlProject);
            mAC.getProjectModule().addProject(ptlProject);
            mAC.getProjectModule().getPtlProjectAdapter().addProject(ptlProject);
            break;
            case 2:
                addClass(ptlClass,parentName);
                mAC.getClassModule().addClass(ptlClass, ptlProject);
            break;
            case 3:
                addMethod(ptlMethod,parentName);
                mAC.getMethodModule().addMethod(ptlMethod,ptlClass);
            break;

        }
    }
    public PTLProject addProject (PTLProject ptlProject){
        String name = name_et.getText().toString();
        if (name.length() == 0) {
            Toast toast = Toast.makeText(((MainActivity)getActivity().getBaseContext()),
                    "Enter the Name", Toast.LENGTH_SHORT);
            toast.show();
        }else {
            ptlProject.setName(name);

        }
        String description = description_et.getText().toString();
        if (name.length() == 0) {
            Toast toast = Toast.makeText(((MainActivity)getActivity().getBaseContext()),
                    "Enter the description", Toast.LENGTH_SHORT);
            toast.show();
        }else {
            ptlProject.setDescription(description);

        }
        return ptlProject;
    }

    public PTLClass addClass (PTLClass ptlClass, String parentName){
        String name = name_et.getText().toString();
        if (name.length() == 0) {
            Toast toast = Toast.makeText(((MainActivity)getActivity().getBaseContext()),
                    "Enter the Name", Toast.LENGTH_SHORT);
            toast.show();
        }else {
            ptlClass.setName(name);

        }
        String description = description_et.getText().toString();
        if (name.length() == 0) {
            Toast toast = Toast.makeText(((MainActivity)getActivity().getBaseContext()),
                    "Enter the description", Toast.LENGTH_SHORT);
            toast.show();
        }else {
            ptlClass.setDescription(description);

        }
        ptlClass.setParentName(parentName);
        return ptlClass;
    }

    public PTLMethod addMethod (PTLMethod ptlMethod, String parentName){
        String name = name_et.getText().toString();
        if (name.length() == 0) {
            Toast toast = Toast.makeText(((MainActivity)getActivity().getBaseContext()),
                    "Enter the Name", Toast.LENGTH_SHORT);
            toast.show();
        }else {
            ptlMethod.setName(name);

        }
        String description = description_et.getText().toString();
        if (name.length() == 0) {
            Toast toast = Toast.makeText(((MainActivity)getActivity().getBaseContext()),
                    "Enter the description", Toast.LENGTH_SHORT);
            toast.show();
        }else {
            ptlMethod.setDescription(description);

        }
        ptlMethod.setParentName(parentName);
        return ptlMethod;
    }

}
