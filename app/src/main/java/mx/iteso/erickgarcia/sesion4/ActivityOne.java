package mx.iteso.erickgarcia.sesion4;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by erickgarcia on 07/02/18.
 */

public class ActivityOne extends Activity {
    Button button;
    Button btnTwo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uno);

        btnTwo = (Button) findViewById(R.id.btnTwo);
        button = (Button) findViewById(R.id.btnOne);

        // explicit intent
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityOne.this, ActivityTwo.class);
                intent.putExtra("values", "Peluche en el estuche >:v");
                startActivity(intent);
            }
        });


        // implicit intent
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent llamar = new Intent(Intent.ACTION_CALL);
                llamar.setData(Uri.parse("tel: 36934972"));
                if (ActivityCompat.checkSelfPermission(ActivityOne.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Agregar los permisos para la llamada
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(llamar);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(ActivityOne.this, "starteando", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(ActivityOne.this, "resumeando", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(ActivityOne.this, "restarteando", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(ActivityOne.this, "pauseando", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(ActivityOne.this, "stopeando", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(ActivityOne.this, "destroyeando", Toast.LENGTH_SHORT).show();
    }
}
