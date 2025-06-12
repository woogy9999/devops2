package com.sist.web.vo;
/*
 * 
CNO               NOT NULL NUMBER         
TITLE             NOT NULL VARCHAR2(200)  
INTRO                      VARCHAR2(2000) 
POSTER                     VARCHAR2(1000) 
MANAGESTTUS       NOT NULL VARCHAR2(500)  
HVOFBGNDE                  VARCHAR2(200)  
HVOFENDDLE                 VARCHAR2(200)  
OPERPDCL                   VARCHAR2(1000) 
INDUTY                     VARCHAR2(1000) 
LCTCL                      VARCHAR2(1000) 
ADDR                       VARCHAR2(3000) 
DONM                       VARCHAR2(300)  
GNRLSITECO                 NUMBER         
AUTOSITECO                 NUMBER         
GLAMPSITECO                NUMBER         
CARAVSITECO                NUMBER         
INDVDLCARAVSITECO          NUMBER         
CARAVACMPNYAT              VARCHAR2(50)   
TRLERACMPNYAT              VARCHAR2(50)   
ANIMALCMGCL                VARCHAR2(1000) 
HIT                        NUMBER         
FCOUNT                     NUMBER         
LCOUNT                     NUMBER         
RCOUNT                     NUMBER         
MAPX                       VARCHAR2(300)  
MAPY                       VARCHAR2(300)  
PRICE                      NUMBER         
OPERDECL                   NUMBER 
 */
public interface CampListVO {
	public int getCno();
	public String getTitle();
	public String getPoster();
	public int getNum();
}
