// PrintJob.java
public class PrintJob {
    private int totalPages;
    private int colorPages;
    private boolean isDoubleSided;
    private double colorDoubleSidedCost;
    private double bwDoubleSidedCost;
    private double colorSingleSidedCost;
    private double bwSingleSidedCost;

    public PrintJob(int totalPages, int colorPages, boolean isDoubleSided,
                    double colorDoubleSidedCost, double bwDoubleSidedCost,
                    double colorSingleSidedCost, double bwSingleSidedCost) {
        this.totalPages = totalPages;
        this.colorPages = colorPages;
        this.isDoubleSided = isDoubleSided;
        this.colorDoubleSidedCost = colorDoubleSidedCost;
        this.bwDoubleSidedCost = bwDoubleSidedCost;
        this.colorSingleSidedCost = colorSingleSidedCost;
        this.bwSingleSidedCost = bwSingleSidedCost;
    }

    public double calculateTotal() {
        int bwPages = totalPages - colorPages;
        double total;
        if (isDoubleSided) {
            total = colorPages * colorDoubleSidedCost + bwPages * bwDoubleSidedCost;
        } else {
            total = colorPages * colorSingleSidedCost + bwPages * bwSingleSidedCost;
        }
        return total / 100.0; // convert cents to dollars
    }

    @Override
    public String toString() {
        int bwPages = totalPages - colorPages;
        String side = isDoubleSided ? "double-sided" : "single-sided";
        return String.format(
            "total pages: %d, color pages: %d, black-and-white pages: %d, %s. total: $%.2f",
            totalPages, colorPages, bwPages, side, calculateTotal()
        );
    }
}
