package C21371216;

import processing.core.PApplet;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;

public class Doughnut extends PApplet {

	int mode = 7;

	Minim minim;
	AudioPlayer aplayer;
	AudioInput ainput;
	AudioBuffer abuffer;
	FFT fft;

	float currentVolume;
    
	int seg = 8; //bands of frequency
	float[] bands = new float[seg];


	public void settings() {
		size(200, 200, P3D);//was 1000,1000
		fullScreen(SPAN);
	}

	public void setup() {
		colorMode(HSB,300,100,100);
        
		minim = new Minim(this);
		aplayer = minim.loadFile("M.O.O.N.mp3", 2048);
		aplayer.play();

		fft = new FFT(aplayer.bufferSize(), aplayer.sampleRate());
		


        for(i=0;i<20;i++) //initialising array for connecting circles animation
		{
            array[i] = i*20;
        }
	}


	/*public void keyPressed() {
		
		println(mode);
	
	public void mouseClicked()
	{
		
	}}*/

	float m = 0;
	float ang = 0;
	float x2 = 0;
	float y2 = 0;
	float z2 = 0;
    float height = 1;
    float bounce = 0;

	int speed = 3;      // speed of camera

    int j = 0;
    int i = 0;
	int p = 0;

    float[] array = new float[20];
        
    int trans = -4500;
    
    
	public void pillar(float x,float y,float z, float r, float h, float detail) //x,y,z coords of base
	{
		for(i=0;i<detail;i++)
		{
			ang = (i/(detail))*TWO_PI;
			x2 = x+r*sin(ang);
			z2 = z+r*cos(ang) + 200*sin(x2/100);
			stroke(x2%300, 100, 100);
			line(x2, y, z2, x2, y-h-(15*cos(x2/15)), z2);
            line(x2, -320, z2, x2, -320+h+(15*cos(x2/15)), z2);
		}
	}

    

	public void circ3d(float x,float y,float z, float r) //circle
	{
		bezier(x, y-r, z, x+(4/3f)*r, y-r, z, x+(4/3f)*r, y+r, z, x, y+r, z);//right
		bezier(x, y-r, z, x-(4/3f)*r, y-r, z, x-(4/3f)*r, y+r, z, x, y+r, z);//left
	}


	public void doughnut(float x, float y, float z, float r, float r2, float detail)
	{
		for(int i=0; i<detail; i++)  //repeated circles to make doughnut
		{
			ang = (i/(detail))*TWO_PI;
            stroke(ang*50,100,100);
			circ3d(x,y,r2*sin(ang),r+r2*cos(ang));
		}
	}

    public void widecircle(float x,float y,float z, float r,float h)//squashed circle , h = percent of height
	{
		bezier(x, y-r*h, z, x+(4/3f)*r, y-r*h, z, x+(4/3f)*r, y+r*h, z, x, y+r*h, z);//right
		bezier(x, y-r*h, z, x-(4/3f)*r, y-r*h, z, x-(4/3f)*r, y+r*h, z, x, y+r*h, z);//left
	}

    public void widedoughnut(float x, float y, float z, float h, float r, float r2, float detail)
	{
		for(int i=0; i<detail; i++) //doughnut with widecircle
		{
			ang = (i/(detail))*TWO_PI;
            stroke(abs(ang-TWO_PI)*47.75f,100,100);
            strokeWeight(5);
			widecircle(x,y,r2*sin(ang),r+r2*cos(ang),h);
		}
	}


    public void slicedcircle(float x,float y,float z, float r, float s) //s = percent sliced (0 normal, 1 sliced)
	{
		bezier(x+(4*s/3f)*r, y-r, z, x+(4/3f)*r, y-r, z, x+(4/3f)*r, y+r, z, x+(4*s/3f)*r, y+r, z);//right
		bezier(x-(4*s/3f)*r, y-r, z, x-(4/3f)*r, y-r, z, x-(4/3f)*r, y+r, z, x-(4*s/3f)*r, y+r, z);//left
	}


	public void slicedoughnut(float x, float y, float z, float s, float r, float r2, float detail)
	{
		for(int i=0; i<detail; i++)//doughnut with slicedcircle
		{
			ang = (i/(detail))*TWO_PI;
            strokeWeight(8*currentVolume+1);
            stroke((300*(ang/TWO_PI)),100,60);
			slicedcircle(x,y,z+r2*sin(ang),r+r2*cos(ang),s);
		}
	}



	public void draw() {
		background(0);
		//fill(255);
		translate(trans, 0);
		trans += speed;
		//noStroke();

		if (keyPressed) {
			if (keyCode == LEFT) {
			  trans += speed; // move the camera to the left
			} else if (keyCode == RIGHT) {
			  trans -= speed; // move the camera to the right
			}
		  }

		switch (mode) {

            case 7:
            noFill();

			fft.forward(aplayer.mix);

			// amplitude of frequency bands
			int lowFreq = 0;
			int highFreq = (int)aplayer.sampleRate() / 2;
			int freqStep = (highFreq - lowFreq) / seg;
			
			for (int i = 0; i < seg; i++) {
				int start = lowFreq + i * freqStep;
				int end = start + freqStep;
				
				float sum = 0;
				for (int j = start; j < end; j++) {
				sum += fft.getBand(j);
				}
				float avg = sum / freqStep;
				
				bands[i] = avg;
				
				/*  testing visual
				rect(-200+(100*i),300-(bands[i]*300),50,bands[i]*300);*/
			}
			
			/*  display the values of the frequency bands
			textSize(32);
			textAlign(LEFT, TOP);
			for (int i = 0; i < seg; i++) {
				text("Band " + i + ": " + bands[i], 10, 10 + i * 40);
			}*/


			// get current volume level
			currentVolume = aplayer.mix.level();

			  //display volume level
			textSize(32);
			text("Current Volume: " + currentVolume, 50, 250);
			text("Translate : " + trans, 0-trans, 350);

			
			
			
            for(p=0;p<seg;p++)
			{
				if(((700-trans)+200*p)>1600){
                    pillar((700-trans)+200*p, 1400, 0, 50, 600+250*bands[p], 20);

                }      
			}
				
            
			
			for(j=0;j<20;j++){
                slicedoughnut(500,500,array[j]*4,(array[j]+200)/380,400,120,20);
				slicedoughnut(-600,500,array[j]*4,(array[j]+200)/380,400,120,20);
				slicedoughnut(-1700,500,array[j]*4,(array[j]+200)/380,400,120,20);
            }

            for(j=0;j<20;j++){
                array[j] += -1;
            }

            if(array[0]<-220){
                for(j=0;j<20;j++){
                    array[j] = j*20-200;
                    
                }
            }

            if (bounce > TWO_PI){
                bounce = 0;
            }

            bounce += 0.2;

            widedoughnut(500, 850-((sin(bounce)/8)+0.875f)*400, 100, (sin(bounce)/8)+0.875f, 100, 20, 40);//right
			widedoughnut(-600, 850-((currentVolume/8)+0.875f)*400, 100, (currentVolume/8)+0.875f, 100, 20, 50);//middle
			widedoughnut(-1700, 850-((sin(bounce)/8)+0.875f)*400, 100, (sin(bounce)/8)+0.875f, 100, 20, 30);//left
                

			default:
				break;
		}

	}
}
