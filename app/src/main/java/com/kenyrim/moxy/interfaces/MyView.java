package com.kenyrim.moxy.interfaces;


import com.arellomobile.mvp.MvpView;
import com.kenyrim.moxy.models.Datum;

import java.util.ArrayList;

public interface MyView extends MvpView {
	void showList(ArrayList<Datum> arrayList);
	void showPicture(String url, String name);
	void showText(String text);
}