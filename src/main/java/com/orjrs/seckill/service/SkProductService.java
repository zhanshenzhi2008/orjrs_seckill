package com.orjrs.seckill.service;

/**
 * 秒杀产品接口
 *
 * @author orjrs
 * @date 2018-06-30 15:40
 */
public interface SkProductService {
    /**
     * 秒杀商品
     *
     * @param productId
     * @param telephone
     */
    void secKill(String productId, String telephone);
}
