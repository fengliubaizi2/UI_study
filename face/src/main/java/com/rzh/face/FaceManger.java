package com.rzh.face;

import android.app.Application;

/**
 * Created by renzhenhua on 2018/10/9.
 */

public class FaceManger {
    private static FaceManger instance;

    public static void init(Application application) {

        synchronized (FaceManger.class) {
            if (instance == null) {
                instance = new FaceManger(application);
            }
        }
    }

    public static FaceManger getInstance() {
        return instance;
    }

    private FaceManger(Application application) {

        application.registerActivityLifecycleCallbacks(new FaceActivityLifeCircle());

    }
}
