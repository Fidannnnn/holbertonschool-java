// Program.java
public class Program {
    public static void main(String[] args) {
        PrintJob printJob1 = PrintJobFactory.createPrintJob(PrintSize.A3, 50, 10, true);
        PrintJob printJob2 = PrintJobFactory.createPrintJob(PrintSize.A4, 50, 10, true);
        PrintJob printJob3 = PrintJobFactory.createPrintJob(PrintSize.A3, 23, 7, false);
        PrintJob printJob4 = PrintJobFactory.createPrintJob(PrintSize.A4, 23, 7, false);
        PrintJob printJob5 = PrintJobFactory.createPrintJob(PrintSize.A2, 23, 7, true);
        PrintJob printJob6 = PrintJobFactory.createPrintJob(PrintSize.A2, 50, 10, false);

        System.out.println(printJob1);
        System.out.println(printJob2);
        System.out.println(printJob3);
        System.out.println(printJob4);
        System.out.println(printJob5);
        System.out.println(printJob6);
    }
}
