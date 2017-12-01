package io.github.alupa.seccion_07_toolbar_tabs_lab.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import io.github.alupa.seccion_07_toolbar_tabs_lab.Models.Person;
import io.github.alupa.seccion_07_toolbar_tabs_lab.R;

/**
 * Created by Alvaro on 26-10-2017.
 */

public class PersonAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Person> persons;

    public PersonAdapter(Context context, int layout, List<Person> persons) {
        this.context = context;
        this.layout = layout;
        this.persons = persons;
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Person getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(layout, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.textViewPersonName);
            holder.country = (TextView) convertView.findViewById(R.id.textViewPersonCountry);
            holder.image = (ImageView) convertView.findViewById(R.id.imageViewFlag);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Person currentPerson = getItem(position);

        holder.name.setText(currentPerson.getName());
        holder.country.setText(currentPerson.getCountry().getName());
        String url = currentPerson.getCountry().getFlagURL();
        Picasso.with(context).load(url).into(holder.image);

        return convertView;
    }

    static class ViewHolder {
        private TextView name;
        private TextView country;
        private ImageView image;
    }
}
