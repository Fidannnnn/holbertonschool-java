public class Video extends Media {

    private int duration;

    public Video(String name, int duration) {
        super(name);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    
    
}
