// AudioPlayer.java
public class AudioPlayer implements MediaPlayer {
    @Override
    public void play(MediaType type, String fileName) {
        if (type == MediaType.MP3) {
            System.out.println("Playing MP3: " + fileName);
        } else {
            MediaPlayerAdapter adapter = new MediaPlayerAdapter(type);
            adapter.play(type, fileName);
        }
    }
}
