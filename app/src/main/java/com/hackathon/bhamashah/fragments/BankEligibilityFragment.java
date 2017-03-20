package com.hackathon.bhamashah.fragments;


        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Spinner;

        import com.hackathon.bhamashah.R;
        import com.hackathon.bhamashah.adapters.BankOffersAdapter;
        import com.hackathon.bhamashah.base.BaseFragment;
        import com.hackathon.bhamashah.bean.CurrentOffersApiResponse;
        import com.hackathon.bhamashah.bean.LoanEligibilityApiResponse;
        import com.hackathon.bhamashah.bean.Login.FamilyDetailsBean;
        import com.hackathon.bhamashah.bean.Login.HofDetailsBean;
        import com.hackathon.bhamashah.bean.currentOffers.PreApprovedLoansBean;
        import com.hackathon.bhamashah.data.local.AppData;
        import com.hackathon.bhamashah.data.remote.RemoteClient;
        import com.hackathon.bhamashah.data.remote.ResponseHandler;
        import com.hackathon.bhamashah.data.remote.api.SuccessInferface;
        import com.hackathon.bhamashah.utilities.AppUtils;

        import java.util.ArrayList;
        import java.util.List;

        import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class BankEligibilityFragment extends BaseFragment {


    private Spinner spinner;
    private HofDetailsBean hofDetailsBean;
    private RecyclerView recyclerView;
    private List<FamilyDetailsBean> list;
    public BankEligibilityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bank_eligilibility, container, false);
        spinner = (Spinner)view.findViewById(R.id.bankEligilibility_spinner);
        recyclerView = (RecyclerView) view.findViewById(R.id.bankEligilibility_recycler_view);
//        bankEligilibility_spinner
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        hofDetailsBean = AppData.getInstance().getUser().getHoFDetails();
        addSpinner(AppData.getInstance().getUser().getFamily_Details());
    }

    private void addSpinner(List<FamilyDetailsBean> list){
        this.list=list;
        String[] items = new String[list.size()+1];
        items[0] = hofDetailsBean.getNAME_ENG();
        for(int position=0;position<list.size();position++){
            FamilyDetailsBean familyDetailsBean = list.get(position);
            items[position+1]=familyDetailsBean.getNAME_ENG();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("TEST", "onItemSelected: " + position);
                hitAPI(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void hitAPI(int position){
        String gender="";
        String isRular="";
        if(position==0){
            gender=hofDetailsBean.getGENDER();
            isRular=hofDetailsBean.getIS_RURAL();
        }else{
            position--;
            FamilyDetailsBean familyDetailsBean = list.get(position);
            gender=familyDetailsBean.getGENDER();
            isRular=familyDetailsBean.getIS_RURAL().trim();
            if(isRular.equalsIgnoreCase("Rural")){
                isRular="1";
            }
        }
        hitAPI(gender,isRular);
    }

    private void hitAPI(final String gender, final String isRullar){
        Call<CurrentOffersApiResponse> testCall = RemoteClient.getApiInterface().getCurrentOffersApiResponse("getAllLoans", AppData.getInstance().getUser().getBhamashahId());
        testCall.enqueue(new ResponseHandler<CurrentOffersApiResponse>(getActivity(), 1, new SuccessInferface<CurrentOffersApiResponse>() {
            @Override
            public void onResponse(int id, final CurrentOffersApiResponse currentOffersApiResponse) {
                AppUtils.updateUI(getActivity(), new Runnable() {
                    @Override
                    public void run() {
                        List<PreApprovedLoansBean> list = currentOffersApiResponse.getData().getPreApprovedLoans();
                        List<PreApprovedLoansBean> filterList = new ArrayList<PreApprovedLoansBean>();
                        for (PreApprovedLoansBean bean :
                                list) {
                            Log.d("TEST", "run:  gender new : " + bean.getGender());
                            Log.d("TEST", "run:  gender old : " + gender);

                            Log.d("TEST", "run:  Rular new : " + bean.getForRural());
                            Log.d("TEST", "run:  Rular old : " + isRullar);
                            if (bean.getGender().equalsIgnoreCase(isRullar) && bean.getForRural().equalsIgnoreCase(isRullar)) {
                                    filterList.add(bean);
                            }
                            }
                        Log.d("TEST", "run: list : " + list.size());
                        Log.d("TEST", "run: filterList : " + filterList.size());
                        AppUtils.addAdatperToRecyclerView(new BankOffersAdapter(getActivity(),filterList),recyclerView);
                    }
                });
            }
        },null));
    }
}
