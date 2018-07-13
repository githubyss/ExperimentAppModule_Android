package com.githubyss.mobile.experiment.app.function

import android.view.View
import com.githubyss.mobile.common.kit.logcat.ComkitLogcatUtils

/**
 * ExpLogcatFunctions
 * <Description>
 * <Details>
 *
 * @author Ace Yan
 * @github githubyss
 */
object ExpLogcatFunctions {
    fun logcatViewProperty(view: View) {
        ComkitLogcatUtils.d(msg = "{x:${view.x.toInt()}, y:${view.y.toInt()}} {translationX:${view.translationX.toInt()}, translationY:${view.translationY.toInt()}} {top:${view.top}, bottom:${view.bottom}, left:${view.left}, right:${view.right}} {width:${view.width}, height:${view.height}}")
    }
}
