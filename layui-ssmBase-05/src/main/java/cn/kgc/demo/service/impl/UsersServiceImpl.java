package cn.kgc.demo.service.impl;

import cn.kgc.demo.pojo.Users;
import cn.kgc.demo.service.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false)
public class UsersServiceImpl extends BaseServiceImpl<Users> implements UsersService {
}
