package com.ruoyi.framework.security.authentication;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.ruoyi.common.core.domain.model.WxLoginBody;
import com.ruoyi.common.enums.UserStatus;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.config.WxMaConfig;
import com.ruoyi.framework.web.service.UserDetailsServiceImpl;
import com.ruoyi.common.core.domain.entity.WxUser;
import com.ruoyi.office.mapper.WxUserMapper;
import me.chanjar.weixin.common.error.WxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WxAuthenticationProvider implements AuthenticationProvider {

    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    private UserDetailsServiceImpl userDetailsService;

    private WxUserMapper userMapper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        WxLoginBody loginBody = (WxLoginBody) authentication.getCredentials();
        WxMaService wxMaService = StringUtils.isEmpty(loginBody.getAppId()) ?
                WxMaConfig.getMaServiceByName(loginBody.getAppName()) : WxMaConfig.getMaServiceById(loginBody.getAppId());
        try {
            WxMaJscode2SessionResult result = wxMaService.jsCode2SessionInfo(loginBody.getCode());
            WxUser wxUser = userMapper.selectUserByOpenId(result.getOpenid());
            if (wxUser == null) {
                wxUser = new WxUser();
                wxUser.setNickName("微信用户");
                wxUser.setOpenId(result.getOpenid());
                wxUser.setUnionId(result.getUnionid());
                wxUser.setCreateBy("admin");
                wxUser.setCreateTime(new Date());
                userMapper.insertWxUser(wxUser);
            } else {
                if (UserStatus.DISABLE.getCode().equals(wxUser.getStatus())) {
                    log.info("登录用户：{} 已被停用." , wxUser.getUnionId());
                    throw new ServiceException("对不起，您的账号：" + wxUser.getUnionId() + " 已停用");
                }
            }
            UserDetails userDetails = userDetailsService.createWxLoginUser(wxUser);
            WxAuthenticationToken authenticationToken = new WxAuthenticationToken(userDetails, loginBody, userDetails.getAuthorities());
            return authenticationToken;
        } catch (WxErrorException e) {
            throw new ServiceException("微信小程序登录出错");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return WxAuthenticationToken.class.isAssignableFrom(authentication);
    }

    @Autowired
    public void setUserDetailsService(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void setUserMapper(WxUserMapper userMapper) {
        this.userMapper = userMapper;
    }
}