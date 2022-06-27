package services.repository

import model.CatFact
import services.api.CatFactService

class CatFactRepository(
    private val catFactService: CatFactService
) {
    suspend fun getCatFact(): CatFact = catFactService.getCatFact()
}