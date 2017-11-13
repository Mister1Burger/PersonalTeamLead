package com.example.burger.personalteamlead.Modules;

import com.example.burger.personalteamlead.Classes.PTLClass;

import java.util.List;

/**
 * Created by java on 13.11.2017.
 */

public interface MethodModule {

     List<PTLClass> getClasses ();

     void removeClass (PTLClass ptlClass);
}
