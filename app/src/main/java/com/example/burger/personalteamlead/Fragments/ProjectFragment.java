package com.example.burger.personalteamlead.Fragments;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.burger.personalteamlead.Controller.MainActivityControllerImpl;
import com.example.burger.personalteamlead.MainActivity;
import com.example.burger.personalteamlead.Projects.PTLProject;
import com.example.burger.personalteamlead.Projects.PTLProjectAdapter;
import com.example.burger.personalteamlead.R;
import com.example.burger.personalteamlead.R2;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by java on 15.11.2017.
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectFragment extends Fragment {
    @BindView(R2.id.projects_list)
    RecyclerView projects_list;
    @BindView(R2.id.add_button)
    Button add_button;
    PTLProjectAdapter adapter;
    List<PTLProject> projects;
    MainActivityControllerImpl mAC;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.project_fragment, container, false);
        ButterKnife.bind(this, view);
        mAC = ((MainActivity) getActivity()).getMAC();
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        projects_list.setLayoutManager(llm);
        add_button.setOnClickListener(view1 -> ((MainActivity) getActivity()).getFragment(FragmentsFlags.ADD, 1, ""));
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onStart() {
        super.onStart();
        mAC.getFragmentMap().addFlag(FragmentsFlags.PROJECT, 1, "");
        mAC.getFragmentMap().clear();
        projects = mAC.getRealmPTL().readPTLProject(getContext());
        adapter = new PTLProjectAdapter(projects, project -> {
            ((MainActivity) getActivity()).getFragment(FragmentsFlags.CLASS, 2, project.getName());
            mAC.getTmpData().setDescription(project.getDescription());
            mAC.getTmpData().setParentName(project.getName());
        });
        projects_list.setAdapter(adapter);
    }
}
