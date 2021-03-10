package com.spinplanet.mvvmbase.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    //Add more ViewModels here

    /*@Binds
    @IntoMap
    @ViewModelKey(DashBoardViewModel::class)
    internal abstract fun dashboardViewModel(viewModel: DashBoardViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(IconSearchViewModel::class)
    internal abstract fun iconSearchViewModel(viewModel: IconSearchViewModel): ViewModel
*/

}