package com.gweiland;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gweiland.Adapter.MyListAdapter;
import com.gweiland.Model.DataItem;
import com.gweiland.Model.Data_Response;
import com.gweiland.Retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Crypto_Fragment extends Fragment {

    TextView textView;
    List<DataItem> data = new ArrayList<>();
    RecyclerView recyclerView;
    MyListAdapter myListAdapter;
    boolean isLoading = false;
    int currentPage =1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         recyclerView =(RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        myListAdapter = new MyListAdapter(getContext(),data);
        recyclerView.setAdapter(myListAdapter);
        ApiCalling("market_cap");

        Log.e("onCreated","onCreated");
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

                // Check if the user has reached the end of the list and not currently loading more data
                if (!isLoading && (visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0) {
                    // Load more data
                    ApiCalling("market_cap");
                }
            }
        });



    }


    public void ApiCalling(String sort) {
        isLoading = true;
        String api = "979e5d13-c1b1-4f0e-a59f-951515b3e0ab";
        Call<Data_Response> apiCalling = RetrofitClient.getmClient().getApi().ListingsLatest(api, currentPage, 100,sort);
        apiCalling.enqueue(new Callback<Data_Response>() {
            @Override
            public void onResponse(Call<Data_Response> call, Response<Data_Response> response) {
                if (response.isSuccessful() && response.code() == 200) {

                    data.addAll(response.body().getData());
                    myListAdapter.notifyDataSetChanged();
                    currentPage++; // Increment the page for the next request

                    // ... other code
                }
                isLoading = false;
            }

            @Override
            public void onFailure(Call<Data_Response> call, Throwable t) {
                Log.e("response", t.getMessage());
                isLoading = false;
            }
        });
    }


}
