package de.dit.btt;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class BTTMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bttmain);
        
        // 27.04.2013 RS: Egit installiert und Projekt lokal geclont
  jkjk j
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bttmain, menu);
        return true;
    }
    
}
