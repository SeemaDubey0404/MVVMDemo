package services.api

import model.CatFact
import retrofit2.http.GET

interface CatFactService {
    @GET("fact")
    suspend fun getCatFact(): CatFact
}