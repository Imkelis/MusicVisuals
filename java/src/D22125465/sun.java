package D22125465;

import ddf.minim.AudioBuffer;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class sun extends PApplet {

    PApplet p;
    float height;
    float width;
    float halfHeight;
    float halfWidth;
    float speed;
    float o = 0;
    float sun;
    float position;

    sun(PApplet p) {

        this.p = p;
        this.height = p.height;
        this.width = p.width;
        this.halfHeight = height / 2;
        this.halfWidth = width / 2;
        this.sun = 400;
        this.position = 0;

    }

    public void drawSun(float[] lerpBuffer, FFT fft, AudioBuffer abuffer, float biggest) {

        for (int i = 0; i < lerpBuffer.length / 15; i++) {

            speed = map(lerpBuffer[i], -0.06830386f, 0.06844372f, 0f, 100f);

            p.fill(330, 100, 100);

            p.rect(i + o, halfHeight - 44, 40, -fft.getBand(i) * 2f);
            o += 40;

            p.fill(47, 30, 77);

            p.ellipse((halfWidth) + cos(this.sun) * 600f, halfHeight + sin(this.sun) * 300f,
                    250 + (abuffer.get(i) * 40f),
                    250 + (abuffer.get(i) * 40f));

        }

        if (this.sun > 402f) {
            this.position = 1;
        }

        if (this.sun < 399f) {
            this.position = 0;
        }

        if (this.position == 1) {
            this.sun -= .0005f * (float) biggest * 180;
        }

        if (this.position == 0) {
            this.sun += .0005f * (float) biggest * 180;
        }
    }

}
