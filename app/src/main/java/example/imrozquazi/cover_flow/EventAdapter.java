package example.imrozquazi.cover_flow;

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
 * Created by Imroz Quazi on 26-01-2018.
 */

public class EventAdapter extends BaseAdapter {

    private List<Event> EventList;
    private Context mcontext;

    public EventAdapter(List<Event> eventList, Context mcontext) {
        EventList = eventList;
        this.mcontext = mcontext;
    }

    @Override
    public int getCount() {
        return EventList.size();

    }

    @Override
    public Object getItem(int position)
    {
        return EventList.get(position);
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


            Picasso.with(mcontext).load(EventList.get(position).getPathofimage()).into(image);
            name.setText(EventList.get(position).getName());
        }
            return  rowView;
    }
}
