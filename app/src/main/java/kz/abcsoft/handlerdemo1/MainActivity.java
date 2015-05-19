package kz.abcsoft.handlerdemo1;

import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;


public class MainActivity extends ActionBarActivity {

    final String LOG_TAG = "myLogs";

    Handler h ;
    TextView tvInfo ;
    Button btnStart ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView)findViewById(R.id.tvInfo) ;
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnStart:
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i = 1; i <= 10; i++){
                            downloadFile() ;
                            tvInfo.setText("Закачано файлов: " + i) ;
                            Log.d(LOG_TAG, "Закачано файлов: " + i) ;
                        }
                    }
                });
                break ;
            case R.id.btnTest:
                Log.d(LOG_TAG, "test");
                break ;
        }
    }

    void downloadFile(){
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
