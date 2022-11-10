package org.sid.security.service;

import org.sid.security.entities.AppRole;
import org.sid.security.entities.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String username, String roleName);
    AppUser loadByUsername(String username);
    List<AppUser> listUsers();
}
