package ashu.com.bingetest;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RestrauntAdapter extends RecyclerView.Adapter<RestrauntAdapter.ViewHolder> {
    private ItemData[] itemsData;

    public RestrauntAdapter(ItemData[] itemsData) {
        this.itemsData = itemsData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, null);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.txt_res_name.setText(itemsData[position].getRes_name());
        viewHolder.img_res.setImageResource(itemsData[position].getRes_image());
        viewHolder.txt_res_type.setText(itemsData[position].getRes_type());
        viewHolder.txt_res_rating.setText(itemsData[position].getRes_rating());
        viewHolder.text_res_price.setText(itemsData[position].getRes_cost());

    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

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

    @Override
    public int getItemCount() {
        return itemsData.length;
    }
}
