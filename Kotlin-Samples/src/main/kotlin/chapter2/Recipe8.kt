package chapter2

import com.google.gson.Gson
import utils.logger

/**
 * Chapter: Expressive functions and adjustable interfaces
 * Recipe: Smart types checking with generic reified parameters
 */
fun main(vararg args: String) {
    val jsonString = "{gifsWithPandas:[first.gif, second.gif, third.gif]}"
    val response = Gson().fromJson<ApiResponse>(jsonString)
    logger<Any>().info(Gson().toJson(response))
}
data class ApiResponse(val gifsWithPandas: List<String>)


inline fun <reified T> Gson.fromJson(json: String): T {
    return fromJson(json, T::class.java)
}