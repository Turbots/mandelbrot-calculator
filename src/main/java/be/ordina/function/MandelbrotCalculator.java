package be.ordina.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@SuppressWarnings("unused")
public class MandelbrotCalculator implements Function<Grid, List<Calculation>> {

	@Override
	public List<Calculation> apply(Grid grid) {
		return Arrays.asList(new Calculation(100.0, 100.0, 255), new Calculation(0.0, 0.0, 255));
	}
}
