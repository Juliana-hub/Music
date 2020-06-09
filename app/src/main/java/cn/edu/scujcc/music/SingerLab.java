package cn.edu.scujcc.music;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Path;

public class SingerLab {

    public static final int SINGER_FIND_SUCCESS=1 ;
    public static final int SINGER_FIND_FAIL=-1;

    private static SingerLab INSTANCE = null;
    private final static String TAG = "Ours";
    private SingerLab(){};
    public static SingerLab getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new SingerLab();

        }
        return INSTANCE;

    }

    public void findNdMusic(String area1, Handler handler) {
        Retrofit retrofit = RetrofitClient.getInstance();
        SingerAPI api = retrofit.create(SingerAPI.class);
        Call<List<Singer>> call = api.getSingerByArea(area1);
        call.enqueue(new Callback<List<Singer>>() {
            public void onResponse(Call<List<Singer>> call, Response<List<Singer>> response) {

                if (response.body() != null) {

                    List<Singer> res=response.body();
                    Log.d(TAG, "查询成功");
                    Log.d(TAG, response.body().toString());
                    Message msg = new Message();
                    msg.what = SINGER_FIND_SUCCESS;
                    msg.obj = res;
                    handler.sendMessage(msg);
                }
                else{
                    Message msg = new Message();
                    msg.what =SINGER_FIND_FAIL;
                    handler.sendMessage(msg);
                }
                }

            @Override
            public void onFailure(Call<List<Singer>> call, Throwable t) {
                Message msg = new Message();
                msg.what =SINGER_FIND_FAIL;
                handler.sendMessage(msg);
            }

            });

        }
}
