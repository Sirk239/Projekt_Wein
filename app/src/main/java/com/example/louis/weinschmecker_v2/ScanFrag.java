package com.example.louis.weinschmecker_v2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScanFrag extends Fragment implements ZXingScannerView.ResultHandler {


    private ZXingScannerView zXingScannerView;


    public ScanFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    //new Code
        zXingScannerView = new ZXingScannerView(getActivity());
        return zXingScannerView;
      //New Code Ende
       // return inflater.inflate(R.layout.fragment_scan, container, false);
    }

    //Barcodescanner
    public void scan (View view){

        zXingScannerView = new ZXingScannerView(getContext().getApplicationContext());
        zXingScannerView.setResultHandler(this);
        zXingScannerView.startCamera();

    }

    //new
    @Override
    public void onResume() {
        super.onResume();
        zXingScannerView.setResultHandler(this);
        zXingScannerView.startCamera();
    }
    //Ende

    @Override
    public void onPause() {
        super.onPause();
        zXingScannerView.stopCamera();

    }

    @Override
    public void handleResult(Result result) {
        Toast.makeText(getContext().getApplicationContext(),result.getText(),Toast.LENGTH_SHORT).show();
        zXingScannerView.resumeCameraPreview(this);


    }

}
