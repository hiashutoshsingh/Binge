package ashu.com.bingetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RestrauntDetailActivity extends AppCompatActivity {

    DatabaseReference databaseReference,db;
    ArrayList<MenuItemModel> list;
    MenuItemAdapter menuItemAdapter;
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

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                final String str_video = dataSnapshot.getValue().toString();
                FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(RestrauntDetailActivity.this, VideoAct.class);
                        intent.putExtra("video",str_video);
                        startActivity(intent);
                    }
                });
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

                menuItemAdapter = new MenuItemAdapter(list, RestrauntDetailActivity.this);
                recyclerView.setAdapter(menuItemAdapter);
                menuItemAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"Error "+ databaseError,Toast.LENGTH_SHORT).show();
            }
        });


    }


}
