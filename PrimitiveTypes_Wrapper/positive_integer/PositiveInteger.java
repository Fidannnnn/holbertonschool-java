public class PositiveInteger {
    private int value;

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

    public void setValue(int value) {
        validate(value);
        this.value = value;
    }

    public void setValor(int value) {
        setValue(value);
    }

    public boolean isPrime() {
        if (value <= 1) return false;     // 1 and below are not prime
        if (value == 2) return true;      // 2 is prime
        if (value % 2 == 0) return false; // even numbers > 2 are not prime
        int limit = (int) Math.sqrt(value);
        for (int i = 3; i <= limit; i += 2) {
            if (value % i == 0) return false;
        }
        return true;
    }

    private void validate(int v) {
        if (v <= 0) {
            throw new IllegalArgumentException("Value is not a positive integer");
        }
    }
}
