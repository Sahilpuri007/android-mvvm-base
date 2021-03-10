package com.spinplanet.mvvmbase.data

import com.spinplanet.mvvmbase.data.local.dao.DataDao
import com.spinplanet.mvvmbase.data.network.ApiInterface
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private var apiClient: ApiInterface,
    private val myDataDao: DataDao
) : DataRepository {

    private val compositeDisposable = CompositeDisposable()

    /*Write methods for api calls as following */
    /*override fun fetchData(
        queryParam1: String,
        queryParam2: Int,
        callBack: CallBack<BaseResponse>
    ) {
        compositeDisposable.add(
            apiClient.searchData(queryParam1 = queryParam1, queryParam2 = queryParam2)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    callBack.onSuccess(it)
                }, {
                    callBack.onError(ErrorHandler.handleError(it))
                })
        )
    }*/


    fun clear() {
        compositeDisposable.clear()
    }


}