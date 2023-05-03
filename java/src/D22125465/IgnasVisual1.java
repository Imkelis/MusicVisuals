package D22125465;

import ie.tudublin.CombinedMain;
import ie.tudublin.Visual;
import processing.core.PApplet;
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

    PApplet parent;

    public IgnasVisual1(PApplet parent) {
        this.parent = parent;
    }

    int Mode = 1;
    int color = 0;
    float spawns = 0;

    float lerpBuffer[] = new float[2048];
    float lerpFFTbuffer[] = new float[2048];

    public void settings() {
        // edit
        size(displayWidth, displayHeight);
    }

    public void setup() {
    }

    // edit
    public void keyPressed() {
        if (key == '3') {
            background(0);
            CombinedMain.runSketch();
            dispose();
        }
    }

    public void draw(float[] lerpFFTbuffer, float[] lerpBuffer, AudioBuffer abuffer, FFT fft, float biggest) {
        float halfHeight = parent.height / 2;
        float halfWidth = parent.width / 2;
        float rotate = 0;

        parent.background(0);

        for (int position = 0; position < 5; position++) {

            parent.pushMatrix();
            rotate = 0;

            if (position == 0) {
                parent.translate(0, 0, -400);
            }

            else if (position == 1) {
                parent.translate(parent.width, 0, -400);
            }

            else if (position == 2) {
                parent.translate(0, parent.height, -400);
            }

            else if (position == 3) {
                parent.translate(parent.width, parent.height, -400);
            }

            else if (position == 4) {
                parent.translate(halfWidth, halfHeight, -400);
            }

            for (int i = 0; i < lerpBuffer.length; i++) {
                rotate += abs(lerpFFTbuffer[i]) / 150000;

                parent.rotateX((sin(i) * 600) * Math.min((parent.millis() / 6000f * rotate), parent.millis() / 50f));
                parent.rotateY(Math.min(parent.millis() / 6000f * rotate, parent.millis() / 50f));

            }

            parent.noFill();
            parent.stroke(color, 255, 255);
            parent.box(Math.min(5 * biggest * 1500, 250f));
            parent.box(2 * biggest * 1500);
            parent.box(biggest * 1500);

            if(abuffer.get(0) != 0.0f){
            if (biggest > 0.025) {
                color -= 5;
                if (color < 0) {
                    color = abs(color) + 255;
                }
            }
        }

            parent.popMatrix();

            if(abuffer.get(0) != 0.0f){

            if (biggest > 0.025) {
                parent.pushMatrix();
                parent.translate(halfWidth, halfHeight, -400);
                parent.box(spawns);
                parent.popMatrix();
            }
        }

            spawns += biggest * 1000;

            if (spawns > 3000f) {
                spawns = 0;
            }
        }

    }

}
