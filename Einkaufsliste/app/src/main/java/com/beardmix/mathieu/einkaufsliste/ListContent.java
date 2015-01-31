package com.beardmix.mathieu.einkaufsliste;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * Created by Mathieu on 31/01/2015.
 */
public class ListContent extends ArrayAdapter<String>
{
    private Integer m_counterElements_ui = 0;

    public ListContent(Context context, int resource)
    {
        super(context, resource);
    }

    public void addElementToListEnd(String f_title)
    {
        m_counterElements_ui++;
        this.add("" + m_counterElements_ui + ": " + f_title);
    }

    public void removeElementFromList(Integer index)
    {
        this.remove(this.getItem(index));
    }

    public void createListContent(Integer f_length_ui)
    {
        for (Integer i = 0; i < f_length_ui; i++)
        {
            addElementToListEnd("Element");
        }
    }

}
