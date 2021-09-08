package com.example.myfirstappwithrxjava;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final  String TAG = "MainActivity";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //****Using create to emit values to observer from observable****
        //final Task task = new Task("Walk the dog", false, 3);
//        final List<Task> tasks = DataSource.createTasksList();
//        Observable<Task> taskObservable = Observable
//                .create(new ObservableOnSubscribe<Task>() {
//                    @Override
//                    public void subscribe(@NonNull ObservableEmitter<Task> emitter) throws Throwable {
//                        for(Task task: DataSource.createTasksList())
//                        if(!emitter.isDisposed()) {
//                            emitter.onNext(task);
//                        }
//
//                        if(!emitter.isDisposed()) {
//                            emitter.onComplete();
//                        }
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());

        //***Using just to emit value to observer from observable***
//        final Task task = new Task("Walk the dog", false, 3);
//
//        Observable<Task> taskObservable = Observable
//                .just(task)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//
//        taskObservable.subscribe(new Observer<Task>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@NonNull Task task) {
//                Log.d(TAG, "onNext: " + task.getDescription());
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });

        //***Using the range***
//        Observable<Task> observable = Observable
//                .range(0, 9)
//                .subscribeOn(Schedulers.io())
//                .map(new Function<Integer, Task>() {
//                    @Override
//                    public Task apply(Integer integer) throws Throwable {
//                        Log.d(TAG, "apply: " + Thread.currentThread().getName());
//                        return new Task("this is a task with priority: " + String.valueOf(integer), false, integer);
//                    }
//                })
//                .takeWhile(new Predicate<Task>() {
//                    @Override
//                    public boolean test(Task task) throws Throwable {
//                        return task.getPriority() < 9;
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread());
//
//        observable.subscribe(new Observer<Task>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@NonNull Task task) {
//                Log.d(TAG, "onNext: " + task.getPriority());
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });

        Observable<Integer> observable = Observable
                .range(0, 3)
                .subscribeOn(Schedulers.io())
                .repeat(3)
                .observeOn(AndroidSchedulers.mainThread());

        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.d(TAG, "onNext: " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}