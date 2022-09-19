package com.example.blocdenotas;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A fragment representing a list of Items.
 */
public class NotaFragment extends Fragment {
    RecyclerView recyclerView;
    MyNotaRecyclerViewAdapter adapterNotas;
    List<Nota> NotasLis;
    OnListFragmentInteractionListener mlistener = null;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NotaFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NotaFragment newInstance(int columnCount) {
        NotaFragment fragment = new NotaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            NotasLis = new ArrayList<>();
            NotasLis.add(new Nota("Lavar trastes", "Lavar trastes el 19/09/2022 a las 10:00 am", 1.00f));
            NotasLis.add(new Nota("Lavar ropa", "Lavar ropa a las 8:00 am", 0.00f));
            NotasLis.add(new Nota("LLevar los niños al colegio", "Llevarlos al colegio a la 1:15 pm", 1.00f));
            NotasLis.add(new Nota("Revision en el dentista", "Ir a revision de dientes el lunes a las 10:00 am", 1.00f));
            NotasLis.add(new Nota("Compras", "Queso Huevos frutas y verduras", 0.00f));
            NotasLis.add(new Nota("Ir al medico para revision del corazon", "Cita medica a las 3:00 pm", 1.00f));
            NotasLis.add(new Nota("Salida con los compañeros de la universidad", "Paseo a la playa", 1.00f));

            OnListFragmentInteractionListener mlistener = null;
            adapterNotas = new MyNotaRecyclerViewAdapter(getContext() , NotasLis, mlistener);
            recyclerView.setAdapter(adapterNotas);
        }
        return view;
    }
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Nota item);

    }
}