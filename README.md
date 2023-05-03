# Music Visualiser Project

Name & student Number: 
<br />Jordan Murray - D22126809
<br />Tom Keane - C21371216
<br />Ignas Merkelis - D22125465

#
Group 856

# Video
[![YouTube](http://img.youtube.com/vi/HA9LgluDzpc/0.jpg)](https://www.youtube.com/watch?v=HA9LgluDzpc)

# Instructions
You can click numbers 1-4 to change visuals, spacebar to pause music, and r to reset the song.


# List of classess/assets
### D22126809
| Class/asset | Source |
|-----------|-----------|
|Celestial.java| Self written|
|CenterElement.java | Self written |
|LifeBoard.java | Modified class code |
|Orbiter.java | Self written |
|Star.java | Self written |
|WaveForm.java | Self written |

#### What i did
I developed the visual that has the center circle with Conways Game of Life glider gun in it 
along with the waveform that moves around the sketch. The visual also has other elements contained 
in it including aspects refered to as Celestials and Orbiters that are used to depict high-hats in
the given input audio. Additionally to represent the kick of the track outward lines leave the
center element in according to the beat.

#### What i am most proud of
Overall, i'm generally proud with the outcome of the sketch that i done. There's much more that i
would of loved to implement with the visual, but as it stands i believe theres some really cool
things about it. I'm particulary proud of the waveform element of the visual sketch and its
constant movement around the screen. When this was first being implemented early on in the project, 
this aspect of the sketch is what mostly got me familiar with the transform function of processing
i.e., applying transformations to the coordinate system in order to fulfil the movement of the
waveform.

#### What i learned
Of course the primary aspect learned throughout the course of this project was the framework of
Processing. I'm grateful to be introduced to this as i never heard of the framework prior to 
starting this module. I believe its an excellent outlet for practicing creative programming.
Another aspect that i've learned considerably more about since starting this project is git which
i consider essential as I progress further. Regularly encountering problems while becoming 
properly accustomed to git was very benefical because as time went on most of the problems 
have been seen before and can be appropriately handled.

#### Waveform
The waveform element of the visual works by keeping track of the position of the waveform as it traverses along the sides of the sketch. An enumerate types is used to keep track of its position i.e., LEFT, TOP etc. The waveform has a PVector attribute to keep track of its coordinates and every time the wave is rendered its position is transformed according to its coordinates.

#### Centre Element
The Game of Life Gosper Gun element in the centre of the circle only displays the cells that are alive within the domain of the circumference of the circle in which it inhabits. This is done by using the ‘fill()’ function to colour the cells that are alive within the circle and if the cells are out of bounds of the circle, then ‘noFill()’ is applied. The outer circle of the centre element that has the blue colouring is reactive to the input audio of the program in the sense that different shapes of blue are shown in accordance to the audio. The outer spikes that come out of the centre element are react to the kick of the input audio

#### Celestial / Orbiters 
The square objects either side of the centre element change colour in according with the input audio, they also change size slightly. These are small circles that orbit the celestial objects and each orbiter has its own rotation direction, either clockwise or anti-clockwise.


## C21371216
#### Doughnut.java

The Doughnut.java class contains code for creating pillars, circles and torus shapes that respond to volume and frequency levels of the audio. While running it scrolls the view from right to left. It uses functions to create the shapes and a lerp buffer to smooth movements of the shapes. There are two different visuals, the first is moving pillars and the second has a bouncing torus shapes surrounded by circles changing in size and colour. 

 
### How it works 

There are functions for each shape and some of these are functions that call other functions repeatedly to make a new shape. For example, a doughnut/torus shape is created with repeated circle functions. Here is a demonstration of both functions: 

```Java 
public void circ3d(float x,float y,float z, float r) //circle 
{ 
    parent.bezier(x, y-r, z, x+(4/3f)*r, y-r, z, x+(4/3f)*r, y+r, z, x, y+r, z);//right 
    parent.bezier(x, y-r, z, x-(4/3f)*r, y-r, z, x-(4/3f)*r, y+r, z, x, y+r, z);//left 
} 
 ``` 
```Java 
public void doughnut(float x, float y, float z, float r, float r2, float detail) //repeated circles to make doughnut 
{ 
    for(int i=0; i<detail; i++)   
    { 
        ang = (i/(detail))*TWO_PI; 
        circ3d(x,y,r2*sin(ang),r+r2*cos(ang)); 
    } 
} 
``` 

The view is scrolled right to left by incrementing the variable transX and using the variable speed to control the movement speed  

```Java 
transX += speed; //scrolling sideways 
parent.translate(transX, 0);
```

The 8 pillars are each tied to the amplitude of a frequency band. Their movement and the wave affect are achieved using sin waves. They eventually disappear to avoid crossing over onto the next visual.  

The position of the converging circles is stored in an array. When the circles move backwards to a certain point, the positions jump back forward, making it look like the last circle disappeared. They also change in size in response to the audio volume. 

```Java 
for(j=0;j<20;j++){    //incrementing postition backwards for sliced circles 
            array[j] += -1; 
} 

if(array[0]<-220){   // when too far back reset position 
    for(j=0;j<20;j++){ 
        array[j] = j*20-200; 
    } 
} 
``` 

The doughnut/torus shapes change in height and position in response to the audio to give the affect that they are bouncing. The lerp is used to smooth this movement.  

### What I am most proud of 
The main thing I'm proud of is getting the bouncing animation on the doughnut shape working right.  It took some time to get the correct values for the movement and to get the lerp working smoothly. After a lot of trial and error I got it working properly and I'm happy with how it turned out.


##### D22125465 - Ignas Merkelis

Class/Asset         	Source
BackgroundVisial.java	Self Written
DropLines.java         	Self Written
IgnasVisual1.java      	Self Written but I was definitely eying down the example visuals when trying to figure out the 3d things, so I guess thats kinda a source.
IgnasVisual2.java     	Self Written
Lines.java          	Self Written
sun.java	            Self Written

#### What I did
I developed two visuals for this project. IgnasVisual1 was the first visual I created; It consists 
of 5 cubes, 4 on the corners and 1 in the middle, and they react to the music my rotating, changing 
size's, and changing colors. I started creating this visual when I was still uncomfortable with 
java, and even though I'm still definetly not a pro, it definetly did help me improve my understanding 
of the java language. After my learning experience with the first visual, I decided to create another one! 
I remembered a game that I really enjoyed a few years ago, and after getting a boost in motivation, I decided 
to create a visual inspired by it. The game where I got inspiration for IgnasVisial2 is called 'Hotline Miami'. 
The second visual has moving lines that both naturally accelerate as they go down, and also accelerate based of 
the music. It also has a sun that moves side to side, the speed that it moves depends on the speed of the 
music, and it also gets bigger and smaller wit the beat. I also have waveforms in the background, those are 
meant to mimic city buildings, to kinda give a visual of a whole city dancing with the song. I dont know if 
thats what I ended up achieving, but its certaintly what I tried to achieve. It was actually originally supposed 
to have palmtrees and a moon too, im sure you can find references to those in the git, but in the end they 
just plain looked bad, so I removed them.

#### What I am most proud of
I'm overall pretty proud of how the second visual came out. I think it, along with the music, give off the 
exact synthwave atmosphere I was going for. ( I actually didnt know it was called synthwave until recently, 
but I definetly knew what synthwave looked like). But if I had to narrow it down to one thing, it would be the
colors, I think I did a good job finding colors that matched. The reason its the thing im most proud of is cause
its probobly the one witht the biggest viusal effect, even if it wasnt the hardest to implement. (But they were hard to find and match)

Beyond just whats within the project, I'd say im most proud of how much I learned while doing this project, but thats not what this is about 
and this is getting long so I'll rapidly move on.

#### What I learned

I learned how to use a varierety of java packeges and frameworks, mostly processing and the various things you can achieve with 
it. Now this is embarrising to say, but I only got a full grasp of how java classes and objects worked during this 
project ( I couldnt figure out why you would want to break your program across multiple java files ). I knew how to get 
classes and objects to work before, but now I actually understand how they work and their use, rather than just being able to 
do it cause of memorisation. Now this is unrelated to java, but I think its related to the project; I feel like I also learned how to 
be more creative in general.

#### BackgroundVisual
This was responsible for drawing the background. It sets the rectangles that act as a background, the lines that branch of the centre 
of the screen, and it also calls on the sun object. I dont think the background could be drawn with a loop since I wanted a specific 
color for each rectangle. This class also draws the lines that go across the screen, this time there is a loop since its just two colors.
This class also calls on the sun, which I will get to in a bit.

```Java
int c = 0;
        for (int i = 4; i <= 44; i = i + 4) {

            if (c == 0) {
                p.stroke(182, 31, 76);
                c = 1;
            } else if (c == 1) {
                p.stroke(0);
                c = 0;
            }

            p.line(0, halfHeight - i, width, halfHeight - i);

        }
```

#### Lines
This is the class responsible for creating the DropLines objects. It contails an array list to keep track of the lines, and its draw 
function calls the methods from DropLines to keep the spawned lines moving. The another line spawns once the last line in the array 
passes 'parent.height / 2', and a line dissapears when it passes 'parent.height'.

#### DropLines
This is the class that is responsible for the lines. It keeps track of the position of the line, and the speed its going & accelerating at. 
It contains methods do display and update the line:
```java
void update() {
        speed += 0.09;
        y += speed + lerpBoost;
    }

    void display() {
        parent.stroke(330, 100, 100);
        parent.line(0, y+50, parent.width, y+50);
    }
```

#### sun
This is responsible for both the sun going left and right on the screen, and also the waveforms that spawn in the background. The speed at which the sun travels depends on the song, the louder it is the faster it travels. Here is the code responsible for it:
```java
for (int i = 0; i < lerpBuffer.length / 15; i++) {

            speed = map(lerpBuffer[i], -0.06830386f, 0.06844372f, 0f, 100f);

            p.fill(330, 100, 100);

            p.rect(i + o, halfHeight - 44, 40, -fft.getBand(i) * 2f);

            o += 40;

            p.fill(47, 30, 77);

            p.ellipse((halfWidth) + cos(this.sun) * 600f, halfHeight + sin(this.sun) * 300f,
                    250 + (abuffer.get(i) * 40f),
                    250 + (abuffer.get(i) * 40f));

        }
        o = 0;
```
Every wafeform is 40 pixels thick, and a new waveform is spawned every 40 pixels, making it seamless. int o, which is responsible for the placement of the waveforms, gets updated every iteration, and then is reset back down to 0 so its ready for when its time for the next loop. In the ellipse, the suns size is increased and decreased with 'abuffer.get(i) * 40f', but it will always be at least 250 pixels.

#### IgnasVisual2

Creates the BackgroundVisual and Lines objects, then calls its methods. Also passes down the needed values down to those methods.

#### IgnasVisual1

5 boxes that rotate, change colors, and change sizes along with the song. There is also another cube that spawns and expands whenever the sound gets loud enough.
This is the code that decides the position of each cube:
```java
if (position == 0) {
                parent.translate(0, 0, -400);
            }

            else if (position == 1) {
                parent.translate(parent.width, 0, -400);
            }

            else if (position == 2) {
                parent.translate(0, parent.height, -400);
            }

            else if (position == 3) {
                parent.translate(parent.width, parent.height, -400);
            }

            else if (position == 4) {
                parent.translate(halfWidth, halfHeight, -400);
            }
```
It just translates to the position needed for the cube, then executes the code under the if & else if's. I would do this different I could 
start again, but this was the first visual I did when I was still uncomfortable with java, so at the time I was just happy to get it working.