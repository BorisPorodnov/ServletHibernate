package com.hibcrud.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lot")
public class Lot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

/*    @ManyToOne
    @JoinColumn(name = "tender")
    private ProgramTender programTender;*/

    @Column(name = "number")
    private String number;

    @Column(name = "code")
    private String code;

    @Column(name = "theme")
    private String theme;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "limit_amount")
    private BigDecimal limitAmount;

    @Column(name = "contract_count")
    private Integer contractCount;

    @Column(name = "contract_amount")
    private BigDecimal contractAmount;

    @Column(name = "is_support_request")
    private Boolean isSupportRequest;

    @Column(name = "request_support_amount")
    private BigDecimal requestSupportAmount;

    @Column(name = "is_support_contract")
    private Boolean isSupportContract;

    @Column(name = "contract_support_amount")
    private BigDecimal contractSupportAmount;

    @NotNull
    @Column(name = "is_marketplace")
    private Boolean isMarketplace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marketplace")
    private RefMarketplace marketplace;

    @Column(name = "marketplace_amount")
    private BigDecimal marketplaceAmount;

/*    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marketplace_signatory")
    private Scientist marketplaceSignatory;*/

    @Column(name = "marketplace_note")
    private String marketplaceNote;

    private String note;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lot", orphanRemoval = true)
    private final Set<LotPrice> lotPrices;

    public Lot() {
        this.lotPrices = new HashSet<LotPrice>();
    }

    public Integer getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(BigDecimal limitAmount) {
        this.limitAmount = limitAmount;
    }

    public Integer getContractCount() {
        return contractCount;
    }

    public void setContractCount(Integer contractCount) {
        this.contractCount = contractCount;
    }

    public BigDecimal getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(BigDecimal contractAmount) {
        this.contractAmount = contractAmount;
    }

    public Boolean isSupportRequest() {
        return isSupportRequest;
    }

    public void setSupportRequest(Boolean isSupportRequest) {
        this.isSupportRequest = isSupportRequest;
    }

    public BigDecimal getRequestSupportAmount() {
        return requestSupportAmount;
    }

    public void setRequestSupportAmount(BigDecimal requestSupportAmount) {
        this.requestSupportAmount = requestSupportAmount;
    }

    public Boolean isSupportContract() {
        return isSupportContract;
    }

    public void setSupportContract(Boolean isSupportContract) {
        this.isSupportContract = isSupportContract;
    }

    public BigDecimal getContractSupportAmount() {
        return contractSupportAmount;
    }

    public void setContractSupportAmount(BigDecimal govermentContractSupportAmount) {
        this.contractSupportAmount = govermentContractSupportAmount;
    }

    @NotNull
    public Boolean isMarketplace() {
        return isMarketplace;
    }

    public void setMarketplace(Boolean isMarketplace) {
        this.isMarketplace = isMarketplace;
    }

    public RefMarketplace getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(RefMarketplace marketplace) {
        this.marketplace = marketplace;
    }

    public BigDecimal getMarketplaceAmount() {
        return marketplaceAmount;
    }

    public void setMarketplaceAmount(BigDecimal marketplaceAmount) {
        this.marketplaceAmount = marketplaceAmount;
    }

/*    public Scientist getMarketplaceSignatory() {
        return marketplaceSignatory;
    }

    public void setMarketplaceSignatory(Scientist marketplaceSignatory) {
        this.marketplaceSignatory = marketplaceSignatory;
    }*/

    public String getMarketplaceNote() {
        return marketplaceNote;
    }

    public void setMarketplaceNote(String marketplaceNote) {
        this.marketplaceNote = marketplaceNote;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<LotPrice> getLotPrices() {
        return lotPrices;
    }
}
