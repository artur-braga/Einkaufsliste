
package com.beardmix.mathieu.einkaufsliste;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by Mathieu on 25/01/2015.
 */
public class ScannerActivity extends Activity
{

    public static final String m_RETURN_VALUE = "RETURN_VALUE_SCANNER";
    public static final String m_INPUT_VALUE = "INPUT_VALUE_SCANNER";
    private float m_price = 3.99f;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scanner_activity);

        String l_arg = getIntent().getStringExtra(m_INPUT_VALUE);
        System.out.println(l_arg);
        Button l_validButton = (Button) findViewById(R.id.validate_button);
        l_validButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(m_RETURN_VALUE, m_price);
                setResult(Activity.RESULT_OK, resultIntent);
                ScannerActivity.this.finish();
            }
        });
    }
}
