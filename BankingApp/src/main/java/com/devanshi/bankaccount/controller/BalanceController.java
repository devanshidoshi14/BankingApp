package com.devanshi.bankaccount.controller;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devanshi.bankaccount.pojo.Account;
import com.devanshi.bankaccount.util.StandardJsonResponse;
import com.devanshi.bankaccount.util.StandardJsonResponseImpl;



@RestController
@RequestMapping(value = "/balance")
public class BalanceController extends BaseController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody StandardJsonResponse getBalance() {

		StandardJsonResponse jsonResponse = new StandardJsonResponseImpl();
		HashMap<String, Object> responseData = new HashMap<>();

		try {
			Optional<Account> account = Optional.of(accountService.findById(ACCOUNT_ID).get());

			if (account.isPresent()) {
				responseData.put("balance", "$" + account.get().getAmount());

				jsonResponse.setSuccess(true);
				jsonResponse.setData(responseData);
				jsonResponse.setHttpResponseCode(HttpStatus.OK);
			} else {
				jsonResponse.setSuccess(false, "Resource not found", StandardJsonResponse.RESOURCE_NOT_FOUND_MSG);
				jsonResponse.setHttpResponseCode(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			logger.error("exception", e);
			jsonResponse.setSuccess(false, StandardJsonResponse.DEFAULT_MSG_TITLE_VALUE,
					StandardJsonResponse.DEFAULT_MSG_NAME_VALUE);
			jsonResponse.setHttpResponseCode(HttpStatus.INTERNAL_SERVER_ERROR);
			return jsonResponse;
		}

		return jsonResponse;
	}

}
