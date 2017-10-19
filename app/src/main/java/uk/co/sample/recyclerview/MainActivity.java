package uk.co.sample.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        RecyclerView list = findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));

        TestAdapter adp=new TestAdapter();

        for (int x = 0; x < 30; x++) {
            adp.items.add(new TestAdapter.MyData("Item " + x));
        }

        list.setAdapter(adp);

    }
}
