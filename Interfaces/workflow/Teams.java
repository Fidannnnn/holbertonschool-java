public class Teams implements NotificationChannel {
    @Override
    public void notify(Message message) {
        System.out.printf("[TEAMS] {%s} - %s%n", message.getMessageType(), message.getText());
    }
}