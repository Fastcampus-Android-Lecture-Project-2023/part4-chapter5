package kr.co.fastcampus.part4.chapter5_9

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeAPI {
    @GET("pokemon/")
    suspend fun getPokemons(): Response

    @GET("pokemon/")
    suspend fun getPokemons(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response

    @GET("pokemon/{pid}/")
    suspend fun getPokemon(@Path("pid") pid: Int): PokemonResponse
}

data class Response(
    val count: Int,
    val previous: String?,
    val next: String?,
    val results: List<Result>
) {
    data class Result(
        val url: String,
        val name: String
    )
}

data class PokemonResponse(
    val species: Species,
    val sprites: Sprites
) {
    data class Species(var name: String)

    data class Sprites(var frontDefault: String)
}

