package com.waaAssig.Assignment.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String title;
    private String content;

    @ManyToOne()
    @JoinColumn()
    @JsonBackReference()
    private Users user;

    @OneToMany( mappedBy = "post", cascade = CascadeType.ALL )
    @JsonManagedReference
    private List<Comment> comments;

}
