package com.codingz2m.mutualfundportfolioservice.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="mutual_fund")
//@Setter
//@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MutualFund {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable=false, length=120)
	private String fundName;
	@Column(nullable=false, length=20)
	private String schemeType;
	
	@Column(nullable=false, length=30)
	private String fundType;
	@Column(nullable=false, length=10)
	private float nav;
	@Column(nullable=false, length=20)
	private double investedValue;
	
	@Column(nullable=false, length=20)
	private double currentValue;
	@Column(nullable=false, length=20)
	private long totalUnits;
	@Column(nullable=false, length=20)
	private long freeUnits;
	
	@Column(nullable=false, length=20)
	private long lockedUnits;
	@Column(nullable=false, length=60)
	private String investmentDate;
	@Column(nullable=false, length=15)
	private String investmentType;

	@Column(nullable=false, length=200)
	private String transactionDetails;
	@Column(nullable=false, length=10)
	private String debitOrCredit;
	
	
	@ManyToOne 
	@JoinColumn(name="mutual_fund_portfolio_id")
	private MutualFundPortfolio mutualFundPortfolio;


	
}

