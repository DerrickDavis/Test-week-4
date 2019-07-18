package com.example.samsungct;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samsungct.model.picsource.SamsungApp;
import com.squareup.picasso.Picasso;


import java.util.List;



public class rvAdaptr extends RecyclerView.Adapter<rvAdaptr.MVH> {

    private Context mContx;
    private List<SamsungApp> mpicDat;

    public rvAdaptr(Context mContx, List<SamsungApp> mpicDat) {
        this.mContx = mContx;
        this.mpicDat = mpicDat;
    }


    @NonNull
    @Override
    public MVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vw;
        LayoutInflater mInflate= LayoutInflater.from(mContx);
        vw = mInflate.inflate(R.layout.item_cardview,parent,false);

        return new MVH(vw);
    }

    @Override
    public void onBindViewHolder(@NonNull MVH holder, int position) {

        holder.tv_photDes.setText(mpicDat.get(position).getTitle());
        String x = mpicDat.get(position).getThumbnailUrl();
        Picasso.get()
                .load(x)
                .resize(100,100)
                .into(holder.iv_imgPlc);

    }


    @Override
    public int getItemCount() {
        return mpicDat.size();
    }


    public static class MVH extends RecyclerView.ViewHolder {

        TextView tv_photDes;
        ImageView iv_imgPlc;

        public MVH(@NonNull View itmVw) {
            super(itmVw);

            tv_photDes = itmVw.findViewById(R.id.tvimage_des);
            iv_imgPlc = itmVw.findViewById(R.id.iv_albmpic);
        }
    }
}
