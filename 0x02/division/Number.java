public class Number {
    public static void todivide(int a, int b){
        int c = 0;
        try{
            c = a/b;
        }
        catch (ArithmeticException e){
            System.out.println("It is not possible to divide by zero.");
        }
        finally{
            System.out.printf("%d / %d = %d\n", a, b, c);
        }
    }
}
