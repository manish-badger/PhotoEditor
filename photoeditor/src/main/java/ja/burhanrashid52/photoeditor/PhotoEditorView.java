package ja.burhanrashid52.photoeditor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;


/**
 * Created by Burhanuddin Rashid on 1/18/2018.
 */

public class PhotoEditorView extends RelativeLayout {

    private ImageView mImgSource;
    private BrushDrawingView mBrushDrawingView;
    private GLSurfaceView mGLFilterView;
    private static final int imgSrcId = 1, brushSrcId = 2, glFilterId = 3;

    public PhotoEditorView(Context context) {
        super(context);
        init(null);
    }

    public PhotoEditorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public PhotoEditorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PhotoEditorView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    @SuppressLint("Recycle")
    private void init(@Nullable AttributeSet attrs) {
        //Setup image attributes
        mImgSource = new ImageView(getContext());
        mImgSource.setId(imgSrcId);
        mImgSource.setAdjustViewBounds(true);
        RelativeLayout.LayoutParams imgSrcParam = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        imgSrcParam.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.PhotoEditorView);
            Drawable imgSrcDrawable = a.getDrawable(R.styleable.PhotoEditorView_photo_src);
            if (imgSrcDrawable != null) {
                mImgSource.setImageDrawable(imgSrcDrawable);
            }
        }

        //Setup brush view
        mBrushDrawingView = new BrushDrawingView(getContext());
        mBrushDrawingView.setVisibility(GONE);
        mBrushDrawingView.setId(brushSrcId);
        //Align brush to the size of image view
        RelativeLayout.LayoutParams brushParam = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        brushParam.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        brushParam.addRule(RelativeLayout.ALIGN_TOP, imgSrcId);
        brushParam.addRule(RelativeLayout.ALIGN_BOTTOM, imgSrcId);

        //Setup GLSurface attributes
        mGLFilterView = new GLSurfaceView(getContext());
        mGLFilterView.setId(glFilterId);
        mGLFilterView.setVisibility(GONE);
        //Align brush to the size of image view
        RelativeLayout.LayoutParams imgFilterParam = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        imgFilterParam.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        imgFilterParam.addRule(RelativeLayout.ALIGN_TOP, imgSrcId);
        imgFilterParam.addRule(RelativeLayout.ALIGN_BOTTOM, imgSrcId);


        //Add image source
        addView(mImgSource, imgSrcParam);

        //Add Gl FilterView
        addView(mGLFilterView, imgFilterParam);

        //Add brush view
        addView(mBrushDrawingView, brushParam);

    }


    /**
     * Source image which you want to edit
     *
     * @return source ImageView
     */
    public ImageView getSource() {
        return mImgSource;
    }

    GLSurfaceView getGLFilterView() {
        return mGLFilterView;
    }

    BrushDrawingView getBrushDrawingView() {
        return mBrushDrawingView;
    }
}
