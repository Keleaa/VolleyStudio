package com.bwie.zhang.volleystudio.MVP;

/**
 * Created by 可乐 on 2019/4/16.
 */

public class Presenter implements Contract.IPresenter {
    private Model model;
    Contract.IView iview;

    @Override
    public void attch(Contract.IView iView) {
        model = new Model();
        this.iview = iView;
    }

    @Override
    public void detch() {
        if (model != null) {
            model = null;
        }
        if (iview != null) {
            iview = null;
        }
        System.gc();
    }

    @Override
    public void login(String url) {
        model.getRequester(url, new Contract.IModel.ModelCallBack() {
            @Override
            public void onSuccess(String data) {
                iview.getLogin(data);
            }

            @Override
            public void onFail() {

            }
        });
    }
}
