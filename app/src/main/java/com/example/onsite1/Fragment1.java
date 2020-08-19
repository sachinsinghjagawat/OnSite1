package com.example.onsite1;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.graphics.Path;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class Fragment1 extends Fragment {

    private Fragment1ViewModel mViewModel;
    FrameLayout drawView;
    public static MyCanvas myCanvas;
    Fragment1Listener listener;

    public static Fragment1 newInstance() {
        return new Fragment1();
    }

    public interface Fragment1Listener {
        void sendPath1 (Path path);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment1_fragment, container, false);
        drawView = rootView.findViewById(R.id.draw1);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        myCanvas = new MyCanvas(this.getContext());
        drawView.addView(myCanvas);

        listener.sendPath1(myCanvas.getPath());

 /*       try {
            mViewModel.setPath(myCanvas.getPath());
        }catch (Exception e){
            e.printStackTrace();
        }
  */

    }

    public static void updatePath1(Path path) {
        myCanvas.setPath(path);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Fragment1Listener) {
            listener = (Fragment1Listener) context;
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(Fragment1ViewModel.class);
        // TODO: Use the ViewModel
 /*       mViewModel.getPath().observe(getViewLifecycleOwner(), new Observer<Path>() {
            @Override
            public void onChanged(Path path) {
                myCanvas.setPath(path);
                myCanvas.invalidate();
            }
        });
  */
    }

}