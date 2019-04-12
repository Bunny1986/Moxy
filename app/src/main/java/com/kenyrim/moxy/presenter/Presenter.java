package com.kenyrim.moxy.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.kenyrim.moxy.RetroClient;
import com.kenyrim.moxy.interfaces.MyView;
import com.kenyrim.moxy.models.Datum;
import com.kenyrim.moxy.models.Example;
import com.kenyrim.moxy.service.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@InjectViewState
public class Presenter extends MvpPresenter<MyView> {
    ArrayList<Datum> contactList = new ArrayList<>();

    public Presenter() {
        ApiService api = RetroClient.getApiService();

        Call<Example> call = api.getMyJSON();

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call,Response<Example> response) {


                if(response.isSuccessful()) {

                    assert response.body() != null;
                    contactList = (ArrayList<Datum>) response.body().getData();

                    getViewState().showList(contactList);
                    getViewState().showPicture(contactList.get(1).getData().getUrl()
                            ,contactList.get(1).getData().getText());
                    getViewState().showText(contactList.get(0).getData().getText());

                } else { Log.e("","Ups");}

            }

            @Override
            public void onFailure(Call<Example> call,Throwable t) {
                Log.e("",t.getMessage());
            }
        });

    }

}