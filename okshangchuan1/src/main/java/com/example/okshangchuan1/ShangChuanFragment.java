package com.example.okshangchuan1;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.example.okshangchuan1.Api.ApiService;
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
public class ShangChuanFragment extends Fragment implements View.OnClickListener {

    private FragmentActivity activity;
    private Button mBtn;
    private ImageView mIamge;

    public ShangChuanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_shang_chuan, container, false);
        activity = getActivity();
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {


        mBtn = (Button) inflate.findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
        mIamge = (ImageView) inflate.findViewById(R.id.iamge);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                // TODO 20/12/29
                updata();
                break;
            default:
                break;
        }
    }

    private void updata() {
        String hader="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOjUwMCwicmlkIjowLCJpYXQiOjE2MDkyNDMyMjIsImV4cCI6MTYwOTMyOTYyMn0.b8-ImvxX67ISXmtkIQeSXl-0IGZVv-QyLNlI6JVQ3ks";

        String s = Environment.getExternalStorageDirectory() + "/Pictures/a1.jpg";
        File file = new File(s);
        if (!file.exists()){
            Toast.makeText(activity, "文件不存在", Toast.LENGTH_SHORT).show();
        }
        RequestBody responseBody = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part file1 = MultipartBody.Part.createFormData("file", file.getName(), responseBody);



        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.upurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        build.create(ApiService.class).getupdata(hader,file1)
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
                            ImgeBean imgeBean = new Gson().fromJson(string, ImgeBean.class);
                            Glide.with(activity).load(imgeBean.getData().getUrl()).into(mIamge);
                            Log.d("TAG", "成功: "+string);
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
