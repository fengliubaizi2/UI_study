package com.mean.ui.DesignModel.Factory;

/**
 * Created by renzhenhua on 2017/10/26.
 */

public class OperationFactory {
    public static Operation createOperation(char c){
        Operation operation=null;
        switch (c){
            case '+':
                operation=new OperationAdd();
                break;
            case '-':
                operation=new OperationMinus();
                break;
            case '*':
                operation=new OperationMul();
                break;
            case '/':
                operation=new OperationDiv();
                break;
            default:
                break;
        }
        return operation;
    }
}
