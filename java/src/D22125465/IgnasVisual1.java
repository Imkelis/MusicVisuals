package D22125465;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class IgnasVisual1 extends PApplet {
    Minim minim;
    AudioPlayer aplayer;
    AudioInput ainput;
    AudioBuffer abuffer;
    FFT fft;

    int Mode = 1;
    int color = 0;
    float spawns = 0;

    float lerpBuffer[] = new float[1024];
    float lerpFFTbuffer[] = new float[1024];

    public void settings() {
        size(1024, 1000, P3D);
    }

    public void setup() {
        colorMode(HSB);
        minim = new Minim(this);
        aplayer = minim.loadFile("heroplanet.mp3", 1024); // Temp Song, to be changed
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

        for (int position = 0; position < 4; position++) {

            pushMatrix();
            rotate = 0;

            if (position == 0) {
                translate(halfHeight / 2, halfWidth / 2);
            } else if (position == 1) {
                translate(halfHeight * 1.5f, halfWidth / 2);
            } else if (position == 2) {
                translate(halfHeight / 2, halfWidth * 1.5f);
            } else if (position == 3) {
                translate(halfHeight * 1.5f, halfWidth * 1.5f);
            }

            for (int i = 0; i < lerpBuffer.length; i++) {
                rotate += abs(lerpFFTbuffer[i]) / 150000;

                rotateX((sin(i) * 600) * Math.min((millis() / 6000f * rotate), millis() / 50f));
                rotateY(Math.min(millis() / 6000f * rotate, millis() / 50f));

            }

            noFill();
            stroke(color, 255, 255);
            box(Math.min(5 * biggest * 1000, 200f));
            box(2 * biggest * 3000);
            box(biggest * 1500);

            if (biggest > 0.0245) {
                color -= 5;
                if (color < 0) {
                    color = abs(color) + 255;
                }
            }

            popMatrix();

            if (biggest > 0.0245 && position == 0) {
                pushMatrix();

                translate(halfHeight, halfWidth);
                box(spawns);
                popMatrix();
            }

            spawns += biggest * 500;

            if (spawns > 3000f) {
                spawns = 0;
            }
        }

    }

    // Might be changed to on screen buttons, not sure thought cause that would
    // block visuals.
    public void keyPressed() {
        if (key >= '0' && key <= '9') {
            Mode = key - '0';
        }
        if (keyCode == ' ') {
            if (aplayer.isPlaying()) {
                aplayer.pause();
            } else {
                aplayer.rewind();
                aplayer.play();
            }
        }
    }
}
