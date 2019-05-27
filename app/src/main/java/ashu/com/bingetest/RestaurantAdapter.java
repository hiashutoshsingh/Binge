package ashu.com.bingetest;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    ArrayList<RestaurantItemModel> list;
    Context context;

    public RestaurantAdapter(ArrayList<RestaurantItemModel> list, Context context) {
        this.list=list;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(context).inflate(R.layout.restaurant_item_layout,parent, false);
        final ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RestaurantDetailActivity.class);
                intent.putExtra("position",viewHolder.getAdapterPosition()+1);
                context.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        viewHolder.txt_res_name.setText(list.get(position).getFire_res_name());
        viewHolder.txt_res_type.setText(list.get(position).getFire_res_type());
        viewHolder.txt_res_rating.setText(list.get(position).getFire_res_rating());
        viewHolder.text_res_price.setText(list.get(position).getFire_res_price());
        Picasso.get().load(list.get(position).getFire_res_img()).placeholder(R.drawable.ic_launcher_foreground)
                .into(viewHolder.img_res);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_res_name;
        ImageView img_res;
        TextView txt_res_type;
        TextView txt_res_rating;
        TextView text_res_price;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txt_res_name = (TextView) itemLayoutView.findViewById(R.id.id_res_name);
            img_res = (ImageView) itemLayoutView.findViewById(R.id.id_res_image);
            text_res_price=(TextView)itemLayoutView.findViewById(R.id.id_res_price);
            txt_res_rating=(TextView)itemLayoutView.findViewById(R.id.id_res_rating);
            txt_res_type=(TextView)itemLayoutView.findViewById(R.id.id_res_type);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(context, RestaurantDetailActivity.class);
//                    context.startActivity(intent);
//                }
//            });
        }
    }
}
