package com.jetec.recyclerviewmixitemexample;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jetec.recyclerviewmixitemexample.RecyclerItemViewHolder.A_TypeMyView;
import com.jetec.recyclerviewmixitemexample.RecyclerItemViewHolder.B_TypeMyView;
import com.jetec.recyclerviewmixitemexample.RecyclerItemViewHolder.MyViewHolders;

import java.util.ArrayList;
import java.util.HashMap;

class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<HashMap<String,String>> arrayList;
    public OnTransClick onItemClick;
    public MyRecyclerViewAdapter(ArrayList<HashMap<String,String>> arrayList) {
        this.arrayList = arrayList;
    }
    /**設置將資料傳回Activity的接口*/
    public void setOnTransButtonClick(OnTransClick onItemClick){
        this.onItemClick = onItemClick;
    }
    /**取得每個item內的"VIEW_TYPE"*/
    @Override
    public int getItemViewType(int position) {
        int getType = Integer.parseInt(arrayList.get(position).get("VIEW_TYPE"));
        return getType;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /**在上面的"getItemViewType"中取得的
         * @see viewType
         * 為基準，判斷每個item需使用哪個介面*/
        if (viewType == 1) {
            return new B_TypeMyView(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.b_type_item, parent, false));
        } else {
            return new A_TypeMyView(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.a_type_item, parent, false));
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        /**將holder強制轉型為"MyViewHolders"類別，使介面Ａ/Ｂ都可以獲得onBindViewHolder內容*/
        ((MyViewHolders) holder).bindViewHolder(arrayList.get(position));
        /**判斷該item的介面是處於哪一個介面*/
        if (holder instanceof A_TypeMyView){
            //你可以試著為他加入點擊事件～
        }else if (holder instanceof B_TypeMyView){
            B_TypeMyView bTypeMyView = (B_TypeMyView) holder;
            /**設置翻譯按鈕的點擊事件*/
            bTypeMyView.btTrans.setOnClickListener(v->{
                onItemClick.OnTransButtonClick(arrayList.get(position));
            });
        }
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    /**設置點擊方法，使點擊後取得到的內容能傳回MainActivity*/
    public interface OnTransClick{
        void OnTransButtonClick(HashMap<String,String> hashMap);
    }
}
