package de.dit.btt;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BTTMainActivity extends Activity {
	
	private TextView 			mTvTerminal;
	private EditText 			mEtInput;
	private Button 				mBtSend;
	
	private BroadcastReceiver 	mBluetoothReceiver					= null;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bttmain);
        
        initGUI();
        registerBroadcastReceiver();
         
        
    }


    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu; this adds items to the action bar if it is present.
	    getMenuInflater().inflate(R.menu.bttmain, menu);
	    return true;
	}


	private void registerBroadcastReceiver() {
		 
        IntentFilter I_BLUETOOTH_CONNECTED 		= new IntentFilter(BluetoothDevice.ACTION_ACL_CONNECTED);
         
        registerReceiver(mBluetoothReceiver, I_BLUETOOTH_CONNECTED);
        
		
	}


	private void initGUI(){
		
		mTvTerminal = (TextView) findViewById(R.id.tv_terminal);
		mEtInput 	= (EditText) findViewById(R.id.et_input);
		mBtSend 	= (Button)   findViewById(R.id.bt_send);
		
		mBtSend.setOnClickListener(handleSend);
	
		
	}

	private OnClickListener handleSend = new OnClickListener(){
	
		@Override
		public void onClick(View arg0) {
			 // TODO: Handle Send Button
			
		}
		
	};
	
	

	public Handler handleBluetoothMessage = new Handler(){
		
		@Override
		public void handleMessage(Message msg){
			
			// This is the place where the main activity thread receives messages
			// Other threads will send messages to main here, pls handle
			super.handleMessage(msg);
			
			mTvTerminal.append("Bluetooth Message: " + msg.toString() + "\n");
	
			
		}
		
		
		
	};

	public class BluetoothRunner implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			while(!Thread.currentThread().isInterrupted()){
				
				Message msg = Message.obtain(); // Message pool
				msg.what = 999; // custom ID
		
				Bundle b = new Bundle();
				b.putString("Broadcast", "alive!");
				msg.setData(b);
			 	
				BTTMainActivity.this.handleBluetoothMessage.sendMessage(msg);
				
				try {
					
					Thread.sleep(1000);					
					
				} catch (Exception e){
					
					
				}
			
			
		}
    	
    	
    }
}}
