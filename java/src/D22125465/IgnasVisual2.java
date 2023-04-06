package D22125465;

import ie.tudublin.Visual;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;

public class IgnasVisual2 extends Visual {

    Minim minim;
    AudioPlayer aplayer;
    AudioInput ainput;
    AudioBuffer abuffer;
    FFT fft;

    public void settings() {
        size(2048, 1000, P3D);
    }

    public void setup() {
        colorMode(HSB);
        minim = new Minim(this);
        aplayer = minim.loadFile("M.O.O.N.mp3", 1048); // Temp Song, to be changed
        aplayer.play();
        abuffer = aplayer.mix;

        fft = new FFT(width, 44100);
    }

    public void draw() {

        float halfHeight = height / 2;
        float halfWidth = width / 2;
        background(255);

        stroke(255, 255, 0);
        strokeWeight(3);
        line(0, halfHeight, width, halfHeight);
        line(halfWidth, halfHeight, 0, halfHeight + halfHeight * .3f);
        line(halfWidth, halfHeight, 0, halfHeight + halfHeight * .9f);
        line(halfWidth, halfHeight, 0, halfHeight + halfHeight * 2.3f);
        line(halfWidth, halfHeight, (float) width, halfHeight + halfHeight * 2.3f);
        line(halfWidth, halfHeight, (float) width, halfHeight + halfHeight * .9f);
        line(halfWidth, halfHeight, (float) width, halfHeight + halfHeight * .3f);

    }

}
