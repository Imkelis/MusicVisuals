package C21371216;

import processing.core.PApplet;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;

public class Doughnut extends PApplet {

	Minim minim;
	AudioPlayer aplayer;
	AudioInput ainput;
	AudioBuffer abuffer;
	FFT fft;

    PApplet parent;

    public Doughnut(PApplet parent) {
        this.parent = parent;
    }


	float currentVolume;
    float previousVolume;
    
	int seg = 8; //bands of frequency
	float[] bands = new float[seg];
    float[] prevbands = new float[seg];
    float[] lerpbands = new float[seg];

    float[] array = new float[20];

    float ang = 0;
	float x2 = 0;
	float z2 = 0;
	float speed = 2.4f; // speed of camera
    int transX = -4600; // camera position
    int j = 0;
    int i = 0;
	int p = 0;
    


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
		
        for(i=0;i<20;i++) //initialising array for connecting circles
		{
            array[i] = i*20;
        }
	}

    
	public void pillar(float x,float y,float z, float r, float h, float detail) //x,y,z coords of base
	{
		for(i=0;i<detail;i++)
		{
			ang = (i/(detail))*TWO_PI;
			x2 = x+r*sin(ang);
			z2 = z+r*cos(ang) + 200*sin(x2/100);
			parent.stroke(x2%360, 100, 100);
			parent.line(x2, y, z2, x2, y-h-(15*cos(x2/15)), z2);  //lower pillar
            parent.line(x2, -320, z2, x2, -320+h+(15*cos(x2/15)), z2);  //upper pillar
		}
	}

	public void circ3d(float x,float y,float z, float r) //circle
	{
		parent.bezier(x, y-r, z, x+(4/3f)*r, y-r, z, x+(4/3f)*r, y+r, z, x, y+r, z);//right
		parent.bezier(x, y-r, z, x-(4/3f)*r, y-r, z, x-(4/3f)*r, y+r, z, x, y+r, z);//left
	}

	public void doughnut(float x, float y, float z, float r, float r2, float detail) //repeated circles to make doughnut
	{
		for(int i=0; i<detail; i++)  
		{
			ang = (i/(detail))*TWO_PI;
            parent.stroke(ang*60,100,100);
			circ3d(x,y,r2*sin(ang),r+r2*cos(ang));
		}
	}

    public void widecircle(float x,float y,float z, float r,float h)//squashed circle , h = percent of height
	{
		parent.bezier(x, y-r*h, z, x+(4/3f)*r, y-r*h, z, x+(4/3f)*r, y+r*h, z, x, y+r*h, z);//right
		parent.bezier(x, y-r*h, z, x-(4/3f)*r, y-r*h, z, x-(4/3f)*r, y+r*h, z, x, y+r*h, z);//left
	}

    public void widedoughnut(float x, float y, float z, float h, float r, float r2, float detail)
	{
		for(int i=0; i<detail; i++) //doughnut with widecircle
		{
			ang = (i/(detail))*TWO_PI;
            parent.stroke(abs(ang-TWO_PI)*57.3f,100,100);
            parent.strokeWeight(5);
			widecircle(x,y,r2*sin(ang),r+r2*cos(ang),h);
		}
	}

    public void slicedcircle(float x,float y,float z, float r, float s) //s = percent sliced (0 normal, 1 sliced)
	{
		parent.bezier(x+(4*s/3f)*r, y-r, z, x+(4/3f)*r, y-r, z, x+(4/3f)*r, y+r, z, x+(4*s/3f)*r, y+r, z);//right
		parent.bezier(x-(4*s/3f)*r, y-r, z, x-(4/3f)*r, y-r, z, x-(4/3f)*r, y+r, z, x-(4*s/3f)*r, y+r, z);//left
	}

	public void slicedoughnut(float x, float y, float z, float s, float r, float r2, float detail)
	{
		for(int i=0; i<detail; i++)//doughnut with slicedcircle
		{
			ang = (i/(detail))*TWO_PI;
            parent.strokeWeight(8*currentVolume+1);
            parent.stroke((360*(ang/TWO_PI)),100,60);
			slicedcircle(x,y,z+r2*sin(ang),r+r2*cos(ang),s);
		}
	}



	public void draw(FFT fft, AudioPlayer aplayer/*int transX, float previousVolume, float[] prevbands, float lerpbands[]*/) {
		parent.background(0);
        parent.noFill();

        transX += speed; //scrolling sideways
        parent.translate(transX, 0);

		if (keyPressed) {
			if (keyCode == LEFT) {
			  transX += speed; // move the camera to the left
			} else if (keyCode == RIGHT) {
			  transX -= speed; // move the camera to the right
			}
		}
        
        if(transX>3600){  //kill after 3600
            noLoop();
        }

        
        fft.forward(aplayer.mix);

        currentVolume = aplayer.mix.level(); //get volume level
        
        float lerpedVolume = lerp(previousVolume,currentVolume,0.08f);
        previousVolume = lerpedVolume;
    
        int lowFreq = 0;
        int highFreq = (int)aplayer.sampleRate() / 2;
        int freqStep = (highFreq - lowFreq) / seg;
        
        for (int i = 0; i < seg; i++) {          //amplitude of frequency bands
            int start = lowFreq + i * freqStep;
            int end = start + freqStep;
            
            float sum = 0;
            for (int j = start; j < end; j++) {
            sum += fft.getBand(j);
            }
            float avg = sum / freqStep;
            
            bands[i] = avg;

            lerpbands[i] = lerp(prevbands[i],bands[i],0.3f);
            
            prevbands[i] = lerpbands[i];
        }

        
        for(p=0;p<seg;p++) //draw pillars
        {
            if(((300-transX)+200*p)>1400){
                pillar((300-transX)+200*p, 1400, 0, 50, 600+(50+50*p)*lerpbands[p], 20);
            }
        }

        
        for(j=0;j<20;j++){    //incrementing postition backwards for sliced circles
            array[j] += -1;
        }

        if(array[0]<-220){   // when too far back reset position
            for(j=0;j<20;j++){
                array[j] = j*20-200;
            }
        }


        for(j=0;j<20;j++) //draw separating circles
        {
            slicedoughnut(500,500,array[j]*4,(array[j]+200)/380,400,120,20);
            slicedoughnut(-600,500,array[j]*4,(array[j]+200)/380,400,120,20);
            slicedoughnut(-1700,500,array[j]*4,(array[j]+200)/380,400,120,20);
        }

        //draw bouncing doughnuts
        widedoughnut(500, 850-((lerpedVolume/1)+0.5f)*400, 100, (lerpedVolume/1)+0.5f, 100, 20, 40);//right
        widedoughnut(-600, 850-((lerpedVolume*1.2f)+0.5f)*400, 100, (lerpedVolume*1.2f)+0.5f, 100, 20, 50);//middle
        widedoughnut(-1700, 850-((lerpedVolume/1)+0.5f)*400, 100, (lerpedVolume/1)+0.5f, 100, 20, 50);//lef

	}
}