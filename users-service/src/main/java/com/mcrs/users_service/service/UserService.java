package com.mcrs.users_service.service;

import com.mcrs.users_service.VO.Department;
import com.mcrs.users_service.VO.ResponseTemplateVO;
import com.mcrs.users_service.entity.Users;
import com.mcrs.users_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    public ResponseTemplateVO getUserById(Long userId) {
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        Users user = userRepository.findById(userId).orElse(null);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId()
                , Department.class);
        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);
        return responseTemplateVO;
    }

    public Users saveUser(Users users) {
        return userRepository.save(users);
    }
}
