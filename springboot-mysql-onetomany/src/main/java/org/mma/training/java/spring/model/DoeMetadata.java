package org.mma.training.java.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * The persistent class for the doe_metadata database table.
 *
 */

@Entity
@Table(name="doe_metadata")
//@NamedQuery(name="DoeMetadata.findAll", query="SELECT d FROM DoeMetadata d")
public class DoeMetadata implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="doe_id")
	private int doeId;

	@Lob
	@Column(name="additional_information")
	private String additionalInformation;

	@Size(max=1000, message="Author ORCID field should not exceed more than 1000 characters")
	@Column(name="author_orcid")
	private String authorOrcid;

	@Lob
	@NotNull(message="Authors cannot be empty")
	@Size(min=1, message="Authors cannot be empty")
	private String authors;

	@Size(max=255, message="Combined ID Exact Match field should not exceed more than 255 characters")
	@Column(name="combined_id_exact_match")
	private String combinedIdExactMatch;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="conference_end_date")
	private Date conferenceEndDate;

	@Lob
	@Column(name="conference_location")
	@Size(max=4000, message="Conference Location size must be between 0-4000")
	private String conferenceLocation;

	@Lob
	@Column(name="conference_name")
	//@Size(min=1, message="Conference Name cannot be empty")
	private String conferenceName;



	@Temporal(TemporalType.TIMESTAMP)

	@Column(name="conference_start_date")

	private Date conferenceStartDate;



	@Temporal(TemporalType.TIMESTAMP)

	@Column(name="date_covered_from")

	private Date dateCoveredFrom;



	@Temporal(TemporalType.TIMESTAMP)

	@Column(name="date_covered_to")

	private Date dateCoveredTo;



	@Column(name="date_to_combined_table")

	private Timestamp dateToCombinedTable;



	@NotNull(message="Document Availability cannot be empty")

	//	            @Pattern(regexp="^[A-F]{1}$", message="Distribution Availability code has to be between A-F. Contact your DOE Administrator to identify the right code")

	@Size(max=255, message="Distribution Availability field should not exceed more than 255 characters")

	@Column(name="distribution_availability")

	private String distributionAvailability;



	@Temporal(TemporalType.TIMESTAMP)

	@Column(name="distribution_date")

	private Date distributionDate;



	@Size(max=255, message="Distribution OSTI Journal field should not exceed more than 255 characters")

	private String distribution_ostl_Journal;





	//	            @Pattern(regexp="^[0-9]{1}|1[0-2]{1}$", message="Distribution Reasons can only be between 1-12. Contact your DOE Administrator for the correct code")

	@Size(max=255, message="Distribution Reasons field should not exceed more than 255 characters")

	@Column(name="distribution_reasons")

	private String distributionReasons;



	//	            @Pattern(regexp="^[0-1]$", message="Abstract Distribution Same-As Report has to be either 0 or 1")

	@Size(max=255, message="Distribution Same Report field should not exceed more than 255 characters")

	@Column(name="distribution_same_report")

	private String distributionSameReport;



	@Lob

	@Column(name="document_sub_type_desc")

	@NotNull(message="Document SubType cannot be empty")

	private String documentSubTypeDesc;



	@Lob

	@Column(name="document_type_desc")

	@NotNull(message="Document Type cannot be empty")

	private String documentTypeDesc;



	@Size(max=512, message="DOI field should not exceed more than 512 characters")

	@Column(name="doi")

	private String doi;



	//@Pattern(regexp="^[0-1]$", message="Export Control has to be either 0 or 1")

	@Size(max=255, message="Export Control field should not exceed more than 255 characters")

	@Column(name="export_control")

	private String exportControl;



	@Column(name="file_name")

	private String fileName;



	@Size(max=255, message="Funding Organization Acronym field should not exceed more than 255 characters")

	@Column(name="funding_org_acronym")

	private String fundingOrgAcronym;



	@Size(max=1000, message="Funding Organization Contract Number field should not exceed more than 1000 characters")

	@Column(name="funding_org_contract_num")

	private String fundingOrgContractNum;



	@Size(max=1000, message="Funding Organization Grant Number field should not exceed more than 1000 characters")

	@Column(name="funding_org_grant_number")

	private String fundingOrgGrantNumber;



	@Lob

	@NotNull(message="Funding Organization Name cannot be empty")

	@Size(min=1, message="Funding Organization Name cannot be empty")

	@Column(name="funding_org_name")

	private String fundingOrgName;



	@Size(max=1000, message="Funding Organization Report Number field should not exceed more than 1000 characters")

	@Column(name="funding_org_report_number")

	private String fundingOrgReportNumber;



	@Size(max=255, message="Fuzzy Match field should not exceed more than 255 characters")

	@Column(name="fuzzy_match")

	private String fuzzyMatch;



	@NotNull(message="Government Contact Email must not be empty")

	//	            @Pattern(regexp="^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$",

	//	                                          message="Government Contact Email must me in an email format, e.g. optout@mail.mil or something@yahoo.com")

	@Size(max=255, message="Government Contact Email field should not exceed more than 255 characters")

	@Column(name="government_contact_email")

	private String governmentContactEmail;



	//@Pattern(regexp="^[\\p{L}\\s'.-]+$", message="Government POC First Name must contain letters and (.), (-), (') only")

	@Size(max=255, message="Government Contact First Name field should not exceed more than 255 characters")

	@Column(name="government_contact_first_name")

	private String governmentContactFirstName;



	@NotNull(message="Government POC Last Name cannot be empty")

	@Size(max=255, message="Government Contact Last Name field should not exceed more than 255 characters")

	//@Pattern(regexp="^[\\p{L}\\s'.-]+$", message="Government POC Last Name must contain letters and (.), (-), (') only")

	@Column(name="government_contact_last_name")

	private String governmentContactLastName;



	@NotNull(message="Government POC Phone Number cannot be empty")

	@Size(max=255, message="Government Contact Phone field should not exceed more than 255 characters")

	//	            @Pattern(regexp = "^[0-9]{10}|([0-9]{3}\\-[0-9]{3}\\-[0-9]{4})$", message="Government POC Phone Number must contain only numbers")

	@Column(name="government_contact_phone")

	private String governmentContactPhone;



	@Size(max=255, message="Embedded Media field should not exceed more than 255 characters")

	@Column(name="has_embedded_media")

	private String hasEmbeddedMedia;



	@Temporal(TemporalType.TIMESTAMP)

	@Column(name="journal_date")

	private Date journalDate;



	@Size(max=255, message="Issue Number field should not exceed more than 255 characters")

	@Column(name="journal_issue_number")

	private String journalIssueNumber;



	//@Pattern(regexp="^p\\.\\s([0-9]*\\-[0-9]*)$", message="Page Numbers must be in this format, e.g. p. 100-110")

	@Size(max=255, message="Page Number field should not exceed more than 255 characters")

	@Column(name="journal_page_number")

	private String journalPageNumber;



	@NotNull(message="Journal Title cannot be empty")

	@Column(name="journal_title")

	private String journalTitle;



	@Size(max=255, message="Volume Number field should not exceed more than 255 characters")

	@Column(name="journal_vol_number")

	private String journalVolNumber;



	@Column(name="matching_approver_ldap_id")

	private String matchingApproverLdapId;



	//	            @Pattern(regexp="^[0-9]*$", message="Number of Pages must be numeric only")

	@Size(max=255, message="Number Of Pages field should not exceed more than 255 characters")

	@Column(name="number_of_pages")

	private String numberOfPages;



	@Lob

	@Column(name="parent_agency")

	private String parentAgency;



	@Lob

	@NotNull(message="Performing Organization Name cannot be empty")

	@Size(min=1, message="Performing Organization Name cannot be empty")

	@Column(name="performing_org_name")

	private String performingOrgName;



	@Lob

	@Column(name="performing_org_report_num")

	private String performingOrgReportNum;



	@Column(name="pubdefense_date_created")

	private Timestamp pubdefenseDateCreated;



	@Size(max=1, message="Release Flag field should not exceed more than 1 character")

	@Column(name="release_flag")

	private String releaseFlag;



	@Size(max=255, message="Source field should not exceed more than 255 characters")

	private String source;



	@Lob

	@Column(name="subject_info_abstract")

	private String subjectInfoAbstract;



	@Lob

	@Column(name="subject_terms")

	private String subjectTerms;





	//	            @Pattern(regexp="^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$",

	//	                                          message="Submitter Email must me in an email format, e.g. optout@mail.mil or something@yahoo.com")

	@NotNull(message="Submitter Email must not be empty")

	@Size(max=255, message="Submitter Email Address field should not exceed more than 255 characters")

	@Column(name="submitter_email_address")

	private String submitterEmailAddress;



	@Size(max=255, message="Submitter First Name field should not exceed more than 255 characters")

	@Column(name="submitter_first_name")

	private String submitterFirstName;



	@Size(max=1, message="Submitter Is Author field should not exceed more than 1 character")

	@Column(name="submitter_is_author")

	private String submitterIsAuthor;



	@NotNull(message="Submitter Last Name must not be empty")

	//@Pattern(regexp="^[\\p{L}\\s'.-]+$", message="Submitter Last Name must contain letters and (.), (-), (') only")

	@Size(max=255, message="Submitter Last Name field should not exceed more than 255 characters")

	@Column(name="submitter_last_name")

	private String submitterLastName;



	@Size(max=255, message="Submitter Middle Initial field should not exceed more than 255 characters")

	@Column(name="submitter_middle_initial")

	private String submitterMiddleInitial;



	@NotNull(message="Submitter Phone must not be empty")

	//	            @Pattern(regexp = "^[0-9]{10}|([0-9]{3}\\-[0-9]{3}\\-[0-9]{4})$", message="Submitter Phone Number must contain only numbers")

	@Size(max=255, message="Submitter Phone field should not exceed more than 255 characters")

	@Column(name="submitter_phone")

	private String submitterPhone;



	@NotNull(message="Title may not be empty")

	@Size(min=1, message="Title is required ")

	@Column(name="title")

	private String title;



	@NotNull(message="Web Publication Date cannot be empty")

	@Temporal(TemporalType.TIMESTAMP)

	@Column(name="web_publication_date")

	private Date webPublicationDate;



	// uni-directional many-to-one association to DoeAuthorDetail

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
//
//	@JoinColumn(name = "doe_id", nullable = false)
//
//	@Fetch(value = FetchMode.SUBSELECT)
//
//	@Valid
//
//	private List<DoeAuthorDetail> doeAuthorDetails;



//	// uni-directional many-to-one association to DoeFundingOrganization
//
//	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
//
//	@JoinColumn(name = "doe_id", nullable = false)
//
//	@Fetch(value = FetchMode.SUBSELECT)
//
//	@Valid
//
//	private List<DoeFundingOrganization> doeFundingOrganizations;



//	// uni-directional many-to-one association to DoePerformingOrg
//
//	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
//
//	@JoinColumn(name = "doe_id", nullable = false)
//
//	@Fetch(value = FetchMode.SUBSELECT)
//
//	@Valid
//
//	private List<DoePerformingOrg> doePerformingOrgs;



	// uni-directional one-to-one association to DoeSubmissionTracking

//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//
//	@JoinColumn(name = "submission_tracking_id", nullable = false)
//
//	@Valid
//
//	private DoeSubmissionTracking doeSubmissionTracking;



	@Column(name="open_access")

	private boolean openAccess;



	@Column(name="record_number_masi")

	private String recordNumberMasi;



	@Column(name="date_created_masi")

	private Timestamp dateCreatedMasi;



	@Column(name="pdf_url")

	private String pdfUrl;



	public DoeMetadata() {

		//

	}



	public int getDoeId() {

		return this.doeId;

	}



	public void setDoeId(int doeId) {

		this.doeId = doeId;

	}



	public String getAdditionalInformation() {

		return this.additionalInformation;

	}



	public void setAdditionalInformation(String additionalInformation) {

		this.additionalInformation = additionalInformation;

	}



	public String getAuthorOrcid() {

		return this.authorOrcid;

	}



	public void setAuthorOrcid(String authorOrcid) {

		this.authorOrcid = authorOrcid;

	}



	public String getAuthors() {

		return this.authors;

	}



	public void setAuthors(String authors) {

		this.authors = authors;

	}



	public String getCombinedIdExactMatch() {

		return this.combinedIdExactMatch;

	}



	public void setCombinedIdExactMatch(String combinedIdExactMatch) {

		this.combinedIdExactMatch = combinedIdExactMatch;

	}



	public Date getConferenceEndDate() {

		return this.conferenceEndDate;

	}



	public void setConferenceEndDate(Date conferenceEndDate) {

		this.conferenceEndDate = conferenceEndDate;

	}



	public String getConferenceLocation() {

		return this.conferenceLocation;

	}



	public void setConferenceLocation(String conferenceLocation) {

		this.conferenceLocation = conferenceLocation;

	}



	public String getConferenceName() {

		return this.conferenceName;

	}



	public void setConferenceName(String conferenceName) {

		this.conferenceName = conferenceName;

	}



	public Date getConferenceStartDate() {

		return this.conferenceStartDate;

	}



	public void setConferenceStartDate(Date conferenceStartDate) {

		this.conferenceStartDate = conferenceStartDate;

	}



	public Date getDateCoveredFrom() {

		return this.dateCoveredFrom;

	}



	public void setDateCoveredFrom(Date dateCoveredFrom) {

		this.dateCoveredFrom = dateCoveredFrom;

	}



	public Date getDateCoveredTo() {

		return this.dateCoveredTo;

	}



	public void setDateCoveredTo(Date dateCoveredTo) {

		this.dateCoveredTo = dateCoveredTo;

	}



	public Timestamp getDateToCombinedTable() {

		return this.dateToCombinedTable;

	}



	public void setDateToCombinedTable(Timestamp dateToCombinedTable) {

		this.dateToCombinedTable = dateToCombinedTable;

	}



	public String getDistributionAvailability() {

		return this.distributionAvailability;

	}



	public void setDistributionAvailability(String distributionAvailability) {

		this.distributionAvailability = distributionAvailability;

	}



	public Date getDistributionDate() {

		return this.distributionDate;

	}



	public void setDistributionDate(Date distributionDate) {

		this.distributionDate = distributionDate;

	}



	public String getDistribution_ostl_Journal() {

		return this.distribution_ostl_Journal;

	}



	public void setDistribution_ostl_Journal(String distribution_ostl_Journal) {

		this.distribution_ostl_Journal = distribution_ostl_Journal;

	}



	public String getDistributionReasons() {

		return this.distributionReasons;

	}



	public void setDistributionReasons(String distributionReasons) {

		this.distributionReasons = distributionReasons;

	}



	public String getDistributionSameReport() {

		return this.distributionSameReport;

	}



	public void setDistributionSameReport(String distributionSameReport) {

		this.distributionSameReport = distributionSameReport;

	}



	public String getDocumentSubTypeDesc() {

		return this.documentSubTypeDesc;

	}



	public void setDocumentSubTypeDesc(String documentSubTypeDesc) {

		this.documentSubTypeDesc = documentSubTypeDesc;

	}



	public String getDocumentTypeDesc() {

		return this.documentTypeDesc;

	}



	public void setDocumentTypeDesc(String documentTypeDesc) {

		this.documentTypeDesc = documentTypeDesc;

	}



	public String getDoi() {

		return this.doi;

	}



	public void setDoi(String doi) {

		this.doi = doi;

	}



	public String getExportControl() {

		return this.exportControl;

	}



	public void setExportControl(String exportControl) {

		this.exportControl = exportControl;

	}



	public String getFileName() {

		String test = StringUtils.substringAfterLast(fileName, "/");

		return  fileName;//StringUtils.substringAfterLast(fileName, "/");

	}



	public void setFileName(String fileName) {

		this.fileName = fileName;

	}



	public String getFundingOrgAcronym() {

		return this.fundingOrgAcronym;

	}



	public void setFundingOrgAcronym(String fundingOrgAcronym) {

		this.fundingOrgAcronym = fundingOrgAcronym;

	}



	public String getFundingOrgContractNum() {

		return this.fundingOrgContractNum;

	}



	public void setFundingOrgContractNum(String fundingOrgContractNum) {

		this.fundingOrgContractNum = fundingOrgContractNum;

	}



	public String getFundingOrgGrantNumber() {

		return this.fundingOrgGrantNumber;

	}



	public void setFundingOrgGrantNumber(String fundingOrgGrantNumber) {

		this.fundingOrgGrantNumber = fundingOrgGrantNumber;

	}



	public String getFundingOrgName() {

		return this.fundingOrgName;

	}



	public void setFundingOrgName(String fundingOrgName) {

		this.fundingOrgName = fundingOrgName;

	}



	public String getFundingOrgReportNumber() {

		return this.fundingOrgReportNumber;

	}



	public void setFundingOrgReportNumber(String fundingOrgReportNumber) {

		this.fundingOrgReportNumber = fundingOrgReportNumber;

	}



	public String getFuzzyMatch() {

		return this.fuzzyMatch;

	}



	public void setFuzzyMatch(String fuzzyMatch) {

		this.fuzzyMatch = fuzzyMatch;

	}



	public String getGovernmentContactEmail() {

		return this.governmentContactEmail;

	}



	public void setGovernmentContactEmail(String governmentContactEmail) {

		this.governmentContactEmail = governmentContactEmail;

	}



	public String getGovernmentContactFirstName() {

		return this.governmentContactFirstName;

	}



	public void setGovernmentContactFirstName(String governmentContactFirstName) {

		this.governmentContactFirstName = governmentContactFirstName;

	}



	public String getGovernmentContactLastName() {

		return this.governmentContactLastName;

	}



	public void setGovernmentContactLastName(String governmentContactLastName) {

		this.governmentContactLastName = governmentContactLastName;

	}



	public String getGovernmentContactPhone() {

		return this.governmentContactPhone;

	}



	public void setGovernmentContactPhone(String governmentContactPhone) {

		this.governmentContactPhone = governmentContactPhone;

	}



	public String getHasEmbeddedMedia() {

		return this.hasEmbeddedMedia;

	}



	public void setHasEmbeddedMedia(String hasEmbeddedMedia) {

		this.hasEmbeddedMedia = hasEmbeddedMedia;

	}



	public Date getJournalDate() {

		return this.journalDate;

	}



	public void setJournalDate(Date journalDate) {

		this.journalDate = journalDate;

	}



	public String getJournalIssueNumber() {

		return this.journalIssueNumber;

	}



	public void setJournalIssueNumber(String journalIssueNumber) {

		this.journalIssueNumber = journalIssueNumber;

	}



	public String getJournalPageNumber() {

		return this.journalPageNumber;

	}



	public void setJournalPageNumber(String journalPageNumber) {

		this.journalPageNumber = journalPageNumber;

	}



	public String getJournalTitle() {

		return this.journalTitle;

	}



	public void setJournalTitle(String journalTitle) {

		this.journalTitle = journalTitle;

	}



	public String getJournalVolNumber() {

		return this.journalVolNumber;

	}



	public void setJournalVolNumber(String journalVolNumber) {

		this.journalVolNumber = journalVolNumber;

	}



	public String getMatchingApproverLdapId() {

		return this.matchingApproverLdapId;

	}



	public void setMatchingApproverLdapId(String matchingApproverLdapId) {

		this.matchingApproverLdapId = matchingApproverLdapId;

	}



	public String getNumberOfPages() {

		return this.numberOfPages;

	}



	public void setNumberOfPages(String numberOfPages) {

		this.numberOfPages = numberOfPages;

	}



	public String getParentAgency() {

		return this.parentAgency;

	}



	public void setParentAgency(String parentAgency) {

		this.parentAgency = parentAgency;

	}



	public String getPerformingOrgName() {

		return this.performingOrgName;

	}



	public void setPerformingOrgName(String performingOrgName) {

		this.performingOrgName = performingOrgName;

	}



	public String getPerformingOrgReportNum() {

		return this.performingOrgReportNum;

	}



	public void setPerformingOrgReportNum(String performingOrgReportNum) {

		this.performingOrgReportNum = performingOrgReportNum;

	}



	public Timestamp getPubdefenseDateCreated() {

		return this.pubdefenseDateCreated;

	}



	public void setPubdefenseDateCreated(Timestamp pubdefenseDateCreated) {

		this.pubdefenseDateCreated = pubdefenseDateCreated;

	}



	public boolean getReleaseFlag() {

		if (releaseFlag == null){

			return false;

		}

		if (releaseFlag.equals("1")){

			return true;

		}

		else if (releaseFlag.equals("0")){

			return false;

		} else {

			// log.debug("releaseFlag for record dticId=" + this.getDticId() +" had a value for release_flag that was not 0 or 1");

			return false;

		}

	}

	public void setReleaseFlag(boolean releaseFlag) {

		if (releaseFlag){

			this.releaseFlag = "1";

		} else {

			this.releaseFlag = "0";

		}

	}



	/*public String getReleaseFlag() {

	                              return this.releaseFlag;

	               }



	               public void setReleaseFlag(String releaseFlag) {

	                              this.releaseFlag = releaseFlag;

	               }*/



	public String getSource() {

		return this.source;

	}



	public void setSource(String source) {

		this.source = source;

	}



	public String getSubjectInfoAbstract() {

		return this.subjectInfoAbstract;

	}



	public void setSubjectInfoAbstract(String subjectInfoAbstract) {

		this.subjectInfoAbstract = subjectInfoAbstract;

	}



	public String getSubjectTerms() {

		return this.subjectTerms;

	}



	public void setSubjectTerms(String subjectTerms) {

		this.subjectTerms = subjectTerms;

	}



	public String getSubmitterEmailAddress() {

		return this.submitterEmailAddress;

	}



	public void setSubmitterEmailAddress(String submitterEmailAddress) {

		this.submitterEmailAddress = submitterEmailAddress;

	}



	public String getSubmitterFirstName() {

		return this.submitterFirstName;

	}



	public void setSubmitterFirstName(String submitterFirstName) {

		this.submitterFirstName = submitterFirstName;

	}



	public String getSubmitterIsAuthor() {

		return this.submitterIsAuthor;

	}



	public void setSubmitterIsAuthor(String submitterIsAuthor) {

		this.submitterIsAuthor = submitterIsAuthor;

	}



	public String getSubmitterLastName() {

		return this.submitterLastName;

	}



	public void setSubmitterLastName(String submitterLastName) {

		this.submitterLastName = submitterLastName;

	}



	public String getSubmitterMiddleInitial() {

		return this.submitterMiddleInitial;

	}



	public void setSubmitterMiddleInitial(String submitterMiddleInitial) {

		this.submitterMiddleInitial = submitterMiddleInitial;

	}



	public String getSubmitterPhone() {

		return this.submitterPhone;

	}



	public void setSubmitterPhone(String submitterPhone) {

		this.submitterPhone = submitterPhone;

	}



	public String getTitle() {

		return this.title;

	}



	public void setTitle(String title) {

		this.title = title;

	}



	public Date getWebPublicationDate() {

		return this.webPublicationDate;

	}



	public void setWebPublicationDate(Date webPublicationDate) {

		this.webPublicationDate = webPublicationDate;

	}



//	public List<DoeAuthorDetail> getDoeAuthorDetails() {
//
//		return this.doeAuthorDetails;
//
//	}
//
//
//
//	public void setDoeAuthorDetails(List<DoeAuthorDetail> doeAuthorDetails) {
//
//		this.doeAuthorDetails = doeAuthorDetails;
//
//	}



//	public List<DoeFundingOrganization> getDoeFundingOrganizations() {
//
//		return this.doeFundingOrganizations;
//
//	}
//
//
//
//	public void setDoeFundingOrganizations(List<DoeFundingOrganization> doeFundingOrganizations) {
//
//		this.doeFundingOrganizations = doeFundingOrganizations;
//
//	}



//	public List<DoePerformingOrg> getDoePerformingOrgs() {
//
//		return this.doePerformingOrgs;
//
//	}
//
//
//
//	public void setDoePerformingOrgs(List<DoePerformingOrg> doePerformingOrgs) {
//
//		this.doePerformingOrgs = doePerformingOrgs;
//
//	}
//
//
//
//	public DoeSubmissionTracking getDoeSubmissionTracking() {
//
//		return this.doeSubmissionTracking;
//
//	}
//
//
//
//	public void setDoeSubmissionTracking(DoeSubmissionTracking doeSubmissionTracking) {
//
//		this.doeSubmissionTracking = doeSubmissionTracking;
//
//	}





	public boolean isOpenAccess() {

		return openAccess;

	}



	public void setOpenAccess(boolean openAccess) {

		this.openAccess = openAccess;

	}



	public String getRecordNumberMasi() {

		return recordNumberMasi;

	}



	public void setRecordNumberMasi(String recordNumberMasi) {

		this.recordNumberMasi = recordNumberMasi;

	}



	public Timestamp getDateCreatedMasi() {

		return dateCreatedMasi;

	}



	public void setDateCreatedMasi(Timestamp dateCreatedMasi) {

		this.dateCreatedMasi = dateCreatedMasi;

	}



	public String getPdfUrl() {

		return pdfUrl;

	}



	public void setPdfUrl(String pdfUrl) {

		this.pdfUrl = pdfUrl;

	}



	public void setReleaseFlag(String releaseFlag) {

		this.releaseFlag = releaseFlag;

	}


}
