package com.lin.kotlinbase.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lin.kotlinbase.R
import com.lin.kotlinbase.api.entity.TimeEntity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    companion object {
        const val DATA: String = "DATA"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val timeEntity = intent.getSerializableExtra(DATA) as? TimeEntity

        message.text = timeEntity?.startTime +"\n"+
                timeEntity?.endTime +"\n"+
                timeEntity?.parameter?.parameterName + timeEntity?.parameter?.parameterUnit
    }
}
