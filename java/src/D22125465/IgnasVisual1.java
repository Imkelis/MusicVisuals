package D22125465;

import ie.tudublin.Visual;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;

public class IgnasVisual1 extends Visual {
    Minim minim;
    AudioPlayer aplayer;
    AudioInput ainput;
    AudioBuffer abuffer;
    FFT fft;

    int Mode = 1;
    int color = 0;
    float spawns = 0;
    float egg = 1;

    float lerpBuffer[] = new float[2048];
    float lerpFFTbuffer[] = new float[2048];

    public void settings() {
        size(2048, 1000, P3D);
    }

    public void setup() {
        colorMode(HSB);
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
        fft.forward(abuffer);

        for (int i = 0; i < abuffer.size(); i++) {
            lerpFFTbuffer[i] = lerp(lerpFFTbuffer[i], fft.getBand(i), 0.0005f);
            lerpBuffer[i] = lerp(lerpBuffer[i], abuffer.get(i), 0.005f);
            if (lerpBuffer[i] > biggest) {
                biggest = lerpBuffer[i];
            }

        }

        background(0);

        for (int position = 0; position < 5; position++) {

            pushMatrix();
            rotate = 0;

            if (position == 0) {
                translate(0, 0, -400);
            }

            else if (position == 1) {
                translate(width, 0, -400);
            }

            else if (position == 2) {
                translate(0, height, -400);
            }

            else if (position == 3) {
                translate(width, height, -400);
            }

            else if (position == 4) {
                translate(halfWidth, halfHeight, -400);
            }

            for (int i = 0; i < lerpBuffer.length; i++) {
                rotate += abs(lerpFFTbuffer[i]) / 150000;

                rotateX((sin(i) * 600) * Math.min((millis() / 6000f * rotate), millis() / 50f));
                rotateY(Math.min(millis() / 6000f * rotate, millis() / 50f));

            }

            noFill();
            stroke(color, 255, 255);
            box(Math.min(5 * biggest * 1500, 250f));
            box(2 * biggest * 1500);
            box(biggest * 1500);

            if (biggest > 0.025) {
                color -= 5;
                if (color < 0) {
                    color = abs(color) + 255;
                }
            }

            popMatrix();

            if (biggest > 0.025) {
                pushMatrix();
                translate(halfWidth, halfHeight, -400);
                box(spawns);
                popMatrix();
            }

            spawns += biggest * 1000;

            if (spawns > 3000f) {
                spawns = 0;
            }
        }

    }

}
