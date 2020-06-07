package cn.edu.scujcc.music;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class songLab {

    public static final int PUT_IN_SUCCESS = 1;
    public static final int PUT_IN_FAIL =-1 ;
    private static songLab INSTANCE = null;
    private final static String TAG = "Ours";

    private songLab(){};
    public static songLab getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new songLab();

        }
        return INSTANCE;

    }

    public void putIn(song niceSong, Handler handler) {
        Retrofit retrofit = RetrofitClient.getInstance();
        songAPI api = retrofit.create(songAPI.class);
        Call<song> call = api.putInLikes(niceSong);
        call.enqueue(new Callback<song>() {
            public void onResponse(Call<song> call, Response<song> response) {

                if (response.body() != null) {

                    song res=response.body();
                    Log.d(TAG, "查询成功");
                    Log.d(TAG, response.body().toString());
                    Message msg = new Message();
                    msg.what = PUT_IN_SUCCESS;
                    msg.obj = res;
                    handler.sendMessage(msg);
                }
                else{
                    Message msg = new Message();
                    msg.what =PUT_IN_FAIL;
                    handler.sendMessage(msg);
                }
            }

            @Override
            public void onFailure(Call<song> call, Throwable t) {
                Message msg = new Message();
                msg.what =PUT_IN_FAIL;
                handler.sendMessage(msg);
            }

        });

    }
}
