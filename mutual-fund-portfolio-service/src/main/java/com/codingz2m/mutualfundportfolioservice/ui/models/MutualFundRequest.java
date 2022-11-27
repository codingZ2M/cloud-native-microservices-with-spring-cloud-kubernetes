package com.codingz2m.mutualfundportfolioservice.ui.models;

import com.codingz2m.mutualfundportfolioservice.repository.MutualFundPortfolio;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class MutualFundRequest {
	@Null
	private Long id;
	@NotNull(message="Fund Name Cannot Be Null")
	private String fundName;
	@NotNull(message="Scheme Type Cannot Be Null")
		private String schemeType;
		@NotNull(message="Fund Type Cannot Be Null")
		private String fundType;
	
	@NotNull(message="NAV Cannot Be Null")
	@Min(value = 0, message="NAV Value must be greater than or equal to 0 ")
	private float nav;
	@NotNull(message="Invested Value Cannot Be Null")
	@Min(value = 0, message="Invested Value must be greater than or equal to 0 ")
	private double investedValue;
	
	@NotNull(message="Current Value Cannot Be Null")
	@Min(value = 0, message="Current Value must be greater than or equal to 0 ")
	private double currentValue;
	@NotNull(message="tottalUnits Cannot Be Null")
	@Min(value = 0, message="Total Units must be greater than or equal to 0 ")
	private long totalUnits;
	
	@NotNull(message="Free Units Cannot Be Null")
	private long freeUnits;
	@NotNull(message="Locked Units Cannot Be Null")
	private long lockedUnits;
	@NotNull(message="Investment Date Cannot Be Null")
	private String investmentDate;

	@NotNull(message="Investment Type Cannot Be Null")
	private String investmentType;
	@NotNull(message="Transaction Details Cannot Be Null")
	private String transactionDetails;
	@NotNull(message="Debit/Credit Value Cannot Be Null")
	private String debitOrCredit;
	
	private MutualFundPortfolio mutualFundPortfolio;

	
	
}
