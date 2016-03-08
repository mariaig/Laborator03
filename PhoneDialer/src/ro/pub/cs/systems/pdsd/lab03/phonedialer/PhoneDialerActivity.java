package ro.pub.cs.systems.pdsd.lab03.phonedialer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class PhoneDialerActivity extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);
        
        final EditText phoneNumberText = (EditText) findViewById(R.id.editText1);
        
        
        int ids[] = new int[] {R.id.button1, R.id.button2, R.id.button3,
        		R.id.button4, R.id.button5, R.id.button6,
        		R.id.button7, R.id.button8, R.id.button9,
        		R.id.button10, R.id.button11, R.id.button12};
        
        
        for(int i = 0; i < 12; i++) {
        	final Button btn = (Button) findViewById(ids[i]);
        	btn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					String text = phoneNumberText.getText().toString();
					phoneNumberText.setText(text + btn.getText());
				}
			});
        }
        
        ImageButton editBtn = (ImageButton) findViewById(R.id.backspaceButton);
        editBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String text = phoneNumberText.getText().toString();
				int len = text.length();
				if(len > 0) { 
					phoneNumberText.setText(text.substring(0, len-1));
				}
			}
		});
        
        
        ImageButton callBtn = (ImageButton) findViewById(R.id.callButton);
        callBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String phoneNumber = phoneNumberText.getText().toString();
				Intent intent = new Intent(Intent.ACTION_CALL);
				intent.setData(Uri.parse("tel:" + phoneNumber));
				startActivity(intent);
			}
		});
        
        
        ImageButton hangupButton = (ImageButton) findViewById(R.id.hangupButton);
        hangupButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
        
    }
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.phone_dialer, menu);
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
    
}
