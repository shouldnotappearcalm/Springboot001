package com.gzr.service;

import com.gzr.dao.AdminRepository;
import com.gzr.entity.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * ${description}
 * Created by GZR
 * 2017-07-05
 */
@Service("adminDetailService")
public class AdminDetailService implements UserDetailsService{
    @Resource
    private AdminRepository adminRepository;

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //接收到请求
        ServletRequestAttributes requestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=requestAttributes.getRequest();
        logger.error(request.getRequestURI());
        HttpSession session=request.getSession();
        session.setAttribute("username",username);
        logger.error("haha");
        Admin admin=adminRepository.findAdminByUsername(username);
        if(null==admin){
            throw  new UsernameNotFoundException("Username not found");
        }else{
            return new User(admin.getUsername(),admin.getPassword(),admin.getStatus()==1,true,true,true,getGrantedAuthorities(admin));
        }
    }
    private List<GrantedAuthority> getGrantedAuthorities(Admin admin){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+admin.getRole()));
        logger.info("authorities :"+authorities);
        return authorities;
    }
}
