package com.gweiland.Model;

import com.google.gson.annotations.SerializedName;

public class Quote{

	@SerializedName("USD")
	private USD uSD;

	@SerializedName("ETH")
	private ETH eTH;

	@SerializedName("BTC")
	private BTC bTC;

	public USD getUSD(){
		return uSD;
	}

	public ETH getETH(){
		return eTH;
	}

	public BTC getBTC(){
		return bTC;
	}
}