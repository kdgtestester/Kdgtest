package com.testmatick.utils.mail;


public class MailMatcher {

    String mailSubject;
    String mailContentUniqueValue;
    String mailBody;
    boolean containsAttachment;

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }


    public String getMailContentUniqueValue() {
        return mailContentUniqueValue;
    }

    public void setMailContentUniqueValue(String mailContentUniqueValue) {
        this.mailContentUniqueValue = mailContentUniqueValue;
    }

    public String getMailBody() {
        return mailBody;
    }

    public void setMailBody(String mailBody) {
        this.mailBody = mailBody;
    }

    public boolean isContainsAttachment() {
        return containsAttachment;
    }

    public void setContainsAttachment(boolean containsAttachment) {
        this.containsAttachment = containsAttachment;
    }
}
