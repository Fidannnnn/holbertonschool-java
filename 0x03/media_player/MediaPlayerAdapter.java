// MediaPlayerAdapter.java
public class MediaPlayerAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaPlayerAdapter(MediaType type) {
        if (type != MediaType.MP3) {
            advancedMediaPlayer = new VideoMediaPlayer();
        }
    }

    @Override
    public void play(MediaType type, String fileName) {
        if (advancedMediaPlayer == null) {
            System.out.println("Unsupported media type: " + type);
            return;
        }

        switch (type) {
            case VLC:
                advancedMediaPlayer.playVLC(fileName);
                break;
            case MP4:
                advancedMediaPlayer.playMP4(fileName);
                break;
            default:
                System.out.println("Unsupported media type: " + type);
        }
    }
}
