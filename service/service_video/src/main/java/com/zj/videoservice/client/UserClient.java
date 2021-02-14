package com.zj.videoservice.client;

import com.zj.baseservice.entity.OutdoorUserRelation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(value = "service-user")
public interface UserClient {

    @GetMapping("/userservice/relation/queryAllFanId/{upId}")
    List<OutdoorUserRelation> queryAllFanId(@PathVariable("upId") Long upId);

}
