package com.htds.spring.samples.domain;

import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Hasan
 * on 8.6.2015.
 */
@Audited
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractAuditingEntity {

	@CreatedBy
	@NotNull
	@Column(name = "created_by", length = 50, nullable = false, updatable = false)
	private String createdBy;

	@CreatedDate
	@NotNull
//	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name = "created_date", nullable = false)
//	private DateTime createdDate = DateTime.now();
	private Date createdDate = new Date();

	@LastModifiedBy
	@Column(name = "last_modified_by", length = 50)
	private String lastModifiedBy;

	@LastModifiedDate
//	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name = "last_modified_date")
//	private DateTime lastModifiedDate = DateTime.now();
	private Date lastModifiedDate = new Date();

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

//	public DateTime getCreatedDate() {
//		return createdDate;
//	}
//
//	public void setCreatedDate(DateTime createdDate) {
//		this.createdDate = createdDate;
//	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

//	public DateTime getLastModifiedDate() {
//		return lastModifiedDate;
//	}
//
//	public void setLastModifiedDate(DateTime lastModifiedDate) {
//		this.lastModifiedDate = lastModifiedDate;
//	}


	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
