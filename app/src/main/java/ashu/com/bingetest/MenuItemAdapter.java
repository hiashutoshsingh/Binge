package ashu.com.bingetest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemAdapter.MenuItemHolder> {

    ArrayList<MenuItemModel> list;
    Context context;

    public MenuItemAdapter(ArrayList<MenuItemModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MenuItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLayoutView = LayoutInflater.from(context).inflate(R.layout.menu_item_layout,viewGroup, false);
        MenuItemHolder viewHolder = new MenuItemHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuItemHolder menuItemHolder, int i) {

        menuItemHolder.txt_menu_item.setText(list.get(i).getMenu_item());
        menuItemHolder.txt_menu_item_price.setText(list.get(i).getMenu_cost());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MenuItemHolder extends RecyclerView.ViewHolder{

            TextView txt_menu_item;
            TextView txt_menu_item_price;

        public MenuItemHolder(@NonNull View itemView) {
            super(itemView);

            txt_menu_item =(TextView)itemView.findViewById(R.id.id_menu_item_name);
            txt_menu_item_price=(TextView)itemView.findViewById(R.id.id_menu_item_cost);
        }
    }
}
