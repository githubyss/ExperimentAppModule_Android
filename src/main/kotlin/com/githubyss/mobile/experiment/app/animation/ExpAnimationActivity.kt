package com.githubyss.mobile.experiment.app.animation

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.githubyss.mobile.experiment.app.R
import com.githubyss.mobile.experiment.app.base.ExpBaseActivity

/**
 * ExpAnimationActivity
 * <Description>
 * <Details>
 *
 * @author Ace Yan
 * @github githubyss
 */
@Route(path = "/experiment/app/animation/ExpAnimationActivity")
class ExpAnimationActivity : ExpBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragment(ExpAnimationFragment(), ExpAnimationFragment.TAG, false)
    }

    override fun onResume() {
        super.onResume()
        setToolbarTitle(R.string.expAnimationTitle)
    }
}