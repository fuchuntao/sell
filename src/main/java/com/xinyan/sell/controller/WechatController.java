package com.xinyan.sell.controller;

import com.xinyan.sell.enums.ResultStatus;
import com.xinyan.sell.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Administrator
 * 2018/11/20 0020
 * 微信网页授权
 */
@Slf4j
@RequestMapping("/wechat")
@Controller
public class WechatController {

    @Autowired
    private WxMpService wxMpService;

    /**
     * 返回带 code 和 state 的 url
     * @param returnUrl
     * @return
     */
    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl")String returnUrl){
        //构造网页授权url，然后构成超链接让用户点击重定向的url地址
        String url = "http://*******/sell/wechat/userInfo";

        //redirectUrl: 授权后重定向的回调链接地址
        //注意：跳转回调redirect_uri，应当使用https链接来确保授权code的安全性。
            String redirectUrl = null;
        try {
            redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO,
                 URLEncoder.encode(returnUrl, "utf-8"));
        } catch (UnsupportedEncodingException e) {
                log.error("【微信网页授权】获取code, redirectUrl:{}", redirectUrl);
                throw new SellException(ResultStatus.WECHAT_MP_AUTHORIZE_ERROR);
        }
                return "redirect:" + redirectUrl;

    }


    /**
     * 返回带 openId 的 url
     * @param code
     * @param returnUrl
     * @return
     */

    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,@RequestParam("state") String returnUrl){

        WxMpUser wxMpUser = null;
        try {
            //当用户同意授权后，会回调所设置的url并把authorization code传过来，
            // 然后用这个code获得access token，其中也包含用户的openid等信息
            WxMpOAuth2AccessToken wxMpOAuth2AccessToken =wxMpService.oauth2getAccessToken(code);
            //获取用户基本信息
            wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
        } catch (WxErrorException e) {
            log.error("【微信网页授权】{}", e);
            throw new SellException(ResultStatus.WECHAT_MP_AUTHORIZE_ERROR.getCode(),
            e.getError().getErrorMsg());
        }
            String openId = wxMpUser.getOpenId();
            return  "redirect:" + returnUrl + "?openid=" + openId;
    }

}
