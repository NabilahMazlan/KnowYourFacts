package com.example.knowyourfacts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {

    ImageView imgView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment3, container, false);

        imgView = view.findViewById(R.id.imageView);
        String imageUrl = "https://wtffunfact.com/wp-content/uploads/2019/06/fun-facts-the-disney-movies-facts-princes-and-the-frog.png";
        Picasso.with(getContext()).load(imageUrl).into(imgView);



        return view;
    }

}
