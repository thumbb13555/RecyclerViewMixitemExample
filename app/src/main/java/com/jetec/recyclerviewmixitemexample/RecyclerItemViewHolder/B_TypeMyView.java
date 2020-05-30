package com.jetec.recyclerviewmixitemexample.RecyclerItemViewHolder;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.jetec.recyclerviewmixitemexample.R;

import java.util.HashMap;

public class B_TypeMyView extends MyViewHolders {

    public Button btTrans;
    public TextView tvShow;

    public B_TypeMyView(@NonNull View itemView) {
        super(itemView);
        btTrans = itemView.findViewById(R.id.button_GetChinese);
        tvShow = itemView.findViewById(R.id.textView_Word);
    }
    /**將資料綁到介面Ｂ的內容*/
    @Override
    public void bindViewHolder(HashMap<String, String> hashMap) {
        tvShow.setText(hashMap.get("ENGLISH"));
    }
}
