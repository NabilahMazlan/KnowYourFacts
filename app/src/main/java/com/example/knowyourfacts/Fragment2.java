package com.example.knowyourfacts;


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
public class Fragment2 extends Fragment {
    TextView tv;
    Button btn;
    FrameLayout layout;
    boolean colour = true;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        tv = view.findViewById(R.id.textViewFragment2);
        btn = view.findViewById(R.id.buttonFragment2);
        layout = view.findViewById(R.id.framelayout2);
        tv.setText("“Cinderella”: In the Brothers Grimm version, one of Cinderella’s evil stepsisters cuts off her toes, and the other her heel so they can both fit into the tiny glass slipper. The prince is notified by little doves that there is blood on the shoe, and finally discovers that the true owner is Cinderella. Once the stepsisters realize that they should try to win favor with Cinderella (after all, she will be queen), they attend her wedding, only to have their eyes pecked out by birds. Did they deserve it? I’ll let you decide, reader. \n" +
                "\n" +
                "SOME OTHER SIDENOTES ON THIS STORY: Cinderella doesn’t have a fairy godmother. Rather, she plants a tree by her mother’s grave and prays under it every day. She finds her dresses to wear to each ball under the tree (there are three in the story, not one like in the movie). She is still helped by animals, though specifically birds, not mice. Also, she doesn’t just lose her shoe because she is in a rush. The clever prince covers the steps in pitch to make her stick to them, but she only loses a shoe in the process. ");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(colour){
                    colour = false;
                    layout.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));

                }else{
                    colour = true;
                    layout.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
                }
            }
        });
        return view;
    }

}
