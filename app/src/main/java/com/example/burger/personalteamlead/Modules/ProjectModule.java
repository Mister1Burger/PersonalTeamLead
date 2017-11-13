package com.example.burger.personalteamlead.Modules;

import com.example.burger.personalteamlead.Projects.PTLProject;

import java.util.List;

/**
 * Created by java on 13.11.2017.
 */

public interface ProjectModule {

    public List<PTLProject> getProgects();

    public void removeClass(PTLProject ptlProject);
}
