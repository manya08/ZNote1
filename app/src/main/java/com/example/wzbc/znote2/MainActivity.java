package com.example.wzbc.znote2;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.wzbc.znote2.fragments.MyNoteFragment;
import com.example.wzbc.znote2.fragments.OnNoteClickListener;


public class MainActivity extends AppCompatActivity implements OnNoteClickListener {
    private boolean mDualPane;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes);
        View mNoteFrame =findViewById(R.id.note_detail);
        mDualPane =mNoteFrame !=null
                && mNoteFrame.getVisibility()==View.VISIBLE;
        if(mDualPane){
            showNote(0);
        }
    }
    private void showNote(long id){
        MyNoteFragment myNoteFragment =(MyNoteFragment) getSupportFragmentManager()
                .findFragmentById(R.id.note_detail);
        if(myNoteFragment == null ||myNoteFragment.getCurrentItemid() !=id){
            myNoteFragment =MyNoteFragment.NewInstance(id);
            FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.note_detail,myNoteFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack("aa");
            ft.commit();
        }
    }

    @Override
    public void onItemClick(long id) {
    if (mDualPane){
        showNote(id);
    }else{
        Intent intent =new Intent();
        intent.setClass(MainActivity.this,MyNoteActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }
    }
}
