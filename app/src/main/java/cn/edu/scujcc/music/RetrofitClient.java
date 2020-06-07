package cn.edu.scujcc.music;

import retrofit2.Retrofit;

public class RetrofitClient {
    private static Retrofit retrofit=null;
    public static Retrofit getInstance(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl("http://47.107.233.70:8080")
                    .build();
        }
        return retrofit;
    }


}
