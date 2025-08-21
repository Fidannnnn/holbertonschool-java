public class PositiveInteger {
    Integer value;
    public PositiveInteger(int value) {
        validate(value);
        this.value = value;
    }
    public PositiveInteger(String value) {
        try {
            int parsed = Integer.parseInt(value);
            validate(parsed);
            this.value = parsed;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Value is not a positive integer");
        }
    }
    public int getValue() {
        return value;
    }
    public void setValor(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int v) {
        if (v <= 0) {
            throw new IllegalArgumentException("Value is not a positive integer");
        }
    }

    public boolean isPrime() {
        if (value <= 1) {
            return false;
        }
        if (value == 2) {
            return true;
        }
        if (value % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(value);
        for (int i = 3; i <= sqrt; i += 2) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

}