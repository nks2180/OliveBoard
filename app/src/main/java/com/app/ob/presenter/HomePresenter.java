package com.app.ob.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.app.ob.executor.ParsingExecutor;
import com.app.ob.model.Exam;
import com.app.ob.retrofit.ApiController;
import com.app.ob.retrofit.ApiDataReceiveCallback;
import com.app.ob.retrofit.NetworkConstants;
import com.app.ob.retrofit.RequestBuilder;
import com.app.ob.utils.OBLogger;
import com.app.ob.utils.OBUtils;
import com.bluelinelabs.logansquare.LoganSquare;

import java.io.IOException;
import java.util.HashMap;

import javax.inject.Inject;

/**
 * Created by niranjan on 04/04/17.
 */

public class HomePresenter extends BasePresenterImpl<HomeView> implements ApiDataReceiveCallback {

    @Inject
    ApiController apiController;

    @Inject
    ParsingExecutor parsingExecutor;

    @Inject
    HomePresenter(Context baseContext) {
        super(baseContext);
    }

    public void getTabsData() {
        if (!OBUtils.isConnected(baseContext)) {
            view.showNoInternetConnectionToast();
            return;
        } else {
            RequestBuilder requestBuilder = new RequestBuilder(NetworkConstants.API_FETCH_TABS_DATA);
            HashMap<String, String> requestParams = new HashMap<>();
            requestBuilder.setExtraParameters(requestParams);
            apiController.hitApi(requestBuilder, this);
        }
    }

        @Override
        public void onDataReceived (String response,int type){
            parseTabsResponse(response);
        }

        private void parseTabsResponse(String tabResponse){
            try {
                if (!TextUtils.isEmpty(tabResponse)) {
                    OBLogger.d("tabResponse", tabResponse);
                    view.onTabsResponseCame(LoganSquare.parse(tabResponse, Exam.class));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError ( int type){

        }
    }
