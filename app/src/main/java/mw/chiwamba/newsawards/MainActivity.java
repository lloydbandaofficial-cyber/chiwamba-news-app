package mw.chiwamba.newsawards;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String START_URL =
            "https://lloydbandaofficial-cyber.github.io/Chiwamba-news-awards-/";

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        box.setPadding(48, 120, 48, 48);
        box.setBackgroundColor(Color.WHITE);

        TextView tv = new TextView(this);
        tv.setTextSize(22);
        tv.setTextColor(Color.BLACK);
        tv.setText("Chiwamba News Awards\n\nThe app is working.");
        box.addView(tv);

        Button b = new Button(this);
        b.setText("Open website");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSite();
            }
        });
        box.addView(b);

        setContentView(box);
    }

    private void openSite() {
        try {
            webView = new WebView(this);
            WebSettings s = webView.getSettings();
            s.setJavaScriptEnabled(true);
            s.setDomStorageEnabled(true);
            webView.setWebViewClient(new WebViewClient());
            setContentView(webView);
            webView.loadUrl(START_URL);
        } catch (Throwable t) {
            Log.e("Chiwamba", "WebView error", t);
            TextView e = new TextView(this);
            e.setPadding(32, 64, 32, 32);
            e.setText("WebView error:\n\n" + Log.getStackTraceString(t));
            ScrollView sv = new ScrollView(this);
            sv.addView(e);
            setContentView(sv);
        }
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
