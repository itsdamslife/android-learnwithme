package com.itscoderslife.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.itscoderslife.helloworld.dummy.DummyContent;

import java.util.List;

public class MainActivity extends AppCompatActivity
    implements blogpostsFragment.OnListFragmentInteractionListener {

    public static final String EXTRA_MSG = "com.itscoderslife.helloworld.MSG";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
//        mLayoutManager = new GridLayoutManager(this);  // Next will do either Card Layout or Grid Layout!! Thanks for watching!
        mRecyclerView.setLayoutManager(mLayoutManager);


        List<DummyContent.DummyItem> myDataset = DummyContent.ITEMS;


        // specify an adapter (see also next example)
        mAdapter = new MyblogpostsRecyclerViewAdapter(myDataset, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Intent displayMsgIntent = new Intent(this, DisplayMessageActivity.class);
        displayMsgIntent.putExtra(EXTRA_MSG, item.content);
        startActivity(displayMsgIntent);
    }

//    public void sendMessage(View view) {
//        Intent displayMsgIntent = new Intent(this, DisplayMessageActivity.class);
//        EditText editText =  (EditText) findViewById(R.id.editText);
//        String msg = editText.getText().toString();
//        displayMsgIntent.putExtra(EXTRA_MSG, msg);
//        startActivity(displayMsgIntent);
//    }
}
