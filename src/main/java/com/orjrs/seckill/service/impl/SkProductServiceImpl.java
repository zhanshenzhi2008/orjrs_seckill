package com.orjrs.seckill.service.impl;

import com.orjrs.seckill.common.exception.BizException;
import com.orjrs.seckill.repository.SkItemRepository;
import com.orjrs.seckill.repository.SkProductRepository;
import com.orjrs.seckill.service.SkProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * 秒杀产品服务
 *
 * @author orjrs
 * @date 2018-06-30 15:41
 */
@Service
public class SkProductServiceImpl implements SkProductService {

    @Autowired
    private SkProductRepository skProductRepository;

    @Autowired
    private SkItemRepository skItemRepository;

    /**
     * 秒杀商品
     *
     * @param productId 产品id
     * @param telephone 电话
     */
    @Override
    @Transactional
    public void secKill(String productId, String telephone) {
        Date currentTime = new Date();
        int updateCount = skProductRepository.reduceNumber(productId, currentTime);
        if (updateCount <= 0) {
            throw new BizException("库存不足");
        }
        skItemRepository.insertSkItem(productId, telephone, currentTime);
    }
}
