package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;
import D22125465.IgnasVisual1;
import D22125465.IgnasVisual2;

public class Combined extends Visual {
    Minim minim;
    AudioPlayer aplayer;
    AudioInput ainput;
    AudioBuffer abuffer;
    FFT fft;

    IgnasVisual1 IgnasV1 = new IgnasVisual1(this);
    IgnasVisual2 IgnasV2 = new IgnasVisual2(this);

    int Mode = 1;
    int color = 0;
    float spawns = 0;
    float moon = -100;

    float lerpBuffer[] = new float[2048];
    float lerpFFTbuffer[] = new float[2048];

    public void keyPressed() {
        if (key >= '0' && key <= '9') {
            Mode = key - '0';
        }
    }

    public void settings() {
        size(2048, 1000, P3D);
    }

    public void setup() {
        colorMode(HSB, 360, 100, 100);
        minim = new Minim(this);
        aplayer = minim.loadFile("M.O.O.N.mp3", 2048);
        aplayer.play();
        abuffer = aplayer.mix;

        fft = new FFT(2048, 44100);

    }

    public void draw() {
        float biggest = 0;
        fft.forward(abuffer);

        for (int i = 0; i < abuffer.size(); i++) {
            lerpFFTbuffer[i] = lerp(lerpFFTbuffer[i], fft.getBand(i), 0.0005f);
            lerpBuffer[i] = lerp(lerpBuffer[i], abuffer.get(i), 0.005f);
            if (lerpBuffer[i] > biggest) {
                biggest = lerpBuffer[i];
            }

        }

        switch (Mode) {
            case 1:

                IgnasV2.draw(lerpFFTbuffer, lerpBuffer, abuffer, fft, biggest);

                break;
            case 2:

                IgnasV1.draw(lerpFFTbuffer, lerpBuffer, abuffer, fft, biggest);

                break;

            case 3:
                // background(0);
                // CombinedMain.runSketch();
                // dispose();
                // break;
        }

    }
}
