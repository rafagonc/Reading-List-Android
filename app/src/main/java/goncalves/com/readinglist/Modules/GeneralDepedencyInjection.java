package goncalves.com.readinglist.Modules;

import com.google.inject.AbstractModule;

import goncalves.com.readinglist.GeneralClasses.ImageSaver.Abstract.ImageSaver;
import goncalves.com.readinglist.GeneralClasses.ImageSaver.Concrete.ImageSaverImpl;
import goncalves.com.readinglist.GeneralClasses.NotificationPreseter.Abstract.NotificationPresenter;
import goncalves.com.readinglist.GeneralClasses.NotificationPreseter.Concrete.NotificationPresenterImpl;
import goncalves.com.readinglist.GeneralClasses.ProgressPresenter.Abstract.ProgressPresenter;
import goncalves.com.readinglist.GeneralClasses.ProgressPresenter.Concrete.ProgressPresenterImpl;

/**
 * Created by rafagonc on 1/19/16.
 */
public class GeneralDepedencyInjection extends AbstractModule {

    @Override
    protected void configure() {
        bind(ProgressPresenter.class).to(ProgressPresenterImpl.class);
        bind(NotificationPresenter.class).to(NotificationPresenterImpl.class);
        bind(ImageSaver.class).to(ImageSaverImpl.class);
    }
}
