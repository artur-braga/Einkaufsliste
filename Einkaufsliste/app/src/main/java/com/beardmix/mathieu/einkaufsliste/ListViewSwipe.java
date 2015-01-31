package com.beardmix.mathieu.einkaufsliste;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

import com.beardmix.mathieu.einkaufsliste.ListContent;
import com.beardmix.mathieu.einkaufsliste.SwipeDismissListViewTouchListener;

/**
 * Created by Mathieu on 31/01/2015.
 */
public class ListViewSwipe extends ListView
{
    public ListViewSwipe(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public void create(final ListContent f_content)
    {
        this.setAdapter(f_content); // ListView Item Click Listener
        // Create a ListView-specific touch listener. ListViews are given special treatment because
        // by default they handle touches for their list items... i.e. they're in charge of drawing
        // the pressed state (the list selector), handling list item clicks, etc.
        SwipeDismissListViewTouchListener touchListener =
                new SwipeDismissListViewTouchListener(
                        this,
                        new SwipeDismissListViewTouchListener.DismissCallbacks()
                        {
                            @Override
                            public boolean canDismiss(int position)
                            {
                                return true;
                            }

                            @Override
                            public void onDismiss(ListView listView, int[] reverseSortedPositions)
                            {
                                for (int position : reverseSortedPositions)
                                {
                                    f_content.removeElementFromList(position);
                                }
                                //m_listContent_as.notifyDataSetChanged();
                                f_content.notifyDataSetChanged();
                            }
                        });
        this.setOnTouchListener(touchListener);
        // Setting this scroll listener is required to ensure that during ListView scrolling,
        // we don't look for swipes.
        this.setOnScrollListener(touchListener.makeScrollListener());
    }
}
