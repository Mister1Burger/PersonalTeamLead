package com.example.burger.personalteamlead.Modules;

import com.example.burger.personalteamlead.Projects.PTLProject;

import java.util.List;

/**
 * Created by java on 13.11.2017.
 */

public interface ProjectModule {

    public List<PTLProject> getProjects();

    public void removeProject(PTLProject ptlProject);

    public PTLProject getPtlProject();

    public void setPtlProject(PTLProject ptlProject);

    void addProject(PTLProject ptlProject);
}
