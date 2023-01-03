package com.devanshi.bankaccount.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.devanshi.bankaccount.service.AccountService;

public class BaseController {

	protected static final long ACCOUNT_ID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	AccountService accountService;
}
