package di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import services.api.CatFactService
import services.repository.CatFactRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCatFactRepository(
        catFactService: CatFactService
    ): CatFactRepository =
        CatFactRepository(catFactService)
}