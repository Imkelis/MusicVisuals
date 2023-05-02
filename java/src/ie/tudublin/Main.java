package ie.tudublin;

public class Main {

	public void Combo() {
		String[] a = { "MAIN" };
		processing.core.PApplet.runSketch(a, new Combined());
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.Combo();
	}
}