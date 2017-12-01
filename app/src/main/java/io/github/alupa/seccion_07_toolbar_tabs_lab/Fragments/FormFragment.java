package io.github.alupa.seccion_07_toolbar_tabs_lab.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import io.github.alupa.seccion_07_toolbar_tabs_lab.Interfaces.OnPersonCreated;
import io.github.alupa.seccion_07_toolbar_tabs_lab.Models.Country;
import io.github.alupa.seccion_07_toolbar_tabs_lab.Models.Person;
import io.github.alupa.seccion_07_toolbar_tabs_lab.R;
import io.github.alupa.seccion_07_toolbar_tabs_lab.Utils.Util;

public class FormFragment extends Fragment {

    private EditText editTextPerson;
    private Spinner spinnerCountry;
    private Button btnCreate;

    private List<Country> countries;

    private OnPersonCreated onPersonCreated;

    public FormFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form, container, false);

        editTextPerson = (EditText) view.findViewById(R.id.editTextName);
        spinnerCountry = (Spinner) view.findViewById(R.id.spinnerCountry);
        btnCreate = (Button) view.findViewById(R.id.buttonCreate);

        countries = Util.getCountries(getContext());

        // Creamos un ArrayAdapter para ser pasado a nuestro Spinner/DropDown/Lista despegable
        // Con un layout integrado en Android para su uso directo, llamado
        // simple_spinner_dropdown_item
        ArrayAdapter<Country> adapter = new ArrayAdapter<Country>(getContext(), android.R.layout.simple_spinner_dropdown_item, countries);
        spinnerCountry.setAdapter(adapter);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewPerson();
            }
        });

        return view;
    }

    private void createNewPerson() {
        if (!editTextPerson.getText().toString().isEmpty()){
            Country country = (Country) spinnerCountry.getSelectedItem();
            Person person = new Person(editTextPerson.getText().toString(), country);
            // Usamos la interfaz para comunicarnos con el MainActivity y éste con el otro fragment
            onPersonCreated.createPerson(person);
        }
    }

    // Eventos para enlazar el listener
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPersonCreated)
            onPersonCreated = (OnPersonCreated) context;
        else
            throw new RuntimeException(context.toString() + " must implement OnPersonCreated");
    }

    // Eventos para desenlazar el listener

    @Override
    public void onDetach() {
        super.onDetach();
        onPersonCreated = null;
    }
}
