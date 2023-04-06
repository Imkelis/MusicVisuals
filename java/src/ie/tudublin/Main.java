package ie.tudublin;

import D22125465.IgnasVisual1;
import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;

public class Main {

	public void startUI() {
		String[] a = { "MAIN" };
		processing.core.PApplet.runSketch(a, new MyVisual());
	}

	public void ignasVisual1() {
		String[] a = { "MAIN" };
		processing.core.PApplet.runSketch(a, new IgnasVisual1());
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.ignasVisual1();
	}
}