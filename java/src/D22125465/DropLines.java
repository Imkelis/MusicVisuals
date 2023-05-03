package D22125465;

import processing.core.PApplet;

class DropLines extends PApplet{
    float y;
    float speed;
    PApplet parent;
    float lerpBoost;

    DropLines(PApplet parent, float[] lerpBuffer,float y) {
        this.y = y;
        this.speed = 0;
        this.parent = parent;
        this.lerpBoost = abs(lerpBuffer[0]) * 11f;
    }

    void update() {
        speed += 0.09;
        y += speed + lerpBoost;
    }

    void display() {
        parent.stroke(330, 100, 100);
        parent.line(0, y+50, parent.width, y+50);
    }
}
