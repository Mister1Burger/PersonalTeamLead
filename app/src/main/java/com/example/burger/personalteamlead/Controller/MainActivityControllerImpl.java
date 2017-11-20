package com.example.burger.personalteamlead.Controller;

import android.content.Context;

import com.example.burger.personalteamlead.Modules.ClassModule;
import com.example.burger.personalteamlead.Modules.ClassModuleImpl;
import com.example.burger.personalteamlead.Modules.MethodModule;
import com.example.burger.personalteamlead.Modules.MethodModuleImpl;
import com.example.burger.personalteamlead.Modules.ProjectModule;
import com.example.burger.personalteamlead.Modules.ProjectModulesImpl;
import com.example.burger.personalteamlead.Realm.RealmPTLImpl;

/**
 * Created by java on 13.11.2017.
 */

public class MainActivityControllerImpl implements MainActivityController {
    private ClassModule classModule;
    private ProjectModule projectModule;
    private MethodModule methodModule;


    @Override
    public void init(RealmPTLImpl realmPTL, Context context) {
        classModule = new ClassModuleImpl(realmPTL,context);
        projectModule = new ProjectModulesImpl(realmPTL,context);
        methodModule = new MethodModuleImpl(realmPTL,context);

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
