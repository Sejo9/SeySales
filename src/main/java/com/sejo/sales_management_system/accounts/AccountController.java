package com.sejo.sales_management_system.accounts;

import com.sun.el.parser.BooleanNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/accounts")
@CrossOrigin("*")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAccounts(){
        return accountService.getAccounts();
    }

    @PostMapping
    public Boolean createNewAccount(@RequestBody Account account){return accountService.addNewAccount(account);}

    @PostMapping(path = "login")
    public AccountLoginResponse loginUser(
            @RequestParam String UoE,
            @RequestParam String password
    ) throws NoSuchAlgorithmException {
        return accountService.loginUser(UoE,password);
    }

    @PutMapping(path = "password/{userId}")
    public void changePassword(
            @PathVariable Long userId,
            @RequestParam String password
    ){
        accountService.changePassword(userId,password);
    }

    @GetMapping(path = "{userId}")
    public Account getLoggedInAccount(@PathVariable("userId") Long userId){
        return accountService.getLoggedInAccount(userId);
    }
}
