package com.company.designpattern.problmes.callback;

public class CallbackManager {
    public static void main(String[] args) {
        CallbackImpl callbackService = new CallbackImpl(10);

        for(int i=0;i<20;++i) {
            int finalI = i;
            callbackService.execute(1000, () ->{
                System.out.println("Executing "+ finalI +", by"+Thread.currentThread().getName()+" with delay of "+(1000*finalI));
            });
        }

    }
}
