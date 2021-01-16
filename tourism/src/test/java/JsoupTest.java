import com.shangda.tourism.TourismApplication;
import com.shangda.tourism.dao.AreaDao;
import com.shangda.tourism.model.Area;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = TourismApplication.class)
public class JsoupTest {
//
//    @Resource
//    private AreaDao areaDao;
//
//    //只获取字符串中的数字
//    private static String toNum(String s) {
//        String regEx = "[^0-9]";
//        Pattern p = Pattern.compile(regEx);
//        Matcher m = p.matcher(s);
//        return m.replaceAll("").trim();
//    }
//
//    @Test
//    public void insertArea() {
//        String url;
//        Area area;
//        //这里的i=1为第一页  i<13为总页数+1
//        for (int i = 1; i < 13; i++) {
//            //url为景点的链接
//            url = "https://you.ctrip.com/sight/heihe265/s0-p" + i + ".html#sightname";
//            try {
//                Document root = Jsoup.connect(url).get();
//                Element body = root.body();
//                Elements list_mod2 = body.getElementsByClass("list_mod2");
//                for (Element e : list_mod2) {
//                    Element leftimg = e.getElementsByTag("div").get(1);
//                    Element rdetailbox = e.getElementsByTag("div").get(2);
//                    Element aa = leftimg.getElementsByTag("a").get(0);
//                    Element a = rdetailbox.getElementsByTag("a").get(0);
//                    Element li = rdetailbox.getElementsByTag("li").get(2);
//
//                    String html = aa.attr("href");
//                    html = "https://you.ctrip.com" + html;
//                    Document roota = Jsoup.connect(html).get();
//                    Element bodya = roota.body();
//                    StringBuilder contentBuilder = new StringBuilder();
//                    try {
//                        Element LimitHeightText = bodya.getElementsByClass("LimitHeightText").get(0);
//                        Element div = LimitHeightText.getElementsByTag("div").get(0);
//                        Elements p = div.getElementsByTag("p");
//                        for (Element p1 : p) {
//                            String p1s = p1.text();
//                            contentBuilder.append(p1s);
//                        }
//                    } catch (Exception e1) {
//                        System.out.println("该景点无简介");
//                    }
//                    String comment = li.getElementsByTag("a").get(0).text();
//                    Integer commentNum = Integer.parseInt(StringUtils.isBlank(toNum(comment)) ? "0" : toNum(comment));
//                    String address = rdetailbox.getElementsByTag("dd").get(0).text();
//                    String name = a.attr("title");
//                    String content = contentBuilder.toString();
//                    Element img = aa.getElementsByTag("img").get(0);
//                    String image = img.attr("src");
//                    area = new Area();
//                    area.setName(name);
//                    area.setCommentNum(commentNum);
//                    area.setContent(content);
//                    area.setImage(image);
//                    area.setAddress(address);
//                    areaDao.insertArea(area);
//                    System.out.println(name + "数据爬取完毕");
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
