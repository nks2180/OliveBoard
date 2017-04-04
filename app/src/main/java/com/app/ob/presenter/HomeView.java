package com.app.ob.presenter;


import com.app.ob.model.Exam;

/**
 * Created by niranjan on 04/04/17.
 */

public interface HomeView extends BaseView {

    void onTabsResponseCame(Exam Exams);

    void showNoInternetConnectionToast();
}
