package com.anim1;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class animasi1 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.setupButton();
    }
    private void setupButton(){
    	Button b=(Button)findViewById(R.id.StartAnimButton);
    	b.setOnClickListener(new Button.OnClickListener(){
    		public void onClick(View v){
    			parentButtonClicked(v);
    		}
    	});
    }
    private void parentButtonClicked(View v){
    	animate();
    }
    private void animate(){
    	ImageView imgView=(ImageView)findViewById(R.id.animationImage);
    	imgView.setVisibility(ImageView.VISIBLE);
    	imgView.setBackgroundResource(R.drawable.frame_animasi);
    	
    	AnimationDrawable frameAnimation=(AnimationDrawable)imgView.getBackground();
    	if(frameAnimation.isRunning()){
    		frameAnimation.stop();
    	}
    	else
    	{
    		frameAnimation.stop();
    		frameAnimation.start();
    	}
    }
}