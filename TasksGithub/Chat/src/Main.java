/**
 * Created by triest on 29.03.2017.
 */

/*
Chat Application (IRC or MSN Style) – Create a chat application that can create simple
chat rooms like on Internet Relay Chat (IRC) or a more direct chatting style like MSN.
For added complexity, create your own protocol to facilitate this chatting.
* */
public class Main {

    public static void main(String[] args) {
       Sender sender=new Sender("127.0.0.1",1050);
       Recipient recipient=new Recipient();
       sender.setHost("127.0.0.1");
       sender.setPort(1050);
       sender.sendMessage("Hell4o");

    }
}
