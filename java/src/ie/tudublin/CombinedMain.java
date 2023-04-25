package ie.tudublin;

import D22126809.MainSketch;
import D22125465.IgnasVisual1;

public class CombinedMain {
	public static void runSketch() {
		String[] a = { "MAIN" };
		processing.core.PApplet.runSketch(a, new MainSketch());
	}

	public static void runSketch2() {
		String[] a = { "MAIN" };
		processing.core.PApplet.runSketch(a, new IgnasVisual1());
	}

	public static void main(String[] args) {
		runSketch();
	}
}
