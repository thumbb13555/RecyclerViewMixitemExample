package com.jetec.recyclerviewmixitemexample.RecyclerItemViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.jetec.recyclerviewmixitemexample.R;

import java.util.HashMap;

public class A_TypeMyView extends MyViewHolders {
    public TextView tvTitle;

    public A_TypeMyView(@NonNull View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.textView_ATItle);

    }
    /**將資料綁到介面Ａ的內容*/
    @Override
    public void bindViewHolder(HashMap<String, String> hashMap) {
        tvTitle.setText(hashMap.get("ENGLISH"));
    }
}
