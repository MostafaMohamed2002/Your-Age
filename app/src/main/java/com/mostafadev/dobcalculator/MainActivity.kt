package com.mostafadev.dobcalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        selectdatebtn.setOnClickListener{
            datePicker()

        }
    }
    open fun datePicker(){
        var myCalender=Calendar.getInstance()
        var year=myCalender.get(Calendar.YEAR)
        var month=myCalender.get(Calendar.MONTH)
        var day=myCalender.get(Calendar.DAY_OF_MONTH)
        var dpd=      DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{view,selectedYear,selectedMonth,selectedDay->
                Toast.makeText(this,"Selected Date:$selectedDay/${selectedMonth+1}/$selectedYear",Toast.LENGTH_SHORT).show()
                var selectedDate="$selectedDay/${selectedMonth+1}/$selectedYear"
                textViewselecteddate1?.text = "$selectedDate"
                var sdf= SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
                var theDate=sdf.parse(selectedDate)
                var selectedDateInDays=theDate.time/86400000
                var currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))
                var currentDateInDays=currentDate.time/86400000
                var diffrenceBetweenDates=currentDateInDays-selectedDateInDays
                textViewyourageindays.text=diffrenceBetweenDates.toString()
            },
            year,
            month,
            day,
        )
        dpd.datePicker.maxDate=System.currentTimeMillis()
        dpd.show()
    }
}