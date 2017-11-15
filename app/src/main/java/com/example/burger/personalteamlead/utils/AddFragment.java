package com.example.burger.personalteamlead.utils;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.burger.personalteamlead.Classes.PTLClass;
import com.example.burger.personalteamlead.Controller.MainActivityControllerImpl;
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
    MainActivityControllerImpl mAC;
    int id;
    String parentName

    public AddFragment() {
    }

    @SuppressLint("ValidFragment")
    public AddFragment(int id, String parentName) {
        this.id = id;
        this.parentName = parentName;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_fragment,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addItem(id,parentName);
    }

    public void addItem(int id, String parentName){
        PTLProject ptlProject = new PTLProject();
        PTLClass ptlClass = new PTLClass();
        PTLMethod ptlMethod = new PTLMethod();
        switch (id){
            case 1:
                ptlProject.setName(name_et.getText());
                ptlProject.setDescription(description_et.getText());
                mAC.getProjectModule().addProject(ptlProject);
            break;
            case 2:
                ptlClass.setName(name_et.getText());
                ptlClass.setDescription(description_et.getText());
                ptlClass.setParentName(parentName);
                mAC.getClassModule().addClass(ptlClass, ptlProject);
            break;
            case 3:
                ptlMethod.setName(name_et.getText());
                ptlMethod.setDescription(description_et.getText());
                ptlMethod.setParentName(parentName);
                mAC.getMethodModule().addMethod(ptlMethod,ptlClass);
            break;

        }
    }
}
