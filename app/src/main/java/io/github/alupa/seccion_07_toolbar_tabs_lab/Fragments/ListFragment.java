package io.github.alupa.seccion_07_toolbar_tabs_lab.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.github.alupa.seccion_07_toolbar_tabs_lab.Adapters.PersonAdapter;
import io.github.alupa.seccion_07_toolbar_tabs_lab.Models.Person;
import io.github.alupa.seccion_07_toolbar_tabs_lab.R;

public class ListFragment extends Fragment {

    private List<Person> persons;
    private ListView listView;
    private PersonAdapter adapter;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        persons = new ArrayList<Person>();
        listView = (ListView) view.findViewById(R.id.listViewPerson);
        adapter = new PersonAdapter(getContext(), R.layout.list_view_item_person, persons);
        listView.setAdapter(adapter);

        return view;
    }

    public void AddPerson(Person person){
        persons.add(person);
        adapter.notifyDataSetChanged();
    }


}
