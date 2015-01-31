package com.beardmix.mathieu.einkaufsliste;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Outline;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity
{
    private static final int m_SCANNER_ACTIVITY_CODE = 10;
    ListView m_listView;
    ListViewSwipe m_listViewSwipe;
    ImageButton m_addListElement_fab;
    ListContent m_listContent;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creates the content of the list
        m_listContent = new ListContent(this, android.R.layout.simple_list_item_1);
        m_listContent.createListContent(10);

        // Creates the list
        createViewList();

        // Creates the fab to add elements to list
        createFloatingActionButtonAdd();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // switch from which activity we get the result
        switch (requestCode)
        {
            // if the result comes from the scanner
            case (m_SCANNER_ACTIVITY_CODE):
            {
                // if the activity was successful
                if (resultCode == Activity.RESULT_OK)
                {
                    float l_price = data.getFloatExtra(ScannerActivity.m_RETURN_VALUE, 0.0f);
                    m_listContent.addElementToListEnd("Element " + l_price);
                    System.out.println("Returned value received: " + l_price);
                }
                else
                {
                    System.out.println("No value returned from scanner");
                }
                break;
            }
        }
    }

    private void createFloatingActionButtonAdd()
    {
        // get the button from the UI
        m_addListElement_fab = (ImageButton) findViewById(R.id.fab);

        // define look
        ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider()
        {
            @Override
            public void getOutline(View view, Outline outline)
            {
                // Or read size directly from the view's width/height
                int size = getResources().getDimensionPixelSize(R.dimen.fab_size);
                outline.setOval(0, 0, size, size);
            }
        };
        m_addListElement_fab.setOutlineProvider(viewOutlineProvider);

        // Perform action on click
        m_addListElement_fab.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent scanActIntent;
                scanActIntent = new Intent(m_listViewSwipe.getContext(), ScannerActivity.class);
                scanActIntent.putExtra(ScannerActivity.m_INPUT_VALUE, "Salut Scanner!");
                startActivityForResult(scanActIntent, m_SCANNER_ACTIVITY_CODE);
            }
        });
    }

    private void createViewList()
    {
        // Get ListView object from xml
        m_listViewSwipe = (ListViewSwipe) findViewById(R.id.list);
        m_listViewSwipe.create(m_listContent);
    }


}