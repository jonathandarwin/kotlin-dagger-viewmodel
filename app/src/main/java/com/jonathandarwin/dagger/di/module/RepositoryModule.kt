package com.jonathandarwin.dagger.di.module

import com.jonathandarwin.dagger.network.WebService
import com.jonathandarwin.dagger.repository.IMainRepository
import com.jonathandarwin.dagger.repository.MainRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//@Module
//object RepositoryModule{
//
//    // Provide : To let Dagger knows about how to create a instance with IMainRepository type.
//    // Here, it contains another dependency called webService, it will be injected by
//    // other module with @Provide function and with WebService return type (on the NetworkModule)
//
//    // UPDATE : using alias (static @Provide), will automatically inject the MainRepository as long as it has @Inject in the Constructor,
//    //        : more eficient
//    @Provides
//    @JvmStatic fun provideMainRepository(mainRepository: MainRepository) : IMainRepository = mainRepository
//}

@Module
abstract class RepositoryModule {
    // If you using alias (static @Provide), its better to use @Binds because Dagger only needs the module at compile time,
    // and can avoid class loading the module at runtime - as it said in dagger.dev/dev-guide/
    @Binds abstract fun bindMainRepository(mainRepository: MainRepository) : IMainRepository
}