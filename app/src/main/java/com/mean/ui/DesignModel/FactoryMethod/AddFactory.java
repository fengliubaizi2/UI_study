package com.mean.ui.DesignModel.FactoryMethod;

import com.mean.ui.DesignModel.Factory.Operation;
import com.mean.ui.DesignModel.Factory.OperationAdd;

/**
 * Created by renzhenhua on 2017/10/26.
 */

public class AddFactory implements IFactory{
    @Override
    public Operation createOperation() {
        return new OperationAdd();
    }
}
