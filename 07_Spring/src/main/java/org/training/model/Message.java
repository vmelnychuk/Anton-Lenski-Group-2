package org.training.model;

public class Message {
    private String toMailBox;
    private String fromMailBox;
    private String subject;
    private String messageText;
    private boolean sent;
    public Message() { this.sent = false; }
    public Message(String toMailBox, String fromMailBox, String subject,
            String messageText) {
        super();
        this.toMailBox = toMailBox;
        this.fromMailBox = fromMailBox;
        this.subject = subject;
        this.messageText = messageText;
        this.sent = false;
    }
    public String getToMailBox() {
        return toMailBox;
    }
    public void setToMailBox(String toMailBox) {
        this.toMailBox = toMailBox;
    }
    public String getFromMailBox() {
        return fromMailBox;
    }
    public void setFromMailBox(String fromMailBox) {
        this.fromMailBox = fromMailBox;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getMessageText() {
        return messageText;
    }
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    public boolean isSent() {
        return sent;
    }
    public void setSent(boolean sent) {
        this.sent = sent;
    }
    @Override
    public String toString() {
        return "Message [toMailBox=" + toMailBox + ", fromMailBox="
                + fromMailBox + ", subject=" + subject + ", messageText="
                + messageText + ", sent=" + sent + "]";
    }
}
