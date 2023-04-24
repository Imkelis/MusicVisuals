package D22125465;

import processing.core.PApplet;

class FallingLine extends PApplet {
    PApplet parent;
    float count;
    float acceleration;
    float biggest;
    float start;

    FallingLine(PApplet parent, float acceleration, float biggest, float start) {
        this.start = start;
        this.parent = parent;
        this.acceleration = acceleration;
        this.biggest = biggest;
        this.count = 1;
    }

    void update() {
        parent.stroke(330, 100, 100);
        parent.line(0, (parent.height / 2) + this.start + this.count, parent.width,
                (parent.height / 2) + start + this.count);
        this.count += (1f + (this.count * (acceleration)));

        if (this.count >= 500 - start) {
            this.count = 1;
            this.start = 0;
        }
    }
}