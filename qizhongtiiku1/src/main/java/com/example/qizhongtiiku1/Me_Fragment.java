package com.example.qizhongtiiku1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class Me_Fragment extends Fragment {

    private FragmentActivity activity;
    private WebView webview;

    public Me_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_me_, container, false);
        activity = getActivity();
        initView(inflate);

        return inflate;
    }

    private void initView(View inflate) {
        webview = inflate.findViewById(R.id.webview);
        webview.loadUrl("https://www.baidu.com/?tn=40020637_14_oem_dg");
        webview.setWebViewClient(new WebViewClient());

    }


}
