package com.example.burger.personalteamlead.Modules;

import android.content.Context;

import com.example.burger.personalteamlead.Classes.PTLClass;
import com.example.burger.personalteamlead.Methods.PTLMethod;
import com.example.burger.personalteamlead.Realm.RealmPTL;

import java.util.List;

/**
 * Created by java on 13.11.2017.
 */

public class MethodModuleImpl implements MethodModule {
    RealmPTL realmPTL;
    Context context;

    public MethodModuleImpl(RealmPTL realmPTL, Context context) {
        this.realmPTL = realmPTL;
        this.context = context;
    }

    @Override
    public List<PTLMethod> getMethods (PTLMethod ptlMethod){
        return realmPTL.readPTLMethods(context, ptlMethod.getParentName());
    }

    @Override
    public void removeMethod (PTLClass ptlClass){
        realmPTL.removePTLMethod(context, ptlClass.getParentName());
    }

    @Override
    public void addMethod(PTLMethod ptlMethod, PTLClass ptlClass) {
        ptlMethod.setParentName(ptlClass.getName());
        realmPTL.savePTLMethod(context,ptlMethod);
    }
}
