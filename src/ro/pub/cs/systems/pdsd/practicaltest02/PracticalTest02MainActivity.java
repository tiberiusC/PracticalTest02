package ro.pub.cs.systems.pdsd.practicaltest02;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.widget.Button;
import android.widget.EditText;


public class PracticalTest02MainActivity extends Activity {

	EditText portServer, porttClient, adressaToServer, word, Tv;
	Button btnStart, btnConnect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test02_main);
        portServer = (EditText)findViewById(R.id.server_port_edit_text);
        porttClient = (EditText) findViewById(R.id.idPortClient);
        adressaToServer = (EditText) findViewById(R.id.idAdresa);
        word = (EditText) findViewById(R.id.idCuvant);
        btnStart = (Button) findViewById(R.id.connect_button);
        btnConnect = (Button) findViewById(R.id.idConnectClient);
        Tv  = (EditText) findViewById(R.id.idText_view);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test02_main, menu);
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
