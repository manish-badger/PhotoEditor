package ja.burhanrashid52.photoeditor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes
import ja.burhanrashid52.photoeditor.MultiTouchListener.OnGestureControl

/**
 * Created by Burhanuddin Rashid on 14/05/21.
 *
 * @author <https:></https:>//github.com/burhanrashid52>
 */
// The name "GraphicalBase": Originally termed as "Graphic" by the lib developers, Graphic
// is supposed to be a representation of graphical data, such as, Bitmap but the responsibilities
// are not true to the concept of a "graphic".
// It is due to this reason, we have changed the name to such. Now, it is a View based
// graphical container
abstract class GraphicalBase(
    protected val context: Context,
    val tag: String,
    val viewType: ViewType) {

    lateinit var rootView: View
    protected set
}