package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;
import D22125465.IgnasVisual1;
import D22125465.IgnasVisual2;

public class Combined extends PApplet {
    int mode = 1;

    public void keyPressed() {
        if (key >= '0' && key <= '9') {
            mode = key - '0';
        }
    }

    IgnasVisual1 IgnasV1 = new IgnasVisual1(this);
    IgnasVisual2 IgnasV2 = new IgnasVisual2(this);

    Minim minim;
    AudioPlayer aplayer;
    AudioInput ainput;
    AudioBuffer abuffer;
    FFT fft;

    int Mode = 1;
    int color = 0;
    float spawns = 0;
    float count1 = 1;
    float count2 = 1;
    float count3 = 1;
    float count4 = 1;
    float count5 = 1;
    float sun = 400;
    float moon = -100;

    float lerpBuffer[] = new float[2048];
    float lerpFFTbuffer[] = new float[2048];

    public void settings() {
        size(2048, 1000, P3D);
    }

    public void setup() {
        colorMode(HSB, 360, 100, 100);
        minim = new Minim(this);
        aplayer = minim.loadFile("M.O.O.N.mp3", 2048); // Temp Song, to be changed
        aplayer.play();
        abuffer = aplayer.mix;

        fft = new FFT(width, 44100);
    }

    public void draw() {
        float halfHeight = height / 2;
        float halfWidth = width / 2;
        float biggest = 0;
        float rotate = 0;
        float speed = 0;
        float smallest = 10000;
        float acceleration = 0.05f;
        float o = 0;
        fft.forward(abuffer);

        for (int i = 0; i < abuffer.size(); i++) {
            lerpFFTbuffer[i] = lerp(lerpFFTbuffer[i], fft.getBand(i), 0.0005f);
            lerpBuffer[i] = lerp(lerpBuffer[i], abuffer.get(i), 0.005f);
            if (lerpBuffer[i] > biggest) {
                biggest = lerpBuffer[i];
            }

        }

        switch (mode) {
            case 1:

                IgnasV2.draw(lerpFFTbuffer, lerpBuffer, abuffer, fft, biggest);

                break;
            case 2:

                IgnasV1.draw(lerpFFTbuffer, lerpBuffer, abuffer, fft, biggest);

                break;
        }

    }
}
