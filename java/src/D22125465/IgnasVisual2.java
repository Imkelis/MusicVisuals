package D22125465;

import ie.tudublin.Visual;
import processing.core.PApplet;
import ddf.minim.AudioBuffer;
import ddf.minim.analysis.FFT;

public class IgnasVisual2 extends Visual {

    PApplet parent;
    float o;
    float halfHeight;
    float halfWidth;

    public IgnasVisual2(PApplet parent) {
        this.parent = parent;
    }

    BackgroundVisual CoolBack;
    Lines downLines;

    public void draw(float[] lerpFFTbuffer, float[] lerpBuffer, AudioBuffer abuffer, FFT fft, float biggest) {

        if (CoolBack == null) {
            CoolBack = new BackgroundVisual(parent);
        }

        if (downLines == null) {
            downLines = new Lines(parent);
        }

        CoolBack.draw(lerpBuffer, fft, abuffer, biggest);
        downLines.draw(abuffer, lerpBuffer);
    }
}
