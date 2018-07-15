package com.githubyss.mobile.experiment.app.kittest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.githubyss.mobile.common.kit.ComkitApplication
import com.githubyss.mobile.common.kit.logcat.ComkitLogcatUtils
import com.githubyss.mobile.common.kit.manager.contacts.ComkitContactsFetchManager
import com.githubyss.mobile.common.kit.manager.contacts.ComkitContactsModel
import com.githubyss.mobile.experiment.app.R
import com.githubyss.mobile.experiment.app.base.ExpBaseFragment
import kotlinx.android.synthetic.main.exp_fragment_contacts_fetch.*

/**
 * ExpContactsFetchFragment
 * <Description>
 * <Details>
 *
 * @author Ace Yan
 * @github githubyss
 */
class ExpContactsFetchFragment : ExpBaseFragment() {
    companion object {
        val TAG = ExpContactsFetchFragment::class.java.simpleName
    }


    private var rootView: View? = null

    private val onClickListener = View.OnClickListener { v ->
        when (v.id) {
            R.id.btnStartContactsFetch -> {
                ComkitContactsFetchManager.instance.startFetch(
                        ComkitApplication.instance.application,
                        object : ComkitContactsFetchManager.OnContactsFetchListener {
                            override fun onContactsFetched(list: List<ComkitContactsModel>) {
                                ComkitLogcatUtils.d(msg = list.toString())
                            }
                        })
            }

            R.id.btnStopContactsFetch -> {
                ComkitContactsFetchManager.instance.stopFetch()
            }
        }
    }


    override fun initView() {
        btnStartContactsFetch.setOnClickListener(onClickListener)
        btnStopContactsFetch.setOnClickListener(onClickListener)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater?.inflate(R.layout.exp_fragment_contacts_fetch, container, false)
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
}
