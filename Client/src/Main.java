import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by triest on 12.06.2017.
 */
public class Main {
/*
    public static void main(String[] args) throws IOException {
     Client client=new Client();
 //    client.Connect();
   //  client.UserEnter();
//     client.SendTextMessage("TextMessage");
  //   client.SendLoginAndPasswordToServer();
     //   client.UserEnter();
       // client.SendTextMessage("Text");
  //   client.ClientExample();
        /*
    Client2 client2=new Client2();
         client2.exampl();


        final String host = "localhost";
        final int portNumber = 444;
        System.out.println("Creating socket to '" + host + "' on port " + portNumber);
        Socket socket;
        PrintWriter out;
        BufferedReader br;
        BufferedReader userInputBR;

        socket = new Socket(host, portNumber);
        while (true) {
         br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           out = new PrintWriter(socket.getOutputStream(), true);
            userInputBR = new BufferedReader(new InputStreamReader(System.in));

            //...code...

        }
     //   socket.close();
        /*out.close();
        br.close();
        userInputBR.close();
    }
    */



// оригинал
/*
        public static void main(String argv[]) throws Exception {
            String sentence;
            String modifiedSentence;
            BufferedReader inFromUser =
                    new BufferedReader(
                            new InputStreamReader(System.in));
            Socket clientSocket = new Socket("127.0.0.1", 6789);
            DataOutputStream outToServer =
                    new DataOutputStream(
                            clientSocket.getOutputStream());
            BufferedReader inFromServer =
                    new BufferedReader(
                            new InputStreamReader(
                                    clientSocket.getInputStream()));
            modifiedSentence="";
            int count=0;
            while (count<10){
                sentence = inFromUser.readLine();
            outToServer.writeBytes(sentence + "\n");
            modifiedSentence = inFromServer.readLine();
            System.out.println("FROM SERVER: " + modifiedSentence);
            count++;
        }
            clientSocket.close();
        }
    }
*/

    public static void main(String[] args) {
        Socket kkSocket = null;
        PrintWriter pw = null;
        BufferedReader br = null;
        try {
            kkSocket = new Socket("127.0.0.1", 4444);
            pw = new PrintWriter(kkSocket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: taranis");
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: taranis");
        }

        if (kkSocket != null && pw != null && br != null) {
            try {
                StringBuffer buf = new StringBuffer(50);
                int c;
                String fromServer;

                while ((fromServer = br.readLine()) != null) {
                    System.out.println("Server: " + fromServer);
                    if (fromServer.equals("Bye."))
                        break;
                    while ((c = System.in.read()) != '\n') {
                        buf.append((char)c);
                    }
                    System.out.println("Client: " + buf);
                    pw.println(buf.toString());
                    pw.flush();
                    buf.setLength(0);
                }

                pw.close();
                br.close();
                kkSocket.close();
            } catch (UnknownHostException e) {
                System.err.println("Trying to connect to unknown host: " + e);
            } catch (IOException e) {
                System.err.println("IOException:  " + e);
            }
        }
    }
}





