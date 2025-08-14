package products;

public abstract class Products {
    private String title;
    private int year;
    private String country;
    private double grossPrice;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(double grossPrice) {
        this.grossPrice = grossPrice;
    }

    public Products(String title, int year, String country, double grossPrice) {
        this.title = title;
        this.year = year;
        this.country = country;
        this.grossPrice = grossPrice;
    }
    
    public abstract double getNetPrice();
}
