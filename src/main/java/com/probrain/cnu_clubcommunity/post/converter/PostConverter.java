package com.probrain.cnu_clubcommunity.post.converter;

import com.probrain.cnu_clubcommunity.domain.forum.Comment;
import com.probrain.cnu_clubcommunity.domain.forum.Post;
import com.probrain.cnu_clubcommunity.post.dto.CommentDto;
import com.probrain.cnu_clubcommunity.post.dto.PostDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PostConverter {
    //dto -> entity
    public Post convertPost(PostDto postDto) {
        return Post.builder()
                .postId(postDto.getPostId())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .likeCount(postDto.getLikeCount())
                .isNotice(postDto.getIsNotice())
                .postHashtag(postDto.getPostHashtag())
                .comments(postDto.getComments())
                .postType(postDto.getPostType())
                .createdAt(postDto.getCreatedAt())
                .lastEdited(postDto.getLastEdited())
                .build();
    }

    public Comment convertComment(CommentDto commentDto) {
        return Comment.builder()
                .commentId(commentDto.getCommentId())
                .content(commentDto.getContent())
                .post(commentDto.getPost())
                .createdAt(commentDto.getCreatedAt())
                .lastEdited(LocalDateTime.now())
                .build();
    }

    //entity -> dto
    public PostDto convertPostDto(Post post) {
        return PostDto.builder()
                .postId(post.getPostId())
                .title(post.getTitle())
                .content(post.getContent())
                .likeCount(post.getLikeCount())
                .postHashtag(post.getPostHashtag())
                .isNotice(post.getIsNotice())
                .comments(post.getComments())
                .postType(post.getPostType())
                .createdAt(post.getCreatedAt())
                .lastEdited(post.getLastEdited())
                .build();
    }

    public CommentDto convertCommentDto(Comment comment) {
        return CommentDto.builder()
                .commentId(comment.getCommentId())
                .content(comment.getContent())
                .post(comment.getPost())
                .createdAt(comment.getCreatedAt())
                .lastEdited(comment.getLastEdited())
                .build();
    }
}
