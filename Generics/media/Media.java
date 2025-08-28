public class Media {

    private String name;

    @Override
    public String toString() {
        return String.format("Type: %s - Name: %s", this.getClass().getName(), getName());
    }

    public Media(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
}
