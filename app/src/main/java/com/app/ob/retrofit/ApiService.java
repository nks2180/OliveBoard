package com.app.ob.retrofit;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by niranjan on 03/01/16.
 * Custom interface to declare all API calls
 */
public interface ApiService {

    @GET("hiring/mocks.cgi")
    Call<String> fetchTabsData(@QueryMap Map<String, String> requestParams);
}
