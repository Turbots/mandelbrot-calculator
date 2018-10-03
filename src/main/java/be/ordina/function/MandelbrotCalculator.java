package be.ordina.function;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.function.Function;

@SuppressWarnings("unused")
public class MandelbrotCalculator implements Function<Flux<Grid>, Flux<Calculation>> {

	@Override
	public Flux<Calculation> apply(Flux<Grid> grid) {
		return Flux.fromIterable(Arrays.asList(new Calculation(100.0, 100.0, 255), new Calculation(0.0, 0.0, 255)));
	}
}
