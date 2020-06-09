package cn.edu.scujcc.music;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface SingerAPI {
    @GET("/singer/{area}")
    Call<List<Singer>> getSingerByArea(@Path("area") String area);
    @GET("/singer/{gender}")
    Call<List<Singer>> getSingerByGender(@Path("gender") String gender);
    @GET("/singer/{style}")
    Call<List<Singer>> getSingerByStyle(@Path("style") String style);
    @GET("/singer")
    Call<List<Singer>> getAllSingers();


}
