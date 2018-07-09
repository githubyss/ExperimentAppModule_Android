package com.githubyss.mobile.experiment.app.animation

import android.app.Fragment
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.githubyss.mobile.experiment.app.R
import com.githubyss.mobile.experiment.app.base.ExpBaseActivity

/**
 * ExpAnimationActivity.kt
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

        val fragment = ARouter.getInstance().build("/experiment/app/animation/ExpAnimationFragment").navigation() as Fragment
        addFragment(fragment, "ExpAnimationFragment", false)
    }

    override fun onResume() {
        super.onResume()

        setToolbarTitle(R.string.expAnimationTitle)
    }
}
