package unit;

import edu.hm.ba.kongo.infrastructure.auth.entities.Permission;
import edu.hm.ba.kongo.infrastructure.auth.services.PermissionEventService;
import edu.hm.ba.kongo.infrastructure.auth.services.PermissionEventServiceImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Fabian on 13.01.2017.
 */
public class PermissionEventServiceImplTest {

    PermissionEventService permissionEventService = new PermissionEventServiceImpl();

    @Test
    public void onAfterCreateTest(){
        Permission p = new Permission();
        String permission = "test";
        p.setPermission(permission);
        permissionEventService.onAfterCreate(p);
        assertEquals(permission, p.getPermission());
    }

    @Test
    public void onBeforeCreateTest(){
        Permission p = new Permission();
        String permission = "test";
        p.setPermission(permission);
        permissionEventService.onBeforeCreate(p);
        assertEquals(permission, p.getPermission());
    }

    @Test
    public void onAfterSaveTest(){
        Permission p = new Permission();
        String permission = "test";
        p.setPermission(permission);
        permissionEventService.onAfterSave(p);
        assertEquals(permission, p.getPermission());
    }

    @Test
    public void onBeforeSaveTest(){
        Permission p = new Permission();
        String permission = "test";
        p.setPermission(permission);
        permissionEventService.onBeforeSave(p);
        assertEquals(permission, p.getPermission());
    }

    @Test
    public void onAfterLinkSaveTest(){
        Permission p = new Permission();
        String permission = "test";
        String anotherObject = "test";
        p.setPermission(permission);
        permissionEventService.onAfterLinkSave(p, anotherObject);
        assertEquals(permission, p.getPermission());
    }

    @Test
    public void onBeforeLinkSaveTest(){
        Permission p = new Permission();
        String permission = "test";
        String anotherObject = "test";
        p.setPermission(permission);
        permissionEventService.onBeforeLinkDelete(p, anotherObject);
        assertEquals(permission, p.getPermission());
    }

    @Test
    public void onAfterLinkDeleteTest(){
        Permission p = new Permission();
        String permission = "test";
        String anotherObject = "test";
        p.setPermission(permission);
        permissionEventService.onAfterLinkDelete(p, anotherObject);
        assertEquals(permission, p.getPermission());
    }

    @Test
    public void onBeforeLinkDeleteTest(){
        Permission p = new Permission();
        String permission = "test";
        String anotherObject = "test";
        p.setPermission(permission);
        permissionEventService.onBeforeLinkDelete(p, anotherObject);
        assertEquals(permission, p.getPermission());
    }

    @Test
    public void onAfterDeleteTest(){
        Permission p = new Permission();
        String permission = "test";
        p.setPermission(permission);
        permissionEventService.onAfterDelete(p);
        assertEquals(permission, p.getPermission());
    }

    @Test
    public void onBeforeDelete(){
        Permission p = new Permission();
        String permission = "test";
        p.setPermission(permission);
        permissionEventService.onBeforeDelete(p);
        assertEquals(permission, p.getPermission());
    }

}