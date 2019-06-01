package com.binzikeji.itoken.common.web.service;

import com.binzikeji.itoken.common.hystrix.Fallback;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Bin
 * @Date 2019/3/12 15:49
 **/
public interface BaseClientService {

    default String page(int pageNum, int pageSize, String domainJson){
        return Fallback.badGateway();
    }
}
