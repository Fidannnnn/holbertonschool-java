package products;

public class Dvd extends Products {
    
    private String director;
    private String genre;
    private int duration;
    public Dvd(String title, int year, String country, double grossPrice, String director, String genre, int duration) {
        super(title, year, country, grossPrice);
        this.director = director;
        this.genre = genre;
        this.duration = duration;
    }

    @Override
    public double getNetPrice(){
        return getGrossPrice() * 1.2;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
