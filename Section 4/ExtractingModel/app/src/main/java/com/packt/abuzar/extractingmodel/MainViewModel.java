package com.packt.abuzar.extractingmodel;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.widget.Toast;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainViewModel extends ViewModel {


    public final List<ProjectModel> projectListings = new ArrayList<>();
    List<ProjectModel> items = new ArrayList<>();

    private Observable<Integer> mObservable;
    private Observer<Integer> mObserver;


    public void setProjectList() {
        initializeObservable();
        initializeObserver();
        //        subscribing observer to observable
        mObservable.subscribe(mObserver);
    }


    //    code to initialize Observable
    private void initializeObservable() {

        mObservable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {

                for (int i = 0; i < 5; i++) {
                    emitter.onNext(i);
                }
                emitter.onComplete();
            }
        });

        mObservable = Observable.create(e -> {
            for (int i = 1; i <= 5; i++) {
                e.onNext(i);
            }
            e.onComplete();
        });
    }


    //    Code to initialize Observer
    private void initializeObserver() {
        mObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Integer integer) {
                ProjectModel projectModel = new ProjectModel();
                projectModel.title = "Project " + integer;
                items.add(projectModel);
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
                projectListings.addAll(items);
            }
        };
    }


}
