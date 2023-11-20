package com.gweiland.Adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.icu.text.DecimalFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gweiland.Model.CoinInfoResponse;
import com.gweiland.Model.DataItem;
import com.gweiland.R;
import com.gweiland.Retrofit.RetrofitClient;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    private final List<DataItem> listdata;
    Context context;

    public MyListAdapter(Context context, List<DataItem> listdata) {
        this.context = context;
        this.listdata = listdata;

    }


    @NonNull
    @Override
    public MyListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.data_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.ViewHolder holder, int position) {
        position = holder.getAdapterPosition();
        DataItem item = listdata.get(position);
        Log.e("id", String.valueOf(item.getId()));
        fetchCryptoInfoById(item.getId(), holder.logo);





        holder.name.setText(item.getName());
        holder.symbol.setText(item.getSymbol());

        double priceValue = item.getQuote().getUSD().getPrice();

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        String formattedPrice = "$" + decimalFormat.format(priceValue);
        holder.priceUSD.setText(formattedPrice);


        double percentChangeValue = item.getQuote().getUSD().getPercentChange24h();

        String formattedPercentChange = String.format("%.2f %%", percentChangeValue);

        if (percentChangeValue < 0) {
            holder.change24hGraph.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(holder.change24hGraph.getContext(),R.color.red)));
            holder.changeUSD.setTextColor(ContextCompat.getColor(holder.changeUSD.getContext(), R.color.red));
        } else  {
            holder.change24hGraph.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(holder.change24hGraph.getContext(),R.color.green)));

            holder.changeUSD.setTextColor(ContextCompat.getColor(holder.changeUSD.getContext(), R.color.green));
        }
        int finalPosition = position;
        holder.list_data.setOnClickListener(view -> Toast.makeText(view.getContext(), "click on item: " + listdata.get(finalPosition).getName(), Toast.LENGTH_LONG).show());
    }


    public void fetchCryptoInfoById(int id, CircleImageView logoImageView) {

        String api = "979e5d13-c1b1-4f0e-a59f-951515b3e0ab";

        Call<CoinInfoResponse> apiCalling = RetrofitClient.getmClient().getApi().SymbolREsponse(api, id);

        apiCalling.enqueue(new Callback<CoinInfoResponse>() {
            @Override
            public void onResponse(Call<CoinInfoResponse> call, Response<CoinInfoResponse> response) {
                Log.e("logo","r"+response.code()+response.message());
                if (response.isSuccessful() && response.code() == 200) {

                    CoinInfoResponse coinInfoResponse = response.body();
                    if (coinInfoResponse != null) {

                        String logoUrl = coinInfoResponse.getData().get(String.valueOf(id)).getUrls().getLogo();
                        // Use Glide to load the logo into your CircleImageView
                        Glide.with(context)
                                .load(logoUrl)
                                .placeholder(R.drawable.placeholder) // You can set a placeholder image
                                .into(logoImageView);
                    }
                }
            }

            @Override
            public void onFailure(Call<CoinInfoResponse> call, Throwable t) {
                Log.e("response", t.getMessage());
            }
        });
    }



    @Override
    public int getItemCount() {
        Log.d("getItemCount", "size: " + listdata.size());
        return listdata.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView logo;
        TextView name, symbol, priceUSD, changeUSD;
        ImageView change24hGraph;
        ConstraintLayout list_data;

        public ViewHolder(View itemView) {
            super(itemView);
            this.logo = itemView.findViewById(R.id.logo);
            this.name = itemView.findViewById(R.id.name);
            this.symbol = itemView.findViewById(R.id.symbol);
            this.priceUSD = itemView.findViewById(R.id.priceUSD);
            this.changeUSD = itemView.findViewById(R.id.change24);
            this.change24hGraph = itemView.findViewById(R.id.graph);
            this.list_data = itemView.findViewById(R.id.layout_list);
        }
    }
}