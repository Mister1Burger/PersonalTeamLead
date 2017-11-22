package com.example.burger.personalteamlead.Modules;

import android.content.Context;

import com.example.burger.personalteamlead.Classes.PTLClass;
import com.example.burger.personalteamlead.Projects.PTLProject;
import com.example.burger.personalteamlead.Projects.PTLProjectAdapter;
import com.example.burger.personalteamlead.Realm.RealmPTL;

import java.util.List;

/**
 * Created by java on 13.11.2017.
 */

public class ProjectModulesImpl implements  ProjectModule {
    RealmPTL realmPTL;
    Context context;
    PTLProject ptlProject ;
    PTLProjectAdapter ptlProjectAdapter;


    public ProjectModulesImpl(RealmPTL realmPTL, Context context) {
        this.realmPTL = realmPTL;
        this.context = context;
        ptlProject = new PTLProject();
        ptlProjectAdapter = new PTLProjectAdapter();
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
    public PTLProject getPtlProject() {
        return ptlProject;
    }

    @Override
    public void setPtlProject(PTLProject ptlProject) {
        this.ptlProject = ptlProject;
    }

    @Override
    public void addProject(PTLProject ptlProject) {
        realmPTL.savePTLProject(context,ptlProject);
    }

    public PTLProjectAdapter getPtlProjectAdapter() {
        return ptlProjectAdapter;
    }

    public void setPtlProjectAdapter(PTLProjectAdapter ptlProjectAdapter) {
        this.ptlProjectAdapter = ptlProjectAdapter;
    }


}
