package com.probrain.cnu_clubcommunity.domain.forum;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hashtag")
@Getter
@Setter
public class Hashtag {
    @Id
    @Column(name = "hashtag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hashtagId;
    @Column(name = "hashtag_name")
    private String hashtagName;
    @OneToOne(mappedBy = "hashtag")
    private PostHashtag postHashtag;
}
