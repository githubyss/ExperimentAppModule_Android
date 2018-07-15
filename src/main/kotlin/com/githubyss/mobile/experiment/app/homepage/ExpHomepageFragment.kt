package com.githubyss.mobile.experiment.app.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.githubyss.mobile.experiment.app.R
import com.githubyss.mobile.experiment.app.animation.property.ExpPropertyAnimationFragment
import com.githubyss.mobile.experiment.app.base.ExpBaseFragment
import com.githubyss.mobile.experiment.app.kittest.ExpContactsFetchFragment
import com.githubyss.mobile.experiment.app.kittest.ExpScreenshotDetectFragment
import kotlinx.android.synthetic.main.exp_fragment_homepage.*

/**
 * ExpHomepageFragment
 * <Description>
 * <Details>
 *
 * @author Ace Yan
 * @github githubyss
 */
class ExpHomepageFragment : ExpBaseFragment() {
    companion object {
        val TAG = ExpHomepageFragment::class.java.simpleName
    }


    private var rootView: View? = null

    private val onClickListener = View.OnClickListener { v ->
        when (v.id) {
            R.id.btnPropertyAnimation -> {
                replaceFragment(ExpPropertyAnimationFragment(), ExpPropertyAnimationFragment.TAG, true)
            }

            R.id.btnTweenAnimation -> {
            }

            R.id.btnContactsFetch -> {
                replaceFragment(ExpContactsFetchFragment(), ExpContactsFetchFragment.TAG, true)
            }

            R.id.btnScreenshotDetect -> {
                replaceFragment(ExpScreenshotDetectFragment(), ExpScreenshotDetectFragment.TAG, true)
            }
        }
    }


    override fun initView() {
        btnPropertyAnimation.setOnClickListener(onClickListener)
        btnTweenAnimation.setOnClickListener(onClickListener)
        btnContactsFetch.setOnClickListener(onClickListener)
        btnScreenshotDetect.setOnClickListener(onClickListener)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater?.inflate(R.layout.exp_fragment_homepage, container, false)
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
}
