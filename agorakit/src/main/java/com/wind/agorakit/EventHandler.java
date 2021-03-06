package com.wind.agorakit;

import io.agora.rtc.IRtcEngineEventHandler;

public interface EventHandler {
    void onFirstRemoteVideoDecoded(int uid, int width, int height, int elapsed);

    void onLeaveChannel(IRtcEngineEventHandler.RtcStats stats);

    void onJoinChannelSuccess(String channel, int uid, int elapsed);

    void onUserOffline(int uid, int reason);

    void onUserJoined(int uid, int elapsed);

    void onLastmileQuality(int quality);

    void onLastmileProbeResult(IRtcEngineEventHandler.LastmileProbeResult result);

    void onLocalVideoStats(IRtcEngineEventHandler.LocalVideoStats stats);

    void onRtcStats(IRtcEngineEventHandler.RtcStats stats);

    void onNetworkQuality(int uid, int txQuality, int rxQuality);

    void onRemoteVideoStats(IRtcEngineEventHandler.RemoteVideoStats stats);
    void onRemoteVideoStateChanged(int uid, int state, int reason, int elapsed);
    void onRemoteAudioStats(IRtcEngineEventHandler.RemoteAudioStats stats);

    void onAudioVolumeIndication(IRtcEngineEventHandler.AudioVolumeInfo[] speakers, int totalVolume);

    void onChannelMediaRelayStateChanged(int state, int code);

    ///////////////////////////////音乐混音相关/////////////////////////////////////
    void onAudioMixingStateChanged(int state, int reason);

    //////////////////////////////断网重连后重新加入频道成功回调///////////////////////
    void onRejoinChannelSuccess(String channel, int uid, int elapsed);
}