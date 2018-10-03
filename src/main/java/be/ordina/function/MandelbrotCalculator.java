package be.ordina.function;

import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.function.Function;

@SuppressWarnings("unused")
public class MandelbrotCalculator implements Function<Flux<Grid>, Flux<Calculation>> {

	@Override
	public Flux<Calculation> apply(Flux<Grid> grid) {
		return grid
			.doOnNext(g -> System.out.println("Received request for Grid: " + g))
			.flatMap(g -> {
				Flux<Integer> xFlux = Flux.range(0, g.getWidth());
				Flux<Integer> yFlux = Flux.range(0, g.getHeight());

				Flux<Tuple2<Integer, Integer>> tupleFlux = xFlux.flatMap(x -> yFlux.map(y -> Tuples.of(x, y)));

				return tupleFlux.map(t -> calculate(g, t));
			});
	}

	private Calculation calculate(Grid g, Tuple2<Integer, Integer> t) {
		double stepX = (g.getX2() - g.getX1()) / g.getWidth();
		double stepY = (g.getY2() - g.getY1()) / g.getHeight();
		double translatedX = t.getT1() * stepX;
		double translatedY = t.getT2() * stepY;
		double real = g.getX1() + translatedX;
		double imaginary = g.getY1() + translatedY;

		return new Calculation(real, imaginary, t.getT1(), t.getT2(), g.getDepth() * 255);
	}
}
