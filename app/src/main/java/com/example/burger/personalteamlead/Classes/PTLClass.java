package com.example.burger.personalteamlead.Classes;

import io.realm.RealmObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PTLClass extends RealmObject {
    String name;
    String description;
    String parentName;



}
