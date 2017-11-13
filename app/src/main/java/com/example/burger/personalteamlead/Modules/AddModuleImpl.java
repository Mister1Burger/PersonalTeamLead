package com.example.burger.personalteamlead.Modules;

import android.content.Context;

import com.example.burger.personalteamlead.Classes.PTLClass;
import com.example.burger.personalteamlead.Methods.PTLMethod;
import com.example.burger.personalteamlead.Projects.PTLProject;
import com.example.burger.personalteamlead.Realm.RealmPTL;
import com.example.burger.personalteamlead.Realm.RealmPTLImpl;

/**
 * Created by java on 13.11.2017.
 */

public class AddModuleImpl implements AddModule {
    RealmPTL realmPTL;
    Context context;

    public AddModuleImpl(RealmPTLImpl realmPTL, Context context) {
        this.realmPTL = realmPTL;
        this.context = context;
    }

    @Override
    public void addProject(PTLProject ptlProject) {
        realmPTL.saveProject(context,ptlProject);
    }

    @Override
    public void addClass(PTLClass ptlClass, PTLProject ptlProject) {
      ptlClass.setParentName(ptlProject.getName());
      realmPTL.savePTLClass(context,ptlClass);

    }

    @Override
    public void addMethod(PTLMethod ptlMethod, PTLClass ptlClass) {
      ptlMethod.setParentName(ptlClass.getName());
      realmPTL.saveMethod(context,ptlMethod);
    }
}
