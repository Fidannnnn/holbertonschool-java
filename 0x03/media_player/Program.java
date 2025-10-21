// Program.java
public class Program {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play(MediaType.MP3, "The Weeknd - Blinding Lights.mp3");

        System.out.println();

        VideoMediaPlayer videoMediaPlayer = new VideoMediaPlayer();
        videoMediaPlayer.playMP4("Uncharted.mp4");

        System.out.println();

        audioPlayer.play(MediaType.VLC, "Moon Knight S01E01.vlc");
    }
}
