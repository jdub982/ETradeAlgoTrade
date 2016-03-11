package IronCondorCapitalPkg;

import com.etrade.etws.account.Account;
import com.etrade.etws.account.AccountListResponse;
import com.etrade.etws.oauth.sdk.client.IOAuthClient;
import com.etrade.etws.oauth.sdk.client.OAuthClientImpl;
import com.etrade.etws.oauth.sdk.common.Token;
import com.etrade.etws.sdk.client.ClientRequest;
import com.etrade.etws.sdk.client.Environment;
import com.etrade.etws.sdk.client.MarketClient;
import com.etrade.etws.market.*;
import java.awt.Desktop;
import java.net.URI;

import javax.swing.JOptionPane;

public class IronCondorCapitalMain {

	public static void main(String args[]){
		try {
			Desktop.getDesktop().browse(new URI("http://www.google.com"));
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		ClientRequest request = new ClientRequest();
		request.setEnv(Environment.LIVE);
		request.setConsumerKey("Consumer_Key");
		request.setConsumerSecret("Consumer_Secret");
		request.setToken("Access_Token");
		request.setTokenSecret("Token_secret");
		MarketClient client = new MarketClient(request);
		OptionChainRequest req = new OptionChainRequest();
	
	}
}
