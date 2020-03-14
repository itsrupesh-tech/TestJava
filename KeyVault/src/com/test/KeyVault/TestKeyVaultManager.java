package com.test.KeyVault;


import com.azure.security.keyvault.secrets.SecretClient;
import com.tcs.azure.management.keyvault.ManageKeyVault;

public class TestKeyVaultManager {

public static void main(String[] args) {


    ManageKeyVault manageKeyVault = new ManageKeyVault();
   /*String clientId = "1e47a2ca-9475-43f6-99c9-6d3762658cf0";
    String clientSecret = "ed5cc292-1c22-4e85-ae03-19bef906b465";
    String tenantId = "7f2c1900-9fd4-4b89-91d3-79a649996f0a";

     String vaultURL = "https://kv-sg01-sea-u-jfw-vlt01.vault.azure.net/";
     String secretName = "ipos-db";*/


		
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