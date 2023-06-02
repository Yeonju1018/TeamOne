package com.recipeone.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Loginlog extends BaseEntity2 {

    @Id
    private String mid;
//    private String usersex;
//    private String userage;
    private long userlev;
    private LocalDateTime loginlog;


}
