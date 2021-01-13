package com.shangda.tourism.controller;

import com.shangda.tourism.service.CommentService;
import com.shangda.tourism.util.JSONUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class CommentController {
    @Resource
    private CommentService commentService;

    @RequestMapping(path = "comment", method = RequestMethod.GET)
    public String commentListByAreaId(Integer pageNum, Integer row, Integer areaId) {
        Map<String, Object> map = commentService.commentByAreaId(areaId, pageNum, row);
        return JSONUtil.getJSONString(0,"success",map);
    }
}
