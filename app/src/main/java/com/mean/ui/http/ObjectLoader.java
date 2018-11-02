package com.mean.ui.http;


import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @author cauchy
 * @date 2018/8/6 11:29
 * @since 5.1.0
 */
public class ObjectLoader {
    /**
     * @param observable
     * @param <T>
     * @return
     */
    protected <T> Observable<T> observe(Observable<T> observable) {
        return observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    protected <T extends BaseBean> Observable<T> observe2(Observable<T> observable) {

        observable.map(new Func1<T, T>() {
            @Override
            public T call(T t) {
                if (t.getBody().getChangePhone()){
                    return null;
                }
                return t;
            }
        });
        return observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
