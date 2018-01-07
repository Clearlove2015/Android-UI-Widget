package com.aron.recyclerview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by ZC on 2017/11/15.
 * http://www.cnblogs.com/yuezhusust/p/6568241.html
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    int mSpace;

    /**
     * @param outRect Rect to receive the output.
     * @param view    The child view to decorate
     * @param parent  RecyclerView this ItemDecoration is decorating
     * @param state   The current state of RecyclerView.
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = mSpace;
        outRect.right = mSpace;
        outRect.bottom = mSpace;
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = mSpace;
        }

    }

    public SpaceItemDecoration(int space) {
        this.mSpace = space;
    }

}
