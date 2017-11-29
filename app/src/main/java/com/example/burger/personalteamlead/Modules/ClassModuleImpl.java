package com.example.burger.personalteamlead.Modules;

import android.content.Context;

import com.example.burger.personalteamlead.Classes.PTLClass;
import com.example.burger.personalteamlead.Projects.PTLProject;
import com.example.burger.personalteamlead.Modules.RealmModule.RealmPTL;

import java.util.List;

/**
 * Created by java on 13.11.2017.
 */

public class ClassModuleImpl implements ClassModule {
    RealmPTL realmPTL;
    Context context;

    public ClassModuleImpl(RealmPTL realmPTL, Context context) {
        this.realmPTL = realmPTL;
        this.context = context;
    }

    @Override
    public List<PTLClass>  getClasses (PTLClass ptlClass){
        return realmPTL.readPTLClasses(context,ptlClass.getParentName());
    }

    @Override
    public void removeClass (PTLClass ptlClass){
        realmPTL.removePTLClass(context, ptlClass.getParentName());
    }

    @Override
    public void addClass(PTLClass ptlClass) {
        realmPTL.savePTLClass(context,ptlClass);
    }
}
