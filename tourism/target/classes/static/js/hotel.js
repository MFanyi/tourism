$(document).ready(function () {
    var pageNum = getUrlParam("pageNum");
    var row = 12;
    if (pageNum == null) {
        pageNum = 1;
    }
    $.get("hotel?pageNum=" + pageNum + "&row=" + row, function (data) {
        data = $.parseJSON(data);
        var html = "";
        var hotelList = data.hotels.list;
        for (var i = 0; i < hotelList.length; i++) {
            var hotel = hotelList[i];
            var hotelName = hotel.hotelName.substring(0, 6) + "...";
            var city = hotel.city;
            var date = new Date(hotel.createTime).toLocaleDateString();
            var price = hotel.price;
            var address = hotel.address;
            var comment = hotel.comment;
            var commentNum = hotel.commentNum;
            var picture = hotel.picture;
            html += "<div class=\"col-xl-3 col-lg-4 col-md-6\">\n" +
                "                <div class=\"cruise-grid mb-xl-30\">\n" +
                "                    <div class=\"cruise-grid-wrapper bx-wrapper\">\n" +
                "                        <div class=\"image-sec animate-img\">\n" +
                "                            <a href=\"#\">\n" +
                "                                <img src=\"" + picture + "\" class=\"full-width\" alt=\"img\">\n" +
                "                            </a>\n" +
                "                        </div>\n" +
                "                        <div class=\"cruise-grid-caption padding-20 bg-custom-white p-relative\">\n" +
                "                            <h4 class=\"title fs-16 no-margin\"><a href=\"#\" class=\"text-custom-black\">" + hotelName + "<small\n" +
                "                                    class=\"text-light-dark\">" + comment + "</small></a></h4>\n" +
                "                            <span class=\"price\"><small>价格/每晚</small>￥" + price + "</span>\n" +
                "                            <div class=\"feedback\">\n" +
                "                                <div class=\"ratings\">\n" +
                "                                    <span class=\"text-yellow fs-12\"><i class=\"fas fa-star\"></i></span>\n" +
                "                                    <span class=\"text-yellow fs-12\"><i class=\"fas fa-star\"></i></span>\n" +
                "                                    <span class=\"text-yellow fs-12\"><i class=\"fas fa-star\"></i></span>\n" +
                "                                    <span class=\"text-yellow fs-12\"><i class=\"fas fa-star\"></i></span>\n" +
                "                                    <span class=\"text-yellow fs-12\"><i class=\"fas fa-star\"></i></span>\n" +
                "                                </div>\n" +
                "                                <span class=\"review fs-12 text-light-white\">" + commentNum + "条评论</span>\n" +
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
                "                                <a class=\"btn-first btn-submit\" href=\"#\" tabindex=\"0\">查看详情</a>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>";
        }
        $("#hotel").append(html);
        $("#previous").attr('href', 'hotels.html?pageNum=1');
        $("#before").attr('href', 'hotels.html?pageNum=' + data.hotels.prePage);
        $("#after").attr('href', 'hotels.html?pageNum=' + data.hotels.nextPage);
        $("#next").attr('href', 'hotels.html?pageNum=' + data.hotels.pages);
        $("#now").text(data.hotels.pageNum);
        if (!data.hotels.hasPreviousPage) {
            $("#beforeli").addClass("disabled");
            $("#previousli").addClass("disabled");
        }
        if (!data.hotels.hasNextPage) {
            $("#afterli").addClass("disabled");
            $("#nextli").addClass("disabled");
        }
    });
});