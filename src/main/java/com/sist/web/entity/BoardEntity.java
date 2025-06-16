package com.sist.web.entity;
/*
 * NO      NOT NULL NUMBER         
NAME    NOT NULL VARCHAR2(50)   
SUBJECT NOT NULL VARCHAR2(2000) 
CONTENT NOT NULL VARCHAR2(4000) 
PWD     NOT NULL VARCHAR2(10)   
REGDATE          DATE           
HIT              NUMBER 
 */

import java.util.Date;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name="yhw_board")
@Data
@DynamicUpdate
public class BoardEntity {
	@Id
	private int no;
	private String name;
	private String subject;
	private String content;
	@Column(insertable = true,updatable = false)
	private String pwd;
	@Column(insertable = true,updatable = false)
	private Date regdate;
	private int hit;
}
