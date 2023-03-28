package com.probrain.cnu_clubcommunity.post.service;

import com.probrain.cnu_clubcommunity.domain.forum.Comment;
import com.probrain.cnu_clubcommunity.domain.forum.CommentRepository;
import com.probrain.cnu_clubcommunity.domain.forum.Post;
import com.probrain.cnu_clubcommunity.domain.forum.PostRepository;
import com.probrain.cnu_clubcommunity.post.converter.PostConverter;
import com.probrain.cnu_clubcommunity.post.dto.CommentDto;
import com.probrain.cnu_clubcommunity.post.dto.PostDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final PostConverter postConverter;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, CommentRepository commentRepository, PostConverter postConverter) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.postConverter = postConverter;
    }

    @Transactional
    public Long savePost(PostDto postDto) {
        //dto -> entity
        Post post = postConverter.convertPost(postDto);
        //persistence
        Post postEntity = postRepository.save(post);

        return postEntity.getPostId();
    }

    @Transactional
    public Long saveComment(CommentDto commentDto) {
        //dto -> entity
        Comment comment = postConverter.convertComment(commentDto);
        //persistence
        Comment commentEntity = commentRepository.save(comment);

        return commentEntity.getCommentId();
    }

    @Transactional
    public Page<PostDto> findAllPost(Pageable pageable) {
        return postRepository.findAll(pageable)
                .map(postConverter::convertPostDto);
    }

    @Transactional
    public PostDto findOnePostById(Long id) throws NotFoundException {
        return postRepository.findById(id)
                .map(postConverter::convertPostDto)
                .orElseThrow(() -> new NotFoundException("cannot find post"));
    }
}
