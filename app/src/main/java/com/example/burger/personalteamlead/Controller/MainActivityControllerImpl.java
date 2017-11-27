package com.example.burger.personalteamlead.Controller;

import android.content.Context;

import com.example.burger.personalteamlead.Fragments.AddFragment;
import com.example.burger.personalteamlead.Fragments.ClassFragment;
import com.example.burger.personalteamlead.Fragments.MethodsFragment;
import com.example.burger.personalteamlead.Fragments.ProjectFragment;
import com.example.burger.personalteamlead.Modules.ClassModule;
import com.example.burger.personalteamlead.Modules.ClassModuleImpl;
import com.example.burger.personalteamlead.Modules.MethodModule;
import com.example.burger.personalteamlead.Modules.MethodModuleImpl;
import com.example.burger.personalteamlead.Modules.ProjectModule;
import com.example.burger.personalteamlead.Modules.ProjectModulesImpl;
import com.example.burger.personalteamlead.Modules.RealmModule.RealmPTL;
import com.example.burger.personalteamlead.Modules.RealmModule.RealmPTLImpl;
import com.example.burger.personalteamlead.TMP.TmpData;

/**
 * Created by java on 13.11.2017.
 */

public class MainActivityControllerImpl implements MainActivityController {
    private ClassModule classModule;
    private ProjectModule projectModule;
    private MethodModule methodModule;
    private AddFragment addFragment ;
    private ProjectFragment projectFragment;
    private ClassFragment classFragment;
    private MethodsFragment methodsFragment;
    TmpData tmpData;
    RealmPTLImpl realmPTL = new RealmPTLImpl();


    @Override
    public void init(Context context) {
        classModule = new ClassModuleImpl(realmPTL,context);
        projectModule = new ProjectModulesImpl(realmPTL,context);
        methodModule = new MethodModuleImpl(realmPTL,context);
        addFragment = new AddFragment();
        projectFragment = new ProjectFragment();
        classFragment =  new ClassFragment();
        methodsFragment = new MethodsFragment();
        tmpData = new TmpData();


    }

    @Override
    public RealmPTLImpl getRealmPTL(){
        return realmPTL;
    }

    @Override
    public TmpData getTmpData(){
        return tmpData;
    }

    @Override
    public AddFragment getAddFragment() {
        return addFragment;
    }

    @Override
    public ProjectFragment getProjectFragment() {
        return projectFragment;
    }

    @Override
    public ClassFragment getClassFragment() {
        return classFragment;
    }

    @Override
    public MethodsFragment getMethodsFragment() {
        return methodsFragment;
    }

    @Override
    public ClassModule getClassModule() {
        return classModule;
    }

    @Override
    public ProjectModule getProjectModule() {
        return projectModule;
    }

    @Override
    public MethodModule getMethodModule() {
        return methodModule;
    }
}
