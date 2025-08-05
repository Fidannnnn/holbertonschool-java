
public class GoldEditionBook extends Book{

    public GoldEditionBook (String title, String author, double price)  throws InvalidAuthorException, InvalidBookException{
        super(title, author, price);
    }
    @Override
    public double getPrice() {
        return super.getPrice()*1.3;
    }
    
}
