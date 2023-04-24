package D22125465;

import ie.tudublin.Visual;
import processing.core.PApplet;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;

public class IgnasVisual2 extends Visual {

    PApplet parent;

    public IgnasVisual2(PApplet parent) {
        this.parent = parent;
    }

    float lerpBuffer[] = new float[2048];
    float lerpFFTbuffer[] = new float[2048];

    FallingLine[] fallingLines = new FallingLine[4];

    float speed = 0;
    float smallest = 10000;
    float count1 = 1;
    float count2 = 1;
    float count3 = 1;
    float count4 = 1;
    float count5 = 1;
    float sun = 400;
    int lock = 0;
    float start;
    long lastSpawnTime = 0;
    int numActiveLines;

    float position = 0;

    Minim minim;
    AudioPlayer aplayer;
    AudioInput ainput;
    AudioBuffer abuffer;
    FFT fft;

    public void settings() {

    }

    public void setup() {

    }

    public void draw(float[] lerpFFTbuffer, float[] lerpBuffer, AudioBuffer abuffer, FFT fft, float biggest) {

        float width = parent.width;
        float halfHeight = parent.height / 2;
        float halfWidth = parent.width / 2;
        float average = 0;
        float o = 0;

        parent.background(11, 100, 62);
        parent.noStroke();
        parent.fill(200, 45, 78);
        parent.rect(0, 0, width, 76);
        parent.fill(206, 41, 77);
        parent.rect(0, 76, width, 152);
        parent.fill(221, 35, 77);
        parent.rect(0, 152, width, 228);
        parent.fill(238, 30, 77);
        parent.rect(0, 228, width, 304);
        parent.fill(260, 35, 76);
        parent.rect(0, 304, width, 380);
        parent.fill(282, 45, 75);
        parent.rect(0, 380, width, 456);

        for (int i = 0; i < lerpBuffer.length / 15; i++) {

            speed = map(lerpBuffer[i], -0.06830386f, 0.06844372f, 0f, 100f);

            parent.fill(330, 100, 100);

            parent.rect(i + o, halfHeight - 44, 40, -fft.getBand(i) * 2f);
            o += 40;

            parent.fill(47, 30, 77);

            parent.ellipse((halfWidth) + cos(sun) * 600f, halfHeight + sin(sun) * 300f, 250 + (abuffer.get(i) * 40f),
                    250 + (abuffer.get(i) * 40f));

        }

        parent.stroke(330, 100, 100);
        parent.strokeWeight(3);
        parent.line(0, halfHeight, width, halfHeight);
        parent.line(halfWidth, halfHeight, 0, halfHeight + halfHeight * .3f);
        parent.line(halfWidth, halfHeight, 0, halfHeight + halfHeight * .9f);
        parent.line(halfWidth, halfHeight, 0, halfHeight + halfHeight * 2.3f);
        parent.line(halfWidth, halfHeight, 0, halfHeight + halfHeight * 6f);
        parent.line(halfWidth, halfHeight, (float) width, halfHeight + halfHeight * 2.3f);
        parent.line(halfWidth, halfHeight, (float) width, halfHeight + halfHeight * .9f);
        parent.line(halfWidth, halfHeight, (float) width, halfHeight + halfHeight * .3f);
        parent.line(halfWidth, halfHeight, (float) width, halfHeight + halfHeight * 6f);

        parent.strokeWeight(4);

        int c = 0;
        for (int i = 4; i <= 44; i = i + 4) {

            if (c == 0) {
                parent.stroke(182, 31, 76);
                c = 1;
            } else if (c == 1) {
                parent.stroke(0);
                c = 0;
            }

            parent.line(0, halfHeight - i, width, halfHeight - i);

        }

        parent.fill(24, 54, 11);
        parent.rect(-5, halfHeight - 5, width + 5, halfHeight + 5);

        parent.stroke(330, 100, 100);

        if (lock == 0) {
            for (int i = 0; i < fallingLines.length; i++) {
                start = 122 * i;
                fallingLines[i] = new FallingLine(parent, 0.05f, biggest, start);
            }
            lastSpawnTime = millis();
            lock++;
            numActiveLines = 1;
        }

        for (int i = 0; i < numActiveLines; i++) {
            fallingLines[i].update();
        }

        if (numActiveLines < fallingLines.length) {
            if (millis() - lastSpawnTime >= 1000) {
                numActiveLines++;
                lastSpawnTime = millis();
            }
        }

        if (sun > 402f) {
            position = 1;
        }

        if (sun < 399f) {
            position = 0;
        }

        if (position == 1) {
            sun -= .0005f * (float) biggest * 180;
        }

        if (position == 0) {
            sun += .0005f * (float) biggest * 180;
        }
    }
}
