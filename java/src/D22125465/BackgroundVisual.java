package D22125465;

import ddf.minim.AudioBuffer;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class BackgroundVisual extends PApplet {

    PApplet p;
    float height;
    float width;
    float halfHeight;
    float halfWidth;
    float speed;
    float o = 0;
    float sun;
    float position;
    sun coolSun;

    BackgroundVisual(PApplet p) {

        this.p = p;
        this.height = p.height;
        this.width = p.width;
        this.halfHeight = height / 2;
        this.halfWidth = width / 2;
        this.sun = 400;
        this.position = 0;
    }

    public void draw(float[] lerpBuffer, FFT fft, AudioBuffer abuffer, float biggest) {

        if (coolSun == null) {
            coolSun = new sun(p);

        }

        p.background(11, 100, 62);
        p.noStroke();
        int rectHeight = (p.height / 2) / 6;

        p.fill(200, 45, 78);
        p.rect(0, 0 * rectHeight, p.width, rectHeight);
        p.fill(206, 41, 77);
        p.rect(0, 1 * rectHeight, p.width, rectHeight);
        p.fill(221, 35, 77);
        p.rect(0, 2 * rectHeight, p.width, rectHeight);
        p.fill(238, 30, 77);
        p.rect(0, 3 * rectHeight, p.width, rectHeight);
        p.fill(260, 35, 76);
        p.rect(0, 4 * rectHeight, p.width, rectHeight);
        p.fill(282, 45, 75);
        p.rect(0, 5 * rectHeight, p.width, rectHeight);

        coolSun.drawSun(lerpBuffer, fft, abuffer, biggest);

        p.stroke(330, 100, 100);
        p.strokeWeight(3);
        p.line(0, halfHeight, width, halfHeight);
        p.line(halfWidth, halfHeight, 0, halfHeight + halfHeight * .3f);
        p.line(halfWidth, halfHeight, 0, halfHeight + halfHeight * .9f);
        p.line(halfWidth, halfHeight, 0, halfHeight + halfHeight * 2.3f);
        p.line(halfWidth, halfHeight, 0, halfHeight + halfHeight * 6f);
        p.line(halfWidth, halfHeight, (float) width, halfHeight + halfHeight * 2.3f);
        p.line(halfWidth, halfHeight, (float) width, halfHeight + halfHeight * .9f);
        p.line(halfWidth, halfHeight, (float) width, halfHeight + halfHeight * .3f);
        p.line(halfWidth, halfHeight, (float) width, halfHeight + halfHeight * 6f);

        int c = 0;
        for (int i = 4; i <= 44; i = i + 4) {

            if (c == 0) {
                p.stroke(182, 31, 76);
                c = 1;
            } else if (c == 1) {
                p.stroke(0);
                c = 0;
            }

            p.line(0, halfHeight - i, width, halfHeight - i);

        }

    }

}
