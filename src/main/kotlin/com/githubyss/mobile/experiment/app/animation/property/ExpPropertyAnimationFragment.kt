package com.githubyss.mobile.experiment.app.animation.property

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.githubyss.mobile.common.kit.ComkitApplication
import com.githubyss.mobile.common.ui.animator.evaluator.coordinate.ComuiCoordinate
import com.githubyss.mobile.common.ui.animator.evaluator.coordinate.ComuiCoordinateEvaluator
import com.githubyss.mobile.common.ui.floatingwindow.ComuiAutoHideFloatingWindow
import com.githubyss.mobile.experiment.app.R
import com.githubyss.mobile.experiment.app.base.ExpBaseFragment
import com.githubyss.mobile.experiment.app.function.ExpLogcatFunctions
import kotlinx.android.synthetic.main.exp_fragment_property_animation.*

/**
 * ExpPropertyAnimationFragment.ktnt.kt.kt
 * <Description>
 * <Details>
 *
 * @author Ace Yan
 * @github githubyss
 */
@Route(path = "/experiment/app/animation/ExpPropertyAnimationFragment")
class ExpPropertyAnimationFragment : ExpBaseFragment() {
    companion object {
        val TAG = ExpPropertyAnimationFragment::class.java.simpleName
    }

    private var rootView: View? = null
    private var moveValueAnimator: ValueAnimator? = null
    private var scaleValueAnimator: ValueAnimator? = null
    private var moveObjectAnimator: ObjectAnimator? = null
    private var scaleObjectAnimator: ObjectAnimator? = null

    private val onClickListener = View.OnClickListener { v ->
        when (v.id) {
            R.id.btnMove -> {
                startMoveObjectAnimator(btnAnimator)
            }

            R.id.btnScale -> {
                startScaleObjectAnimator(btnAnimator)
            }

            R.id.btnShow -> {
                ComuiAutoHideFloatingWindow.instance.show(ComkitApplication.instance.application)
            }

            R.id.btnHide -> {
                ComuiAutoHideFloatingWindow.instance.hide()
            }
        }
    }

    private fun startMoveValueAnimator(view: View) {
        val originX = view.x
        val originY = view.y
        val originCoordinate = ComuiCoordinate(originX, originY)
        val targetedCoordinate = ComuiCoordinate(originX, originY + 500)
        moveValueAnimator = ValueAnimator.ofObject(ComuiCoordinateEvaluator(), originCoordinate, targetedCoordinate)
        moveValueAnimator?.duration = 1000
        moveValueAnimator?.startDelay = 0
        moveValueAnimator?.repeatCount = 1
        moveValueAnimator?.repeatMode = ValueAnimator.REVERSE
        moveValueAnimator?.addUpdateListener { animation ->
            val currentValue = animation.animatedValue as ComuiCoordinate
            view.y = currentValue.y
            view.requestLayout()

            ExpLogcatFunctions.logcatViewProperty(view)
        }
        moveValueAnimator?.start()
    }

    private fun startScaleValueAnimator(view: View) {
        val originalWidth = view.layoutParams.width
        val targetedWidth = originalWidth * 2
        scaleValueAnimator = ValueAnimator.ofInt(originalWidth, targetedWidth)
        scaleValueAnimator?.startDelay = 0
        scaleValueAnimator?.duration = 1000
        scaleValueAnimator?.repeatCount = 1
        scaleValueAnimator?.repeatMode = ValueAnimator.REVERSE
        scaleValueAnimator?.addUpdateListener { animation ->
            val currentValue = animation.animatedValue as Int
            view.layoutParams.width = currentValue
            view.requestLayout()

            ExpLogcatFunctions.logcatViewProperty(view)
        }
        scaleValueAnimator?.start()
    }

    private fun startMoveObjectAnimator(view: View) {
        moveObjectAnimator = ObjectAnimator.ofFloat(view, "translationX", 0F, 300F, 0F)
//        moveObjectAnimator = ObjectAnimator.ofFloat(view, "x", 0F, 300F)
        moveObjectAnimator?.startDelay = 0
        moveObjectAnimator?.duration = 1000
        moveObjectAnimator?.repeatCount = ObjectAnimator.INFINITE
        moveObjectAnimator?.repeatMode = ObjectAnimator.REVERSE
        moveObjectAnimator?.start()
    }

    private fun startScaleObjectAnimator(view: View) {
        val originalWidth = view.layoutParams.width
        val targetedWidth = originalWidth * 2
        scaleObjectAnimator = ObjectAnimator.ofFloat(view, "rotation", 0F, 360F)
        scaleObjectAnimator?.startDelay = 0
        scaleObjectAnimator?.duration = 1000
        scaleObjectAnimator?.repeatCount = ObjectAnimator.INFINITE
        scaleObjectAnimator?.repeatMode = ObjectAnimator.REVERSE
        scaleObjectAnimator?.start()
    }

    private fun stopAnimator() {
        moveValueAnimator?.cancel()
        scaleValueAnimator?.cancel()
        moveObjectAnimator?.cancel()
        scaleObjectAnimator?.cancel()
    }

    override fun initView() {
        btnMove.setOnClickListener(onClickListener)
        btnScale.setOnClickListener(onClickListener)
        btnShow.setOnClickListener(onClickListener)
        btnHide.setOnClickListener(onClickListener)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater?.inflate(R.layout.exp_fragment_property_animation, container, false)
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopAnimator()
        ComuiAutoHideFloatingWindow.instance.hide()
    }
}
