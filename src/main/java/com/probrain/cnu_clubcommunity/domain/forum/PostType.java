package com.probrain.cnu_clubcommunity.domain.forum;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "posttype")
@Getter
@Setter
public class PostType {
    @Id
    @Column(name = "post_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PostTypeId;
    @Column(name = "post_type_name")
    private String PostTypeName;
}
