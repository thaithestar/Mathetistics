package com.example.thait.mathetistics;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Correct extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_correct,
                container, false);

//        Button ok = (Button)rootView.findViewById(R.id.ok_correct);
//        ok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Compete.QList.remove(0);
//                Intent intent = new Intent(getActivity(), Exercise.class);
//                getActivity().finish();
//                startActivity(intent);
//            }
//        });
        return rootView;
    }

}
