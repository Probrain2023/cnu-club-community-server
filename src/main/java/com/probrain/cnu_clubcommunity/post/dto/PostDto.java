package com.probrain.cnu_clubcommunity.post.dto;

import com.probrain.cnu_clubcommunity.domain.forum.Comment;
import com.probrain.cnu_clubcommunity.domain.forum.PostHashtag;
import com.probrain.cnu_clubcommunity.domain.forum.PostType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Long postId;
    private String title;
    private String content;
    private Integer likeCount;
    private Boolean isNotice;
    private PostHashtag postHashtag;
    private List<Comment> comments = new ArrayList<>();
    private PostType postType;
    private LocalDateTime createdAt;
    private LocalDateTime lastEdited;
}
