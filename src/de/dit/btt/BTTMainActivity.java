package de.dit.btt;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
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
	
	// GITHUB TEST
	
	private BroadcastReceiver 	mBluetoothReceiver					= null;
    private BluetoothAdapter 	mBluetoothAdapter					= null; 
    
    // Intent request codes
    private static final int 	REQUEST_CONNECT_DEVICE_SECURE 		= 1;
    private static final int 	REQUEST_CONNECT_DEVICE_INSECURE 	= 2;
    private static final int 	REQUEST_ENABLE_BT 					= 3;; 
    
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


	@Override
	protected void onStart() {
		super.onStart();

        Log.d("onStart", "++ ON START ++");

        // If BT is not on, request that it be enabled.
        // setupChat() will then be ca<lled during onActivityResult
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
        // Otherwise, setup the chat session
        } else {
            //setupChat();
        }
	
	
	}


	private void registerBroadcastReceiver() {
		 
        IntentFilter I_BLUETOOTH_CONNECTED = new IntentFilter(BluetoothDevice.ACTION_ACL_CONNECTED);
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
