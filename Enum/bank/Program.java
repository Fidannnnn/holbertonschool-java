public class Program {

        public static void main(String[] args) {
            Bank bank = new Bank("Wells Fargo");

        bank.addBranch("Washington");

        bank.addCustomer("Washington", "John Bannons", 50.05);
        bank.addCustomer("Washington", "Jane Doe", 175.34);
        bank.addCustomer("Washington", "Jackson Percy", 220.12);

        bank.addCustomerTransaction("Washington", "Jane Doe", 44.22);
        bank.addCustomerTransaction("Washington", "Jane Doe", 12.44);
        bank.addCustomerTransaction("Washington", "Jackson Percy", 1.65);

        bank.listCustomers("Washington", true);
        }
    }