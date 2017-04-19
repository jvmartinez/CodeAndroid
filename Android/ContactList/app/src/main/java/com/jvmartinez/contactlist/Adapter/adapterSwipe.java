package com.jvmartinez.contactlist.Adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.jvmartinez.contactlist.R;

/**
 * Created by Juan Martinez on 18/04/17.
 */

public class adapterSwipe extends ItemTouchHelper.SimpleCallback{
    private Paint paint;

    public adapterSwipe(int dragDirs, int swipeDirs) {
        super(dragDirs, swipeDirs);
        this.paint = new Paint();
    }


    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        Bitmap icon;

            float width = 40f;
            if(dX > ItemTouchHelper.LEFT){
                paint.setColor(viewHolder.itemView.getResources().getColor(R.color.colorRigth));
                RectF background = new RectF((float) viewHolder.itemView.getLeft(), (float) viewHolder.itemView.getTop(), dX,(float) viewHolder.itemView.getBottom());
                c.drawRect(background, paint);
                icon = BitmapFactory.decodeResource(viewHolder.itemView.getResources(), R.drawable.ic_call);
                RectF icon_dest = new RectF((float) viewHolder.itemView.getLeft() + width ,(float) viewHolder.itemView.getTop() + width,(float) viewHolder.itemView.getLeft()+ 2*width,(float)viewHolder.itemView.getBottom() - width);
                c.drawBitmap(icon,null,icon_dest, paint);
                super.onChildDraw(c, recyclerView, viewHolder, (dX - 20), dY, actionState, true);
            } else {
                super.onChildDraw(c, recyclerView, viewHolder, 0, dY, actionState, isCurrentlyActive);
            }
    }
}
