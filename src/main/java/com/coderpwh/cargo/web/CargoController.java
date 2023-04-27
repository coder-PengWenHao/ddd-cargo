package com.coderpwh.cargo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author coderpwh
 * @date 2023/4/23 16:09
 */
@RestController
@RequestMapping("/cargo")
public class CargoController {


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Object saveCarGo() {
        return null;
    }


}
