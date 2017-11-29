package com.example.burger.personalteamlead.Modules;

import com.example.burger.personalteamlead.Fragments.PreviousFragment;
import com.example.burger.personalteamlead.Fragments.FragmentsFlags;

/**
 * Created by java on 29.11.2017.
 */

public interface FragmentMap {
    void addFlag(FragmentsFlags flag, int id, String parentName);

    PreviousFragment previousFragment();

    void clear();

    int getFragmentsQuantity();
}
