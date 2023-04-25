package D22125465;

import ie.tudublin.Visual;
import processing.core.PApplet;
import ddf.minim.AudioBuffer;
import ddf.minim.analysis.FFT;

public class IgnasVisual2 extends Visual {

    PApplet parent;

    public IgnasVisual2(PApplet parent) {
        this.parent = parent;
    }

    BackgroundVisual CoolBack;
    FallingLines fallingLines;

    public void draw(float[] lerpFFTbuffer, float[] lerpBuffer, AudioBuffer abuffer, FFT fft, float biggest) {

        if (CoolBack == null) {
            CoolBack = new BackgroundVisual(parent);
        }

        CoolBack.draw(lerpBuffer, fft, abuffer, biggest);

        if (fallingLines == null) {

            fallingLines = new FallingLines(parent);
        }

        fallingLines.Liney(biggest);

    }
}
