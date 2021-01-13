$(document).ready(function () {
    var pageNum = getUrlParam("pageNum");
    var row = 12;
    if (pageNum == null) {
        pageNum = 1;
    }
    $.get("area?pageNum=" + pageNum + "&row=" + row, function (data) {
        data = $.parseJSON(data);
        var html = "";
        var areaList = data.areaPage.list;
        for (var i = 0; i < areaList.length; i++) {
            var area = areaList[i];
            var date = new Date(area.createTime).toLocaleDateString();
            var address = area.address.substring(0, 4) + "...";
            var content;
            if (area.content.length !== 0) {
                content = area.content.substring(0, 10) + "...";
            } else {
                content = "暂无简介";
            }
            var commentUrl = "comment.html?pageNum=1&areaId=" + area.id;
            html += "<div class=\"col-xl-3 col-lg-4 col-md-6\">\n" +
                "                <div class=\"cruise-grid mb-xl-30\">\n" +
                "                    <div class=\"cruise-grid-wrapper bx-wrapper\">\n" +
                "                        <div class=\"image-sec animate-img\">\n" +
                "                            <a href=\"" + commentUrl + "\">\n" +
                "                                <img src=\"" + area.image + "\" class=\"full-width\" alt=\"img\">\n" +
                "                            </a>\n" +
                "                        </div>\n" +
                "                        <div class=\"cruise-grid-caption padding-20 bg-custom-white p-relative\">\n" +
                "                            <h4 class=\"title fs-16 no-margin\"><a href=\"" + commentUrl + "\" class=\"text-custom-black\">" + area.name + "<small\n" +
                "                                    class=\"text-light-dark\">" + content + "</small></a></h4>\n" +
                "                            <div class=\"feedback\">\n" +
                "                                <div class=\"ratings\">\n" +
                "                                    <span class=\"text-yellow fs-12\"><i class=\"fas fa-star\"></i></span>\n" +
                "                                    <span class=\"text-yellow fs-12\"><i class=\"fas fa-star\"></i></span>\n" +
                "                                    <span class=\"text-yellow fs-12\"><i class=\"fas fa-star\"></i></span>\n" +
                "                                    <span class=\"text-yellow fs-12\"><i class=\"fas fa-star\"></i></span>\n" +
                "                                    <span class=\"text-yellow fs-12\"><i class=\"fas fa-star\"></i></span>\n" +
                "                                </div>\n" +
                "                                <span class=\"review fs-12 text-light-white\">评论数" + area.commentNum + "</span>\n" +
                "                            </div>\n" +
                "                            <div class=\"row time\">\n" +
                "                                <div class=\"date col-6\">\n" +
                "                                    <i class=\"far fa-clock text-yellow fs-18\"></i>\n" +
                "                                    <div class=\"text-light-dark fs-12\">\n" +
                "                                        <span class=\"text-custom-blue\">更新日期</span><br>" + date + "\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                                <div class=\"departure col-6\">\n" +
                "                                    <i class=\"fas fa-map-marker-alt text-yellow fs-18\"></i>\n" +
                "                                    <div class=\"text-light-dark fs-12\">\n" +
                "                                        <span class=\"text-custom-blue\">地址</span><br>" + address + "\n" +
                "                                    </div>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                            <div class=\"action\">\n" +
                "                                <a class=\"btn-second btn-small\" href=\"" + commentUrl + "\" tabindex=\"0\">查看更多</a>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>";
        }
        $("#area").append(html);
        $("#previous").attr('href', 'area.html?pageNum=1');
        $("#before").attr('href', 'area.html?pageNum=' + data.areaPage.prePage);
        $("#after").attr('href', 'area.html?pageNum=' + data.areaPage.nextPage);
        $("#next").attr('href', 'area.html?pageNum=' + data.areaPage.pages);
        $("#now").text(data.areaPage.pageNum);
        if (!data.areaPage.hasPreviousPage) {
            $("#beforeli").addClass("disabled");
            $("#previousli").addClass("disabled");
        }
        if (!data.areaPage.hasNextPage) {
            $("#afterli").addClass("disabled");
            $("#nextli").addClass("disabled");
        }
    });
});
