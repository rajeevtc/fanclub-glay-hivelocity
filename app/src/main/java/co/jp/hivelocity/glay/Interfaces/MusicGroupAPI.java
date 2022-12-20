package co.jp.hivelocity.glay.Interfaces;

import co.jp.hivelocity.glay.Configs.APIConfigurations;
import co.jp.hivelocity.glay.Models.MusicGroupStreamsModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface MusicGroupAPI {
    @GET("groups/{id}")
    Call<MusicGroupStreamsModel> getGroupStreams(@Header(APIConfigurations.HeaderNameHiSession) String sessionId, @Path("id") int id);
}