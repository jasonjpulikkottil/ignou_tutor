package com.jdots.ignou;

import android.Manifest;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
import com.nabinbhandari.android.permissions.PermissionHandler;
import com.nabinbhandari.android.permissions.Permissions;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Objects;

import es.dmoral.toasty.Toasty;
import im.delight.android.webview.AdvancedWebView;


public class WebActivity extends AppCompatActivity {

    private AdvancedWebView webView;
    String text1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //
        try {

            super.onCreate(savedInstanceState);
            adjusttheme();
            setContentView(R.layout.activity_web);
          //  NoInternetDialog noInternetDialog = new NoInternetDialog.Builder(this).build();


            if(!isConnect())
            {
                Toasty.error(this," No Internet ! ", Toast.LENGTH_LONG,false).show();
            }

            AdView adView;
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            LinearLayout adContainer =  findViewById(R.id.banner_container_web);
            if( !(prefs.getBoolean("NOADS", false))) {
                adView = new AdView(this, getString(R.string.fan_banner_id), AdSize.BANNER_HEIGHT_50);
                adContainer.setVisibility(View.VISIBLE);
                adContainer.addView(adView);
                adView.loadAd();
            }else
            {
                adContainer.setVisibility(View.GONE);
            }



            Intent intent = getIntent();
            Bundle extras = intent.getExtras();

            text1 = null;

            if (extras != null) {
                text1 = extras.getString(Main.TOKEN4);

            }

            final TextView T = findViewById(R.id.textView);
            webView =  findViewById(R.id.webView1);

            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);

            WebViewClientImpl webViewClient = new WebViewClientImpl(this);
            webView.setWebViewClient(webViewClient);

            Toasty.success(this, " Loading ", Toast.LENGTH_LONG, false).show();
            webView.loadUrl(text1);
            webView.setWebViewClient(new HelloWebViewClient());

            T.setVisibility(View.GONE);
            webView.setDownloadListener(new DownloadListener() {

                @Override
                public void onDownloadStart(String url, String userAgent,
                                            String contentDisposition, String mimeType,
                                            long contentLength) {

                    if (ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        // ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 10);
                        DRequest(url, userAgent, contentDisposition, mimeType, contentLength);

                    } else {

                        downloadDialog(url, userAgent, contentDisposition, mimeType);
                    }
                }
            });
        }catch(Exception e){
            Toasty.info(this,"Redirecting", Toast.LENGTH_SHORT,false).show();


            try {
                Intent i = getIntent();
                Bundle extras = i.getExtras();
                text1 = "http://www.google.com";
                if (extras != null) {
                    text1 = extras.getString(Main.TOKEN4);
                }
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(text1));
                startActivity(intent);
                finish();

            }catch(Exception a) {
                Toasty.error(this,"Error Loading", Toast.LENGTH_LONG,false).show();

            }

            }
    }
    protected void onDestroy() {



        super.onDestroy();
    }
public boolean isConnect() {
    boolean connected = false;

    try {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        } else
            connected = false;
    }catch(Exception e){
        Toasty.error(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT, true).show();
        return true;
    }
    return connected;
}

    public void DRequest(String url, String userAgent, String contentDisposition, String mimeType, long contentLength) {
        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        String rationale = "Please provide permissions to download";
        Permissions.Options options = new Permissions.Options()
                .setRationaleDialogTitle("Info")
                .setSettingsDialogTitle("Warning");

       final String Vurl= url;
        final  String VuserAgent =userAgent;
        final String VcontentDisposition= contentDisposition;
        final String VmimeType= mimeType;
        final long VcontentLength= contentLength;



        Permissions.check(this/*context*/, permissions, rationale, options, new PermissionHandler() {
            @Override
            public void onGranted() {
                downloadDialog(Vurl, VuserAgent,VcontentDisposition, VmimeType);
            }

            @Override
            public void onDenied(Context context, ArrayList<String> deniedPermissions) {
                DRequest(Vurl, VuserAgent,VcontentDisposition, VmimeType,VcontentLength);
            }
        });
    }

    public void downloadDialog(final String url,final String userAgent,String contentDisposition,String mimetype) {
        //getting filename from url.

        try {


            final String filename = URLUtil.guessFileName(url, contentDisposition, mimetype);

            final NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder.getInstance(this);

            dialogBuilder
                    .withTitle("DOWNLOAD")                                  //.withTitle(null)  no title
                    .withTitleColor("#FFFFFF")                                  //def
                    .withDividerColor("#11000000")                              //def
                    .withMessage("Do you want to save " + filename + " ?")                     //.withMessage(null)  no Msg
                    .withMessageColor("#FFFFFFFF")                              //def  | withMessageColor(int resid)
                    .withDialogColor("#FFE74C3C")                               //def  | withDialogColor(int resid)
                    .withIcon(getResources().getDrawable(R.drawable.jdots))
                    .withDuration(700)                                          //def
                    .withEffect(Effectstype.Flipv)                                         //def Effectstype.Slidetop
                    .withButton1Text("Yes")                                      //def gone
                    .withButton2Text("No")                                  //def gone
                    .isCancelableOnTouchOutside(true)                           //def    | isCancelable(true)
                    // .setCustomView(View or ResId,context)
                    .setButton1Click(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //DownloadManager.Request created with url.
                            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                            //cookie
                            String cookie = CookieManager.getInstance().getCookie(url);
                            //Add cookie and User-Agent to request
                            request.addRequestHeader("Cookie", cookie);
                            request.addRequestHeader("User-Agent", userAgent);
                            //file scanned by MediaScannar
                            request.allowScanningByMediaScanner();
                            //Download is visible and its progress, after completion too.
                            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                            //DownloadManager created
                            DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                            //Saving files in Download folder
                            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, filename);
                            //download enqued
                            try {
                                downloadManager.enqueue(request);
                            } catch (Exception ignored) {
                                Toasty.error(getBaseContext(), "Error Downloading File", Toast.LENGTH_SHORT, true).show();
                            }
                            Toasty.success(getBaseContext(), "Downloading File", Toast.LENGTH_SHORT, true).show();
                            finish();
                        }
                    })
                    .setButton2Click(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialogBuilder.cancel();
                            finish();
                        }
                    })
                    .show();

        } catch (Exception e) {

            Toasty.info(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG, false).show();



        }






    }
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.endsWith(".pdf") || url.endsWith(".PDF") || url.endsWith(".Pdf")) {
                String googleDocs = "https://docs.google.com/viewer?url=";
                view.loadUrl(googleDocs + url);
            }
            else if (url.startsWith("intent://")) try {
                Context context = view.getContext();
                Intent intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);

                if (intent != null) {
                    view.stopLoading();

                    PackageManager packageManager = context.getPackageManager();
                    ResolveInfo info = packageManager.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
                    if (info != null) {
                        context.startActivity(intent);
                    } else {
                        String fallbackUrl = intent.getStringExtra("browser_fallback_url");
                        view.loadUrl(fallbackUrl);

                    }

                    return true;
                }
            } catch (URISyntaxException e) {

                    Log.e("WEBVIEW", "Can't resolve intent://", e);

            }
            else {
                view.loadUrl(url);
            }

            return true;

        }

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webView.canGoBack()) {
            this.webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
    public void adjusttheme() {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String theme=prefs.getString("list_preference_theme","1");
        switch(theme)
        {
            case ("Pink-Blue") :
                setTheme(R.style.AppTheme1);
                break;
            case ("Red-Blue") :
                setTheme(R.style.AppTheme2);
                break;
            case ("Green-Blue") :
                setTheme(R.style.AppTheme3);
                break;
            case ("Green-Red") :
                setTheme(R.style.AppTheme4);
                break;
            default:  setTheme(R.style.AppTheme1);

        }

    }




}


class WebViewClientImpl extends WebViewClient {

    private Activity activity = null;
    @Override
     public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
    public WebViewClientImpl(Activity activity) {
        this.activity = activity;
    }
}