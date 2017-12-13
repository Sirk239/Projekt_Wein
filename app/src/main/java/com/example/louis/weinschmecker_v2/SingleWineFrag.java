package com.example.louis.weinschmecker_v2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SingleWineFrag extends Fragment {

    private View mSingleWeinView ;

    public SingleWineFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mSingleWeinView = inflater.inflate(R.layout.fragment_single_wine,null,false);



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_single_wine, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();
        TextView wineID = mSingleWeinView.findViewById(R.id.TV_wineID);
        wineID.setText(this.getArguments().get("wineID").toString());
    }

}

