package com.service;

import com.domain.Account;

import java.util.List;

public interface AccountService {

    public List<Account> findAll();

    void save(Account account);

    Account findById(Integer id);

    void update(Account account);

    void deleteBatch(Integer[] ids);
}
