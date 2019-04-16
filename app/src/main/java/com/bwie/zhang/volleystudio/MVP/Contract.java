package com.bwie.zhang.volleystudio.MVP;

/**
 * Created by 可乐 on 2019/4/16.
 */

public interface Contract {
    interface IView {
        void getLogin(String data);
    }

    interface IModel {
        void getRequester(String url, ModelCallBack callBack);

        interface ModelCallBack {
            void onSuccess(String data);

            void onFail();
        }
    }

    interface IPresenter {
        void attch(IView iView);

        void detch();

        void login(String url);
    }
}
