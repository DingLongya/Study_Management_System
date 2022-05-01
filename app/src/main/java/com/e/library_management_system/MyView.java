package com.e.library_management_system;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class MyView extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener {
    private Paint p = new Paint();
    private Path path = new Path();

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
        p.setColor(Color.RED);
        p.setTextSize(10);
        p.setStyle(Paint.Style.STROKE);
        p.setAntiAlias(true);
        setOnTouchListener(this);
    }
    public void draw() {
        Canvas canvas = getHolder().lockCanvas();
        //绘制
        canvas.drawColor(Color.WHITE);
        canvas.drawPath(path, p);
        getHolder().unlockCanvasAndPost(canvas);
    }
    public void clear() {
        path.reset();
        draw();
    }
    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        draw();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(motionEvent.getX(), motionEvent.getY());
                draw();
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(motionEvent.getX(), motionEvent.getY());
                draw();
                break;
        }
        return true;
    }
}
