package com.app.ob.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.app.ob.fragment.TabFragment;
import com.app.ob.model.Exam;

import java.util.List;

/**
 * Created by niranjan on 04/04/17.
 */

public class HomePagerAdapter extends FragmentPagerAdapter {

    private List<List<String>> mExams;

    public HomePagerAdapter(FragmentManager fm, Exam exam) {
        super(fm);
        mExams = exam.getExams();
    }

    @Override
    public Fragment getItem(int position) {
        return TabFragment.newInstance(mExams.get(position));
    }

    @Override
    public int getCount() {
        return mExams.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = mExams.get(position).get(0);
        return title;
    }
}