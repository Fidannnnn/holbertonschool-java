public class Rectangle extends GeometricShape{
    protected double width;
    protected double height;
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        if (width < 0) {
            throw new IllegalArgumentException("Width must be greater than or equal to 0");
        }
        else this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        if (height < 0) {
            throw new IllegalArgumentException("Height must be greater than or equal to 0");
        }
        else this.height = height;
    }

    public double area(){
        return getHeight()*getWidth();
    }

    public String toString(){
        return String.format("[Rectangle] %.2f / %.2f", getWidth(), getHeight());
    }
    
}
