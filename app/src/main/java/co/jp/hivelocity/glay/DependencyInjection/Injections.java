package co.jp.hivelocity.glay.DependencyInjection;

import co.jp.hivelocity.glay.Repositories.TopDataSource;
import co.jp.hivelocity.glay.Repositories.TopRepository;

public class Injections {

    public static TopRepository provideTopRepository() {
        return new TopRepository(TopDataSource.getInstance());
    }
}
