package com.example.wzbc.znote2.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.wzbc.znote2.R;

import java.util.List;
import java.util.Map;

import com.example.wzbc.znote2.dbo.GetData;
import com.example.wzbc.znote2.sqlite3.NotesDao;

/**
 * Created by WZBC on 2018/4/11.
 */

public class MyNoteFragment extends Fragment implements View.OnClickListener {
    private  View mview;
    private  long id;
    private  EditText summaryEditText;
    private  EditText contentEditText;
    public static MyNoteFragment NewInstance(long id){
        Bundle bundle =new Bundle();
        bundle.putLong("id",id);
        MyNoteFragment fragment =new MyNoteFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id =getArguments().getLong("id");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mview=inflater.inflate(R.layout.note,container,false);
        summaryEditText =(EditText)mview.findViewById(R.id.note_name);
        contentEditText =(EditText)mview.findViewById(R.id.nate_data);

        List<Map<String,Object>> list = GetData.getMyData();
        summaryEditText.setText((String)list.get((int)id).get("title"));
        contentEditText.setText((String)list.get((int)id).get("info"));
//        saveButton.setOnClickListener(this);
//        cancelButton.setOnClickListener(this);
        return mview;
    }
    public long getCurrentItemid(){
        return  id;
    }

    @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            mview.findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NotesDao dao= new NotesDao(getActivity());
                    dao.open();
                    dao.insertNote(summaryEditText.getText().toString(),contentEditText.getText().toString());
                    dao.close();
                }
            });
        }

    @Override
    public void onClick(View v) {

    }
    public  void setOnClickListener(){

    }
}
