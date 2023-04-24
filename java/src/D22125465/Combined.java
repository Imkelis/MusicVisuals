// package D22125465;

// import ddf.minim.AudioBuffer;
// import ddf.minim.AudioInput;
// import ddf.minim.AudioPlayer;
// import ddf.minim.Minim;
// import ddf.minim.analysis.FFT;
// import processing.core.PApplet;

// public class Combined extends PApplet {
// int mode = 0;

// public void keyPressed() {
// if (key >= '0' && key <= '9') {
// mode = key - '0';
// }
// }

// IgnasVisual1 IgnasV1 = new IgnasVisual1(this);
// IgnasVisual2 IgnasV2 = new IgnasVisual2(this);

// Minim minim;
// AudioPlayer aplayer;
// AudioInput ainput;
// AudioBuffer abuffer;
// FFT fft;

// int Mode = 1;
// int color = 0;
// float spawns = 0;
// float count1 = 1;
// float count2 = 1;
// float count3 = 1;
// float count4 = 1;
// float count5 = 1;
// float sun = 400;
// float moon = -100;

// float lerpBuffer[] = new float[2048];
// float lerpFFTbuffer[] = new float[2048];

// public void settings() {
// size(2048, 1000, P3D);
// }

// public void setup() {
// colorMode(HSB, 360, 100, 100);
// minim = new Minim(this);
// aplayer = minim.loadFile("M.O.O.N.mp3", 2048); // Temp Song, to be changed
// aplayer.play();
// abuffer = aplayer.mix;

// fft = new FFT(width, 44100);
// }

// public void draw() {
// float halfHeight = height / 2;
// float halfWidth = width / 2;
// float biggest = 0;
// float rotate = 0;
// float speed = 0;
// float smallest = 10000;
// float acceleration = 0.05f;
// float o = 0;
// fft.forward(abuffer);

// for (int i = 0; i < abuffer.size(); i++) {
// lerpFFTbuffer[i] = lerp(lerpFFTbuffer[i], fft.getBand(i), 0.0005f);
// lerpBuffer[i] = lerp(lerpBuffer[i], abuffer.get(i), 0.005f);
// if (lerpBuffer[i] > biggest) {
// biggest = lerpBuffer[i];
// }

// }

// switch (mode) {
// case 0:
// pushMatrix();
// IgnasV1.draw(lerpFFTbuffer, lerpBuffer, abuffer, fft, biggest);
// popMatrix();

// break;
// case 1:

// IgnasV2.draw(lerpFFTbuffer, lerpBuffer, abuffer, fft, biggest);

// // background(11, 100, 62);
// // noStroke();
// // fill(200, 45, 78);
// // rect(0, 0, width, 76);
// // fill(206, 41, 77);
// // rect(0, 76, width, 152);
// // fill(221, 35, 77);
// // rect(0, 152, width, 228);
// // fill(238, 30, 77);
// // rect(0, 228, width, 304);
// // fill(260, 35, 76);
// // rect(0, 304, width, 380);
// // fill(282, 45, 75);
// // rect(0, 380, width, 456);

// // for (int i = 0; i < lerpBuffer.length / 15; i++) {

// // speed = map(lerpBuffer[i], -0.06830386f, 0.06844372f, 0f, 100f);

// // fill(330, 100, 100);

// // rect(i + o, halfHeight - 44, 40, -fft.getBand(i) * 2f);
// // o += 40;

// // fill(47, 30, 77);
// // ellipse((halfWidth) + cos(sun) * 600f, halfHeight + sin(sun) * 300f, 250 +
// // (abuffer.get(i) * 40f),
// // 250 + (abuffer.get(i) * 40f));

// // fill(213, 32, 36);
// // ellipse((halfWidth) + cos(moon) * 600f, halfHeight + sin(moon) * 300f, 250
// +
// // (abuffer.get(i) * 40f),
// // 250 + (abuffer.get(i) * 40f));

// // fill(213, 32, 25);
// // ellipse((halfWidth) + cos(moon) * 600f, (halfHeight - 50) + sin(moon) *
// 300f,
// // 50 + (abuffer.get(i) * 40f),
// // 50 + (abuffer.get(i) * 40f));

// // ellipse((halfWidth - 80) + cos(moon) * 600f, (halfHeight + 30) + sin(moon)
// *
// // 300f,
// // 50 + (abuffer.get(i) * 40f),
// // 50 + (abuffer.get(i) * 40f));

// // ellipse((halfWidth + 25) + cos(moon) * 600f, (halfHeight + 50) + sin(moon)
// *
// // 300f,
// // 50 + (abuffer.get(i) * 40f),
// // 50 + (abuffer.get(i) * 40f));

// // }

// // stroke(330, 100, 100);
// // strokeWeight(3);
// // line(0, halfHeight, width, halfHeight);
// // line(halfWidth, halfHeight, 0, halfHeight + halfHeight * .3f);
// // line(halfWidth, halfHeight, 0, halfHeight + halfHeight * .9f);
// // line(halfWidth, halfHeight, 0, halfHeight + halfHeight * 2.3f);
// // line(halfWidth, halfHeight, 0, halfHeight + halfHeight * 6f);
// // line(halfWidth, halfHeight, (float) width, halfHeight + halfHeight *
// 2.3f);
// // line(halfWidth, halfHeight, (float) width, halfHeight + halfHeight * .9f);
// // line(halfWidth, halfHeight, (float) width, halfHeight + halfHeight * .3f);
// // line(halfWidth, halfHeight, (float) width, halfHeight + halfHeight * 6f);

// // strokeWeight(4);

// // int c = 0;
// // for (int i = 4; i <= 44; i = i + 4) {

// // if (c == 0) {
// // stroke(182, 31, 76);
// // c = 1;
// // } else if (c == 1) {
// // stroke(0);
// // c = 0;
// // }

// // line(0, halfHeight - i, width, halfHeight - i);

// // }

// // fill(24, 54, 11);
// // rect(-5, halfHeight - 5, width + 5, halfHeight + 5);

// // stroke(330, 100, 100);

// // line(0, halfHeight + count1, width, halfHeight + count1);

// // count1 += (1f + (count1 * acceleration));

// // if (count1 > 122 || count2 > 1) {
// // line(0, halfHeight + count2, width, halfHeight + count2);
// // count2 += (1f + (count2 * acceleration));
// // }

// // if (count2 > 122 || count3 > 1) {
// // line(0, halfHeight + count3, width, halfHeight + count3);
// // count3 += (1f + (count3 * acceleration));
// // }
// // if (count3 > 122 || count4 > 1) {
// // line(0, halfHeight + count4, width, halfHeight + count4);
// // count4 += (1f + (count4 * acceleration));
// // }

// // if (count4 > 122 || count5 > 1) {
// // line(0, halfHeight + count5, width, halfHeight + count5);
// // count5 += (1f + (count5 * acceleration));
// // }

// // if (count1 > 500) {
// // count1 = 1;
// // }

// // if (count2 > 500) {
// // count2 = 1;
// // }
// // if (count3 > 500) {
// // count3 = 1;
// // }
// // if (count4 > 500) {
// // count4 = 1;
// // }

// // if (count5 > 500) {
// // count5 = 1;
// // }

// // sun += .003f;
// // moon += .003f;
// // break;

// }

// }
// }
