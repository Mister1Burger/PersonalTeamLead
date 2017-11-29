package com.example.burger.personalteamlead.Fragments;

import com.example.burger.personalteamlead.Fragments.FragmentsFlags;

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
public class PreviousFragment {
    private FragmentsFlags flag;
    private String parentName;
    private int id;
}
