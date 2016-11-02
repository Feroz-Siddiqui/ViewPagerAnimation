package com.example.feroz.androidcms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView textView;
    Spinner spinner;

    //"

    String[] animations = {"enter_from_left", "enter_from_right", "exit_to_right", "floating_button_slide_up",
            "slide_down", "slide_right_in", "slide_up", "fade_in", "fade_out", "blink", "zoom_in"
            , "zoom_out", "rotate", "move", "bounce", "bounce_up", "rotate_corner", "rotate_center", "hyperspace_in", "hyperspace_out", "push_left_in", "push_left_out"
            , "push_up_in", "push_up_out", "sequential", "together"};
    ArrayAdapter<String> animation_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = (TextView) findViewById(R.id.text);
        spinner = (Spinner) findViewById(R.id.spinner);

        animation_adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, animations);
        spinner.setAdapter(animation_adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = spinner.getSelectedItem().toString();

                System.out.println("Animation ------------> " + selected);

                switch (selected) {
                    case "enter_from_left":
                        animateData(R.anim.enter_from_left);
                        break;
                    case "enter_from_right":
                        animateData(R.anim.enter_from_right);
                        break;
                    case "exit_to_right":
                        animateData(R.anim.exit_to_right);
                        break;
                    case "floating_button_slide_up":
                        animateData(R.anim.floating_button_slide_up);
                        break;
                    case "slide_down":
                        animateData(R.anim.slide_down);
                        break;
                    case "slide_right_in":
                        animateData(R.anim.slide_right_in);
                        break;
                    case "slide_up":
                        animateData(R.anim.slide_up);
                        break;
                    case "fade_in":
                        animateData(R.anim.fade_in);
                        break;
                    case "fade_out":
                        animateData(R.anim.fade_out);
                        break;
                    case "blink":
                        animateData(R.anim.blink);
                        break;
                    case "zoom_in":
                        animateData(R.anim.zoom_in);
                        break;
                    case "zoom_out":
                        animateData(R.anim.zoom_out);
                        break;
                    case "rotate":
                        animateData(R.anim.rotate);
                        break;
                    case "bounce":
                        animateData(R.anim.bounce);
                        break;
                    case "rotate_center":
                        animateData(R.anim.rotate_center);
                        break;

                    case "rotate_corner":
                        animateData(R.anim.rotate_corner);
                        break;
                    case "hyperspace_in":
                        animateData(R.anim.hyperspace_in);
                        break;
                    case "hyperspace_out":
                        animateData(R.anim.hyperspace_out);
                        break;
                    case "push_left_in":
                        animateData(R.anim.push_left_in);
                        break;

                    case "push_left_out":
                        animateData(R.anim.push_left_out);
                        break;
                    case "push_up_in":
                        animateData(R.anim.push_up_in);
                        break;
                    case "push_up_out":
                        animateData(R.anim.push_up_out);
                        break;
                    case "bounce_up":
                        animateData(R.anim.bounce_up);
                        break;

                    case "move":
                        animateData(R.anim.move);
                        break;
                    case "sequential":
                        animateData(R.anim.sequential);
                        break;
                    case "together":
                        animateData(R.anim.together);
                        break;

                    default:
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


    }

    public void animateData(int res) {

        final Animation animation = AnimationUtils.loadAnimation(this,
                res);
        animation.setDuration(1000);

        textView.startAnimation(animation);
    }

}
