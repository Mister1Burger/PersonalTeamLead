package com.example.burger.personalteamlead.utils;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.burger.personalteamlead.Classes.PTLClass;
import com.example.burger.personalteamlead.Controller.MainActivityControllerImpl;
import com.example.burger.personalteamlead.MainActivity;
import com.example.burger.personalteamlead.Methods.PTLMethod;
import com.example.burger.personalteamlead.Projects.PTLProject;
import com.example.burger.personalteamlead.R;
import com.example.burger.personalteamlead.R2;
import com.example.burger.personalteamlead.Realm.RealmPTLImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by java on 15.11.2017.
 */

public class AddFragment extends DialogFragment {
    @BindView(R2.id.name_et)
    EditText name_et;
    @BindView(R2.id.description_et)
    EditText description_et;
    MainActivityControllerImpl mAC;
    int id;
    String parentName;


    public AddFragment() {
    }



    @SuppressLint("ValidFragment")
    public AddFragment(int id, String parentName) {
        this.id = id;
        this.parentName = parentName;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.add_fragment, null))
                // Add action buttons
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        addItem(id,parentName);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        AddFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
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
