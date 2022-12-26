package task2;

import com.mailjet.client.errors.MailjetException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailSenderTest {

    @Test
    void sendMail() throws MailjetException {
        GiftMail giftMail = new GiftMail();
        Client client = new Client("Liuba", 18, Gender.MALE, "liubomyr.oleksiuk@ucu.edu.ua");
        MailInfo mailInfo = new MailInfo(client, giftMail);
        assertEquals(200, MailSender.sendMail(mailInfo));
    }
}