import java.util.ArrayList;
import java.util.List;

public class VideoProcessor {
    private List<NotificationChannel> channels = new ArrayList<>();

    public void registerChannel(NotificationChannel channel) {
        channels.add(channel);
    }

    public void process(Video video) {
        for (NotificationChannel channel : channels) {
            String msgText = video.getFile() + " - " + video.getFormat();
            channel.notify(new Message(msgText, MessageType.LOG));
        }
    }
}