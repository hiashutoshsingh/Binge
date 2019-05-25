package ashu.com.bingetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ListRestraunts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_restraunts);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        ItemData itemsData[] = {
                new ItemData("Restro-1","North India","Rs 200","* 4.0",R.drawable.ic_launcher_foreground),
                new ItemData("Restro-2","North India","Rs 200","* 4.0",R.drawable.ic_launcher_foreground),
                new ItemData("Restro-3","North India","Rs 200","* 4.0",R.drawable.ic_launcher_foreground),
                new ItemData("Restro-4","North India","Rs 200","* 4.0",R.drawable.ic_launcher_foreground),
                new ItemData("Restro-5","North India","Rs 200","* 4.0",R.drawable.ic_launcher_foreground),
                new ItemData("Restro-6","North India","Rs 200","* 4.0",R.drawable.ic_launcher_foreground),
                new ItemData("Restro-7","North India","Rs 200","* 4.0",R.drawable.ic_launcher_foreground),
                new ItemData("Restro-8","North India","Rs 200","* 4.0",R.drawable.ic_launcher_foreground),
                new ItemData("Restro-9","North India","Rs 200","* 4.0",R.drawable.ic_launcher_foreground),
                new ItemData("Restro-10","North India","Rs 200","* 4.0",R.drawable.ic_launcher_foreground),
                new ItemData("Restro-11","North India","Rs 200","* 4.0",R.drawable.ic_launcher_foreground),
                new ItemData("Restro-12","North India","Rs 200","* 4.0",R.drawable.ic_launcher_foreground),

        };



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RestrauntAdapter mAdapter = new RestrauntAdapter(itemsData);
        recyclerView.setAdapter(mAdapter);
    }
}
