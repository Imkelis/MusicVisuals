package D22125465;

import processing.core.PApplet;

class DropLines extends PApplet{
    float y;
    float speed;
    PApplet parent;

    DropLines(PApplet parent, float y) {
        this.y = y;
        this.speed = 0;
        this.parent = parent;
    }

    void update() {
        speed += 0.12;
        y += speed;
    }

    void display() {
        parent.stroke(330, 100, 100);
        parent.line(0, y+50, parent.width, y+50);
    }
}
