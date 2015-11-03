package com.qatestlab.utils.mail;


import javax.mail.*;
import java.io.InputStream;
import java.util.Properties;

public class MailHelper {

    private static Store store;
    private static Folder emailFolder;

    private static void connect(String login, String password){

        try{
            Properties props = System.getProperties();
            props.setProperty("mail.store.protocol", "imaps");
            props.setProperty("mail.imaps.ssl.trust", "*");
            Session session = Session.getDefaultInstance(props, null);
            store = session.getStore("imaps");
            store.connect("imap.gmail.com", login, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Message getMessage(String login, String password, MailMatcher mailMatcher, String folder){

        try{

            emailFolder = store.getFolder(folder);
            emailFolder.open(Folder.READ_ONLY);

            int start = emailFolder.getMessageCount() > 50 ? emailFolder.getMessageCount() - 50 : 1;

            Message[] messages = emailFolder.getMessages(start, emailFolder.getMessageCount());

            for(int i = 0; i < messages.length; i++) {

                if (isMessageMatchToPattern(messages[i], mailMatcher)){
                    return messages[i];
                }
            }

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static void disconnect(){
        try{
            emailFolder.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isMessageMatchToPattern(Message message, MailMatcher mailMatcher){

        boolean flag = false;

        try {
            if(mailMatcher.getMailSubject()!= null) flag = message.getSubject().equalsIgnoreCase(mailMatcher.getMailSubject());

            if((mailMatcher.getMailBody() != null | mailMatcher.getMailContentUniqueValue() != null) && flag){
                String mailBody = getMailText(message);

                if(mailMatcher.getMailBody() != null)
                    flag = mailBody.equals(mailMatcher.getMailBody());

                if(mailMatcher.getMailContentUniqueValue() != null)
                    flag = mailBody.contains(mailMatcher.getMailContentUniqueValue());
            }

        } catch (MessagingException e) {
            flag = false;
            e.printStackTrace();
        }

        return flag;
    }

    public static String getMailText(Message message){
        try{
            if(message.getContent() instanceof Multipart){
                Multipart messageContent = (Multipart)message.getContent();
                for(int i = 0; i < messageContent.getCount(); i++){
                    BodyPart bodyPart = messageContent.getBodyPart(i);

                    if(bodyPart.isMimeType("text/plain")) return (String) bodyPart.getContent();
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  "Mail has no text";
    }


    public static boolean isMailHasAttachments(Message msg)  {

        try {
            if (msg.isMimeType("multipart/mixed")) {
                Multipart mp = (Multipart) msg.getContent();
                if (mp.getCount() > 1) return true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public static InputStream getMailAttachment(Message message){

        InputStream inputStream = null;

        if(!isMailHasAttachments(message)) return null;

        try{
            Multipart multipart = (Multipart)message.getContent();

            for(int i = 0; i < multipart.getCount(); i++){

                if(multipart.getBodyPart(i).isMimeType("application/octet-stream")) {
                    inputStream = multipart.getBodyPart(i).getInputStream();
                }
                //add other cases if needed
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return inputStream;
    }

    public static Message waitForEmail(String login, String password, MailMatcher mailMatcher, String folder){

        connect(login, password);

        long timeout = 600000;
        long startTime = System.currentTimeMillis();



        while((System.currentTimeMillis() - startTime) < timeout){

            Message message = getMessage(login, password, mailMatcher, folder);


            if(message != null & !getMailText(message).equals("Mail has no text")){
                disconnect();
                return message;
            }

            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        disconnect();
        return null;
    }
}
