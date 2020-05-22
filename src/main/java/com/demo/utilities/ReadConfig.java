package com.demo.utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;




public class ReadConfig extends BaseReadConfig {

    /***
     * This is the overloaded constructor with argument as path 
     * @param path
     */
	public ReadConfig(String path) {
		if(path.contains("bin")){
			path = path.substring(0, path.lastIndexOf("/")-3);
        } else{
        	path = path.substring(0, path.lastIndexOf("/"));
        }
		try {
			config.load(new FileInputStream(path+"/Configuration/Config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.path = path;
		result = new ArrayList<String>();
	}
	
	public ReadConfig() {
		try {
			config.load(new FileInputStream("Configuration\\Config.properties"));			
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.path = "Configuration\\Config.properties";
		result = new ArrayList<String>();
	}

	/***
	 * This method will be used to retrieve values for the specfied key
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public  String getKeyValues(String key) throws FileNotFoundException, IOException {
		return getKeyValues(false, key);
	}

	/***
	 * This method will be used to retrieve the values as an array list by splitting with the provided separator
	 * @param key
	 * @param seperator
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String[] getKeyValues(String key, String seperator) throws FileNotFoundException, IOException {
		return super.getKeyValues(false, key, seperator);
	}
	
	
	

}
