package i.maze.ethgastracker

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface API {
    @GET("ethgasAPI.json")
    fun getData(): Call<EthGasPrice>


    companion object{
        fun create():API{
            val retrofit = Retrofit.Builder()
                .baseUrl("https://ethgasstation.info/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return  retrofit.create(API::class.java)
        }
    }
}