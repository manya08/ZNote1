package com.example.wzbc.znote2;

import android.support.v4.app.Fragment;

import com.example.wzbc.znote2.fragments.MyNoteFragment;


/**
 * Created by WZBC on 2018/4/11.
 */

public class MyNoteActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        long id =getIntent().getLongExtra("id",0);
        return  MyNoteFragment.NewInstance(id);
    }
}
