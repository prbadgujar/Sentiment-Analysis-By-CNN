package MyPack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;


public class FacebookApi {
	public static void getData() throws FacebookException
	{
		// Make the configuration builder
		ConfigurationBuilder confBuilder = new ConfigurationBuilder();
		confBuilder.setDebugEnabled(true);

		// Set application id, secret key and access token
        confBuilder.setOAuthAppId("381764059077144");
        confBuilder.setOAuthAppSecret("157e27f8eb3d8aeefcbbf530faf84771");
        confBuilder.setOAuthAccessToken("EAAFbNl8hGhgBAMDBNa7z1buDwiZBveAWQKlZBjEKi6TL98uSdElBjqr7r0KAFLmPnNOI3LBWxZBbZCN7tuRkvRE21z9VetZC2xh8rQJsxSKn9fvuCytYJjZBCXMPCqvRwMoCMfh31JQ4i7ZAoXPYl0cqi1ItjTJIng9O8XJE4ldvgZDZD");

        // Set permission
        confBuilder.setOAuthPermissions("email,publish_stream, id, name, first_name, last_name, generic");
        confBuilder.setUseSSL(true);
        confBuilder.setJSONStoreEnabled(true);

        // Create configuration object
        Configuration configuration = confBuilder.build();

        // Create facebook instance
        FacebookFactory ff = new FacebookFactory(configuration);
        Facebook facebook = ff.getInstance();

		try {
				// Get facebook posts
				String results = getFacebookPostes(facebook);
				String responce = stringToJson(results);

				// Create file and write to the file
				File file = new File("C:\\facebook.txt");
				if (!file.exists())
				{
					file.createNewFile();
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(results);
					bw.close();
					System.out.println("Writing complete");
				}
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String getFacebookPostes(Facebook facebook) throws FacebookException {
		// Get posts for a particular search
		ResponseList<Post> results =  facebook.getPosts("Reebok");
		return results.toString();

	}
	public static String stringToJson(String data)
	{
		// Create JSON object
		JSONObject jsonObject = JSONObject.fromObject(data);
		JSONArray message = (JSONArray) jsonObject.get("message");
		System.out.println("Message : "+message);
		return "Done";
	}

}