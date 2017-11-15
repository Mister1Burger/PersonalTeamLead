package com.example.burger.personalteamlead.Projects;

import io.realm.RealmModel;
import io.realm.RealmObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Burge on 07.11.2017.
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PTLProject extends RealmObject {
    String name;
    String description;

}
