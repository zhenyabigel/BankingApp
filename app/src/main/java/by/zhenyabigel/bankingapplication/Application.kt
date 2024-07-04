package by.zhenyabigel.bankingapplication

import android.app.Application
import by.zhenyabigel.bankingapplication.di.appModule
import by.zhenyabigel.bankingapplication.di.dataModule
import by.zhenyabigel.bankingapplication.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@Application)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}