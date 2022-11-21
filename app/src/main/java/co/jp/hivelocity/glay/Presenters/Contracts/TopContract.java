package co.jp.hivelocity.glay.Presenters.Contracts;

import java.util.List;

import co.jp.hivelocity.glay.Interfaces.BaseView;
import co.jp.hivelocity.glay.Models.TopDataModel;

public class TopContract {

    public interface View extends BaseView<Presenter> {
        void showTopImages(List<TopDataModel> topImages);
    }

    public interface Presenter {
        void getTopImages();
    }
}