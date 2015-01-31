
package com.beardmix.mathieu.einkaufsliste;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by Mathieu on 25/01/2015.
 */
public class ScannerActivity extends Activity
{

    public static final String m_RETURN_VALUE = "RETURN_VALUE_SCANNER";
    public static final String m_INPUT_VALUE = "INPUT_VALUE_SCANNER";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scanner_activity);

        String l_arg = getIntent().getStringExtra(m_INPUT_VALUE);
        System.out.println(l_arg);

        final EditText l_priceField = (EditText) findViewById(R.id.price_field);

        Button l_validButton = (Button) findViewById(R.id.validate_button);
        l_validButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(m_RETURN_VALUE, Float.parseFloat(l_priceField.getText().toString()));
                setResult(Activity.RESULT_OK, resultIntent);
                ScannerActivity.this.finish();
            }
        });

    }
}
