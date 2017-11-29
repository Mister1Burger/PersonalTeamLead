package com.example.burger.personalteamlead.Modules;

import android.content.Context;

import com.example.burger.personalteamlead.Projects.PTLProject;
import com.example.burger.personalteamlead.Projects.PTLProjectAdapter;
import com.example.burger.personalteamlead.Modules.RealmModule.RealmPTL;

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
    public List<PTLProject> getProjects (){
        return realmPTL.readPTLProject(context);
    }

    @Override
    public void removeProject (PTLProject ptlProject){
        realmPTL.removePTLProject(context, ptlProject.getName());
    }


    @Override
    public void addProject(PTLProject ptlProject) {
        realmPTL.savePTLProject(context,ptlProject);
    }




}
