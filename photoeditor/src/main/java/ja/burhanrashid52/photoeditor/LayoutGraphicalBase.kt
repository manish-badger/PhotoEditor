package ja.burhanrashid52.photoeditor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes

/**
 * Created by Burhanuddin Rashid on 14/05/21.
 *
 * @author <https:></https:>//github.com/burhanrashid52>
 */
// The name "GraphicalBase": Originally termed as "Graphic" by the lib developers, Graphic
// is supposed to be a representation of graphical data, such as, Bitmap but the responsibilities
// are not true to the concept of a "graphic".
// It is due to this reason, we have changed the name to such.
abstract class LayoutGraphicalBase(
    context: Context,
    tag: String,
    /**
     * The layout id of the content to be placed on top of the source image. This would
     * typically be a sticker, text, emoji, etc
     */
    @LayoutRes
    protected val layoutId: Int,
    viewType: ViewType
): GraphicalBase(
    context,
    tag,
    viewType) {

    init {
        if (layoutId == 0) {
            throw UnsupportedOperationException("Layout id cannot be zero. Please define a layout")
        }
        rootView = LayoutInflater.from(context).inflate(layoutId, null)
        setup(rootView)
    }


    private fun setup(rootView: View) {
        //We are setting tag as ViewType to identify what type of the view it is
        //when we remove the view from stack i.e onRemoveViewListener(ViewType viewType, int numberOfAddedViews);
        rootView.tag = viewType
    }
}