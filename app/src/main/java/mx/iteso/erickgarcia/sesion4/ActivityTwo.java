package mx.iteso.erickgarcia.sesion4;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by erickgarcia on 07/02/18.
 */

public class ActivityTwo extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos);

        Bundle extra = getIntent().getExtras();
        if (extra != null){
            String dato = extra.getString("values");

            Toast.makeText(ActivityTwo.this, dato, Toast.LENGTH_SHORT).show();
        }
    }
}
