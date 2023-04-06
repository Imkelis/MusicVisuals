package D22125465;

import ie.tudublin.Visual;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;

public class IgnasVisual2 extends Visual {

    float lerpBuffer[] = new float[2048];
    float lerpFFTbuffer[] = new float[2048];

    float biggest = 0;
    float speed = 0;
    float smallest = 10000;
    int lineamt = 4;
    float count1 = 1;
    float count2 = 1;
    float count3 = 1;
    float count4 = 1;

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
        float total = 0;
        float average = 0;
        float position = halfHeight;

        for (int i = 0; i < abuffer.size(); i++) {
            lerpFFTbuffer[i] = lerp(lerpFFTbuffer[i], fft.getBand(i), 0.0005f);
            lerpBuffer[i] = lerp(lerpBuffer[i], abuffer.get(i), 0.005f);
            total += lerpBuffer[i];
            if (lerpBuffer[i] > biggest) {
                biggest = lerpBuffer[i];
            } // Biggest0.06844372
            if (lerpBuffer[i] < smallest) {
                smallest = lerpBuffer[i];
            } // smallest-0.06830386

        }
        average = total / abuffer.size();

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

        stroke(255, 255, 255);

        line(0, halfHeight + count1, width, halfHeight + count1);

        // if (lineamt < 0) {
        // lineamt--;
        // speed = map(lerpBuffer[i], -0.06830386f, 0.06844372f, 0f, 100f);

        // }

        count1 += (1f + (count1 * 15f / halfHeight));
        println(count1);

        if (count1 > 125 || count2 > 1) {
            stroke(200, 255, 255);
            line(0, halfHeight + count2, width, halfHeight + count2);
            count2 += (1f + (count2 * 15f / halfHeight));
        }

        if (count2 > 125 || count3 > 1) {
            stroke(155, 255, 255);
            line(0, halfHeight + count3, width, halfHeight + count3);
            count3 += (1f + (count3 * 15f / halfHeight));
        }
        if (count3 > 125 || count4 > 1) {
            stroke(100, 255, 255);
            line(0, halfHeight + count4, width, halfHeight + count4);
            count4 += (1f + (count4 * 15f / halfHeight));
        }

        if (count1 > 500) {
            count1 = 1;
        }

        if (count2 > 500) {
            count2 = 1;
        }
        if (count3 > 500) {
            count3 = 1;
        }
        if (count4 > 500) {
            count4 = 1;
        }

    }
}
