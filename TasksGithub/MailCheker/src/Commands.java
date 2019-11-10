import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Created by triest on 22.03.2017.
 */
public class Commands {

    public void applyCommand(String[] command,Mail mail,Dialog dialog) throws IOException, MessagingException {
      //  System.out.println("apply command is run");
      //  System.out.println("folder in applly command "+mail.getFolder()); //почуму тут не INBOX?, я
        if (mail.getPosition().equals("folder")){
            System.out.println("in folder");

            if(command[0].equals("1")){
        //        System.out.println("commamd "+command[0]);
                mail.ShowOpenFolder(mail.getHost(),mail.getUsername(),mail.getPassword(),mail.getStore(),mail.getFolder());
            }
            if(command[0].equals("2")){

                mail.displayMessage(mail.getHost(),mail.getUsername(),mail.getPassword(),mail.getStore(),mail.getFolder(),dialog.AskLetterNumber());
            }
        }
        if(mail.getPosition().equals("letter")){
          //  System.out.println("in letter");
            if(command[0].equals("1")){
                mail.ShowOpenFolder(mail.getHost(),mail.getUsername(),mail.getPassword(),mail.getStore(),mail.getFolder());
            }
            if(command[0].equals("2")){
              //  mail.displayMessage(mail.getHost(),mail.getUsername(),mail.getPassword(),mail.getStore(),mail.getFolder(),dialog.AskLetterNumber());
                System.out.println("Write letter not suportet");
            }
        }

    }
}
