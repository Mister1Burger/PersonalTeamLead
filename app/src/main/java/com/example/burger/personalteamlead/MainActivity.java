package com.example.burger.personalteamlead;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.burger.personalteamlead.Classes.ClassActivity;
import com.example.burger.personalteamlead.Projects.PTLProject;
import com.example.burger.personalteamlead.Projects.PTLProjectAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R2.id.projects_list)
    RecyclerView projects_list;
    @BindView(R2.id.add_button)
    Button add_button;
    PTLProjectAdapter adapter;
    PTLProject project;
    RealmPTLProjects realmPTLProjects;
    List<PTLProject> projects;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        projects_list.setLayoutManager(llm);
        projects = realmPTLProjects.readPTLProject(this);

        adapter = new PTLProjectAdapter(projects, project -> {
            this.project = project;
            Intent intent = new Intent(MainActivity.this, ClassActivity.class);
            intent.putExtra("Name", project.getName());
            startActivity(intent);
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public void addProkect(){

    }
}
