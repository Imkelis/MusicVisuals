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

        for (int i = 0; i < abuffer.size(); i++) {
            lerpFFTbuffer[i] = lerp(lerpFFTbuffer[i], fft.getBand(i), 0.0005f);
            lerpBuffer[i] = lerp(lerpBuffer[i], abuffer.get(i), 0.005f);
            total += lerpBuffer[i];
            if (lerpBuffer[i] > biggest) {
                biggest = lerpBuffer[i];
                println("Biggest" + biggest);
            }
            if (lerpBuffer[i] < biggest) {
                smallest = lerpBuffer[i];
                println("smallest" + smallest);
            }

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

        for (int i = 0; i < abuffer.size(); i++) {

            speed = abs(lerp(speed, average, .1f));
            speed = speed * 10f;
            println(speed);

            stroke(255, 255, 0);
            strokeWeight(3);
            line(0, halfHeight + 5, width, halfHeight + 50);

        }

    }

}
