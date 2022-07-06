package com.example.qizhong1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Two_Fragment extends Fragment {

    private WebView web;

    public Two_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_two_, container, false);



        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        web=inflate.findViewById(R.id.web);
        web.loadUrl("https://www.baidu.com/?tn=02003390_2_hao_pg");
        web.setWebViewClient(new WebViewClient());
    }
}
