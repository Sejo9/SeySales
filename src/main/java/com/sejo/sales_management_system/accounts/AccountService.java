package com.sejo.sales_management_system.accounts;

import com.sejo.sales_management_system.Sha256Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public AccountLoginResponse loginUser(String UoE, String password) throws NoSuchAlgorithmException {

        Account account;
        String hashedPassword = Sha256Hashing.Hash(password);

        if (UoE.contains("@")){
            Optional<Account> accountByEmail = accountRepository.findAccountByEmail(UoE);
            if(accountByEmail.isEmpty()){
                return new AccountLoginResponse(false,"Email "+UoE+" does not exist",null);
            }
            account = accountByEmail.get();
        }else{
            Optional<Account> accountByUsername = accountRepository.findAccountByUsername(UoE);
            if(accountByUsername.isEmpty()){
                return new AccountLoginResponse(false,"Username "+UoE+" does not exist",null);
            }
            account = accountByUsername.get();
        }

        if (Objects.equals(hashedPassword,account.getPassword())){
            return new AccountLoginResponse(true,"Login Successful",account.getUserId());
        }else{
            return new AccountLoginResponse(false,"Invalid Password",null);
        }
    }

    @Transactional
    public void changePassword(Long userId,String password){
    }


    public Account getLoggedInAccount(Long userId) {
        return accountRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("Account with ID "+userId+" does not exist")
        );
    }

    public Boolean addNewAccount(Account account) {
        Optional<Account> accountByEmailAndUsername = accountRepository.findAccountByEmailAndUsername(account.getEmail(), account.getUsername());

        if (accountByEmailAndUsername.isPresent()){
            throw new IllegalStateException("This account already exists");
        }

        accountRepository.save(account);
        return true;
    }
}
