package be.ordina.function;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Grid {

	private int x1, y1;
	private int x2, y2;
	private int width, height;
	private int depth;
}
