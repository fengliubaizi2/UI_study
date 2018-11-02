package com.mean.ui.DesignModel.FactoryMethod;

import com.mean.ui.DesignModel.Factory.Operation;
import com.mean.ui.DesignModel.Factory.OperationDiv;
import com.mean.ui.DesignModel.Factory.OperationMinus;

/**
 * Created by renzhenhua on 2017/10/26.
 */

public class MinusFactory implements IFactory{
    @Override
    public Operation createOperation() {
        return new OperationMinus();
    }
}
