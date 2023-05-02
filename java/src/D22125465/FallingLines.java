package D22125465;

import processing.core.PApplet;

public class FallingLines extends PApplet {

    PApplet parent;
    float height;
    float width;
    float halfHeight;
    float halfWidth;
    Lines[] Line = new Lines[4];
    float smallest = 10000;
    int lock = 0;
    float start;
    long lastSpawnTime = 0;
    int numActiveLines;

    FallingLines(PApplet p) {

        this.parent = p;
        this.height = p.height;
        this.width = p.width;
        this.halfHeight = height / 2;
        this.halfWidth = width / 2;

    }

    public void Liney(float biggest) {

        parent.strokeWeight(4);

        parent.fill(24, 54, 11);
        parent.rect(-5, halfHeight - 5, width + 5, halfHeight + 5);

        parent.stroke(330, 100, 100);

        if (lock == 0) {
            for (int i = 0; i < Line.length; i++) {
                start = 122 * i;
                Line[i] = new Lines(parent, 0.05f, biggest, start);
            }
            lastSpawnTime = millis();
            lock++;
            numActiveLines = 1;
        }

        for (int i = 0; i < numActiveLines; i++) {
            Line[i].update();
        }

        if (numActiveLines < Line.length) {
            if (millis() - lastSpawnTime >= 1000) {
                numActiveLines++;
                lastSpawnTime = millis();
            }
        }
    }

}
