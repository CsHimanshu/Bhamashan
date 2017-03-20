package com.hackathon.bhamashah.fragments;


        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.Spinner;

        import com.hackathon.bhamashah.R;
        import com.hackathon.bhamashah.base.BaseFragment;
        import com.hackathon.bhamashah.bean.Login.FamilyDetailsBean;

        import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BankEligibilityFragment extends BaseFragment {


    private Spinner spinner;
    public BankEligibilityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bank_eligilibility, container, false);
        spinner = (Spinner)view.findViewById(R.id.bankEligilibility_spinner);
//        bankEligilibility_spinner
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void addSpinner(List<FamilyDetailsBean> list){
//        for(int position=0:)
        String[] items = new String[]{"1", "2", "three"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);
    }
}
