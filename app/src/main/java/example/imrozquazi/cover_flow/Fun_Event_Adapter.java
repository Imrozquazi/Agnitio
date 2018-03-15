package example.imrozquazi.cover_flow;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Imroz Quazi on 15-03-2018.
 */

public class Fun_Event_Adapter extends BaseAdapter{

    private List<Fun_Event_1> FunEvent1List;
    private Context mcontext;

    public Fun_Event_Adapter(List<Fun_Event_1> FunEvent1List, Context mcontext) {
        this.FunEvent1List = FunEvent1List;
        this.mcontext = mcontext;
    }

    @Override
    public int getCount() {
        return FunEvent1List.size();

    }

    @Override
    public Object getItem(int position)
    {
        return FunEvent1List.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View rowView = view;

        if(rowView == null)
        {
            rowView = LayoutInflater.from(mcontext).inflate(R.layout.layout_item,null);

            TextView name = (TextView) rowView.findViewById(R.id.label);

            ImageView image = (ImageView) rowView.findViewById(R.id.image);


            Picasso.with(mcontext).load(FunEvent1List.get(position).getPathofimage()).into(image);
            name.setText(FunEvent1List.get(position).getName());
        }
        return  rowView;
    }
}
