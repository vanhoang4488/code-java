package lab.hoangnv.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Service
public class MailService {

    @Value("${oauth.client.id}")
    private String clientId;

    @Value("${oauth.client.secret}")
    private String clientSecret;

    @Value("${oauth.mail.scope}")
    private String mailScope;

    @Value("${oauth.client.request}")
    private  String request;

    public String sendMail(String to){
        try{
            String code = oAuthCode();
            return accessToken(code);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return "failed";
    }

    private String oAuthCode() throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("client_id", clientId);
        params.put("redirect_uri", "http://localhost:8888/user/mail");
        params.put("scope", mailScope);
        params.put("response_type", "code");
        params.put("approval_prompt", "force");
        params.put("access_type", "offline");

        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<String, String> entry : params.entrySet())
            stringBuilder.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), "utf-8")).append("&");

        String url = request + "?" + stringBuilder.toString();
        System.out.println(url);
        String response = Request.Get(url)
                .execute().returnContent().asString();
        System.out.println(response);
        JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);
        return jsonObject.get("code").toString();
    }

    private String accessToken(String code) throws IOException {
        String response = Request.Post(request)
                .bodyForm(Form.form().add("client_id", clientId)
                        .add("client_secret", clientSecret)
                        .add("redirect_uri", "http://localhost:8888/user/mail")
                        .add("grant_type", "authorization_code")
                        .add("code", code).build())
                .execute().returnContent().asString();
        System.out.println(response);
        JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);
        return jsonObject.get("access_token").toString();
    }
}
