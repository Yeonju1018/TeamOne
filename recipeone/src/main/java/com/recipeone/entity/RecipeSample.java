package com.recipeone.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RecipeSample")
public class RecipeSample{

    @Id
    private String id;
    private String title;
    private String tag;


}
