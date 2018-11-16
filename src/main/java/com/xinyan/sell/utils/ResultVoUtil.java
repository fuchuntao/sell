package com.xinyan.sell.utils;

import com.xinyan.sell.vo.ResultVO;
import lombok.Getter;

/**
 * Administrator
 * 2018/11/16 0016
 */
@Getter
public class ResultVoUtil {

    public static ResultVO success(Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(data);
        return resultVO;

    }


}
