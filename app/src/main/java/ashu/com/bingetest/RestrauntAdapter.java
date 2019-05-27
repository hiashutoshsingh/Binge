package ashu.com.bingetest;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RestrauntAdapter extends RecyclerView.Adapter<RestrauntAdapter.ViewHolder> {

    ArrayList<ItemData> list;
    Context context;

    public RestrauntAdapter(ArrayList<ItemData> list, Context context) {
        this.list=list;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(context).inflate(R.layout.item_layout,parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        viewHolder.txt_res_name.setText(list.get(position).getFire_res_name());
        viewHolder.txt_res_type.setText(list.get(position).getFire_res_type());
        viewHolder.txt_res_rating.setText(list.get(position).getFire_res_rating());
        viewHolder.text_res_price.setText(list.get(position).getFire_res_cost());
        Picasso.get().load(list.get(position).getFire_res_image()).into(viewHolder.img_res);

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
        }
    }
}
