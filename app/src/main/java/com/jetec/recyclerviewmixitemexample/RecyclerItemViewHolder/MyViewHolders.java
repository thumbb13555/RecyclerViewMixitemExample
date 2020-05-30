package com.jetec.recyclerviewmixitemexample.RecyclerItemViewHolder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;

public abstract class MyViewHolders extends RecyclerView.ViewHolder {
    public MyViewHolders(@NonNull View itemView) {
        super(itemView);
    }
    /**建立抽象類別，並使onBindViewHolder可分別綁定到介面Ａ與介面Ｂ*/
    public abstract void bindViewHolder(HashMap<String,String> hashMap);
}
