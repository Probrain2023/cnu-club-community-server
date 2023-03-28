package com.probrain.cnu_clubcommunity.domain.forum;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
@SuperBuilder
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
    private Boolean isNotice;
    @OneToOne(mappedBy = "post")
    private PostHashtag postHashtag;
    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "post_type_id")
    private PostType postType;
}
