package com.example.burger.personalteamlead.Modules;

import android.content.Context;

import com.example.burger.personalteamlead.Classes.PTLClass;
import com.example.burger.personalteamlead.Projects.PTLProject;

import java.util.List;

/**
 * Created by java on 13.11.2017.
 */

public interface ClassModule {

    List<PTLClass>  getClasses (PTLClass ptlClass);

    void removeClass (PTLClass ptlClass);

    void addClass(PTLClass ptlClass);
}
