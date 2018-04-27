package com.example.wzbc.znote2.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.wzbc.znote2.MyNoteActivity;
import com.example.wzbc.znote2.R;
import com.example.wzbc.znote2.dbo.GetData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by WZBC on 2018/4/9.
 */

public class NotesListFragment extends ListFragment {
    private OnNoteClickListener listener;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            listener = (OnNoteClickListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SimpleAdapter adapter =new SimpleAdapter(getActivity(), GetData.getMyData(), R.layout.note_list_item,
                new String[]{"title","info","data"},
                new int[]{R.id.title,R.id.info,R.id.date});
        setListAdapter(adapter);
    }



    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        listener.onItemClick(id);
//        Intent intent =new Intent();
//        intent.setClass(getActivity(),MyNoteActivity.class);
//        intent.putExtra("id",id);
//        startActivity(intent);
    }
}
