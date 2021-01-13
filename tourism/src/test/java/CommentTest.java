import com.shangda.tourism.TourismApplication;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = TourismApplication.class)
public class CommentTest {
    String url;

    @Test
    public void insertcomment() {
        for (int i = 1; i < 2; i++) {
            url = "https://you.ctrip.com/sight/haerbin151/s0-p" + i + ".html#sightname";
            try {
                Document root = Jsoup.connect(url).get();
                Element body = root.body();
                Elements rdetailbox = body.getElementsByClass("rdetailbox");
                for(Element el : rdetailbox){
                    Element a = el.getElementsByTag("a").get(0);
                    Element li = el.getElementsByTag("li").get(2);
                    String comment = li.getElementsByTag("a").get(0).attr("href");
                    String text = li.getElementsByTag("a").get(0).text();
                    System.out.println(comment);
                    System.out.println(text);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
