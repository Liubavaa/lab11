package task2;

public class GiftMail implements MailCode{
    private static final String TEMPLATE = "Black friday! %NAME check it out!";
    @Override
    public String generate(Client client) {
        return TEMPLATE.replaceAll("%NAME", client.getName());
    }
}
