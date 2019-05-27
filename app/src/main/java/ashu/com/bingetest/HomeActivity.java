package ashu.com.bingetest;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    ArrayList<RestrauntItemModel> list;
    RestrauntAdapter restrauntAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_restraunts);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        databaseReference = FirebaseDatabase.getInstance().getReference().child("res_list");
        databaseReference.keepSynced(true);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list = new ArrayList<RestrauntItemModel>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    RestrauntItemModel value = dataSnapshot1.getValue(RestrauntItemModel.class);
                    list.add(value);
                }
                restrauntAdapter = new RestrauntAdapter(list, HomeActivity.this);
                recyclerView.setAdapter(restrauntAdapter);
                restrauntAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"Error "+ databaseError,Toast.LENGTH_SHORT).show();
            }
        });
    }
}