import java.util.ArrayList;

public class Library <T extends Media>  {
    
    private ArrayList<T> tList = new ArrayList<T>();
    public void addMedia(T  t){
        tList.add(t);
    }
    public ArrayList<T> getMediaList(){
        return tList;
    }
}
