// PrintJobFactory.java
public class PrintJobFactory {
    public static PrintJob createPrintJob(PrintSize size, int totalPages, int colorPages, boolean isDoubleSided) {
        double colorDoubleSidedCost = 0;
        double bwDoubleSidedCost = 0;
        double colorSingleSidedCost = 0;
        double bwSingleSidedCost = 0;

        switch (size) {
            case A2:
                colorDoubleSidedCost = 28;
                bwDoubleSidedCost = 18;
                colorSingleSidedCost = 32;
                bwSingleSidedCost = 22;
                break;
            case A3:
                colorDoubleSidedCost = 25;
                bwDoubleSidedCost = 15;
                colorSingleSidedCost = 30;
                bwSingleSidedCost = 20;
                break;
            case A4:
                colorDoubleSidedCost = 20;
                bwDoubleSidedCost = 10;
                colorSingleSidedCost = 25;
                bwSingleSidedCost = 15;
                break;
        }

        return new PrintJob(totalPages, colorPages, isDoubleSided,
                colorDoubleSidedCost, bwDoubleSidedCost, colorSingleSidedCost, bwSingleSidedCost);
    }
}
