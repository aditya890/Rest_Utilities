package com.demo.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Properties;

public class BaseReadConfig {

	Properties config = new Properties();
	String path = null;
	String configPath = null;
	
	ArrayList<String> result;

	public Properties getConfig() {
		return this.config;
	}

	public void setConfig(Properties config) {
		this.config = config;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getConfigPath() {
		return this.configPath;
	}

	public void setConfigPath(String configPath) {
		this.configPath = configPath;
	}

	

	public ArrayList<String> getResult() {
		return this.result;
	}

	public void setResult(ArrayList<String> result) {
		this.result = result;
	}

	public String getKeyValues(boolean flag, String key) throws FileNotFoundException, IOException {
		String keyValue = null;
		if (flag) {
			this.config.load(new FileInputStream(String.valueOf(this.configPath) + "/Config.properties"));
			keyValue = this.config.getProperty(key);
		} else {
			this.config.load(new FileInputStream("Configuration"+File.separator+"Config.properties"));
			keyValue = this.config.getProperty(key);
		}
		return keyValue;
	}

	public String[] getKeyValues(boolean flag, String key, String seperator) throws FileNotFoundException, IOException {
		String keyValue = null;
		String[] keyValues = null;
		if (flag) {
			this.config.load(new FileInputStream(String.valueOf(this.configPath) + "/Config.properties"));
			keyValue = this.config.getProperty(key);
			keyValues = keyValue.split(seperator);
		} else {
			this.config.load(new FileInputStream("Configuration"+File.separator+"Config.properties"));
			keyValue = this.config.getProperty(key);
			keyValues = keyValue.split(seperator);
		}
		return keyValues;
	}



	public boolean isClassExists(String className) {
		try {
			Class.forName(className);
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}
}
