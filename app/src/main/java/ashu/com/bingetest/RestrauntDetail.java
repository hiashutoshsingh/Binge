package ashu.com.bingetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class RestrauntDetail extends AppCompatActivity {

    DatabaseReference databaseReference,db;
    ArrayList<MenuItemModel> list;
    MenuItemsAdapter menuItemsAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restraunt_detail);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_restrauntDetail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        databaseReference = FirebaseDatabase.getInstance().getReference().child("res_list").child("1").child("menu");
        db = FirebaseDatabase.getInstance().getReference().child("res_list").child("1").child("video");
        databaseReference.keepSynced(true);
       // Query query = databaseReference.child("menu").orderByChild("1");
        //Log.d("ashu","video "+ FirebaseDatabase.getInstance().getReference().child("res_list").child("1").child("video").getKey());




        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                final String str_video = dataSnapshot.getValue().toString();
                FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(RestrauntDetail.this, VideoAct.class);
                        intent.putExtra("video",str_video);
                        startActivity(intent);
                    }
                });
                Toast.makeText(RestrauntDetail.this,"-----"+ str_video,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list = new ArrayList<MenuItemModel>();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    MenuItemModel value = dataSnapshot1.getValue(MenuItemModel.class);
                    list.add(value);

                }

                menuItemsAdapter = new MenuItemsAdapter(list,RestrauntDetail.this);
                recyclerView.setAdapter(menuItemsAdapter);
                menuItemsAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"Error "+ databaseError,Toast.LENGTH_SHORT).show();
            }
        });


    }


}
