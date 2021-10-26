/* 지역특화거리 기본 정보 */
CREATE TABLE LOCAL_SPECIAL_ST_BASE_INFO (
	LOCAL_SPECIAL_ST_NM VARCHAR2(100) NOT NULL, /* 지역특화거리명 */
	LOCAL_SPECIAL_ST_INTRO VARCHAR2(1000), /* 지역특화거리 소개 */
	ADDR_ROAD VARCHAR2(200), /* 소재지 도로명 주소 */
	ADDR_JIBUN VARCHAR2(200), /* 소재지 지번 주소 */
	LAT VARCHAR2(50), /* 위도 */
	LNG VARCHAR2(50), /* 경도 */
	TTL_LNG NUMBER(10), /* 총길이 */
	STORE_COUNT NUMBER(10), /* 점포수 */
	DSGN_YEAR DATE, /* 지정연도 */
	MNG_AGC_TEL VARCHAR2(15), /* 관리기관 전화번호 */
	MNG_AGC_NM VARCHAR2(100), /* 관리기관 */
	SYNC_TIME DATE /* 데이터기준일자 */
);

ALTER TABLE LOCAL_SPECIAL_ST_BASE_INFO
	ADD
		CONSTRAINT PK_LOCAL_SPECIAL_ST_BASE_INFO
		PRIMARY KEY (
			LOCAL_SPECIAL_ST_NM
		);
Drop table LOCAL_CULT_HERIT_BASE_INFO;
/* 향토문화유적 기본 정보 */
CREATE TABLE LOCAL_CULT_HERIT_BASE_INFO (
	LOCAL_CULT_HERIT_NM VARCHAR2(100), /* 향토문화유적명 */
	LOCAL_CULT_HERIT_CODE VARCHAR2(100) NOT NULL, /* 향토문화유적 지정번호 */
	CLASSIFI_LOCAL_CULT_HERI VARCHAR2(40), /* 향토문화유적 구분 */
	LOCAL_CULT_HERIT_TYPE_NM VARCHAR2(30), /* 황토문화유적 종류 */
	ADDR_ROAD VARCHAR2(200), /* 소재지 도로명주소 */
	ADDR_JIBUN VARCHAR2(200), /* 소재지 지번주소 */
	LAT VARCHAR2(50), /* 위도 */
	LNG VARCHAR2(50), /* 경도 */
	DSGN_DATE DATE, /* 지정일자 */
	OPERATION_RULE_NM VARCHAR2(40), /* 소유주체 구분 */
	OWNER_NAME VARCHAR2(100), /* 소유자명 */
	SCALE VARCHAR2(30), /* 규모 */
	ERA_CREATION VARCHAR2(30), /* 조성시대 */
	PHOTO BLOB, /* 이미지 */
	LOCAL_CULT_HERIT_INTRO VARCHAR2(1000), /* 향도문화유적 소개 */
	MNG_AGC_TEL VARCHAR2(15), /* 관리기관 전화번호 */
	MNG_AGC_NM VARCHAR2(100), /* 관리기관 */
	SYNC_TIME DATE /* 데이터기준일자 */
);

ALTER TABLE LOCAL_CULT_HERIT_BASE_INFO
	ADD
		CONSTRAINT PK_LOCAL_CULT_HERIT_BASE_INFO
		PRIMARY KEY (
			LOCAL_CULT_HERIT_CODE
		);

/* 관광지 기본 정보 */
CREATE TABLE TOUR_DEST_BASE_INFO (
	TOUR_DEST_NM VARCHAR2(100) NOT NULL, /* 관광지명 */
	OPERATION_RULE_NM VARCHAR2(40), /* 관광지 구분 */
	ADDR_ROAD VARCHAR2(200), /* 소재지 도로명주소 */
	ADDR_JIBUN VARCHAR2(200), /* 소재지 지번주소 */
	LAT VARCHAR2(50), /* 위도 */
	LNG VARCHAR2(50), /* 경도 */
	AREA VARCHAR2(30), /* 면적 */
	PUBLIC_CONV_FCLT_INFO VARCHAR2(400), /* 공공편익시설 정보 */
	ACCOM_INFO VARCHAR2(400), /* 숙박시설 정보 */
	SPORTS_ENTER_FCLT_INFO VARCHAR2(400), /* 운동 및 오락시설 정보 */
	RECREATIONAL_CULT_FCLT_INFO VARCHAR2(400), /* 휴양 및 문화시설 정보 */
	HOSPITALITY_FCLT_INFO VARCHAR2(400), /* 접객시설 정보 */
	SUPPORT_FCLT_INFO VARCHAR2(400), /* 지원시설 정보 */
	DSGN_DATE DATE, /* 지정일자 */
	CAPACITY NUMBER(10), /* 수용인원수 */
	AVAIL_PARKING_COUNT NUMBER(10), /* 주차가능수 */
	TOUR_DEST_INTRO VARCHAR2(1000), /* 관광지소개 */
	MNG_AGC_TEL VARCHAR2(15), /* 관리기관전화번호 */
	MNG_AGC_NM VARCHAR2(100), /* 관리기관 */
	SYNC_TIME DATE /* 데이터기준일자 */
);

ALTER TABLE TOUR_DEST_BASE_INFO
	ADD
		CONSTRAINT PK_TOUR_DEST_BASE_INFO
		PRIMARY KEY (
			TOUR_DEST_NM
		);

/* 박물관미술관 기본 정보 */
CREATE TABLE MSM_ART_GLR_BASE_INFO (
	MSM_ART_GLR_NM VARCHAR2(100) NOT NULL, /* 시설명 */
	OPERATION_RULE_NM VARCHAR2(40), /* 박물관미술관 구분 */
	ADDR_ROAD VARCHAR2(200), /* 소새지 도로명주소 */
	ADDR_JIBUN VARCHAR2(200), /* 소재지 지번주소 */
	LAT VARCHAR2(50), /* 위도 */
	LNG VARCHAR2(50), /* 경도 */
	OPERATION_AGC_TEL VARCHAR2(15), /* 운영기관 전화번호 */
	OPERATION_AGC_NM VARCHAR2(100), /* 운영기관 */
	OPERATION_AGC_HOME_PAGE VARCHAR2(200), /* 운영기관 홈페이지 */
	CONV_FCLT_INFO VARCHAR2(400), /* 편의서설 정보 */
	MSM_ART_GLR_INTRO VARCHAR2(1000), /* 박물관미술관 소개 */
	TRAFFIC_INFO VARCHAR2(400), /* 교통안내 정보 */
	MNG_AGC_TEL VARCHAR2(15), /* 관리기관 전화번호 */
	MNG_AGC_NM VARCHAR2(100), /* 관리기관 */
	SYNC_TIME DATE /* 데이터기준일자 */
);

ALTER TABLE MSM_ART_GLR_BASE_INFO
	ADD
		CONSTRAINT PK_MSM_ART_GLR_BASE_INFO
		PRIMARY KEY (
			MSM_ART_GLR_NM
		);

/* 박물관미술관 운영 정보 */
CREATE TABLE MSM_ART_GLR_OPER_INFO (
	WEEKDAY_BEGIN_TIME DATE, /* 평일 관람 시작시각 */
	WEEKDAY_END_TIME DATE, /* 평일 관람 종료시각 */
	HOLIDAY_BEGIN_TIME DATE, /* 공휴일 운영 시작시각 */
	HOLIDAY_END_TIME DATE, /* 공휴일 운영 종료시각 */
	CLOSE_INFO VARCHAR2(400), /* 휴관정보 */
	MSM_ART_GLR_NM VARCHAR2(100) /* 시설명 */
);

/* 박물관미술관 요금 정보 */
CREATE TABLE MSM_ART_GLR_PAY_INFO (
	ADULT_ADMS_FEE NUMBER(10), /* 어른관람료 */
	YOUTH_ADMS_FEE NUMBER(10), /* 어린이관람료 */
	CHILD_ADMS_FEE NUMBER(10), /* 청소년관람료 */
	ADMS_FEE_OTHER_INFO VARCHAR2(400), /* 관료기타정보 */
	MSM_ART_GLR_NM VARCHAR2(100) /* 시설명 */
);

/* 축제 기본 정보 */
CREATE TABLE FESTIVAL_BASE_INFO (
	FESTIVAL_NM VARCHAR2(100) NOT NULL, /* 축제명 */
	FESTIVAL_VENUE VARCHAR2(200), /* 개최장소 */
	FESTIVAL_BEGIN_DATE DATE, /* 축제 시작일자 */
	FESTIVAL_END_DATE DATE, /* 축제 종료일자 */
	FESTIVAL_INFO VARCHAR2(1000), /* 축제 내용 */
	ORGANIZER_AGC_NM VARCHAR2(100), /* 주관기관 */
	SPONSOR_AGC_NM VARCHAR2(100), /* 후원기관 */
	TEL VARCHAR2(15), /* 전화번호 */
	HOME_PAGE VARCHAR2(200), /* 홈페이지주소 */
	RELATED_INFO VARCHAR2(400), /* 관련정보 */
	ADDR_ROAD VARCHAR2(200), /* 소재지 도로명주소 */
	ADDR_JIBUN VARCHAR2(200), /* 소재지 지번주소 */
	LAT VARCHAR2(50), /* 위도 */
	LNG VARCHAR2(50), /* 경도 */
	SYNC_TIME DATE /* 데이터기준일자 */
);

ALTER TABLE FESTIVAL_BASE_INFO
	ADD
		CONSTRAINT PK_FESTIVAL_BASE_INFO
		PRIMARY KEY (
			FESTIVAL_NM
		);

/* 행사 기본 정보 */
CREATE TABLE EVENT_BASE_INFO (
	EVENT_NM VARCHAR2(100) NOT NULL, /* 행사명 */
	EVENT_VENUE VARCHAR2(200), /* 장소 */
	EVENT_INFO VARCHAR2(1000), /* 행사내용 */
	ORGANIZER_AGC_NM VARCHAR2(100), /* 주관기관 */
	HOST_AGC_NM VARCHAR2(100), /* 주최기관 */
	HOST_AGENCY_TEL VARCHAR2(15), /* 전화번호 */
	SPONSOR_AGC_NM VARCHAR2(100), /* 후원기관 */
	SEAT_COUNT NUMBER(10), /* 객석수 */
	ENTER_AGE NUMBER(10), /* 입장연령 */
	NOTICE VARCHAR2(400), /* 유의사항 */
	HOME_PAGE VARCHAR2(200), /* 홈페이지 주소 */
	RSRVT_INFO VARCHAR2(400), /* 예매 정보 */
	PARKING_LOT_AVAILABILITY VARCHAR2(30), /* 주차장 보유여부 */
	ADDR_ROAD VARCHAR2(200), /* 소재지 도로명주소 */
	ADDR_JIBUN VARCHAR2(200), /* 소재지 지번주소 */
	LAT VARCHAR2(50), /* 위도 */
	LNG VARCHAR2(50), /* 경도 */
	SYNC_TIME DATE /* 데이터기준일자 */
);

ALTER TABLE EVENT_BASE_INFO
	ADD
		CONSTRAINT PK_EVENT_BASE_INFO
		PRIMARY KEY (
			EVENT_NM
		);

/* 행사 운영 정보 */
CREATE TABLE EVENT_OPER_INFO (
	EVENT_BEGIN_DATE DATE, /* 행사 시작일자 */
	EVENT_END_DATE DATE, /* 행사 종료일자 */
	EVENT_BEGIN_TIME DATE, /* 행사 시작시각 */
	EVENT_END_TIME DATE, /* 행사 종료시각 */
	EVENT_NM VARCHAR2(100) /* 행사명 */
);

/* 행사 요금 정보 */
CREATE TABLE EVENT_PAY_INFO (
	PAY_YN VARCHAR2(30), /* 요금 정보 */
	PRICE NUMBER(10), /* 관람 요금 */
	DISCOUNT_INFO VARCHAR2(400), /* 할인 정보 */
	EVENT_NM VARCHAR2(100) /* 행사명 */
);

ALTER TABLE MSM_ART_GLR_OPER_INFO
	ADD
		CONSTRAINT FK_MSM_INF_TO_MSM_INF
		FOREIGN KEY (
			MSM_ART_GLR_NM
		)
		REFERENCES MSM_ART_GLR_BASE_INFO (
			MSM_ART_GLR_NM
		);

ALTER TABLE MSM_ART_GLR_PAY_INFO
	ADD
		CONSTRAINT FK_MSM_INF_TO_MSM_INF2
		FOREIGN KEY (
			MSM_ART_GLR_NM
		)
		REFERENCES MSM_ART_GLR_BASE_INFO (
			MSM_ART_GLR_NM
		);

ALTER TABLE EVENT_OPER_INFO
	ADD
		CONSTRAINT FK_EVNT_BS_INF_TO_EVNT_INF
		FOREIGN KEY (
			EVENT_NM
		)
		REFERENCES EVENT_BASE_INFO (
			EVENT_NM
		);

ALTER TABLE EVENT_PAY_INFO
	ADD
		CONSTRAINT FK_EVNT_BS_INF_TO_EVNT_INF2
		FOREIGN KEY (
			EVENT_NM
		)
		REFERENCES EVENT_BASE_INFO (
			EVENT_NM
		);