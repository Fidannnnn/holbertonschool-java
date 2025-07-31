public class Program {
        public static void main(String[] args) {

            boolean characterInUppercase1 = TheCharacter.IsUpper('a');
            boolean characterInUppercase2 = TheCharacter.IsUpper('B');
            boolean characterInUppercase3 = TheCharacter.IsUpper('d');
            boolean characterInUppercase4 = TheCharacter.IsUpper('f');
            boolean characterInUppercase5 = TheCharacter.IsUpper('G');

            System.out.printf("%b\n", characterInUppercase1);
            System.out.printf("%b\n", characterInUppercase2);
            System.out.printf("%b\n", characterInUppercase3);
            System.out.printf("%b\n", characterInUppercase4);
            System.out.printf("%b\n", characterInUppercase5);
        }
    }