package uk.co.sample.recyclerview;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.VH> {

    // Class that holds the actual data we want to keep track of
    static class MyData {
        boolean TextVisible = true;
        String Text;

        MyData(String text) {
            Text = text;
        }
    }

    // Class that holds the Views. So that's why it is called a ViewHolder!!
    class VH extends RecyclerView.ViewHolder {

        Button button;
        TextView text;

        VH(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button);
            text = itemView.findViewById(R.id.text1);
        }
    }

    List<MyData> items = new ArrayList<>(); // List of items to display

    TestAdapter() {
    }

    @Override
    public TestAdapter.VH onCreateViewHolder(ViewGroup parent, int viewType) {
        // Called when we need a new View
        return new VH((
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.test_layout, parent, false))
        );
    }

    @Override
    public void onBindViewHolder(final TestAdapter.VH holder, final int position) {
        // Called every time we need to bind data to a view.
        // i.e When displaying for the first time or after notifyItemChanged is called.
        final MyData itm = items.get(position);

        holder.button.setText((itm.TextVisible ? "Hide ": "Show ") + itm.Text);
        holder.text.setVisibility(itm.TextVisible ? View.VISIBLE : View.INVISIBLE);
        holder.text.setText(itm.Text);

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itm.TextVisible = !itm.TextVisible;
                notifyItemChanged(holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}