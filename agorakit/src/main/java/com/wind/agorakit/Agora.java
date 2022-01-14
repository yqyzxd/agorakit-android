package com.wind.agorakit;

import android.content.Context;

import com.wind.agorakit.util.FileUtil;

import io.agora.rtc.RtcEngine;

/**
 * Created By wind
 * on 2019-11-13
 */
public class Agora {

    public static final String APP_ID="7a1da063288245c4b87dfef64a78f71a";
    /**
     * 因为token 是服务端生成的，所以服务端用的哪个app_id,就是哪个。 客户端可随意设置app_id
     */
//    public static final String APP_ID="910bf1b1f45e423f80f9f1495c27d067";
    private boolean hasInited;
    private RtcEngine mRtcEngine;
    private AgoraEventHandler mHandler = new AgoraEventHandler();
    private static Agora sAgora=null;
    public static Agora getInstance(){
        if (sAgora==null){
            synchronized (Agora.class){
                if (sAgora==null){
                    sAgora=new Agora();
                }
            }
        }
        return sAgora;
    }
    public RtcEngine rtcEngine(){
        return mRtcEngine;
    }
    public void create(Context context){
        try {

            mRtcEngine = RtcEngine.create(context,APP_ID, mHandler);
            mRtcEngine.setChannelProfile(io.agora.rtc.Constants.CHANNEL_PROFILE_LIVE_BROADCASTING);
            mRtcEngine.enableVideo();
            mRtcEngine.setLogFile(FileUtil.initializeLogFile(context));
            mRtcEngine.enableDualStreamMode(true);
            //在直播模式下，移动端/桌面端和 Web 端必须同时设置，才能实现互通：
            mRtcEngine.enableWebSdkInteroperability(true);
            hasInited=true;
            //System.out.println("Agora create RtcEngine success    RtcEngine.getSdkVersion()"+   RtcEngine.getSdkVersion());
        } catch (Exception e) {
            System.out.println("Agora create RtcEngine error");
            e.printStackTrace();
        }
    }

    public void registerEventHandler(EventHandler handler) { mHandler.addHandler(handler); }

    public void removeEventHandler(EventHandler handler) { mHandler.removeHandler(handler); }


    public boolean hasInited(){
        return hasInited;
    }


    public void destroy(){
        if (hasInited){
            mHandler.remove();
            RtcEngine.destroy();
            hasInited=false;
            sAgora=null;
        }

    }
}
