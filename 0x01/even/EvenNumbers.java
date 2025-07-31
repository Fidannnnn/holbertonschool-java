public class EvenNumbers {
    public static void main(String args[]){
        for(int i = 0; i < 99; i=i+2){
            if (i < 98) {
                System.out.print(i + ", ");
            } else {
                System.out.println(i);
            }
        }
    }
}
