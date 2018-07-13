package com.githubyss.mobile.experiment.app.homepage

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.githubyss.mobile.experiment.app.R
import com.githubyss.mobile.experiment.app.base.ExpBaseActivity

/**
 * ExpHomepageActivity
 * <Description>
 * <Details>
 *
 * @author Ace Yan
 * @github githubyss
 */
@Route(path = "/experiment/app/homepage/ExpHomepageActivity")
class ExpHomepageActivity : ExpBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragment(ExpHomepageFragment(), ExpHomepageFragment.TAG, false)
    }

    override fun onResume() {
        super.onResume()
        setToolbarTitle(R.string.expAnimationTitle)
    }
}
