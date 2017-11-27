package com.example.burger.personalteamlead.Modules.RealmModule;

import android.content.Context;

import com.example.burger.personalteamlead.Classes.PTLClass;
import com.example.burger.personalteamlead.Methods.PTLMethod;
import com.example.burger.personalteamlead.Projects.PTLProject;

import java.util.List;

import io.realm.Realm;

/**
 * Created by java on 13.11.2017.
 */

public interface RealmPTL {
    Realm init(Context context);

    List<PTLClass> readPTLClasses(Context context, String parentName);

    void savePTLClass(Context context, PTLClass ptlClass);

    void removePTLClass(Context context, String parentName);

    void onDestroy(Context context);

    List<PTLMethod> readPTLMethods(Context context, String parentName);

    void savePTLMethod(Context context, PTLMethod ptlMethods);

    void removePTLMethod(Context context, String parentName);

    List<PTLProject> readPTLProject(Context context);

    void savePTLProject(Context context, PTLProject ptlProject);

    void removePTLProject(Context context, String name);
}
