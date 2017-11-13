package com.example.burger.personalteamlead.Controller;

import android.content.Context;

import com.example.burger.personalteamlead.Modules.AddModule;
import com.example.burger.personalteamlead.Modules.ClassModule;
import com.example.burger.personalteamlead.Modules.MethodModule;
import com.example.burger.personalteamlead.Modules.ProjectModule;
import com.example.burger.personalteamlead.Realm.RealmPTLImpl;

/**
 * Created by java on 13.11.2017.
 */

public interface MainActivityController {
    void init(RealmPTLImpl realmPTL, Context context);
    public AddModule getAddModule();

    public ClassModule getClassModule();

    public ProjectModule getProjectModule();

    public MethodModule getMethodModule();
}
