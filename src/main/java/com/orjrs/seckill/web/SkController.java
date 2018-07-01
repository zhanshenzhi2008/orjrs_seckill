package com.orjrs.seckill.web;

import com.orjrs.seckill.service.SkProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 秒杀
 *
 * @author orjrs
 * @date 2018-06-30 15:40
 */
@RestController
public class SkController {
    @Autowired
    private SkProductService skProductService;

    @RequestMapping(value = "/sk/secKill", method = RequestMethod.POST)
    public Map secKill(@RequestParam("productId") String productId, @RequestParam("telephone") String telephone) {
        skProductService.secKill(productId, telephone);
        Map<String, Object> map = new HashMap<>();
        map.put("code", "success");
        return map;
    }
}
