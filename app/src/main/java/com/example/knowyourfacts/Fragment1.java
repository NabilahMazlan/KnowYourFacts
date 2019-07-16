package com.example.knowyourfacts;


import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {

    TextView tv;
    Button btn;
    FrameLayout layout;
    boolean colour = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        tv = view.findViewById(R.id.textView);
        btn = view.findViewById(R.id.buttonFragment1);
        layout = view.findViewById(R.id.framelayout1);

        tv.setText("The warrior-heroine then joins up with a group of young men also heading off to become soldiers, fighting beside them for years while somehow keeping her true identity a secret. After leading the army to victory in a final battle, the emperor himself wishes to bestow a reward of her choosing upon Mulan, but all she asks is to be allowed to return home.\n" +
                "\n" +
                "In some versions of the story (such as Disney’s famous movie), there is a romantic subplot with a fellow officer, while in other tellings, there isn’t, ditto for the part about Mulan having a younger brother who is too young to join the army. Some versions are more comedic, others darker — with one from the Qing dynasty having the heroine commit suicide.\n" +
                "\n" +
                "Despite all of these variations, the central tale of a girl going to war to save her father has remained immensely popular in China, although the story was often ignored in the study of serious Chinese literature given that it was passed down orally.");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(colour){
                    colour = false;
                    layout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));

                }else{
                    colour = true;
                    layout.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                }



            }
        });
        return view;
    }

}
