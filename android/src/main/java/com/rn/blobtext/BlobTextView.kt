package com.rn.blobtext

import android.app.Activity
import android.content.Context
import android.os.AsyncTask
import android.os.Handler
import android.view.View
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.views.text.ReactTextView
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

class BlobTextView(context: Context?) : ReactTextView(context) {

    private var route = ""

    @ReactProp(name = "src")
    fun setBlobRoute(view : BlobTextView, sources : ReadableArray?){
        route = if(sources?.getString(0)!=null){
            sources.getString(0)
        }else{
            ""
        }
        if(!route.isNullOrBlank()){
            loadtext()
        }
    }

    fun loadtext(){

        class UpdateUITask(val text: String) : Runnable{
            override fun run() {
                setText(text)
            }
        }

        class InnerTask(val fileName : String) : Runnable{
            override fun run() {
                val text = StringBuilder()
                try {
                    val file = File(fileName)

                    val br = BufferedReader(FileReader(file))
                    var line: String
                    do {
                        line = br.readLine()
                        text.append(line)
                        text.append('\n')
                        handler.post(UpdateUITask(text.toString()))
                    } while(line !=null)
                    br.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

            fun execute(){
                AsyncTask.THREAD_POOL_EXECUTOR.execute(this)
            }
        }
        InnerTask(route).execute()
    }

    private fun getActivity() : Activity{
        return findViewById<View>(android.R.id.content).context as Activity
    }

    override fun getHandler() : Handler {
        var handler = super.getHandler()
        if(handler == null) handler = getActivity().window.decorView.handler
        return handler
    }
}