package com.githubyss.mobile.experiment.app.animation

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.githubyss.mobile.common.kit.logcat.ComkitLogcatUtils
import com.githubyss.mobile.experiment.app.R
import com.githubyss.mobile.experiment.app.animation.evaluator.coordinate.Coordinate
import com.githubyss.mobile.experiment.app.animation.evaluator.coordinate.CoordinateEvaluator
import com.githubyss.mobile.experiment.app.base.ExpBaseContract
import com.githubyss.mobile.experiment.app.base.ExpBaseFragment
import kotlinx.android.synthetic.main.exp_fragment_animation.*

/**
 * ExpAnimationFragment.kt
 * <Description>
 * <Details>
 *
 * @author Ace Yan
 * @github githubyss
 */
@Route(path = "/experiment/app/animation/ExpAnimationFragment")
class ExpAnimationFragment : ExpBaseFragment(), ExpAnimationContract.IView {
    private var rootView: View? = null

    private val onClickListener = View.OnClickListener { v ->
        when (v.id) {
            R.id.btnMove -> {
                val originX = btnMove.x
                val originY = btnMove.y
                val originCoordinate = Coordinate(originX, originY)
                val targetedCoordinate = Coordinate(originX, originY + 500)
                val animator = ValueAnimator.ofObject(CoordinateEvaluator(), originCoordinate, targetedCoordinate)
                animator.duration = 1000
                animator.startDelay = 0
                animator.repeatCount = 1
                animator.repeatMode = ValueAnimator.REVERSE
                animator.addUpdateListener { animation ->
                    val currentValue = animation.animatedValue as Coordinate
                    btnMove.y = currentValue.y
                    btnMove.requestLayout()

                    logXY(btnMove)
                }
                animator.start()
            }

            R.id.btnScale -> {
                val originalWidth = btnScale.layoutParams.width
                val targetedWidth = originalWidth * 2
                val animator = ValueAnimator.ofInt(originalWidth, targetedWidth)
                animator.duration = 1000
                animator.startDelay = 0
                animator.repeatCount = 1
                animator.repeatMode = ValueAnimator.REVERSE
                animator.addUpdateListener { animation ->
                    val currentValue = animation.animatedValue as Int
                    btnScale.layoutParams.width = currentValue
                    btnScale.requestLayout()

                    logXY(btnScale)
                }
                animator.start()
            }
        }
    }

    private fun logXY(view: View) {
        ComkitLogcatUtils.d(msg = "{x:${view.x.toInt()}, y:${view.y.toInt()}} {translationX:${view.translationX.toInt()}, translationY:${view.translationY.toInt()}} {top:${view.top}, bottom:${view.bottom}, left:${view.left}, right:${view.right}} {width:${view.width}, height:${view.height}}")
    }


    override fun initView() {
        btnMove.setOnClickListener(onClickListener)
        btnScale.setOnClickListener(onClickListener)
    }


    override fun setPresenter(iPresenter: ExpBaseContract.IPresenter) {
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater?.inflate(R.layout.exp_fragment_animation, container, false)
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
}
