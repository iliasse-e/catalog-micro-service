package org.sid.security.web;

import org.sid.dto.ProductDTO;
import org.sid.security.entities.AppRole;
import org.sid.security.entities.AppUser;
import org.sid.security.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountRestController {

    private AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(path= "/users")
    public List<AppUser> userList() {
        return accountService.listUsers();
    }

    @PostMapping(path= "/users")
    public AppUser saveUser(@RequestBody AppUser appUser) {
        return accountService.addNewUser(appUser);
    }

    @PostMapping(path= "/roles")
    public AppRole saveRole(@RequestBody AppRole appRole) {
        return accountService.addNewRole(appRole);
    }

    @PostMapping(path= "/addRoleToUser")
    public void addRoleToUser(@RequestBody String userName, String roleName) {
        accountService.addRoleToUser(userName, roleName);
    }

}
