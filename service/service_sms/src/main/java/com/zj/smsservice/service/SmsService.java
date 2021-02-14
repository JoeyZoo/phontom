package com.zj.smsservice.service;

import java.util.HashMap;

public interface SmsService {
    Boolean sendSms(String PhoneNumbers, HashMap<String, String> map);
}
