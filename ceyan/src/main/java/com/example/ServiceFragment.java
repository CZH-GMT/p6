package com.example;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import androidx.fragment.app.Fragment;

import com.example.ceyan.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServiceFragment extends Fragment implements View.OnClickListener {

    private Button mUpbtn;
    private Button mDownbtn;
    private ProgressBar progressBar;

    public ServiceFragment() {
        // Required empty public constructor
    }
    String downLoadUrl = "https://alissl.ucdl.pp.uc.cn/fs08/2017/05/02/7/106_64d3e3f76babc7bce131650c1c21350d.apk";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_service, container, false);

        initView(inflate);
        EventBus.getDefault().register(this);



        return inflate;


    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getprogess(int progess){
        progressBar.setProgress((Integer)progess);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void initView(View inflater) {

        mUpbtn = (Button) inflater.findViewById(R.id.upbtn);
        mUpbtn.setOnClickListener(this);
        mDownbtn = (Button) inflater.findViewById(R.id.downbtn);
        mDownbtn.setOnClickListener(this);
        progressBar = (ProgressBar) inflater.findViewById(R.id.seekbar);
        progressBar.setMax(100);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.upbtn:
                // TODO 21/01/03
                break;
            case R.id.downbtn:
                // TODO 21/01/03
                Intent intent = new Intent(getActivity(), MyService.class);
                intent.putExtra("hh",downLoadUrl);
                getActivity().startService(intent);

                break;
            default:
                break;
        }
    }
}
