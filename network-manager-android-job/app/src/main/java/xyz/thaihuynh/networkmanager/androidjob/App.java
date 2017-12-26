package xyz.thaihuynh.networkmanager.androidjob;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;
import com.evernote.android.job.JobManager;

/**
 * @author hthai
 * @since 12/26/17
 */

public class App extends Application {

    private static App mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;

        JobManager.create(this).addJobCreator(new JobCreator() {
            @Nullable
            @Override
            public Job create(@NonNull String tag) {
                switch (tag) {
                    case BestTimeJob.TAG:
                        return new BestTimeJob();
                    default:
                        return null;
                }
            }
        });
    }

    public static App getInstance() {
        return mApp;
    }
}
