package com.rk.mylibrary.services;

/**
 * @author orange
 * @time 2019-04-07 00:36
 */
public class ServiceFactory {

    private final static ServiceFactory instancce=new ServiceFactory();
    private ServiceFactory(){}

    public static ServiceFactory getInstancce(){
        return instancce;
    }

    private ILoginService mILoginService;
    private IMineService mIMineService;

    public ILoginService getILoginService() {
        if (mILoginService == null) {
            mILoginService=new EmptyService();
        }
        return mILoginService;
    }

    public void setILoginService(ILoginService ILoginService) {
        mILoginService = ILoginService;
    }

    public IMineService getIMineService() {
        return mIMineService;
    }

    public void setIMineService(IMineService IMineService) {
        mIMineService = IMineService;
    }
}
