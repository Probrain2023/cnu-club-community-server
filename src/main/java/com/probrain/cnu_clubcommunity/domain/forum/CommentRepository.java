package com.probrain.cnu_clubcommunity.domain.forum;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
