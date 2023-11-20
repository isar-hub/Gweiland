package com.gweiland.Model;

import com.google.gson.annotations.SerializedName;

public class ETH{

	@SerializedName("percent_change_24h")
	private int percentChange24h;

	@SerializedName("volume_change_24h")
	private Object volumeChange24h;

	@SerializedName("price")
	private int price;

	@SerializedName("volume_24h")
	private int volume24h;

	public int getPercentChange24h(){
		return percentChange24h;
	}

	public Object getVolumeChange24h(){
		return volumeChange24h;
	}

	public int getPrice(){
		return price;
	}

	public int getVolume24h(){
		return volume24h;
	}
}