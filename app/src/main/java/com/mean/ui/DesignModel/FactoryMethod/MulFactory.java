package com.mean.ui.DesignModel.FactoryMethod;

import com.mean.ui.DesignModel.Factory.Operation;
import com.mean.ui.DesignModel.Factory.OperationAdd;
import com.mean.ui.DesignModel.Factory.OperationMinus;
import com.mean.ui.DesignModel.Factory.OperationMul;

/**
 * Created by renzhenhua on 2017/10/26.
 */

public class MulFactory implements IFactory{
    @Override
    public Operation createOperation() {
        return new OperationMul();
    }
}
