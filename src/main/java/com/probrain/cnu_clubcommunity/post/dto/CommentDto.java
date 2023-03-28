package com.probrain.cnu_clubcommunity.post.dto;

import com.probrain.cnu_clubcommunity.domain.forum.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Long commentId;
    private String content;
    private Post post;
    private LocalDateTime createdAt;
    private LocalDateTime lastEdited;
}
