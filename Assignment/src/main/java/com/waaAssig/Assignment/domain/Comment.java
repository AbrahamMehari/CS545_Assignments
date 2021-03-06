package com.waaAssig.Assignment.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
//import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic( optional = false)
//    @NotNull
    @Column( nullable = false)
    private Long id;
    private String name;

    @ManyToOne()
    @JoinColumn()
    @JsonBackReference()
    private Post post;

}
