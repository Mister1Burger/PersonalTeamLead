package com.example.burger.personalteamlead.Modules;

import com.example.burger.personalteamlead.Classes.PTLClass;
import com.example.burger.personalteamlead.Methods.PTLMethod;

import java.util.List;

/**
 * Created by java on 13.11.2017.
 */

public interface MethodModule {

     List<PTLMethod> getMethods (PTLMethod ptlMethod);

     void removeMethod (PTLClass ptlClass);

    void addMethod(PTLMethod ptlMethod);
}
