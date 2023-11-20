package com.gweiland.Model;

import com.google.gson.annotations.SerializedName;

public class USD{

	@SerializedName("percent_change_24h")
	private double percentChange24h;

	@SerializedName("volume_change_24h")
	private Object volumeChange24h;

	@SerializedName("price")
	private double price;

	@SerializedName("volume_24h")
	private double volume24h;

	@SerializedName("last_updated")
	private String lastUpdated;

	public double getPercentChange24h(){
		return percentChange24h;
	}

	public Object getVolumeChange24h(){
		return volumeChange24h;
	}

	public double getPrice(){
		return price;
	}

	public double getVolume24h(){
		return volume24h;
	}

	public String getLastUpdated(){
		return lastUpdated;
	}
}