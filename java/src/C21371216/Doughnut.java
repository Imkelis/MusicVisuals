package C21371216;

import processing.core.PApplet;

public class Doughnut extends PApplet {

	int mode = 0;

	public void settings() {
		size(1000, 1000, P3D);
		//fullScreen(SPAN);
	}

	public void setup() {
		colorMode(HSB,300,100,100);
        
        for(i=0;i<20;i++){
            array[i] = i*20;
        }
        
	}

	public void keyPressed() {

		mode = key - '0';
		println(mode);
	}

	float off = 0;
	float counter = 0;
	float slowcounter = 0;
	float m = 0;
	float ang = 0;
    int updown = 0;
    float height = 1;
    float bounce = 0;

	//case 3 testing variables
	float squareX = 200;    // x-coordinate of the square
	int squareY = 500;  // y-coordinate of the square
	int squareSize = 50;  // size of the square
	int speed = 10;      // speed at which the square moves
	float rotation = 0;
    int j = 0;
    int i = 0;

    float[] array = new float[20];
        
    
    
    
    
	

	public void circ3d(float x,float y,float z, float r)
	{
		bezier(x, y-r, z, x+(4/3f)*r, y-r, z, x+(4/3f)*r, y+r, z, x, y+r, z);//right

		bezier(x, y-r, z, x-(4/3f)*r, y-r, z, x-(4/3f)*r, y+r, z, x, y+r, z);//left
	}

	public void doughnut(float x, float y, float z, float r, float r2, float detail)
	{
		for(int i=0; i<detail; i++)
		{
			ang = (i/(detail))*TWO_PI;
            stroke(ang*50,100,100);
			//println("i = ",i,"ang = ",ang,"x = ",x,"y = ",y,"z = ",r2*cos(ang),"r = ",r+r2*cos(ang));
			circ3d(x,y,r2*sin(ang),r+r2*cos(ang));

		}

	}

    public void widecircle(float x,float y,float z, float r,float h)//h = percent of height
	{
		bezier(x, y-r*h, z, x+(4/3f)*r, y-r*h, z, x+(4/3f)*r, y+r*h, z, x, y+r*h, z);//right

		bezier(x, y-r*h, z, x-(4/3f)*r, y-r*h, z, x-(4/3f)*r, y+r*h, z, x, y+r*h, z);//left
	}

    public void widedoughnut(float x, float y, float z, float h, float r, float r2, float detail)
	{
		for(int i=0; i<detail; i++)
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
		for(int i=0; i<detail; i++)
		{
			ang = (i/(detail))*TWO_PI;
            strokeWeight(2f);
            stroke(ang*50,100,60);
			slicedcircle(x,y,z+r2*sin(ang),r+r2*cos(ang),s);

		}

	}

	public void draw() {
		background(0);
		//fill(255);
		
		//noStroke();

		switch (mode) {
			/*case 9:
				int numCircles = (int) max(1, mouseX / 50.0f);
				float d = width / numCircles;
				for (int j = 0; j < numCircles; j++) {
					for (int i = 0; i < numCircles; i++) {
						float x = (d * 0.5f) + (d * i);
						float y = (d * 0.5f) + (d * j);
						float c = ((i + j) / ((numCircles - 1) * 2.0f)) * 255.0f;
						fill((c + off) % 256, 255, 255);
						circle(x, y, d);
					}
				}
				off += (mouseY / 50.0f);
				break;
			case 1:
				fill(50,255,80);
				circle(200 * cos(slowcounter) + 400, 200 * sin(slowcounter) + 400, 60); 
				fill(255,255,255);
				slowcounter = slowcounter + 1;
				for(counter = 0;counter<360;counter++)	{
					float x = 200 * cos(counter) + 400;
					float y = 200 * sin(counter) + 400;
					circle(x, y, 50); 
				}
					
					//ellipse(500,500,300,100);
				break;*/
			case 2:
				//int m = second();
				//translate(300, 350, 0); 
				rotateY(QUARTER_PI);
				stroke(255);
				strokeWeight(2);
				noFill();
				//box(160);
				/*square(50,200,200);
				circ3d(400,400,0,50);
				circ3d(500,400,0,80);
				circ3d(600,400,0,100);
				circ3d(150,300,0,100);
				
				text("Hello hello",300,300);
				
				circ3d(700,500,0,150);
				circ3d(700,500,50,150);
				circ3d(700,500,100,150);
				circ3d(700,500,150,150);*/

				doughnut(500,500,0,100,40,2);
				

				/*bezier(150, 200, 283, 200, 283, 400, 150, 400);//right
				bezier(150, 200, 17, 200, 17, 400, 150, 400);//left
				bezier(50, 300, 50, 167, 250, 167, 250, 300);//up
				bezier(50, 300, 50, 433, 250, 433, 250, 300);//down*/
				
				
				
				
				break;
			case 3:
				background(0);  // clear the screen
                //stroke((squareX-200)/2,squareX,squareX);
				noFill();
				rotateY(degrees(rotation));
				//rotation += 0.0005;
				strokeWeight((abs(500 - squareX))/100);
				//rect(squareX, squareY, squareSize, squareSize);  // draw the square
				doughnut(600, squareY, 0, 10*(sin(squareX/50)+60), 2*(sin(squareX/50)+60), 50);
				// move the square to the right
				squareX += speed;
			
				// if the square moves off the right edge of the screen,
				// reset its position to the left side
				if (squareX > width-200) {
				squareX = 200-squareSize;
				}

                break;

            case 4:
                background(0); 
                stroke(300,100,100);
                noFill();
                strokeWeight(2);
                widedoughnut(400,400,0, height, 100,20,20);

                if (height<0.801){
                    updown = 0;
                }
                else if (height>0.999){
                    updown = 1;
                }

                if (updown == 1){
                    height += -.01;
                }
                else
                {
                    height += .01;
                }
                break;

            case 5:
            background(0); 
            stroke(300,100,100);
            rotateY(rotation);
            noFill();
            strokeWeight(2);
            slicedoughnut(400,300,0, height, 200,80,30);

            rotation += .01;
            if (height<0.001){
                updown = 0;
            }
            else if (height>1.399){
                updown = 1;
            }

            if (updown == 1){
                height += -.01;
            }
            else
            {
                height += .01;
            }
                break;

            case 6:
            rotateY(20);
            slicedoughnut(400,400,0,0.5f,200,80,30);
            
                break;

            case 7:
            noFill();
            for(j=0;j<20;j++){
                slicedoughnut(500,500,array[j]*4,(array[j]+200)/380,400,120,20);
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

            widedoughnut(500, 850-((sin(bounce)/8)+0.875f)*400, 100, (sin(bounce)/8)+0.875f, 100, 20, 20);



                
			default:
				break;
		}

	}
}
