package task2;

import com.mailjet.client.errors.MailjetException;

import java.util.ArrayList;
import java.util.List;

public class MailBox {
    public List<MailInfo> infos = new ArrayList<>();

    public void addMailInfo(MailInfo mailInfo) {
        infos.add(mailInfo);
    }

    public void sendAll() throws MailjetException {
        for (MailInfo info: infos) {
            MailSender.sendMail(info);
        }
    }
}
