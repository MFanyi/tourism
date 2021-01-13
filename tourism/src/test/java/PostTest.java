import com.alibaba.fastjson.JSONObject;

import org.apache.http.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

public class PostTest {
    public static String post(JSONObject json, String url) throws IOException {
        String body = "";

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("content-type", "application/json");

        StringEntity stringEntity = new StringEntity(json.toString(), "UTF-8");
        stringEntity.setContentEncoding("UTF-8");

        httpPost.setEntity(stringEntity);

        CloseableHttpResponse responseBody = httpclient.execute(httpPost);
        HttpEntity entity = responseBody.getEntity();
        if (entity != null) {
            body = EntityUtils.toString(entity, "UTF-8");
        }
        EntityUtils.consume(entity);
        httpclient.close();
        responseBody.close();
        return body;
    }


    public static void main(String[] args) {
        String url = "https://m.ctrip.com/restapi/soa2/13444/json/getCommentCollapseList?_fxpcqlniredt=09031108411554783550";
        String url2 = "https://m.ctrip.com/restapi/soa2/13444/json/getCommentCollapseList?_fxpcqlniredt=09031108411554783550";
        JSONObject jsonObject = new JSONObject();
        JSONObject arg = new JSONObject();
        JSONObject head = new JSONObject();
        arg.put("channelType", 2);
        arg.put("collapseType", 0);
        arg.put("commentTagId", 0);
        arg.put("pageIndex", 3);
        arg.put("pageSize", 10);
        arg.put("poiId", 77071);
        arg.put("sortType", 3);
        arg.put("sourceType", 1);
        arg.put("starType", 0);
        head.put("auth", "");
        head.put("cid", "09031108411554783550");
        head.put("ctok", "");
        head.put("cver", "1.0");
        List<JSONObject> extension = new ArrayList<>();
        head.put("extension", extension);
        head.put("lang", "01");
        head.put("sid", "8888");
        head.put("syscode", "09");
        head.put("xsid", "");
        jsonObject.put("arg", arg);
        jsonObject.put("head", head);
        System.out.println(jsonObject);
        String json = null;
        try {
            json = post(jsonObject, url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }
}
