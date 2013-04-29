package de.dit.btt;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BTTMainActivity extends Activity {
	
	private TextView 	mTvOutput;
	private EditText 	mEtInput;
	private Button 		mBtSend;

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
    	
    	//mTvOutput = (TextView) findViewById(R.id.);
    	 
    	
    }
    
    
}
