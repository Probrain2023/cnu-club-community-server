package com.probrain.cnu_clubcommunity.domain.forum;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "posthashtag")
@Getter
@Setter
public class PostHashtag {
    @Id
    @Column(name = "postHashtag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postHashtagId;
    @OneToOne
    @JoinColumn(name = "hashtag_id")
    private Hashtag hashtag;
    @OneToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
