package com.app.ob.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.app.ob.R;
import com.app.ob.adapter.HomePagerAdapter;
import com.app.ob.component.ApplicationComponent;
import com.app.ob.model.Exam;
import com.app.ob.presenter.HomePresenter;
import com.app.ob.presenter.HomeView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by niranjan on 04/04/17.
 */

public class HomeScreenActivity extends BaseViewPresenterActivity<HomePresenter> implements HomeView {

    @Inject
    HomePresenter homePresenter;

    Context mContext;

    @BindView(R.id.tabLyt_home)
    TabLayout tabLytHome;
    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    Exam mExams;
    HomePagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        mContext = this;

        setUpActionBar();
        homePresenter.getTabsData();
    }

    private void setUpActionBar() {
        toolbar.setTitle(R.string.app_name);
        toolbar.setTitleTextColor(ContextCompat.getColor(mContext, R.color.white));
        setSupportActionBar(toolbar);
    }

    @Override
    public void onTabsResponseCame(Exam exams) {
        this.mExams = exams;
        setUpTabs();
    }

    private void setUpTabs() {
        mPagerAdapter = new HomePagerAdapter(getSupportFragmentManager(), mExams);
        pager.setAdapter(mPagerAdapter);
        tabLytHome.setupWithViewPager(pager);

    }

    @Override
    public void showNoInternetConnectionToast() {

    }

    @Override
    protected int getMainLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void injectComponent(ApplicationComponent applicationComponent) {
        applicationComponent.inject(this);
    }

    @Override
    public void initializePresenter() {
        super.initializePresenter(homePresenter, this);
    }
}
