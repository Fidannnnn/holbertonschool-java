public class Program {
        public static void main(String[] args) {
            try {
                PositiveInteger positiveInteger = new PositiveInteger("1");
                System.out.println(positiveInteger.getValue() + " - " + positiveInteger.isPrime());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            PositiveInteger positiveInteger1 = null;

            try {
                positiveInteger1 = new PositiveInteger("43");
                System.out.println(positiveInteger1.getValue() + " - " + positiveInteger1.isPrime());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            try {
                positiveInteger1.setValor(-1);
                System.out.println(positiveInteger1.getValue() + " - " + positiveInteger1.isPrime());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            try {
                positiveInteger1.setValue(positiveInteger1.getValue() + 1);
                System.out.println(positiveInteger1.getValue() + " - " + positiveInteger1.isPrime());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            try {
                PositiveInteger positiveInteger = new PositiveInteger("-3");
                System.out.println(positiveInteger.getValue() + " - " + positiveInteger.isPrime());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            try {
                PositiveInteger positiveInteger = new PositiveInteger(379);
                System.out.println(positiveInteger.getValue() + " - " + positiveInteger.isPrime());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            try {
                PositiveInteger positiveInteger = new PositiveInteger(378);
                System.out.println(positiveInteger.getValue() + " - " + positiveInteger.isPrime());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }