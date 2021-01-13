package com.shangda.tourism.dao;

import com.shangda.tourism.model.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> selectCommentByAreaId(int areaId);
    List<Comment> selectCommentByUserId(int userId);
    Comment selectCommentByContent(String content);

}
