package com.example.burger.personalteamlead.Projects;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.burger.personalteamlead.Classes.ClassFragment;
import com.example.burger.personalteamlead.Controller.MainActivityControllerImpl;
import com.example.burger.personalteamlead.MainActivity;
import com.example.burger.personalteamlead.R;
import com.example.burger.personalteamlead.R2;
import com.example.burger.personalteamlead.utils.AddFragment;
import com.example.burger.personalteamlead.utils.FragmentsFalgs;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by java on 15.11.2017.
 */

public class ProjectFragment extends Fragment {
    @BindView(R2.id.projects_list)
    RecyclerView projects_list;
    @BindView(R2.id.add_button)
    Button add_button;
    PTLProjectAdapter adapter;
    List<PTLProject> projects;


    MainActivityControllerImpl mAC;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.project_fragment,container,false);
        ButterKnife.bind(this,view);
        return  view;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        projects_list.setLayoutManager(llm);
        projects = mAC.getProjectModule().getProjects();
        adapter = new PTLProjectAdapter(projects, project -> {
            ((MainActivity)getActivity()).getFragment(FragmentsFalgs.CLASS,1, project.getName());

        });
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).getFragment(FragmentsFalgs.ADD,1,"");
            }
        });
    }

}
