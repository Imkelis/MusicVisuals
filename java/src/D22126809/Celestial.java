package D22126809;

import java.util.ArrayList;

import ddf.minim.analysis.FFT;
import processing.core.PApplet;
import processing.core.PVector;

public class Celestial extends Star {
    
    private ArrayList<Orbiter> orbiters;
    private float velocity;
    float[] lerpedBuffer;

    public Celestial(int size, PVector v, int color, int id, PApplet p, FFT fft) {
        super(size, v, color, id, p, fft);
        this.orbiters = new ArrayList<>();
        for(int i = 1; i < 25; i++){
            int c = p.color(p.random(255), 255, p.random(255));
            orbiters.add(new Orbiter(10, new PVector(this.getV().x, this.getV().y), c, (int)p.random(1, 1000), p, fft));
        }
        this.velocity = (id % 2 == 0) ? -0.01f : 0.01f;
        this.lerpedBuffer = new float[p.width];
    }

    @Override
    public void render() {
        float v = calculateFFT();
        rotate(v);
        changeColor(v);

        for(Orbiter o: orbiters){
            o.render();
        }

        // Draw the triangle in the center of the circle
        int s = 10;
        p.beginShape();
        p.vertex(getV().x, getV().y - s);  
        p.vertex(getV().x - s, getV().y + s); 
        p.vertex(getV().x + s, getV().y + s); 
        p.endShape();
    }

    private void rotate(float amp){
        amp = PApplet.lerp(amp, 200, 0.5f);
        p.strokeWeight(1);
        p.pushMatrix();
        p.fill(getColor()); 
        p.rectMode(PApplet.CENTER);
        p.translate(getV().x, getV().y);
        p.rotate((float) (p.frameCount * velocity));
        p.rect(0, 0, amp, amp );
        p.popMatrix();
    }

    @Override
    public float calculateFFT() {
        float max = Float.MAX_VALUE;
        for(int i = 0; i < fft.specSize() / 2; i++){
            lerpedBuffer[i] = PApplet.lerp(lerpedBuffer[i], fft.getBand(i), 0.07f);
            if(lerpedBuffer[i] < max){
                max = lerpedBuffer[i];
            }
        }
        return max;
    }

    @Override
    public void changeColor(float v){
        float x = PApplet.map(v, -1, 1, 0, 255);
        int c =  p.color((int)PApplet.lerp(0, x, 0.9f), 255, 255);
        setColor(c);
    }
}
