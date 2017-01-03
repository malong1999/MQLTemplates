package maxiaobu.mqltemplate;

import android.app.Application;
import android.content.pm.InstrumentationInfo;

import com.maxiaobu.volleykit.IRequest;

import maxiaobu.mxbutilscodelibrary.Utils;

/**
 * Created by 马小布 on 2017/1/3：13:19.
 * introduction：我长得真他娘的磕碜，单身未娶，求包养
 * email：maxiaobu1216@gmail.com
 * 功能：
 * 伪码：
 * 待完成：
 */

public class App extends Application {
    private static App instance;
    private static IRequest sIRequest;
    public static IRequest getRequestInstance(){
        return sIRequest;
    }
    public static App getInstance(){
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        Utils.init(this);
        sIRequest = new IRequest(instance);
    }
}
