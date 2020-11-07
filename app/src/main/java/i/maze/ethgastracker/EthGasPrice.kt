package i.maze.ethgastracker


import com.google.gson.annotations.SerializedName

data class EthGasPrice(
    @SerializedName("average")
    val average: Int,
    @SerializedName("avgWait")
    val avgWait: Double,
    @SerializedName("blockNum")
    val blockNum: Int,
    @SerializedName("block_time")
    val blockTime: Double,
    @SerializedName("fast")
    val fast: Int,
    @SerializedName("fastWait")
    val fastWait: Double,
    @SerializedName("fastest")
    val fastest: Int,
    @SerializedName("fastestWait")
    val fastestWait: Double,
//    @SerializedName("gasPriceRange")
//    val gasPriceRange: GasPriceRange,
    @SerializedName("safeLow")
    val safeLow: Int,
    @SerializedName("safeLowWait")
    val safeLowWait: Double,
    @SerializedName("speed")
    val speed: Double
)