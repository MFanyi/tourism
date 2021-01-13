$(function () {
    var pageNum = getUrlParam("pageNum");
    var row = 5;
    if (pageNum == null) {
        pageNum = 1;
    }
    var areaId = getUrlParam("areaId");
    $.get("comment?pageNum=" + pageNum + "&row=" + row + "&areaId=" + areaId, function (data) {
        data = $.parseJSON(data);
        var html = "";
        var commentList = data.commentPage.list;
        var userList = data.userList;
        var area = data.area;
        $("#area-name-head-a").text(area.name);
        $("#area-name-head-b").text(area.name);
        $("#img").attr('src', area.image);
        $("#area-name-body").text(area.name);
        $("#address").text(area.address);
        if (area.content.length !== 0) {
            $("#content").text(area.content);
        } else {
            $("#content").text("暂无简介");
        }
        $("#comment-num").text("评论:(" + area.commentNum + ")条");
        for (var i = 0; i < commentList.length; i++) {
            var comment = commentList[i];
            var user = userList[i];
            var scoreArea;
            var scoreCost;
            var scoreInterest;
            var imageThumbs = comment.imageThumb.split(",");
            var image;
            var userImag = data.userImag;
            var imgHtml = "";
            for (var j = 0; j < imageThumbs.length; j++) {
                image = imageThumbs[j].replace(/\s*/g, "");
                if (image.length !== 0) {
                    imgHtml += "<img src=\"" + image + "\"\n" +
                        "                     alt=\"img\">";
                }
            }
            if (commentList[i].scoreArea !== null) {
                scoreArea = commentList[i].scoreArea;
            } else {
                scoreArea = "5";
            }
            if (commentList[i].scoreCost !== null) {
                scoreCost = commentList[i].scoreCost;
            } else {
                scoreCost = "5";
            }
            if (commentList[i].scoreInterest !== null) {
                scoreInterest = commentList[i].scoreInterest;
            } else {
                scoreInterest = "5";
            }
            html += "<li class=\"comment\">\n" +
                "    <article>\n" +
                "        <div class=\"comment-avatar\">\n" +
                "            <figure style=\"width: 100px;height: 100px;\">\n" +
                "                <img src=\"" + userImag[i] + "\" class=\"img-circle\"\n" +
                "                     alt=\"img\">\n" +
                "            </figure>\n" +
                "        </div>\n" +
                "        <div class=\"comment-content\">\n" +
                "            <div class=\"comment-meta\">\n" +
                "                <div class=\"comment-meta-header\">\n" +
                "                    <h5 class=\"text-custom-black fw-600 author mb-3\">" + user + "</h5>\n" +
                "                    <div class=\"post-date\">\n" +
                "                        <a class=\"date bg-custom-blue text-custom-white\">景色:" + scoreArea + " 趣味:" + scoreInterest + "\n" +
                "                            性价比:" + scoreCost + "</a>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"comment-meta-reply\">\n" +
                "                    <a href=\"#\" class=\"text-light-dark mr-2\" tabindex=\"-1\">\n" +
                "                    <span class=\"text-custom-blue\">\n" +
                "                    <i class=\"fas fa-thumbs-up\"></i>\n" +
                "                    </span> 50\n" +
                "                    </a>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"comment\">\n" +
                "            <p class=\"text-light-dark\">\n" +
                "                " + comment.content + "</p>\n" +
                "        </div>\n" +
                "        <div class=\"comment-image\">\n" + imgHtml +
                "            \n" +
                "        </div>\n" +
                "        </div>\n" +
                "    </article>\n" +
                "</li>";
        }
        $("#comment").html(html);
        $("#previous").attr('href','comment.html?pageNum=1&areaId=' + area.id);
        $("#before").attr('href','comment.html?pageNum=' + data.commentPage.prePage + '&areaId=' + area.id);
        $("#now").text(data.commentPage.pageNum);
        $("#after").attr('href','comment.html?pageNum=' + data.commentPage.nextPage + '&areaId=' + area.id);
        $("#next").attr('href','comment.html?pageNum=' + data.commentPage.pages + '&areaId=' + area.id);
        if (!data.commentPage.hasPreviousPage) {
            $("#beforeli").addClass("disabled");
            $("#previousli").addClass("disabled");
        }
        if (!data.commentPage.hasNextPage) {
            $("#afterli").addClass("disabled");
            $("#nextli").addClass("disabled");
        }
    });
});