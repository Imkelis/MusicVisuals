# Music Visualiser Project

Name & student Number: 
<br />Jordan Murray - D22126809

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment

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

