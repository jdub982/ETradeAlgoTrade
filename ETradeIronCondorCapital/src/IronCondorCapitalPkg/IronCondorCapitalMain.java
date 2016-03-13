package IronCondorCapitalPkg;

import com.etrade.etws.account.Account;
import com.etrade.etws.account.AccountListResponse;
import com.etrade.etws.oauth.sdk.client.IOAuthClient;
import com.etrade.etws.oauth.sdk.client.OAuthClientImpl;
import com.etrade.etws.oauth.sdk.common.Token;
import com.etrade.etws.sdk.client.ClientRequest;
import com.etrade.etws.sdk.client.Environment;
import com.etrade.etws.sdk.client.MarketClient;
import com.etrade.etws.sdk.common.ETWSException;
import com.etrade.etws.market.*;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

public class IronCondorCapitalMain {

	public static final void main(String args[]) throws IOException, ETWSException, URISyntaxException{
		IOAuthClient client = null;
		ClientRequest request = null;
		Token token = null;
		String oauth_consumer_key = "2bfcf0df027807eccd78686bf4f6e1ad"; // Your consumer key
		String oauth_consumer_secret = "58a23519e4dce2b881edb367d94c1f98"; // Your consumer secret
		String oauth_request_token = null; // Request token 
		String oauth_request_token_secret = null; // Request token secret
		client = OAuthClientImpl.getInstance(); // Instantiate IOAUthClient
		request = new ClientRequest(); // Instantiate ClientRequest
		request.setEnv(Environment.SANDBOX); // Use sandbox environment
		request.setConsumerKey(oauth_consumer_key); //Set consumer key
		request.setConsumerSecret(oauth_consumer_secret); // Set consumer secret
		token= client.getRequestToken(request); // Get request-token object
		oauth_request_token  = token.getToken(); // Get token string
		oauth_request_token_secret = token.getSecret(); // Get token secret
		request.setToken(oauth_request_token);
		request.setTokenSecret(oauth_request_token_secret);

		String authorizeURL = null;
		authorizeURL = client.getAuthorizeUrl(request); // E*TRADE authorization URL
		//System.out.println(authorizeURL);
		URI uri = new java.net.URI(authorizeURL);
		Desktop desktop = Desktop.getDesktop();
		desktop.browse(uri);
		
		String oauth_access_token = null; // Variable to store access token 
		String oauth_access_token_secret = null; // Variable to store access token secret
		String oauth_verify_code = "Your verification_code"; // Should contain the Verification Code received from the authorization step
		 
		request = new ClientRequest(); // Instantiate ClientRequest
		request.setEnv(Environment.SANDBOX); // Use sandbox environment
		// Prepare request
		request.setConsumerKey(oauth_consumer_key); // Set consumer key
		request.setConsumerSecret(oauth_consumer_secret); // Set consumer secret
		request.setToken(oauth_request_token); // Set request token
		request.setTokenSecret(oauth_request_token_secret); // Set request-token secret
	 	request.setVerifierCode(oauth_verify_code); // Set verification code
		 
	 	// Get access token
	 	token = client.getAccessToken(request); // Get access-token object
	 	oauth_access_token = token.getToken(); // Access token string
	 	oauth_access_token_secret = token.getSecret(); // Access token secret
	}
}
