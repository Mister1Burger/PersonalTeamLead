package com.example.burger.personalteamlead.TMP;

import com.example.burger.personalteamlead.Fragments.FragmentsFlags;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by java on 27.11.2017.
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TmpData {
    int id;
    FragmentsFlags flag;
    String parentName;
    String description;

}
