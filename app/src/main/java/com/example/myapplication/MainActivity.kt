package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val Firt = editTextTextPersonName.text.toString()
            val Last = editTextTextPersonName2.text.toString()

            val fb = FirebaseDatabase.getInstance()
            val ref = fb.getReference("Employee")
            val id: String? = ref.push().key

            val Employee = Employee(id.toString(), Firt, Last)
            ref.child(id.toString()).setValue(Employee).addOnCompleteListener {
                Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show()
                editTextTextPersonName.text.clear()
                editTextTextPersonName2.text.clear()
            }
        }



        button2.setOnClickListener {
            editTextTextPersonName.text.clear()
            editTextTextPersonName2.text.clear()
        }
    }
}
class Employee(val id: String, val firt: String, val last: String) {

}