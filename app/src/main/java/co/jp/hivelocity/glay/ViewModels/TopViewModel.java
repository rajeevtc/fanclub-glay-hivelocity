package co.jp.hivelocity.glay.ViewModels;

import co.jp.hivelocity.glay.Repositories.TopRepository;

public class TopViewModel {

    TopRepository repository;

    public TopViewModel(TopRepository repository) {
        this.repository = repository;
    }

    public TopRepository getRepository() {
        return repository;
    }

    public void setRepository(TopRepository repository) {
        this.repository = repository;
    }

    public void fetchTopImages() {
        repository.getTopImages();
    }
}
