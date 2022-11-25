package co.jp.hivelocity.glay.Interfaces;

import java.util.List;
import co.jp.hivelocity.glay.Models.TopDataModel;

public interface APICallBacks {
    void onSuccess(List<TopDataModel> data);
    void onFailure();
}