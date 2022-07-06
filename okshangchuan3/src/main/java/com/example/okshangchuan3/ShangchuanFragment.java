package com.example.okshangchuan3;

import android.os.Bundle;
import android.os.Environment;
import android.provider.Telephony;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShangchuanFragment extends Fragment implements View.OnClickListener {

    private FragmentActivity activity;
    private Button mBtn;
    private ImageView mIv;

    public ShangchuanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_shangchuan, container, false);
        activity = getActivity();
        initView(inflate);

        return inflate;
    }

    private void initView(View inflate) {

        mBtn = (Button) inflate.findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
        mIv = (ImageView) inflate.findViewById(R.id.iv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                // TODO 20/12/28

                initData();


                break;
            default:
                break;
        }
    }

    private void initData() {
        String header="";
        String s = Environment.getExternalStorageState() + "image/a2.jpg";
        File file = new File(s);
        if (!file.exists()){
            Toast.makeText(activity, "文件未找到", Toast.LENGTH_SHORT).show();
        }
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part file1 = MultipartBody.Part.createFormData("file", file.getName(), requestBody);


        new Retrofit.Builder()
                .baseUrl(ApiService.upurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()


                .create(ApiService.class).getupdata(header,file1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Imgbean imgbean = new Gson().fromJson(string, Imgbean.class);
                            String url = imgbean.getData().getUrl();
                            Glide.with(activity).load(url).into(mIv);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });



    }
}
