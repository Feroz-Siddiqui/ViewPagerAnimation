package com.example.feroz.androidcms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class EndActivity extends AppCompatActivity {
    private Button submit;
    private ImageView imageView;
    private Picasso mPicasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        submit = (Button) findViewById(R.id.submit);
        imageView = (ImageView) findViewById(R.id.image);

        /*mPicasso = Picasso.with(this); //Single instance

        mPicasso.load(R.drawable.theend)
                .resize(200, 200).centerInside()
                .error(context.getResources().getDrawable(R.mipmap.ic_business_black_48dp))
                .placeholder(context.getResources().getDrawable(R.mipmap.ic_business_black_48dp)).into(imageView);
*/

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(EndActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
