package edu.hm.ba.kongo.infrastructure.auth.controller;

import edu.hm.ba.kongo.infrastructure.auth.dto.AuthorityDto;
import edu.hm.ba.kongo.infrastructure.auth.dto.UserDto;
import edu.hm.ba.kongo.infrastructure.auth.entities.Permission;
import edu.hm.ba.kongo.infrastructure.auth.entities.User;
import edu.hm.ba.kongo.infrastructure.auth.mapper.UserMapper;
import edu.hm.ba.kongo.infrastructure.auth.repositories.PermissionRepository;
import edu.hm.ba.kongo.infrastructure.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.ArrayList;

/**
 * Created by dennis_huning on 08.12.15.
 */
@Controller
public class UserRestController {

    @Autowired
    UserRepository userRepository;

    UserMapper userMapper = UserMapper.INSTANCE;

    @Autowired
    PermissionRepository permissionRepository;

    /**
     * Aktiviert eine konfortable Möglichkeit den token in lesbare Userinformation umzuwandeln. Kann im ResourceServer über die Property "spring.oauth2.resource.userInfoUri" referenziert werden: spring.oauth2.resource.userInfoUri: http://localhost:9999/uaa/user
     */
    @RequestMapping("/user")
    @ResponseBody
    public UserDto user(Principal user) {
        final User savedUser = userRepository.findFirstByUsername(user.getName());
        Iterable<Permission> allPermissions = permissionRepository.findAll();
        UserDto dto = userMapper.userToUserDto(savedUser);
        if (savedUser.isAdmin()) {
            // The authority ADMIN gets automatically all permissions. Hence no service needs to map the permissions manual.
            AuthorityDto all = new AuthorityDto();
            all.setPermissions(new ArrayList<>());
            all.setAuthority("all");
            allPermissions.forEach(permission -> all.getPermissions().add(permission.getPermission()));
            dto.getAuthorities().addAll(all.getPermissions());
        }
        return dto;
    }
}

