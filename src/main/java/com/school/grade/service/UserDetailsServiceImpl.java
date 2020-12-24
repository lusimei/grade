package com.school.grade.service;

import com.school.grade.entity.Users;
import com.school.grade.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersMapper.selectOneUsers(username);
        if(users == null){
            throw new UsernameNotFoundException("用户名找不到！");
        }
        List<GrantedAuthority> list = AuthorityUtils
                .commaSeparatedStringToAuthorityList("admin,ROLE_sale,ROLE_look");
        return new User(users.getUsername(),new BCryptPasswordEncoder().encode(users.getPassword()),list);
    }
}
