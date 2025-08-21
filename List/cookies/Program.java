public class Program {
        public static void main(String[] args) {
            Order order = new Order();

            order.addCookieOrder(new CookieOrder("Chocolate", 10));
            order.addCookieOrder(new CookieOrder("Nutella", 3));
            order.addCookieOrder(new CookieOrder("Vanilla", 2));

            System.out.println(String.format("Total: %d", order.getTotalBoxes()));

            order.addCookieOrder(new CookieOrder("Chocolate", 1));
            order.addCookieOrder(new CookieOrder("Nutella", 1));

            System.out.println(String.format("Total: %d", order.getTotalBoxes()));

            int quantityRemoved = order.removeFlavor("Nutella");

            System.out.println(String.format("Total: %d - Removed: %d", order.getTotalBoxes(), quantityRemoved));

            quantityRemoved = order.removeFlavor("Chocolate");

            System.out.println(String.format("Total: %d - Removed: %d", order.getTotalBoxes(), quantityRemoved));

            quantityRemoved = order.removeFlavor("Vanilla");

            System.out.println(String.format("Total: %d - Removed: %d", order.getTotalBoxes(), quantityRemoved));

            quantityRemoved = order.removeFlavor("Chocolate");

            System.out.println(String.format("Total: %d - Removed: %d", order.getTotalBoxes(), quantityRemoved));

            pedido.addCookieOrder(new CookieOrder("Nutella", 5));

            System.out.println(String.format("Total: %d", order.getTotalBoxes()));
        }
    }