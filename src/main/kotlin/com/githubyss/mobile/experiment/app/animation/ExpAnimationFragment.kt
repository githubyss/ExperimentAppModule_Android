package com.githubyss.mobile.experiment.app.animation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.githubyss.mobile.experiment.app.R
import com.githubyss.mobile.experiment.app.animation.property.ExpPropertyAnimationFragment
import com.githubyss.mobile.experiment.app.base.ExpBaseFragment
import kotlinx.android.synthetic.main.exp_fragment_animation.*

/**
 * ExpPropertyAnimFragmentent.kt
 * <Description>
 * <Details>
 *
 * @author Ace Yan
 * @github githubyss
 */
@Route(path = "/experiment/app/animation/ExpPropertyAnimationFragment")
class ExpAnimationFragment : ExpBaseFragment() {
    companion object {
        val TAG = ExpAnimationFragment::class.java.simpleName
    }

    private var rootView: View? = null

    private val onClickListener = View.OnClickListener { v ->
        when (v.id) {
            R.id.btnProperty -> {
                replaceFragment(ExpPropertyAnimationFragment(), ExpPropertyAnimationFragment.TAG, true)
            }

            R.id.btnTween -> {
            }
        }
    }


    override fun initView() {
        btnProperty.setOnClickListener(onClickListener)
        btnTween.setOnClickListener(onClickListener)
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