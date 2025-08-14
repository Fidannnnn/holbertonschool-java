public class Slack implements NotificationChannel {
    @Override
    public void notify(Message message) {
        System.out.printf("[SLACK] {%s} - %s%n", message.getMessageType(), message.getText());
    }
}