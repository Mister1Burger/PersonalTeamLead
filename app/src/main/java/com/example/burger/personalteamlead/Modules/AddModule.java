package com.example.burger.personalteamlead.Modules;

import android.content.Context;

import com.example.burger.personalteamlead.Classes.PTLClass;
import com.example.burger.personalteamlead.Methods.PTLMethod;
import com.example.burger.personalteamlead.Projects.PTLProject;
import com.example.burger.personalteamlead.Realm.RealmPTLImpl;

/**
 * Created by java on 13.11.2017.
 */

public interface AddModule {
    void addProject(PTLProject ptlProject);
    void addClass(PTLClass ptlClass, PTLProject ptlProject);
    void addMethod(PTLMethod ptlMethod, PTLClass ptlClass);

}
