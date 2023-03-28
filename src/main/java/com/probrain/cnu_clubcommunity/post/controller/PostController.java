package com.probrain.cnu_clubcommunity.post.controller;

import com.probrain.cnu_clubcommunity.post.ApiResponse;
import com.probrain.cnu_clubcommunity.post.dto.PostDto;
import com.probrain.cnu_clubcommunity.post.service.PostServiceImpl;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    PostServiceImpl postService;

    @Autowired
    public PostController(PostServiceImpl postServiceImpl) {
        this.postService = postServiceImpl;
    }

    @ExceptionHandler(NotFoundException.class)
    public ApiResponse<String> notFoundHandler (NotFoundException e) {
        return ApiResponse.fail(404, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<String> internalServerErrorHandler (Exception e) {
        return ApiResponse.fail(500, e.getMessage());
    }

    @GetMapping("/post-list")
    public ApiResponse<Page<PostDto>> getAllPlan(Pageable pageable) {
        Page<PostDto> all = postService.findAllPost(pageable);

        return ApiResponse.ok(all);
    }
}
