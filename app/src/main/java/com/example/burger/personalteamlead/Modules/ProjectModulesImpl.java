package com.example.burger.personalteamlead.Modules;

import android.content.Context;

import com.example.burger.personalteamlead.Classes.PTLClass;
import com.example.burger.personalteamlead.Projects.PTLProject;
import com.example.burger.personalteamlead.Realm.RealmPTL;

import java.util.List;

/**
 * Created by java on 13.11.2017.
 */

public class ProjectModulesImpl implements  ProjectModule {
    RealmPTL realmPTL;
    Context context;

    public ProjectModulesImpl(RealmPTL realmPTL, Context context) {
        this.realmPTL = realmPTL;
        this.context = context;
    }

    @Override
    public List<PTLProject> getProgects (){
        return realmPTL.readPTLProject(context);
    }

    @Override
    public void removeClass (PTLProject ptlProject){
        realmPTL.removePTLClass(context, ptlProject.getName);
    }
}
