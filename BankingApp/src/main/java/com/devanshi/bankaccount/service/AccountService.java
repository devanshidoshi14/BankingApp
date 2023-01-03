package com.devanshi.bankaccount.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devanshi.bankaccount.pojo.Account;

@Repository
public interface AccountService extends CrudRepository<Account, Long> {


}
