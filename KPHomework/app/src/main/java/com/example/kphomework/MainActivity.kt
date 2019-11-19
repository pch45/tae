package com.example.kphomework

import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.util.Base64
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.kphomework.Glide.loadImage

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.security.MessageDigest
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val image = findViewById<ImageView>(R.id.imageView)
//        loadImage("https://t1.daumcdn.net/cfile/tistory/2550AC3855A1FEBB26").into(image)
//        val info = packageManager.getPackageInfo("com.example.kphomework", PackageManager.GET_SIGNATURES)
//        for(sig in info.signatures) {
//            val md = MessageDigest.getInstance("SHA")
//            md.update(sig.toByteArray())
//            Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT))
//        }
        CoroutineScope(Dispatchers.Main).launch {
//            val result = APIClient.getRetrofitService().getImage("KakaoAK 167c9cf60682bbee5446d229f97acc25","설현")
//            loadImage(result.resultList[0].imageUrl).into(image)
            val result = APIClient.getRetrofitService2().getLotto("getLottoNumber",875)
            Log.d("hans",result.toString())
        }
    }
}
