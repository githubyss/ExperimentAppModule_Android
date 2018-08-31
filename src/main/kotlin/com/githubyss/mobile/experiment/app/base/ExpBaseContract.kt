package com.githubyss.mobile.experiment.app.base

import com.githubyss.mobile.common.ui.basemvp.ComuiBaseContract

/**
 * ExpBaseContract
 * <Description>
 * <Details>
 *
 * @author Ace Yan
 * @github githubyss
 */
interface ExpBaseContract {
    interface IView : ComuiBaseContract.ComuiBaseIView<IPresenter>
    interface IPresenter : ComuiBaseContract.ComuiBaseIPresenter
}
