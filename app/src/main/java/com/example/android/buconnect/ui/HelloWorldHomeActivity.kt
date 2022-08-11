package com.example.android.buconnect.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.roomwordssample.R
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset


/**
 * A simple [Fragment] subclass.
 * Use the [HelloWorldHomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HelloWorldHomeActivity :  AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_world_home)

        val adapter: RecyclerViewAdapter

        val backButton: View = findViewById(R.id.backButton)
        val recyclerView: RecyclerView = findViewById(R.id.rvMainprofile)

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        var datasetList = ArrayList<String>()

        try {
            val obj = JSONObject(loadJSONFromAsset())
            val userArray = obj.getJSONArray("users")
            for (i in 0 until userArray.length()) {
                val userDetail = userArray.getJSONObject(i)
                datasetList.add(userDetail.getString("name"))
            }
        }
        catch (e: JSONException) {
            e.printStackTrace()
        }

        val adapterDataList = RecyclerViewAdapter(datasetList, this)
        recyclerView.adapter = adapterDataList

        recyclerView.setOnClickListener{
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

            Log.d("Hello World Activity", "Running onCreate")
    }

    fun travelToChat(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun loadJSONFromAsset(): String {
        val json: String?
        try {
            val inputStream = assets.open("contacts.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)
        }
        catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json
    }

}