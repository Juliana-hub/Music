package cn.edu.scujcc.music;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface songAPI {
    @PUT("/song/likes/{songId}")
    Call<song> putInLikes(@Body song niceSong);
    @GET("/song/likes/{status}")
    Call<List<song>> getLikes(@Path("status") String status);
}