package com.example.burger.personalteamlead.Modules;

import android.content.Context;

import com.example.burger.personalteamlead.Classes.PTLClass;

import java.util.List;

/**
 * Created by java on 13.11.2017.
 */

public interface ClassModule {

    List<PTLClass>  getClasses ();

    void removeClass (PTLClass ptlClass);
}
