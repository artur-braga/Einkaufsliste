
package com.beardmix.mathieu.einkaufsliste;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * Created by Mathieu on 25/01/2015.
 */
public class ScannerActivity extends Activity
{

    float m_price = 3.99f;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scanner_activity);

        String l_arg = getIntent().getStringExtra("Args");
        System.out.println(l_arg);
        Button l_validButton = (Button) findViewById(R.id.validate_button);
        l_validButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getIntent().putExtra("Return","Salut Main!!");
                ScannerActivity.this.finish();
            }
        });
    }
}
