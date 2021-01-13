package com.shangda.tourism.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shangda.tourism.dao.AreaDao;
import com.shangda.tourism.dao.CommentDao;
import com.shangda.tourism.dao.UserDao;
import com.shangda.tourism.model.Area;
import com.shangda.tourism.model.Comment;
import com.shangda.tourism.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class CommentService {
    @Resource
    private CommentDao commentDao;

    @Resource
    private UserDao userDao;

    @Resource
    private AreaDao areaDao;

    public Map<String, Object> commentByAreaId(int areaId, int pageNum, int row) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNum, row);
        List<Comment> commentList = commentDao.selectCommentByAreaId(areaId);
        Area area = areaDao.selectThisArea(areaId);
        List<String> userList = new LinkedList<>();
        List<String> userImag = new LinkedList<>();
        for(Comment comment : commentList){
            String name = userDao.selectById(comment.getUserId()).getName();
            String Image = userDao.selectById(comment.getUserId()).getHeaderUrl();
            userList.add(name);
            userImag.add(Image);
        }
        PageInfo<Comment> pageInfo = new PageInfo<>(commentList);
        map.put("commentPage", pageInfo);
        map.put("userList",userList);
        map.put("area",area);
        map.put("userImag",userImag);
        return map;
    }
}
