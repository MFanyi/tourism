import com.shangda.tourism.TourismApplication;
import com.shangda.tourism.util.MailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = TourismApplication.class)
public class MailTest {
//    @Resource
//    private MailUtil mailUtil;
//
//    @Resource
//    private TemplateEngine templateEngine;
//
//    @Test
//    public void testHtmlMail() {
//        Context context = new Context();
//        context.setVariable("username", "sunday");
//
//        String content = templateEngine.process("mail/activation", context);
//        System.out.println(content);
//        mailUtil.sendMail("1263408260@qq.com", "Html", content);
//    }
}
