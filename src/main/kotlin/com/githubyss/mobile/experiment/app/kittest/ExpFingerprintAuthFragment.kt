package com.githubyss.mobile.experiment.app.kittest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.githubyss.mobile.common.kit.ComkitApplication
import com.githubyss.mobile.common.kit.manager.fingerprint.ComkitFingerprintAuthManager
import com.githubyss.mobile.experiment.app.R
import com.githubyss.mobile.experiment.app.base.ExpBaseFragment
import kotlinx.android.synthetic.main.exp_fragment_fingerprint_auth.*

/**
 * ExpFingerprintAuthFragment
 * <Description>
 * <Details>
 *
 * @author Ace Yan
 * @github githubyss
 */
class ExpFingerprintAuthFragment : ExpBaseFragment() {
    companion object {
        val TAG = ExpContactsFetchFragment::class.java.simpleName
    }

    private var rootView: View? = null

    private val onClickListener = View.OnClickListener { v ->
        when (v.id) {
            R.id.btnStartFingerprintAuth -> {
                ComkitFingerprintAuthManager.instance.startAuth(
                        ComkitApplication.instance.application,
                        object : ComkitFingerprintAuthManager.OnFingerprintAuthListener {
                            override fun onFingerprintAuth(result: ComkitFingerprintAuthManager.FingerprintAuthResult, info: String) {
                                tvFingerprintAuthInfo.text = info
                            }
                        })
                tvFingerprintAuthInfo.text = "Please auth your fingerprint."
            }

            R.id.btnStopFingerprintAuth -> {
                ComkitFingerprintAuthManager.instance.cancelAuthExternally()
            }
        }
    }


    override fun initView() {
        btnStartFingerprintAuth.setOnClickListener(onClickListener)
        btnStopFingerprintAuth.setOnClickListener(onClickListener)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater?.inflate(R.layout.exp_fragment_fingerprint_auth, container, false)
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onStop() {
        super.onStop()
        ComkitFingerprintAuthManager.instance.release()
    }

    override fun onDestroy() {
        super.onDestroy()
        ComkitFingerprintAuthManager.instance.release()
    }
}
