package heckerpowered.stacker.util.numeric;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

public enum NumericUnit {
    KILO("K", 1000), MEGA("M", 1000000), BILLION("B", 1000000000);

    private final String symbol;
    private final int value;

    private NumericUnit(@Nonnull final String symbol, final int value) {
        this.symbol = symbol;
        this.value = value;
    }

    public final String getSymbol() {
        return symbol;
    }

    public final int getValue() {
        return value;
    }

    public static final String format(@Nonnegative final int value) {
        NumericUnit unit = null;
        for (final var currentUnit : NumericUnit.values()) {
            if (value >= currentUnit.getValue()) {
                unit = currentUnit;
            }
        }

        //
        // I hate formatting
        //
        return unit == null ? String.valueOf(value)
                : String.format("%.2f%s", value / (double) unit.getValue(), unit.getSymbol());
    }
}
