package com.zj.baseservice.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.zj.baseservice.common.OutdoorException;

public class InitVodClient {

    private InitVodClient(){
        throw new OutdoorException("请勿对工具类进行实例化", 20001);
    }

    public static IAcsClient getClient(){
        DefaultProfile profile = DefaultProfile.getProfile("cn-shanghai", ConstantVodUtil.ACCESS_KEY_ID, ConstantVodUtil.ACCESS_KEY_SECRET);
        IAcsClient client = new DefaultAcsClient(profile);
        return client;
    }

}
