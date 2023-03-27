package com.probrain.cnu_clubcommunity.domain.forum;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
@Getter
@Setter
public class Post extends BaseEntity {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "like_count")
    private Integer likeCount;
    @Column(name = "is_notice", nullable = false)
    private boolean isNotice;
    @OneToOne(mappedBy = "post")
    private PostHashtag postHashtag;
    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "post_type_id")
    private PostType postType;
}
