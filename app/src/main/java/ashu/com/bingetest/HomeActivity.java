package ashu.com.bingetest;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    ArrayList<RestaurantItemModel> list;
    RestaurantAdapter restaurantAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_restaurant);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        databaseReference = FirebaseDatabase.getInstance().getReference().child("res_list");
        databaseReference.keepSynced(true);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list = new ArrayList<RestaurantItemModel>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    RestaurantItemModel value = dataSnapshot1.getValue(RestaurantItemModel.class);
                    list.add(value);
                }
                restaurantAdapter = new RestaurantAdapter(list, HomeActivity.this);
                recyclerView.setAdapter(restaurantAdapter);
                restaurantAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"Error "+ databaseError,Toast.LENGTH_SHORT).show();
            }
        });
    }
}