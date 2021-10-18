package com.example.rxjava1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        Task task = new Task(1, "Go to Gym", true);
        Observable<Task> integerObservable = Observable.
                fromIterable(getTaskList())
                .filter(new Predicate<Task>() {
                    @Override
                    public boolean test(Task task) throws Throwable {
                        SystemClock.sleep(1000);
                        return task.isBoo();
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

        Observer<Task> integerObserver = new Observer<Task>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                disposable = d;
                Log.d("Lloyd", "onSubscribe");
            }

            @Override
            public void onNext(@NonNull Task task) {
                Log.d("Lloyd", "onNext " + task.getId());
                String data = textView.getText().toString() + task.getName();
                textView.setText(data + "\n");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("Lloyd", "onError " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d("Lloyd", "onComplete");
                String data = textView.getText().toString() + "Completed";
                textView.setText(data + "\n");
            }
        };

        integerObservable.subscribe(integerObserver);
    }

    private List<Task> getTaskList() {
        List<Task> taskList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                Task task = new Task(i, "Task - " + i, true);
                taskList.add(task);
            } else {
                Task task = new Task(i, "Task - " + i, false);
                taskList.add(task);
            }
        }
        return taskList;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}