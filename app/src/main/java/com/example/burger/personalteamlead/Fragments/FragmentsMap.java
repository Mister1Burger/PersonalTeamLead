package com.example.burger.personalteamlead.Fragments;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by java on 22.11.2017.
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class FragmentsMap  {
  private List<FragmentsFalgs> flags = new ArrayList();
  private List<Integer> ids = new ArrayList<>();
  private  List<String> parentNames = new ArrayList<>();


    public void addFlag(FragmentsFalgs flag, int id, String parentName){
     flags.add(flag);
     ids.add(id);
     parentNames.add(parentName);
    }

    public PreviousFragment previousFragmet(){
        PreviousFragment fragment = new PreviousFragment();
       FragmentsFalgs flag = flags.get(flags.size() - 1);
    switch (flag){
        case PROJECT:
            fragment.setFlag(FragmentsFalgs.PROJECT);
            fragment.setId(0);
            fragment.setParentName(null);
            break;

        case CLASS:
            fragment.setFlag(FragmentsFalgs.PROJECT);
            fragment.setId(0);
            fragment.setParentName(null);
            flags.remove(flags.size()-1);
            ids.remove(ids.size()-1);
            parentNames.remove(parentNames.size()-1);

            break;

        case METHOD:
            fragment.setFlag(FragmentsFalgs.CLASS);
            fragment.setId(ids.size()-2);
            fragment.setParentName(String.valueOf(parentNames.size()-2));
            Log.d("TAG", String.valueOf(parentNames.size()-2));
            flags.remove(flags.size()-1);
            ids.remove(ids.size()-1);
            parentNames.remove(parentNames.size()-1);
            break;

        case ADD:
            flags.remove(flags.size()-1);
            ids.remove(ids.size()-1);
            parentNames.remove(parentNames.size()-1);
            previousFragmet();
            break;
    }
    return fragment;

    }
}
