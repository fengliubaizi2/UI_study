package com.mean.ui.DesignModel;

import android.content.Context;
import android.util.Log;

import com.mean.ui.DesignModel.Factory.Operation;
import com.mean.ui.DesignModel.Factory.OperationFactory;
import com.mean.ui.DesignModel.FactoryMethod.AddFactory;
import com.mean.ui.DesignModel.FactoryMethod.IFactory;
import com.mean.ui.DesignModel.Prototype.Student;
import com.mean.ui.DesignModel.Proxy.Proxy;
import com.mean.ui.DesignModel.Proxy.SchoolGirl;
import com.mean.ui.DesignModel.SingleInstance.SingleInstance;
import com.mean.ui.DesignModel.ZhizeLian.Manager;
import com.mean.ui.DesignModel.ZhizeLian.President;
import com.mean.ui.DesignModel.ZhizeLian.TopManager;

/**
 * Created by renzhenhua on 2017/10/26.
 */

public class Test {
    // 简单工厂模型
    public static String TAG = "RZH";

    public static void factoryTest() {
        Operation operation;
        operation = OperationFactory.createOperation('+');
        operation.A = 3;
        operation.B = 1.2;
        Log.i(TAG, operation.getResoult() + "");
    }

    // 工厂方法模型
    public static void FactoryMethonTest() {
        Operation operation;
        IFactory factory;
        factory = new AddFactory();
        operation = factory.createOperation();
        operation.A = 3;
        operation.B = 1.2;
        Log.i(TAG, operation.getResoult() + "");
    }

    //代理模型
    public static void ProxyTest() {
        SchoolGirl mm = new SchoolGirl("韩梅梅");
        Proxy gg = new Proxy(mm);
        gg.giveApple();
        gg.giveFlower();
    }

    public static void PrototypeTest() {
        Student stu1 = new Student();
        stu1.setAge(17);
        stu1.setName("小明");
        Student stu2 = (Student) stu1.clone();
        stu2.setName("老王");
        stu2.setAge(50);
        Log.i(TAG, stu1.getName() + "--" + stu1.getAge());
        Log.i(TAG, stu2.getName() + "--" + stu2.getAge());
    }

    public static void testService(Context context) {
    }

    public static void testInstance(Context context) {
        SingleInstance ts1 = SingleInstance.getInstance();
        ts1.setName("jason");
        SingleInstance ts2 = SingleInstance.getInstance();
        ts2.setName("0539");
        ts1.printInfo();
        ts2.printInfo();
        if (ts1 == ts2) {
            Log.d("RZH","创建的是同一个实例" );
        } else {
            Log.d("RZH","创建的不是同一个实例" );
        }
    }
    public static void testZhize(Context context) {
        Manager manager=new Manager();
        TopManager topManager=new TopManager();
        President president=new President();
        manager.setHandler(topManager);
        topManager.setHandler(president);

        int[] requests={200,80,990,2002};
        for (int i=0;i<requests.length;i++){
            manager.setChuli(requests[i]);
        }
    }
}
