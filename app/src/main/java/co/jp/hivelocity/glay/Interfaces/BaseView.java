package co.jp.hivelocity.glay.Interfaces;

public interface BaseView<T> {
    void setPresenter(T presenter);
    void showError(Error error);
    void showLoadingIndicator(Boolean status);
}
