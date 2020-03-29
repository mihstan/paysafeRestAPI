package com.paysafe.test.typicalAPI.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.paysafe.test.typicalAPI.configuration.ApplicationConfiguration;
import com.paysafe.test.typicalAPI.service.AccessControlServerOptions;
import com.paysafe.test.typicalAPI.service.Account;
import com.paysafe.test.typicalAPI.service.Authentication;
import com.paysafe.test.typicalAPI.service.AuthenticationResult;
import com.paysafe.test.typicalAPI.service.AutheticatePayment;
import com.paysafe.test.typicalAPI.service.Auths;
import com.paysafe.test.typicalAPI.service.AuthsResponse;
import com.paysafe.test.typicalAPI.service.Enrollment;
import com.paysafe.test.typicalAPI.service.Monitor;

@RestController
public class ApplicationController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ApplicationConfiguration configuration;
	
    
    @GetMapping("/monitor")
	public Monitor monitor() {
		
		ResponseEntity<Monitor> responseEntity = restTemplate.getForEntity(configuration.getUrl() + "/monitor", Monitor.class);
		
		return responseEntity.getBody();
	}
    
	/*
	 * Return the EnrollmentCheck status based on account
	 */
	@PostMapping("/checkEnrollment/{accountId}")
	public ResponseEntity<String> performTest(@PathVariable int accountId, @RequestBody Account account) {
	

	    HttpEntity<Account> request = new HttpEntity<Account>(account, createBasicAuthHeader());
	    
	    
	    ResponseEntity<Enrollment> response = restTemplate.exchange(configuration.getUrl() + "/v1/accounts/{account_id}/enrollmentchecks",
	    									HttpMethod.POST, request, Enrollment.class,accountId);
	    
	    return new ResponseEntity<String>(response.getBody().getStatus(), HttpStatus.OK);
		
	}
	
	
	/*
	 * Validate enrollment and return the ACS URL and paReq to populate in the hidden form in the UI 
	 */
	@PostMapping("/getACSDetails/{accountId}")
	public ResponseEntity<AccessControlServerOptions> checkEnrollment(@PathVariable int accountId, @RequestBody Account account) {
		

	    HttpEntity<Account> request = new HttpEntity<Account>(account, createBasicAuthHeader());
	    
	    
	    ResponseEntity<Enrollment> response = restTemplate.exchange(configuration.getUrl() + "/v1/accounts/{account_id}/enrollmentchecks",
	    									HttpMethod.POST, request, Enrollment.class,accountId);
	    
	    Enrollment enrollment = response.getBody();
	    AccessControlServerOptions result = new AccessControlServerOptions();
	    if(enrollment.getThreeDEnrollment().equalsIgnoreCase("Y")) {
	    	result.setAcsURL(enrollment.getAcsURL());
	    	result.setPaReq(enrollment.getPaReq());
	    	return new ResponseEntity<AccessControlServerOptions>(result, HttpStatus.OK);
	    }
		return new ResponseEntity<AccessControlServerOptions>(result, HttpStatus.OK);
	}
	
	/*
	 * Return the AuthenticationResult status based on account
	 */
	@PostMapping("/checkAuthenticationResult/{accountId}")
	public ResponseEntity<String> checkAuthenticationResult(@PathVariable int accountId, @RequestBody Account account) {
	

	    HttpEntity<Account> request = new HttpEntity<Account>(account, createBasicAuthHeader());
	    
	    
	    ResponseEntity<Enrollment> enrollmentResponse = restTemplate.exchange(configuration.getUrl() + "/v1/accounts/{account_id}/enrollmentchecks",
	    									HttpMethod.POST, request, Enrollment.class,accountId);
	    Enrollment enrollment = enrollmentResponse.getBody();
	    if(enrollment.getThreeDEnrollment().equalsIgnoreCase("Y")) {
	    	
	    	AutheticatePayment paymentData = new AutheticatePayment();
	    	paymentData.setMerchantRefNum(enrollment.getMerchantRefNum());
	    	paymentData.setPaReq(enrollment.getPaReq());
	    	
	    	HttpEntity<AutheticatePayment> entity = new HttpEntity<AutheticatePayment>(paymentData, createBasicAuthHeader());
	    	ResponseEntity<AuthenticationResult> authenticationResponse = restTemplate.exchange(configuration.getUrl() + "/v1/accounts/{account_id}/enrollmentchecks/{enrollment_id}/authentications",
						HttpMethod.POST, entity, AuthenticationResult.class,accountId, enrollment.getId());
	    	return new ResponseEntity<String>(authenticationResponse.getBody().getStatus(), HttpStatus.OK);
	    }
	    return new ResponseEntity<String>(enrollmentResponse.getBody().getStatus(), HttpStatus.OK);
		
	}
	
	/*
	 * Process Purchase for an account
	 */

	@PostMapping("/processPurchase/{accountId}")
	public ResponseEntity<String> checkPayment(@PathVariable int accountId, @RequestBody Account account) {
		

		HttpEntity<Account> request = new HttpEntity<Account>(account, createBasicAuthHeader());
	    
	    
	    ResponseEntity<Enrollment> enrollmentResponse = restTemplate.exchange(configuration.getUrl() + "/v1/accounts/{account_id}/enrollmentchecks",
	    									HttpMethod.POST, request, Enrollment.class,accountId);
	    
	    Enrollment enrollment = enrollmentResponse.getBody();
	    if(enrollment.getThreeDEnrollment().equalsIgnoreCase("Y")) {
	    	
	    	AutheticatePayment paymentData = new AutheticatePayment();
	    	paymentData.setMerchantRefNum(enrollment.getMerchantRefNum());
	    	paymentData.setPaReq(enrollment.getPaReq());
	    	
	    	HttpEntity<AutheticatePayment> entity = new HttpEntity<AutheticatePayment>(paymentData, createBasicAuthHeader());
	    	ResponseEntity<AuthenticationResult> authenticationResponse = restTemplate.exchange(configuration.getUrl() + "/v1/accounts/{account_id}/enrollmentchecks/{enrollment_id}/authentications",
						HttpMethod.POST, entity, AuthenticationResult.class,accountId, enrollment.getId());
	    	AuthenticationResult authResult = authenticationResponse.getBody();
	    	if(authResult.getStatus().equalsIgnoreCase("completed")) {
	    		Auths auths = new Auths();
	    		auths.setMerchantRefNum(paymentData.getMerchantRefNum());
	    		auths.setAmount(enrollment.getAmount());
	    		auths.setSettleWithAuth(true);
	    		auths.setCard(new Auths.Card(enrollment.getCard().getCardType(), enrollment.getCard().getCardExpiry(), 0));
	    		Authentication authentication = new Authentication();
	    		authentication.setCavv(authResult.getCavv());
	    		authentication.setEci(authResult.getEci());
	    		authentication.setSignatureStatus(authResult.getSignatureStatus());
	    		authentication.setThreeDEnrollment(enrollment.getThreeDEnrollment());
	    		authentication.setThreeDResult(authResult.getThreeDResult());
	    		authentication.setXid(authResult.getXid());
	    		auths.setAuthentication(authentication);
	    		HttpEntity<Auths> authsEntity = new HttpEntity<Auths>(auths, createBasicAuthHeader());
		    	ResponseEntity<AuthsResponse> authsResponse = restTemplate.exchange("https://api.test.paysafe.com/cardpayments/v1/accounts/{account_id}/auths",
							HttpMethod.POST, authsEntity, AuthsResponse.class,accountId);
		    	return new ResponseEntity<String>(authsResponse.getBody().getStatus(), HttpStatus.OK);
	    	} else {
	    		return new ResponseEntity<String>(authResult.getStatus(), HttpStatus.OK);
	    	}
	    }
	    
		return new ResponseEntity<String>(enrollment.getStatus(), HttpStatus.OK);
	}

	/*
	 * Create the Authorization header based account username and password defined in the configuration file
	 */
	private HttpHeaders createBasicAuthHeader() {
		
	    String userNamePwdString = configuration.getUser() + ":" + configuration.getPassword();
	    String base64Creds = Base64.getEncoder().encodeToString(userNamePwdString.getBytes());
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Authorization", "Basic " + base64Creds);
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
	    return headers;
		
	}


}
