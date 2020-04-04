package com.test.KeyVault;


import com.azure.security.keyvault.secrets.SecretClient;
import com.tcs.azure.management.keyvault.ManageKeyVault;

public class TestKeyVaultManager {

public static void main(String[] args) {


    ManageKeyVault manageKeyVault = new ManageKeyVault();
   

		
		  String clientId = "09e72b93-ac71-44fb-896a-26edb211e265"; 
   String clientSecret = "d70d97b9-7fcd-4f66-92bb-42cd95c72baf";
   String tenantId = "2a7528ac-d996-41e4-80ce-189c2b58e715";
		   String vaultURL = "https://testrkj.vault.azure.net/";
		  String secretName = "secret";
		 
    SecretClient secretClient = manageKeyVault.getSecretClient(clientId, clientSecret, tenantId, vaultURL);
     String secretValue = manageKeyVault.getSecretValue(secretClient, secretName);
    System.out.println("SecretValue::" + secretValue);







}
}
