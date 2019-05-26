package com.githubyss.mobile.experiment.app.uitest

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.githubyss.mobile.common.kit.hint.ComkitToastUtils
import com.githubyss.mobile.common.ui.dialog.ComuiCommonDialog
import com.githubyss.mobile.common.ui.recyclerview.singleselection.ComuiSingleSelectionAdapter
import com.githubyss.mobile.common.ui.recyclerview.singleselection.ComuiSingleSelectionModel
import com.githubyss.mobile.experiment.app.R
import com.githubyss.mobile.experiment.app.base.ExpBaseFragment
import kotlinx.android.synthetic.main.exp_fragment_recycler_view.*

/**
 * ExpRecyclerViewFragment
 * <Description>
 * <Details>
 *
 * @author Ace Yan
 * @github githubyss
 */
class ExpRecyclerViewFragment : ExpBaseFragment() {
    companion object {
        val TAG = ExpRecyclerViewFragment::class.java.simpleName
    }


    private var rootView: View? = null
    private var dataList = ArrayList<ComuiSingleSelectionModel>()
    private var rvAdapter: ComuiSingleSelectionAdapter? = null


    private val onItemClickListener = object : ComuiSingleSelectionAdapter.OnItemClickListener {
        override fun onItemClick(view: View, position: Int) {
            ComkitToastUtils.showMessage(msgStr = "Row $position was selected")
            ComuiCommonDialog.showByMsg(
                    manager = fragmentManager,
                    titleStr = "Test title",
                    btnLeftStr = "Cancel", btnRightStr = "Confirm",
                    onBtnLeftClickListener = View.OnClickListener { ComkitToastUtils.showMessage(msgStr = "Cancel clicked.") },
                    onBtnRightClickListener = View.OnClickListener { ComkitToastUtils.showMessage(msgStr = "Confirm clicked.") }
            )
        }
    }


    override fun initData() {
        (0 until 20).forEach {
            val dataModel = ComuiSingleSelectionModel("Row $it", "content in row $it", false)
            dataList.add(dataModel)
        }

        dataList[0].selectStatus = true
    }

    override fun initView() {
        rvAdapter = ComuiSingleSelectionAdapter(dataList)
        rvAdapter?.setOnItemClickListener(onItemClickListener)

        rvSingleSelection.setHasFixedSize(true)
        rvSingleSelection.layoutManager = LinearLayoutManager(activity)
        rvSingleSelection.adapter = rvAdapter
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater?.inflate(R.layout.exp_fragment_recycler_view, container, false)
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initView()
    }
}