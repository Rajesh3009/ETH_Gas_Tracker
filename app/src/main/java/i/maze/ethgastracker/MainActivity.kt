package i.maze.ethgastracker

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {

    private val mService by lazy {
        API.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageButton.setOnClickListener {
            getGas()
        }
    }

    override fun onStart() {

        val timer = Timer()
        timer.scheduleAtFixedRate(
            object : TimerTask() {
                override fun run() {
                    getGas()
                }
            },
            0, 5000
        )
        super.onStart()
    }


    private fun getGas() {

        CoroutineScope(IO).launch {
            val call = mService.getData()

            call.enqueue(object : Callback<EthGasPrice> {
                override fun onResponse(
                    call: Call<EthGasPrice>,
                    response: Response<EthGasPrice>
                ) {

                    val mData = response.body()
                    if (mData != null) {
                        tv_fastest.text = ((mData.fastest.toDouble()) / 10).toString()
                        tv_fast.text = ((mData.fast).toDouble() / 10).toString()
                        tv_average.text = ((mData.average).toDouble() / 10).toString()
                        tv_slow.text = ((mData.safeLow).toDouble() / 10).toString()
                    }
                }

                override fun onFailure(call: Call<EthGasPrice>, t: Throwable) {
                    Toast.makeText(baseContext, "$t", Toast.LENGTH_SHORT).show()
                }

            })

        }

    }
}