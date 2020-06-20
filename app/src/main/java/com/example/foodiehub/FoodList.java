package com.example.foodiehub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import Interface.ItemClickListener;
import ViewHolder.FoodViewHolder;
import model.Food;

public class FoodList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference foodList;
    String categoryId ="";
    FirebaseRecyclerAdapter<Food, FoodViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        database = FirebaseDatabase.getInstance();
        foodList= database.getReference("Foods");

        recyclerView= (RecyclerView) findViewById(R.id.recycler_food);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        if(getIntent() !=null)
            categoryId = getIntent().getStringExtra("CategoryId");
            
        if (!categoryId.isEmpty() && categoryId !=null){
            //loadListFood(categoryId);
        }

    }

//    private void loadListFood(String categoryId) {
//        adapter = new FirebaseRecyclerAdapter<Food, FoodViewHolder>(Food.class,R.layout.food_item,FoodViewHolder.class,foodList.orderByChild("MenuId").equalTo(categoryId)) {
//            @Override
//            protected void populateViewHolder(FoodViewHolder viewHolder, Food model, int position) {
//                viewHolder.food_name.setText(model.getName());
//                Picasso.with(getBaseContext()).load(model.getImage()).into(viewHolder.food_image);
//
//                final Food local = model;
//                viewHolder.setItemClickListener(new ItemClickListener() {
//                    @Override
//                    public void onClick(View view, int position, boolean isLongClick) {
//                        Intent foodDetail = new Intent(FoodList.this,FoodDetail.class);
//                        foodDetail.putExtra("FoodId",adapter.getRef(position).getKey());
//                        startActivity(foodDetail);
//                    }
//                });
//
//
//
//
//            }
//
//
//
//            };
//        Log.d("Tag", ""+adapter.getItemCount());
//                recyclerView.setAdapter(adapter);
//    }




}