package com.example.internalandexternalstorageinandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.ContactsContract
import android.util.Log
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        var externalStorage = Environment.getExternalStorageState()
        if(externalStorage.equals(Environment.MEDIA_MOUNTED)){
            Log.e("tag","Media Mounted")
        }

        if(externalStorage.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            Log.e("tag","Media Mounted Read Only")
        }

        var rootDir : File = Environment.getExternalStorageDirectory()
        Log.e("tag","${rootDir.absolutePath}")

        var extMoviesRootDir : File = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES)
        Log.e("tag","${extMoviesRootDir.absolutePath}")

        var extMusicRootDir : File = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)
        Log.e("tag","${extMusicRootDir.absolutePath}")

        var extAppRootDir = getExternalFilesDir(Environment.DIRECTORY_MOVIES)
        if (extAppRootDir != null) {
            Log.e("tag","${extAppRootDir.absolutePath}")
        }
         */


        var fileOutputStream : FileOutputStream = openFileOutput("internalstorageDemo_testFile",AppCompatActivity.MODE_PRIVATE)
        fileOutputStream.write("Krishna tried Firebase Management".toByteArray())
        fileOutputStream.write("My Nov 22 Batch enjoys Android and is Best!".toByteArray())
        fileOutputStream.close()

        var fileInputStream : FileInputStream = openFileInput("internalstorageDemo_testFile")
        var count = 0
        var data = ByteArray(1024 * 2)
        count = fileInputStream.read(data)
        Log.e("tag","$count")


        while (count != -1){
            Log.e("tag", String(data,0,count))
            count = fileInputStream.read(data)
        }
        fileInputStream.close()
    }
}