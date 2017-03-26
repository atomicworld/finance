package com.mf.shareholder.entity;

import java.util.List;

import com.mf.financemng.entity.FinanceShareholder;
import com.mf.financemng.entity.Profit;

public class ShareholderList {
	
	private List<Profit> profitlist;
	
	private List<FinanceShareholder> shareholdlist;

	public List<Profit> getProfitlist() {
		return profitlist;
	}

	public void setProfitlist(List<Profit> profitlist) {
		this.profitlist = profitlist;
	}

	public List<FinanceShareholder> getShareholdlist() {
		return shareholdlist;
	}

	public void setShareholdlist(List<FinanceShareholder> shareholdlist) {
		this.shareholdlist = shareholdlist;
	}
	
}
