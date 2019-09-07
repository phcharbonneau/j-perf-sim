package org.ph.jopssim.timeout.service;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BankAccountServiceImpl implements BankAccountService {
	
	private String bankAccountMicroserviceURL = "http://localhost:9001/banknb";
	private int timeoutValue = 1000; // universal value of 30 secs
	private String accountNb = null;
	
	@Override
	public long getAccountNb(String userId) {
		
		try {
			ClientHttpRequestFactory requestFactory = getClientHttpRequestFactory();
			RestTemplate restTemplate = new RestTemplate(requestFactory);
			ResponseEntity<String> response
			  = restTemplate.getForEntity(bankAccountMicroserviceURL, String.class);
			
			accountNb = response.getBody();
			
		} catch (Exception any) {
			System.out.println(any);
			
			any.printStackTrace();
		}
		
		return Long.parseLong(accountNb);
	}
	
	private ClientHttpRequestFactory getClientHttpRequestFactory() {
	    
	    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory 
	    = new HttpComponentsClientHttpRequestFactory();
	    
	    clientHttpRequestFactory.setConnectTimeout(timeoutValue);
	    clientHttpRequestFactory.setConnectionRequestTimeout(timeoutValue);
	    clientHttpRequestFactory.setReadTimeout(timeoutValue);
	    
	    return clientHttpRequestFactory;
	}
}
