package com.example.burger.personalteamlead.Fragments;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
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
import com.example.burger.personalteamlead.Modules.RealmModule.RealmPTLImpl;

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
    MainActivityControllerImpl mAC ;
    PreviousFragment previousFragment;



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_fragment, container,false);
        ButterKnife.bind(this,view);
        mAC = ((MainActivity)getActivity()).getMAC() ;
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        add_btn.setOnClickListener(view1 -> {
            addItem(mAC.getTmpData().getId(), mAC.getTmpData().getParentName());
            ((MainActivity)getActivity()).getFragment(previousFragment.getFlag(),previousFragment.getId(),previousFragment.getParentName());
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mAC.getFragmentMap().addFlag(mAC.getTmpData().getFlag(),mAC.getTmpData().getId(),mAC.getTmpData().getParentName());
        previousFragment = mAC.getFragmentMap().previousFragment();
    }

    public void addItem(int id, String parentName){
        PTLMethod ptlMethod = new PTLMethod();
        switch (id){
            case 1:if (addProject() == null){
                Log.d("TAG", "NULL");
            }else {
                mAC.getProjectModule().addProject(addProject());}
            break;
            case 2:
                mAC.getClassModule().addClass(addClass(parentName));
            break;
            case 3:
               // mAC.getMethodModule().addMethod(addMethod(ptlMethod,parentName),addClass(ptlClass,parentName));
            break;

        }
    }
    public PTLProject addProject (){
        PTLProject ptlProject = new PTLProject();
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

    public PTLClass addClass (String parentName){
        PTLClass ptlClass =  new PTLClass();
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
