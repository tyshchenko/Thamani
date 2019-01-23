package com.project.thamani.adapter;

/**
 * Created by ravi on 20/02/18.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.thamani.R;
import com.project.thamani.model.Note;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OfflineAdapter extends RecyclerView.Adapter<OfflineAdapter.MyViewHolder> {

    private Context context;
    private List<Note> notesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView product,items,price,code;


        public MyViewHolder(View view) {
            super(view);
            product = view.findViewById(R.id.product);
            items = view.findViewById(R.id.itemss);
            price = view.findViewById(R.id.price);
            code = view.findViewById(R.id.code);
        }
    }


    public OfflineAdapter(Context context, List<Note> notesList) {
        this.context = context;
        this.notesList = notesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.offline_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Note note = notesList.get(position);

        holder.product.setText(note.getItem());

        // Displaying dot from HTML character code
        holder.code.setText("#"+note.getGTIN());

        holder.items.setText("1x1");

//        double prices=Double.parseDouble(note.getPrice());
//        double itemss=Double.parseDouble(note.getItems());
//        double tprice=itemss*prices;

//        String final_price=Double.toString(tprice);

        holder.price.setText("Ksh."+note.getPrice());


    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    /**
     * Formatting timestamp to `MMM d` format
     * Input: 2018-02-21 00:15:42
     * Output: Feb 21
     */
    private String formatDate(String dateStr) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtOut = new SimpleDateFormat("MMM d");
            return fmtOut.format(date);
        } catch (ParseException e) {

        }

        return "";
    }
}
