public class Program {

    public static void main(String[] args) {

                System.out.println("Valid Email Test");
        boolean isValidEmail = EmailTest.test_email_with_at_symbol();
        System.out.println(isValidEmail);

              System.out.println("Email Test Without @ Symbol");
        isValidEmail = EmailTest.test_email_without_at_symbol();
        System.out.println(isValidEmail);

                System.out.println("Email Test With More Than 50 Characters");
        isValidEmail = EmailTest.test_email_over_50_characters();
        System.out.println(isValidEmail);
    }
}