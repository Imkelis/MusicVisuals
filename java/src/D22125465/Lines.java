package D22125465;

import java.util.ArrayList;

import processing.core.*;

public class Lines extends PApplet {

    ArrayList<DropLines> lines;
    PApplet parent;
    int x = 0;

    Lines(PApplet parent){
        this.parent = parent;
    }

    public void draw() {

        if(x == 0){
        lines = new ArrayList<>();
        lines.add(new DropLines(parent, parent.height / 2));
        x++;
        }

        for (DropLines line : lines) {
            parent.strokeWeight(4);

            parent.fill(24, 54, 11);
            parent.rect(-5, parent.height/2, parent.width + 10, parent.height/2 + 5);


            line.update();
            line.display();
        }
        if (lines.get(lines.size() - 1).y > parent.height / 2) {
            lines.add(new DropLines(parent, parent.height / 2 - 50));
        }
        if (lines.get(0).y > parent.height) {
            lines.remove(0);
        }
    }
}
