# Music Visualiser Project

Name & student Number: 
<br />Jordan Murray - D22126809
<br />Tom Keane - C21371216

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment

# Video
[![YouTube](http://img.youtube.com/vi/HA9LgluDzpc/0.jpg)](https://www.youtube.com/watch?v=HA9LgluDzpc)

# Instructions

# How it works


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

### What I did
I made a visual with pillars, circles and doughnut shapes using java functions and used minim to analyze the audio of the song and control the movement of shapes to go along with the volume and different frequency bands of the song. I made the size and colours respond to the audio and I used lerp to smooth the movement of the shapes.
### What I am most proud of 
The main thing I'm proud of is getting the bouncing animation on the doughnut shape working right.  It took some time to get the correct values for the movement and to get the lerp working smoothly. After a lot of trial and error I got it working properly and I'm happy with how it turned out.
## What I learned
I learned a lot about java, processing and git doing this project. I expanded my knowledge on functions, classes and how to use multiple files in one program using java. I learned about the processing library and how to make shapes and visuals. This was my first time using github for a project so I learned a lot about how to use git bash and github and now I feel more confident with these programs.



# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |




D22125465 Idea:

I took inspiration from a video game I played  few years ago, the song is also from that video game.
The game is set in Maimi, and I tried to get the visual to match that asthetic.




Functionality:

You can scroll through the visuals, pause the song, and reset the song.




D22125465 Git Commits:

Commits on May 3, 2023
Added the functionality to pause and reset, didnt realise that was mi… 

@Imkelis
Imkelis committed 12 hours ago
 
Changed how the background is formed so that the background stretched… 

@Imkelis
Imkelis committed 13 hours ago
 
Merge branch 'master' of https://github.com/Imkelis/MusicVisuals

@Imkelis
Imkelis committed 13 hours ago
 
Changed how lines are created again, now its actually decent

@Imkelis
Imkelis committed 13 hours ago
 
Commits on Apr 25, 2023
I previously broke elements of my code without realising. Fixed it now.

@Imkelis
Imkelis committed last week
 
Small things

@Imkelis
Imkelis committed last week
 
Seperated my code into class, and other small changes

@Imkelis
Imkelis committed last week
 
Merge branch 'master' of https://github.com/Imkelis/MusicVisuals

@Imkelis
Imkelis committed last week
 
Seperated my code into classes, also a few other small changes.

@Imkelis
Imkelis committed last week
 
Merge branch 'master' of https://github.com/Imkelis/MusicVisuals

@Imkelis
Imkelis committed last week
 
commit before pull

@Imkelis
Imkelis committed last week
 
Commits on Apr 24, 2023
Changed how the lines are made, now made in its own class. Also remov… 

@Imkelis
Imkelis committed last week
 
Cleaned up some stuff.

@Imkelis
Imkelis committed last week
 
Created a new class to launch our code, and also edited alot of my co… 

@Imkelis
Imkelis committed last week
 
Commits on Apr 19, 2023
Changed the way the colored lines in the middle of the screen are mad… 

@Imkelis
Imkelis committed 2 weeks ago
 
Added a moon

@Imkelis
Imkelis committed 2 weeks ago
 
Commits on Apr 7, 2023
Fixing minor things

@Imkelis
Imkelis committed last month
 
Changed some colors, trying to figure out how to make nice palm trees

@Imkelis
Imkelis committed last month
 
Commits on Apr 6, 2023
Need to finish palmtrees, and maybe remake the floor for my second vi… 

@Imkelis
Imkelis committed last month
 
Added background, idk if I like the colors so may change later

@Imkelis
Imkelis committed last month
 
Got the road moving, but the lines are getting grouped

@Imkelis
Imkelis committed last month
 
Trying to get the road to move smoothly

@Imkelis
Imkelis committed last month
 
Started second visual, fixed the weird angle that developed on the fi… 

Imkelis committed last month


Finally got a song and some inspiration, starting next visual element… 

Imkelis committed last month
 


First commit, I mistakenly started working on this project on my own repo

Imkelis committed last month

