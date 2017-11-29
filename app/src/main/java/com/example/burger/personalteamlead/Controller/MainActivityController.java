package com.example.burger.personalteamlead.Controller;

import android.content.Context;

import com.example.burger.personalteamlead.Fragments.AddFragment;
import com.example.burger.personalteamlead.Fragments.ClassFragment;
import com.example.burger.personalteamlead.Fragments.MethodsFragment;
import com.example.burger.personalteamlead.Fragments.ProjectFragment;
import com.example.burger.personalteamlead.Modules.ClassModule;
import com.example.burger.personalteamlead.Modules.FragmentMap;
import com.example.burger.personalteamlead.Modules.MethodModule;
import com.example.burger.personalteamlead.Modules.ProjectModule;
import com.example.burger.personalteamlead.Modules.RealmModule.RealmPTL;
import com.example.burger.personalteamlead.TMP.TmpData;

/**
 * Created by java on 13.11.2017.
 */

public interface MainActivityController {
    void init(Context context);

    public ClassModule getClassModule();

    public ProjectModule getProjectModule();

    public MethodModule getMethodModule();

    RealmPTL getRealmPTL();

    TmpData getTmpData();

    public AddFragment getAddFragment();

    public ProjectFragment getProjectFragment();

    public ClassFragment getClassFragment();

    public MethodsFragment getMethodsFragment() ;

    FragmentMap getFragmentMap();
}
