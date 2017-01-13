package unit;

import de.muenchen.service.security.UserInfo;
import edu.hm.ba.kongo.infrastructure.auth.dto.AuthorityDto;
import edu.hm.ba.kongo.infrastructure.auth.dto.UserDto;
import edu.hm.ba.kongo.infrastructure.auth.entities.Authority;
import edu.hm.ba.kongo.infrastructure.auth.entities.Permission;
import edu.hm.ba.kongo.infrastructure.auth.entities.User;
import edu.hm.ba.kongo.infrastructure.auth.mapper.UserMapper;
import edu.hm.ba.kongo.infrastructure.auth.mapper.UserMapperImpl;
import org.apache.http.auth.AUTH;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Fabian on 13.01.2017.
 */
public class UserMapperImplTest {

    private UserMapper userMapper = new UserMapperImpl();
    private User testUser;

    private List<String> permissionNames = new ArrayList<>(Arrays.asList("testperm one", "testperm two", "testperm three"));
    private List<String> authorityNames = new ArrayList<>(Arrays.asList("auth 1", "auth 2", "auth 3"));

    private Set<Authority> authorities;

    @Before
    public void initializeUser(){
        Permission p1 = new Permission();
        p1.setPermission(permissionNames.get(0));
        Permission p2 = new Permission();
        p2.setPermission(permissionNames.get(1));
        Permission p3 = new Permission();
        p3.setPermission(permissionNames.get(2));
        Set<Permission> permissions1 = new HashSet<>(Collections.singletonList(p1));
        Set<Permission> permissions2 = new HashSet<>(Arrays.asList(p2, p3));
        Set<Permission> permissions3 = new HashSet<>();

        Authority authority1 = new Authority();
        authority1.setAuthority(authorityNames.get(0));
        authority1.setPermissions(permissions1);
        Authority authority2 = new Authority();
        authority2.setAuthority(authorityNames.get(1));
        authority2.setPermissions(permissions2);
        Authority authority3 = new Authority();
        authority3.setAuthority(authorityNames.get(2));
        authority3.setPermissions(permissions3);
        authorities = new HashSet<>(Arrays.asList(authority1, authority2, authority3));

        testUser = new User();
        testUser.setUsername("jackjonson");
        testUser.setPassword("password");
        testUser.setForname("jack");
        testUser.setSurname("jonson");
        testUser.setBirthdate(new GregorianCalendar(1960 + 1900, 10, 10).getTime());
        testUser.setEmail("jack@johnson.com");
        testUser.setUserEnabled(true);
        testUser.setAuthorities(authorities);
    }

    @Test
    public void authoritiesToAuthoritiesTest(){
        Set<String> strings = userMapper.authoritiesToAuthorities(authorities);
        assertEquals(strings, new HashSet<String>(permissionNames));
    }

    @Test
    public void authoritiesToGrantedAuthoritiesTest(){
        Set<GrantedAuthority> grantedAuthorities = userMapper.authoritiesToGrantedAuthorities(authorities);
        Set<String> grantedAuthorityNames = grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
        assertTrue(grantedAuthorityNames.containsAll(authorityNames));
    }

    @Test
    public void userToUserDtoTest(){
        UserDto userDto = userMapper.userToUserDto(testUser);
        assertEquals(testUser.getUsername(), userDto.getUsername());
        assertEquals(testUser.getForname(), userDto.getForname());
        assertEquals(testUser.getSurname(), userDto.getSurname());
        assertEquals(testUser.getBirthdate(), userDto.getBirthdate());
        assertEquals(testUser.getEmail(), userDto.getEmail());
        assertEquals(testUser.isUserEnabled(), userDto.isUserEnabled());
        assertEquals(userMapper.authoritiesToAuthorities(testUser.getAuthorities()), userDto.getAuthorities());
    }

    @Test
    public void authorityToAuthorityDtoTest(){
        Authority auth = authorities.iterator().next();
        AuthorityDto authorityDto = userMapper.authorityToAuthorityDto(auth);

        List<String> permissions = auth.getPermissions().stream().map(Permission::getPermission).collect(Collectors.toList());

        assertEquals(auth.getAuthority(), authorityDto.getAuthority());
        assertEquals(permissions, authorityDto.getPermissions());
    }

    @Test
    public void permissionsToPermissionsTest(){
        Permission p = new Permission();
        p.setPermission(permissionNames.get(0));
        Set<Permission> permissions = new HashSet<>(Arrays.asList(p));
        Set<String> strings = userMapper.permissionsToPermissions(permissions);
        assertEquals(strings.size(), 1);
        assertTrue(strings.contains(permissionNames.get(0)));
    }

    @Test
    public void userToUserInfoTest(){
        UserInfo userInfo = userMapper.userToUserInfo(testUser);
        assertEquals(testUser.getUsername(), userInfo.getUsername());
        assertEquals(testUser.getPassword(), userInfo.getPassword());
        assertEquals(userMapper.authoritiesToGrantedAuthorities(testUser.getAuthorities()), userInfo.getAuthorities());
    }

}
