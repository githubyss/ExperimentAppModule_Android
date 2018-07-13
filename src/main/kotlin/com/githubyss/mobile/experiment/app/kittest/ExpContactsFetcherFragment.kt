package com.githubyss.mobile.experiment.app.kittest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.githubyss.mobile.common.kit.fetcher.contacts.ComkitContactsFetcher
import com.githubyss.mobile.common.kit.fetcher.contacts.ComkitContactsModel
import com.githubyss.mobile.common.kit.logcat.ComkitLogcatUtils
import com.githubyss.mobile.experiment.app.R
import com.githubyss.mobile.experiment.app.base.ExpBaseFragment
import kotlinx.android.synthetic.main.exp_fragment_contacts_fetcher.*

/**
 * ExpContactsFetcherFragment
 * <Description>
 * <Details>
 *
 * @author Ace Yan
 * @github githubyss
 */
class ExpContactsFetcherFragment : ExpBaseFragment() {
    companion object {
        val TAG = ExpContactsFetcherFragment::class.java.simpleName
    }


    private var rootView: View? = null

    private val onClickListener = View.OnClickListener { v ->
        when (v.id) {
            R.id.btnStartContactsFetch -> {
                ComkitContactsFetcher.instance.startFetch(
                        activity,
                        object : ComkitContactsFetcher.OnContactsFetchListener {
                            override fun onFetchComplete(list: List<ComkitContactsModel>) {
                                ComkitLogcatUtils.d(msg = list.toString())
                            }
                        })
            }

            R.id.btnStopContactsFetch -> {
                ComkitContactsFetcher.instance.stopFetch()
            }
        }
    }


    override fun initView() {
        btnStartContactsFetch.setOnClickListener(onClickListener)
        btnStopContactsFetch.setOnClickListener(onClickListener)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater?.inflate(R.layout.exp_fragment_contacts_fetcher, container, false)
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
}
