package com.sf.omletintegrationandroid;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {

	private Button sendTextButton;
	private Button sendImageButton;
	private Button sendGifButton;
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        
	        this.sendTextButton = (Button)this.findViewById(R.id.sendText);
	        this.sendTextButton.setOnClickListener(new OnClickListener() 
	        {
				@Override
				public void onClick(View v) 
				{
					sendText();
				}
	        });
	        
	        this.sendImageButton = (Button)this.findViewById(R.id.sendImage);
	        this.sendImageButton.setOnClickListener(new OnClickListener() 
	        {
				@Override
				public void onClick(View v) 
				{
					sendImage();
				}
	        });
	        
	        this.sendGifButton = (Button)this.findViewById(R.id.sendGif);
	        this.sendGifButton.setOnClickListener(new OnClickListener() 
	        {
				@Override
				public void onClick(View v) 
				{
					sendGif();
				}
	        }); 
	    }

	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }

	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Handle action bar item clicks here. The action bar will
	        // automatically handle clicks on the Home/Up button, so long
	        // as you specify a parent activity in AndroidManifest.xml.
	        int id = item.getItemId();
	        if (id == R.id.action_settings) {
	            return true;
	        }
	        return super.onOptionsItemSelected(item);
	    }
	    
	    public void sendText()
	    {
	    	Intent response = new Intent();
	    	response.putExtra(Intent.EXTRA_TEXT, "Saying Hi to Omlet!");
	    	response.setType("text/plain");
	    	setResult(RESULT_OK, response);
	    	finish();
	    }
	    
	    public void sendImage()
	    {
	    	Intent response = new Intent();
	    	Uri uri = Uri.parse("android.resource://com.sf.omletintegrationandroid/" + R.drawable.example_image);
	    	response.putExtra(Intent.EXTRA_STREAM, uri);
	    	response.setType("image/png");
	    	setResult(RESULT_OK, response);
	    	finish();
	    }
	    
	    public void sendGif()
	    {
	    	Intent response = new Intent();
	    	Uri uri = Uri.parse("android.resource://com.sf.omletintegrationandroid/" + R.drawable.example_gif);
	    	response.putExtra(Intent.EXTRA_STREAM, uri);
	    	response.setType("image/gif");
	    	setResult(RESULT_OK, response);
	    	finish();
	    }
}
