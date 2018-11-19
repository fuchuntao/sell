package com.xinyan.sell.controller;

import com.xinyan.sell.converter.OrderFormToOrderDTOConverter;
import com.xinyan.sell.dto.OrderDTO;
import com.xinyan.sell.enums.ResultStatus;
import com.xinyan.sell.exception.SellException;
import com.xinyan.sell.form.OrderForm;
import com.xinyan.sell.service.OrderService;
import com.xinyan.sell.utils.ResultVoUtil;
import com.xinyan.sell.vo.OrderMasterVO;
import com.xinyan.sell.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Administrator
 * 2018/11/17 0017
 * 买家订单 Controller
 *
 */
@Slf4j
@RequestMapping("/buyer/order")
@RestController
public class BuyerOrderController {


    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     * @param orderForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/create")
    public ResultVO create(@Valid OrderForm orderForm,
                           BindingResult bindingResult) {


        //验证订单是否有误
        if(bindingResult.hasErrors()) {
            log.error("【创建订单】订单参数有误, OrderForm :{}", orderForm);
            throw new SellException(ResultStatus.ORDER_PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());

        }
        //将OrderForm转换为OrderDTO
        OrderDTO orderDTO = OrderFormToOrderDTOConverter.converter(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空，orderDetailList :{}", orderDTO.getOrderDetailList());
            throw new SellException(ResultStatus.CART_EMPTY);
        }
        //创建订单
        OrderDTO order = orderService.createOrder(orderDTO);

        //返回参数
        Map<String, String> map = new HashMap<>();
        map.put("orderId", order.getOrderId());

        return ResultVoUtil.success(map);

    }

    /**
     * 订单列表
     *
     * @param openid
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public ResultVO findList(@RequestParam("openid") String openid,
                             @RequestParam(value = "page", defaultValue = "0") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size){
        //先把pageable类包装
        PageRequest pageRequest = new PageRequest(page, size);

        //调用订单列表方法
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, pageRequest);
        if(CollectionUtils.isEmpty(orderDTOPage.getContent())) {
            log.info("【订单列表】订单不存在, orderDTOList: {}", orderDTOPage.getContent());
            throw new SellException(ResultStatus.ORDER_NOT_EXIST);
        }

        //返回参数
        List<OrderMasterVO> orderMasterVOList = new ArrayList<>();
        for(OrderDTO orderDTO : orderDTOPage.getContent()) {
            OrderMasterVO orderMasterVO = new OrderMasterVO();
            BeanUtils.copyProperties(orderDTO, orderMasterVO);
            orderMasterVOList.add(orderMasterVO);
        }


       return ResultVoUtil.success(orderMasterVOList);

    }

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    @GetMapping("/detail")
    public ResultVO findOne(@RequestParam("orderId") String orderId) {

        //查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);

        return ResultVoUtil.success(orderDTO);

    }

    /**
     * 取消订单
     * @param orderId
     * @return
     */
    @GetMapping("/cancel")
    public ResultVO cancel(@RequestParam("orderId") String orderId) {

        //查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);


        //取消订单
        OrderDTO orderDTO1 = orderService.cancel(orderDTO);

        return ResultVoUtil.success(null);

    }

}
