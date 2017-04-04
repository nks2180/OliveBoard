package com.app.ob.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.ob.R;
import com.app.ob.customViews.OBTextView;
import com.app.ob.utils.OBUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by niranjan on 04/04/17.
 */

public class TabFragment extends Fragment {
    Context mContext;
    List<String> exam;

    @BindView(R.id.txtVw_detail)
    OBTextView txtVwDetail;

    public static TabFragment newInstance(List<String> exam) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putSerializable(OBUtils.EXTRA_EXAM_OBJ, (Serializable) exam);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (null != bundle) {
            exam = (ArrayList<String>) bundle.getSerializable(OBUtils.EXTRA_EXAM_OBJ);
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getActivity();

        if (null != exam){
            String details = exam.get(1);
            txtVwDetail.setText(details);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_tab, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
