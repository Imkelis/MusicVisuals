package D22125465;

import ie.tudublin.Visual;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;

//circle color = 47, 30, 77

public class IgnasVisual2 extends Visual {

    float lerpBuffer[] = new float[2048];
    float lerpFFTbuffer[] = new float[2048];

    float speed = 0;
    float smallest = 10000;
    float count1 = 1;
    float count2 = 1;
    float count3 = 1;
    float count4 = 1;
    float count5 = 1;
    float acceleration = 0.05f;
    float sun = 500;

    Minim minim;
    AudioPlayer aplayer;
    AudioInput ainput;
    AudioBuffer abuffer;
    FFT fft;

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
        float total = 0;
        float biggest = 0;
        float average = 0;
        float position = halfHeight;
        float o = 0;

        fft.forward(abuffer);

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

        background(11, 100, 62);
        noStroke();
        fill(200, 45, 78);
        rect(0, 0, width, 76);
        fill(206, 41, 77);
        rect(0, 76, width, 152);
        fill(221, 35, 77);
        rect(0, 152, width, 228);
        fill(238, 30, 77);
        rect(0, 228, width, 304);
        fill(260, 35, 76);
        rect(0, 304, width, 380);
        fill(282, 45, 75);
        rect(0, 380, width, 456);

        for (int i = 0; i < lerpBuffer.length / 15; i++) {

            speed = map(lerpBuffer[i], -0.06830386f, 0.06844372f, 0f, 100f);

            fill(330, 100, 100);

            rect(i + o, halfHeight - 44, 40, -fft.getBand(i) * 1.5f);
            o += 40;

            fill(47, 30, 77);
            ellipse((halfWidth) + cos(sun) * 600f, halfHeight + sin(sun) * 300f, 250 + (abuffer.get(i) * 40f),
                    250 + (abuffer.get(i) * 40f));

        }

        stroke(330, 100, 100);
        strokeWeight(3);
        line(0, halfHeight, width, halfHeight);
        line(halfWidth, halfHeight, 0, halfHeight + halfHeight * .3f);
        line(halfWidth, halfHeight, 0, halfHeight + halfHeight * .9f);
        line(halfWidth, halfHeight, 0, halfHeight + halfHeight * 2.3f);
        line(halfWidth, halfHeight, (float) width, halfHeight + halfHeight * 2.3f);
        line(halfWidth, halfHeight, (float) width, halfHeight + halfHeight * .9f);
        line(halfWidth, halfHeight, (float) width, halfHeight + halfHeight * .3f);

        strokeWeight(4);
        stroke(175, 47, 88);
        line(0, halfHeight - 4, width, halfHeight - 4);
        stroke(0);
        line(0, halfHeight - 8, width, halfHeight - 8);
        stroke(175, 47, 88);
        line(0, halfHeight - 12, width, halfHeight - 12);
        stroke(0);
        line(0, halfHeight - 16, width, halfHeight - 16);
        stroke(175, 47, 88);
        line(0, halfHeight - 20, width, halfHeight - 20);
        stroke(0);
        line(0, halfHeight - 24, width, halfHeight - 24);
        stroke(175, 47, 88);
        line(0, halfHeight - 28, width, halfHeight - 28);
        stroke(0);
        line(0, halfHeight - 32, width, halfHeight - 32);
        stroke(175, 47, 88);
        line(0, halfHeight - 36, width, halfHeight - 36);
        stroke(0);
        line(0, halfHeight - 40, width, halfHeight - 40);
        stroke(175, 47, 88);
        line(0, halfHeight - 44, width, halfHeight - 44);
        fill(24, 54, 11);
        rect(-5, halfHeight - 5, width + 5, halfHeight + 5);

        //// A whole lotta code for moving lines. Idk how to implement this any other
        //// way. Ill try again later.
        stroke(330, 100, 100);

        line(0, halfHeight + count1, width, halfHeight + count1);

        count1 += (1f + (count1 * acceleration));

        if (count1 > 122 || count2 > 1) {
            line(0, halfHeight + count2, width, halfHeight + count2);
            count2 += (1f + (count2 * acceleration));
        }

        if (count2 > 122 || count3 > 1) {
            line(0, halfHeight + count3, width, halfHeight + count3);
            count3 += (1f + (count3 * acceleration));
        }
        if (count3 > 122 || count4 > 1) {
            line(0, halfHeight + count4, width, halfHeight + count4);
            count4 += (1f + (count4 * acceleration));
        }

        if (count4 > 122 || count5 > 1) {
            line(0, halfHeight + count5, width, halfHeight + count5);
            count5 += (1f + (count5 * acceleration));
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

        if (count5 > 500) {
            count5 = 1;
        }

        sun += .003f;
    }
}
