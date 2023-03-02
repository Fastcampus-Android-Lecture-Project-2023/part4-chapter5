package kr.co.fastcampus.part4.part5_7.service

import kr.co.fastcampus.part4.part5_7.model.Repo
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users/{user}/repos")
    suspend fun listRepos(@Path("user") user: String): List<Repo>
}