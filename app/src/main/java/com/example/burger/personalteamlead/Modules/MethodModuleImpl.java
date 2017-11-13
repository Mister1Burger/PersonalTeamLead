package com.example.burger.personalteamlead.Modules;

import android.content.Context;

import com.example.burger.personalteamlead.Classes.PTLClass;
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
    public List<PTLClass> getClasses (){
        return realmPTL.readPTLClasses(context);
    }

    @Override
    public void removeClass (PTLClass ptlClass){
        realmPTL.removePTLClass(context, ptlClass.getParentName);
    }
}
