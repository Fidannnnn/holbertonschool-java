// VideoMediaPlayer.java
public class VideoMediaPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVLC(String fileName) {
        System.out.println("Playing VLC: " + fileName);
    }

    @Override
    public void playMP4(String fileName) {
        System.out.println("Playing MP4: " + fileName);
    }
}
