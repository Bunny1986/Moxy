package com.kenyrim.moxy;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.arellomobile.mvp.presenter.InjectPresenter;
import com.kenyrim.moxy.adapters.MyContactAdapter;
import com.kenyrim.moxy.interfaces.MyView;
import com.kenyrim.moxy.models.Datum;
import com.kenyrim.moxy.mvp.MvpAppCompatActivity;
import com.kenyrim.moxy.presenter.Presenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;



public class MainActivity extends MvpAppCompatActivity implements MyView {

    private ListView listView;
    private ImageView imageView;
    Context context;

    private ArrayList<Datum> contactList = new ArrayList<>();
    private MyContactAdapter adapter;

    @InjectPresenter
    Presenter presenter;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        //contactList = new ArrayList<>();

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        Log.e("MainActivity", "onCreate");

        listView = findViewById(R.id.listView);

    }

    @Override
    public void showList(ArrayList<Datum> arrayList) {
        adapter = new MyContactAdapter(MainActivity.this, arrayList);
        listView.setAdapter(adapter);
    }

    @Override
    public void showPicture(String url,final String name) {
        Picasso.with(context).load(url).into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,name,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showText(String text) {
        textView.setText(text);
    }

}
