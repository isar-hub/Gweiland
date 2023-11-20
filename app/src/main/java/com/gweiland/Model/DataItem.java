package com.gweiland.Model;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("symbol")
	private String symbol;

	@SerializedName("quote")
	private Quote quote;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("slug")
	private String slug;

	@SerializedName("num_market_pairs")
	private int numMarketPairs;

	@SerializedName("total_supply")
	private int totalSupply;

	@SerializedName("cmc_rank")
	private int cmcRank;

	public String getSymbol(){
		return symbol;
	}

	public Quote getQuote(){
		return quote;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public String getSlug(){
		return slug;
	}

	public int getNumMarketPairs(){
		return numMarketPairs;
	}

	public int getTotalSupply(){
		return totalSupply;
	}

	public int getCmcRank(){
		return cmcRank;
	}
}