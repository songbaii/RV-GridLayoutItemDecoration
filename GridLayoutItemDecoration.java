package com.example.itemdec;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.view.View;

public class GridLayoutItemDecoration extends ItemDecoration {

    private int spanCount;
    private int spacing;
    private boolean includeEdge;

    public GridLayoutItemDecoration(int spanCount, int spacing, boolean includeEdge) {
        this.spanCount = spanCount;
        this.spacing = spacing;
        this.includeEdge = includeEdge;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int pos = parent.getChildAdapterPosition(view);
        int col = pos % spanCount;

        if (includeEdge) {
            outRect.left = spacing - col * spacing / spanCount;
            outRect.right = (col + 1) * spacing / spanCount;
            if (pos < spanCount) {
                outRect.top = spacing;
            }
            outRect.bottom = spacing;
        } else {
            outRect.left = col * spacing / spanCount;
            outRect.right = spacing - (col + 1) * spacing / spanCount;
            if (pos >= spanCount) {
                outRect.top = spacing;
            }
        }
    }
}
