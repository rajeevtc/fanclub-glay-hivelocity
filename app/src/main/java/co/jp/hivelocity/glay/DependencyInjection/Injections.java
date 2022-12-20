package co.jp.hivelocity.glay.DependencyInjection;

import co.jp.hivelocity.glay.Repositories.MovieGroupDataSource;
import co.jp.hivelocity.glay.Repositories.MovieGroupRepository;
import co.jp.hivelocity.glay.Repositories.MusicGroupDataSource;
import co.jp.hivelocity.glay.Repositories.MusicGroupRepository;
import co.jp.hivelocity.glay.Repositories.TopDataSource;
import co.jp.hivelocity.glay.Repositories.TopRepository;

public class Injections {

    public static TopRepository provideTopRepository() {
        return new TopRepository(TopDataSource.getInstance());
    }

    public static MusicGroupRepository provideMusicStreamsRepository() {
        return new MusicGroupRepository(MusicGroupDataSource.getInstance());
    }

    public static MovieGroupRepository provideMovieGroupRepository() {
        return new MovieGroupRepository(MovieGroupDataSource.getInstance());
    }
}
