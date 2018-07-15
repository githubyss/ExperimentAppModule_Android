package com.githubyss.mobile.experiment.app.kittest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.githubyss.mobile.common.kit.ComkitApplication
import com.githubyss.mobile.common.kit.manager.screenshot.ComkitScreenshotDetectManager
import com.githubyss.mobile.common.ui.floatingwindow.ComuiAutoHideFloatingWindow
import com.githubyss.mobile.experiment.app.R
import com.githubyss.mobile.experiment.app.base.ExpBaseFragment
import kotlinx.android.synthetic.main.exp_fragment_screenshot_detect.*

/**
 * ExpScreenshotDetectFragment
 * <Description>
 * <Details>
 *
 * @author Ace Yan
 * @github githubyss
 */
class ExpScreenshotDetectFragment : ExpBaseFragment() {
    companion object {
        val TAG = ExpScreenshotDetectFragment::class.java.simpleName
    }


    private var rootView: View? = null

    private val onClickListener = View.OnClickListener { v ->
        when (v.id) {
            R.id.btnStartScreenshotDetect -> {
                ComkitScreenshotDetectManager.instance.startDetect(
                        ComkitApplication.instance.application,
                        object : ComkitScreenshotDetectManager.OnScreenshotDetectListener {
                            override fun onScreenshotDetected(path: String) {
                                ComuiAutoHideFloatingWindow.instance.show(ComkitApplication.instance.application).setImage(path)
                            }
                        })
            }

            R.id.btnStopScreenshotDetect -> {
                ComkitScreenshotDetectManager.instance.stopDetect(ComkitApplication.instance.application)
            }
        }
    }


    override fun initView() {
        btnStartScreenshotDetect.setOnClickListener(onClickListener)
        btnStopScreenshotDetect.setOnClickListener(onClickListener)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater?.inflate(R.layout.exp_fragment_screenshot_detect, container, false)
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
}
