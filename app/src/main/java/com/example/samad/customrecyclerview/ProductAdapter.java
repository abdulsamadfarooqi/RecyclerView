package com.example.samad.customrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter <ProductAdapter.ProductViewHolder> {

    private Context mcontext;
    private String[] mData = new String[0];

    public ProductAdapter(Context mcontext, List<Product> productlist) {
        this.mcontext = mcontext;
        this.productlist = productlist;
    }

    private List<Product> productlist ;

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        View view = inflater.inflate(R.layout.list_layout,null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productlist.get(position);

        holder.textView.setText(product.getDescription());
        holder.imageView.setImageDrawable(mcontext.getResources().getDrawable(product.getImage()));

    }

    @Override
    public int getItemCount() {
        return productlist.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView imageView;
        TextView textView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener( this);
            imageView = itemView.findViewById(R.id.imageview);
            textView = itemView.findViewById(R.id.txt);
        }


        @Override
        public void onClick(View view) {

            Intent i=new Intent(mcontext,DetailActivity.class);
            imageView.buildDrawingCache();
            Bitmap image= imageView.getDrawingCache();
            Bundle mBundle = new Bundle();
            mBundle.putParcelable("Browser Image", image);
            String str=textView.getText().toString();
            i.putExtras(mBundle);
            i.putExtra("Browser Name",str);
            mcontext.startActivity(i);
        }
    }

}