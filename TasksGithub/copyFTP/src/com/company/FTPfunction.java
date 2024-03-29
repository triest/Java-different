package com.company;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.net.SocketException;
import java.io.*;
import java.net.SocketException;

/**
 * Created by triest on 06.03.2017.
 */
public class FTPfunction {

    public boolean connect(FTPClient ftpClient, String hostname, String username, String password) {
        try {
            ftpClient.connect(hostname);
            boolean login=ftpClient.login (username,password);
            boolean answer=ftpClient.sendNoOp ();
            if (login==true&&answer==true){
                return true;
            }
            else {return false;}

        }catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }


    public static boolean downloadFile( FTPClient ftpClient,String Filename) {

        OutputStream output = null;
        try {
            //***********
            String remoteFile1 = Filename;
            File downloadFile1=new File("E:/Dropbox/"+remoteFile1);
            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
            System.out.println(success);
            outputStream1.close();
            if (success == true) {
                System.out.println ("Download success!");
                return true;
            }
            else System.out.println("False");

        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public static boolean uploadFile(FTPClient ftpClient,String patchname) {

        OutputStream output = null;
        try {
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            //тут попробуем залить
            // client.enterLocalActiveMode();
            System.out.println();
            System.out.println("Start upload");
            //       client.setFileType(FTP.BINARY_FILE_TYPE);
            File file = new File (patchname);
            //     String patch="E:/Dropbox/HQ2.txt";
            String testName = file.getName();

            if ((!file.exists()) || (!file.canRead())){
                System.err.println("File Not Found or Unreadable: " + file.getName());
            }
            FileInputStream fis = new FileInputStream(file);
            boolean result = ftpClient.storeFile(testName, fis);

            System.out.println(file.getPath());
            if (result == true) {
                System.out.println("File was upload");
                return result;
            } else {
                System.out.println("FAIL upload");
                return result;
            }
            // конец заливки.

        /*
         * Use passive mode as default because most of us are behind
         * firewalls these days.
         */
//        return true;

        }catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }
}
