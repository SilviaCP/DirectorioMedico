package com.example.usuarioupt.directoriomedico.Fragmentos;


import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.tts.Voice;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.usuarioupt.directoriomedico.Datos.MedicosCursorAdapter;
import com.example.usuarioupt.directoriomedico.Datos.MedicosDbHelper;
import com.example.usuarioupt.directoriomedico.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MedicosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MedicosFragment extends Fragment {

    ListView mMedicosList;
    CursorAdapter mMedicosAdapter;
    FloatingActionButton AddButton;
    MedicosDbHelper mMedicosDbHelper;

    public MedicosFragment() {
        // Required empty public constructor
    }

    public static MedicosFragment newInstance() {
        return new MedicosFragment();
    }
    public void loadMedicos(){
        new MedicosLoadTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_medicos,container,false);

        // Referencia UI
        mMedicosList=(ListView)root.findViewById(R.id.medicos_list);
        mMedicosAdapter= new MedicosCursorAdapter(getActivity(),null);
        AddButton= (FloatingActionButton)getActivity().findViewById(R.id.fab);

        //Configurar
        mMedicosList.setAdapter(mMedicosAdapter);

        //Instancia de helper
        mMedicosDbHelper = new MedicosDbHelper(getActivity());

        //Carga de Datos
        loadMedicos();

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){

    }

    private class MedicosLoadTask extends AsyncTask<Void,Void,Cursor>{

        @Override
        protected Cursor doInBackground(Void... params){
            return mMedicosDbHelper.getAllMedicos();
        }

        @Override
        protected void onPostExecute(Cursor c){
            if (c != null && c.getCount() > 0){
                mMedicosAdapter.swapCursor(c);
            }else{
                //Mostar empty state
            }
        }

    }

}
