package D22126809;

import processing.core.PApplet;

public class test2 extends PApplet{

    float petalSize = 60; // size of each petal
    float flowerSize = 300; // size of each flower
    float petalSpacing = 15; // spacing between petals
    int numPetals = 6; // number of petals per flower
    int numCols = 8; // number of columns in the grid
    int numRows = 6; // number of rows in the grid
    

    public void settings(){
        size(800, 800);
    }
    
    public void setup() {
        // background(0);
        noStroke();
        smooth();
 
 

    }
    
   
public void draw() {
    background(255);
  
    // Draw the flowers
    for (int col = 0; col < numCols; col++) {
      for (int row = 0; row < numRows; row++) {
        float x = map(col, 0, numCols-1, flowerSize, width - flowerSize);
        float y = map(row, 0, numRows-1, flowerSize, height - flowerSize);
        drawFlower(x, y);
      }
    }
  }
  
  void drawFlower(float x, float y) {
    pushMatrix();
    translate(x, y);
  
    // Draw the petals
    float petalAngle = TWO_PI / numPetals;
    float petalRotation = petalAngle / 2;
    float petalXOffset = (petalSize / 2) * sin(petalRotation);
    float petalYOffset = (petalSize / 2) * cos(petalRotation);
    fill(255, 0, 0); // red petals
    for (int i = 0; i < numPetals; i++) {
      rotate(petalAngle);
      ellipse(-petalXOffset, -petalYOffset - flowerSize / 2 - petalSpacing, petalSize, petalSize);
    }
  
    // Draw the center of the flower
    fill(255, 255, 0); // yellow center
    ellipse(0, 0, flowerSize/2, flowerSize/2);
  
    popMatrix();
  }
    
}