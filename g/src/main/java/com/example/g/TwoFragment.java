package com.example.g;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import java.io.File;
import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment {

    private FragmentActivity activity;
    private SurfaceView mSfv;

    public TwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_one, container, false);
        activity = getActivity();
        initView(inflate);

        return inflate;

    }

    private void initView(View inflate) {

        mSfv = (SurfaceView) inflate.findViewById(R.id.sfv);
//        final MediaPlayer mediaPlayer = new MediaPlayer();
//
//        final String s = Environment.getExternalStorageDirectory() + File.separator + "d.mp4";
//        File file = new File(s);
//        if (!file.exists()){
//            Toast.makeText(activity, "不存在", Toast.LENGTH_SHORT).show();
//        }
//
//
//        mSfv.getHolder().addCallback(new SurfaceHolder.Callback() {
//            @Override
//            public void surfaceCreated(@NonNull SurfaceHolder holder) {
//                try {
//                    mediaPlayer.setDataSource(s);
//                    mediaPlayer.prepare();
//                    mediaPlayer.setDisplay(mSfv.getHolder());
//                    mediaPlayer.start();
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//            @Override
//            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
//
//            }
//
//            @Override
//            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
//
//            }
//        });
        final MediaPlayer mediaPlayer = new MediaPlayer();

        final String s = Environment.getExternalStorageDirectory() + File.separator + "e.mp4";
        File file = new File(s);
        if (!file.exists()){
            Toast.makeText(activity, "失败", Toast.LENGTH_SHORT).show();
        }



        mSfv.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                try {
                    mediaPlayer.setDataSource(s);
                    mediaPlayer.prepare();
                    mediaPlayer.setDisplay(mSfv.getHolder());
                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

            }
        });
    }
}
