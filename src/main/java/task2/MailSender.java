package task2;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;


public class MailSender {
    public static int sendMail (MailInfo mailInfo) throws MailjetException {
        String MJ_APIKEY_PUBLIC = "ed548e2a522d11dbb62a8131bfe81648";
        String MJ_APIKEY_PRIVATE = "d8f265b26dd8489f45f10e13680b0a96";
        String senderEmail = "oleksiukliub@gmail.com";

        String text = mailInfo.generate();
        String name = mailInfo.getClient().getName();
        String email = mailInfo.getClient().getEmail();

        ClientOptions options = ClientOptions.builder()
                .apiKey(MJ_APIKEY_PUBLIC)
                .apiSecretKey(MJ_APIKEY_PRIVATE)
                .build();

        MailjetClient client = new MailjetClient(options);

        MailjetRequest request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", senderEmail)
                                        .put("Name", "Me"))
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject()
                                                .put("Email", email)
                                                .put("Name", name)))
                                .put(Emailv31.Message.SUBJECT, "Hello!")
                                .put(Emailv31.Message.TEXTPART, text)));
        MailjetResponse response = client.post(request);
        return response.getStatus();
        //System.out.println(response.getData());
    }
}