package de.dit.btt;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BTTMainActivity extends Activity {
	
	private TextView 	mTvTerminal;
	private EditText 	mEtInput;
	private Button 		mBtSend;
	
	private OnClickListener handleSend = new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			 // TODO: Handle Send Button
			
		}
    	
    }; 
	


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bttmain);
        
        initGUI();
         
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bttmain, menu);
        return true;
    }
    
    private void initGUI(){
    	
    	mTvTerminal = (TextView) findViewById(R.id.tv_terminal);
    	mEtInput 	= (EditText) findViewById(R.id.et_input);
    	mBtSend 	= (Button)   findViewById(R.id.bt_send);
    	
    	mBtSend.setOnClickListener(handleSend);
    
    	
    }
    
    
}
