package com.example.surfaceviewexample;

import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView {
   private Bitmap bmpIcon;
   private SurfaceHolder surfaceHolder;
   public int xpos, ypos;
   public int dx, dy;
   Square[] Squares = new Square[20];
   MyThread myThread;
   
	public MySurfaceView(Context context) {
		super(context);
		init();
		// TODO Auto-generated constructor stub
	}
	public MySurfaceView(Context context, AttributeSet attrs) {
		super(context,attrs);
		init();
		// TODO Auto-generated constructor stub
	}
	public MySurfaceView(Context context, AttributeSet attrs, int defstyle) {
		super(context,attrs, defstyle);
		init();
		// TODO Auto-generated constructor stub
	}
	
private void  init() {
   Random r = new Random();
	myThread = new MyThread(this);
 
	xpos = 10;
	ypos  =20;
	dx = 20;
	dy=20;
	for (int i = 1; i<Squares.length;i++) {
		Square s = new Square();
		s.x = r.nextInt(500);
		s.y = r.nextInt(500);
		s.dx = r.nextInt(40)-5;
		s.dy = r.nextInt(40)-5;
		Squares[i] = s;
	}
	
	surfaceHolder = getHolder();
	surfaceHolder.addCallback(new SurfaceHolder.Callback() { 
	
public void surfaceCreated(SurfaceHolder holder) {
	/*  Canvas canvas = holder.lockCanvas(null);
      drawSomething(canvas);
	  holder.unlockCanvasAndPost(canvas);*/
	myThread.setRunning(true);
	myThread.start();
}

public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
	 
}
public void surfaceDestroyed(SurfaceHolder holder) {
	boolean retry = true;
	 myThread.setRunning(false);
	 
	 while(retry) {
		 try {
			 myThread.join();
			 retry = false;
		 } catch (InterruptedException e) {
			 
		 }
	 }
	 
	 
	    
    } });
}	 
		
   protected void drawSomething (Canvas canvas){
	   Random r= new Random();
	   int startx, starty, squaresize;
	   squaresize = 100;
	   int w = 10,h=10;
	   
	    canvas.drawRGB(255,255,255);
	    
	    Paint p = new Paint( );
	    p.setColor(Color.BLUE);
	    startx = xpos;
	    starty = ypos;
		canvas.drawRect(xpos,ypos,xpos+w,ypos+h,p);
		
		xpos = xpos + dx;
		ypos = ypos + dy;
		
		
		Square s;
		for (int i = 1; i<Squares.length;i++) {
			s = Squares[i];
			canvas.drawRect(s.x,s.y,s.x+20,s.y+20,p);
			s.x = s.x+s.dx;
			s.y = s.y + s.dy;
			if (s.x+w>canvas.getWidth()) {s.dx = s.dx*-1;}
			if (s.y+h>canvas.getHeight()) {s.dy = s.dy*-1;}
			if (s.x <0) {s.dx = s.dx*-1;}
			if (s.y <0) {s.dy = s.dy*-1;}
			 
		}
		
		
	/*    
	    
	    
	   Color c;
	     
	    p.setTextSize(50);
	    canvas.drawText("Hello", canvas.getWidth()/2, 40, p);
	    
	    p.setColor(Color.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		p.setStyle(Style.FILL);
		startx = xpos;
	    starty = ypos;
		canvas.drawRect(startx,starty,startx+squaresize,starty+squaresize, p);
		  
		p.setColor(Color.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		p.setStyle(Style.FILL);
		startx = canvas.getWidth()-squaresize-xpos;
		starty = ypos;  
		canvas.drawRect(startx,starty,startx+squaresize,starty+squaresize, p);
		  
		p.setColor(Color.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		p.setStyle(Style.FILL);
		startx = xpos;
		starty = canvas.getHeight()-squaresize-ypos;  
		canvas.drawRect(startx,starty,startx+squaresize,starty-squaresize, p);
		  
		
		p.setColor(Color.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		p.setStyle(Style.FILL);
		startx = canvas.getWidth()-squaresize-xpos;
		starty = canvas.getHeight()-squaresize-ypos;  
		canvas.drawRect(startx,starty,startx+squaresize,starty-squaresize, p);
		  
		
		  xpos+=r.nextInt(40);
		  ypos+=r.nextInt(40);
		  
		  if (xpos > 500) {xpos = 0;ypos=0;}
		  */
   }
   

}
