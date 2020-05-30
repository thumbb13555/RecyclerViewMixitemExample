package com.jetec.recyclerviewmixitemexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        /**設置recyclerView有分隔線*/
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        MyRecyclerViewAdapter mAdapter = new MyRecyclerViewAdapter(makeData());
        recyclerView.setAdapter(mAdapter);
        /**從MyRecyclerViewAdapter取得資料的點擊事件*/
        mAdapter.setOnTransButtonClick(hashMap -> {
            String getTrans = hashMap.get("CHINESE");
            Toast.makeText(this, getTrans, Toast.LENGTH_SHORT).show();
        });//Click
    }
    /**製作單字資料*/
    private ArrayList<HashMap<String,String>> makeData(){
        ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
        String[] vocabulary = {"#A","aptitude","apprentice"
                ,"#B","bilingual","banquet"
                ,"#C","credential","coordinator","contain","continued"
                ,"#D","distributor","deviate"
                ,"#E","enhancement","election","engrave","excess"
                ,"#F","factor"};
        String[] chinese = {"#A","才能、資質","實習生"
                ,"#B","雙語的","宴會"
                ,"#C","證書","協調者","包含","持續的"
                ,"#D","分配者、分銷商","偏離"
                ,"#E"," 提升、改善","選舉","雕刻","超量"
                ,"#F","要素"};
        for (int i = 0; i < vocabulary.length; i++) {
            HashMap<String,String> hashMap = new HashMap<>();
            if (vocabulary[i].charAt(0) == '#'){
                hashMap.put("ENGLISH",vocabulary[i].replace("#",""));
                hashMap.put("CHINESE","--");
                hashMap.put("VIEW_TYPE","0");
            }else{
                hashMap.put("ENGLISH",vocabulary[i]);
                hashMap.put("CHINESE",chinese[i]);
                hashMap.put("VIEW_TYPE","1");
            }
            arrayList.add(hashMap);
        }
        return arrayList;
    }//makeData
}