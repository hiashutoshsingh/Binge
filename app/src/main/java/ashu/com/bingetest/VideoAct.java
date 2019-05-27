package ashu.com.bingetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class VideoAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        WebView webView = (WebView)findViewById(R.id.video_webview);
        Intent intent = getIntent();
        webView.loadUrl(intent.getStringExtra("video"));
    }
}
