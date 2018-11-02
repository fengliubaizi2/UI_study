package com.mean.ui.RV.qq;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.view.Menu;
import android.view.MenuItem;

import com.mean.ui.R;

public class QQActivity extends Activity implements StartDragListener{

	private RecyclerView recyclerview;
	private ItemTouchHelper itemTouchHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_swipe_card);
		recyclerview = (RecyclerView)findViewById(R.id.rv);
		List<QQMessage> list = DataUtils.init();
			
		
		MessageAdapter adapter = new MessageAdapter(list,this);
		recyclerview.setLayoutManager(new LinearLayoutManager(this));
//		recyclerview.addItemDecoration(new DividerItemDecoration(this));
		recyclerview.setAdapter(adapter);
		Callback callback = new MessageItemTouchCallback(adapter);
		Callback callback2 = new MyTouchCallback(adapter,list,this);
		itemTouchHelper = new ItemTouchHelper(callback2);
		itemTouchHelper.attachToRecyclerView(recyclerview);

	}

	@Override
	public void onStartDrag(ViewHolder viewHolder) {
		itemTouchHelper.startDrag(viewHolder);
	}

}
