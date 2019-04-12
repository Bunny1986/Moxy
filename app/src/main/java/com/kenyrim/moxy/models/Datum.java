package com.kenyrim.moxy.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

@SerializedName("name")
@Expose
private String name;
@SerializedName("data")
@Expose
private Data data;


    public Datum(String name,Data data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Data getData() {
return data;
}

public void setData(Data data) {
this.data = data;
}

}
