/* ����Ưȭ�Ÿ� �⺻ ���� */
CREATE TABLE LOCAL_SPECIAL_ST_BASE_INFO (
	LOCAL_SPECIAL_ST_NM VARCHAR2(100), /* ����Ưȭ�Ÿ��� */
	LOCAL_SPECIAL_ST_INTRO VARCHAR2(255), /* ����Ưȭ�Ÿ� �Ұ� */
	ADDR_ROAD VARCHAR2(200), /* ������ ���θ� �ּ� */
	ADDR_JIBUN VARCHAR2(200), /* ������ ���� �ּ� */
	LAT VARCHAR2(50), /* ���� */
	LNG VARCHAR2(50), /* �浵 */
	TTL_LNG NUMBER(10), /* �ѱ��� */
	STORE_COUNT NUMBER(10), /* ������ */
	DSGN_YEAR DATE, /* �������� */
	MNG_AGC_TEL VARCHAR2(15), /* ������� ��ȭ��ȣ */
	MNG_AGC VARCHAR2(100), /* ������� */
	SYNC_TIME DATE /* �����ͱ������� */
);

/* ���乮ȭ���� �⺻ ���� */
CREATE TABLE LOCAL_CULT_HERIT_BASE_INFO (
	LOCAL_CULT_HERIT_CODE VARCHAR2(100) NOT NULL, /* ���乮ȭ���� ������ȣ */
	LOCAL_CULT_HERIT_NM VARCHAR2(100), /* ���乮ȭ������ */
	CLASSIFI_LOCAL_CULT_HERI VARCHAR2(40), /* ���乮ȭ���� ���� */
	LOCAL_CULT_HERIT_TYPE_NM VARCHAR2(30), /* Ȳ�乮ȭ���� ���� */
	ADDR_ROAD VARCHAR2(200), /* ������ ���θ��ּ� */
	ADDR_JIBUN VARCHAR2(200), /* ������ �����ּ� */
	CAPACITY NUMBER(10), /* ������ȹ�� */
	LAT VARCHAR2(50), /* ���� */
	LNG VARCHAR2(50), /* �浵 */
	DSGN_DATE DATE, /* �������� */
	OPERATION_RULE_NM VARCHAR2(40), /* ������ü ���� */
	OWNER_NAME VARCHAR2(100), /* �����ڸ� */
	SCALE VARCHAR2(30), /* �Ը� */
	ERA_CREATION VARCHAR2(30), /* �����ô� */
	PHOTO BLOB, /* �̹��� */
	LOCAL_CULT_HERIT_INTRO VARCHAR2(255), /* �⵵��ȭ���� �Ұ� */
	MNG_AGC_TEL VARCHAR2(15), /* ������� ��ȭ��ȣ */
	MNG_AGC VARCHAR2(100), /* ������� */
	SYNC_TIME DATE /* �����ͱ������� */
);

ALTER TABLE LOCAL_CULT_HERIT_BASE_INFO
	ADD
		CONSTRAINT PK_LOCAL_CULT_HERIT_BASE_INFO
		PRIMARY KEY (
			LOCAL_CULT_HERIT_CODE
		);

/* ������ �⺻ ���� */
CREATE TABLE TOUR_DEST_BASE_INFO (
	TOUR_DEST_NM VARCHAR2(100), /* �������� */
	OPERATION_RULE_NM VARCHAR2(40), /* ������ ���� */
	ADDR_ROAD VARCHAR2(200), /* ������ ���θ��ּ� */
	ADDR_JIBUN VARCHAR2(200), /* ������ �����ּ� */
	LAT VARCHAR2(50), /* ���� */
	LNG VARCHAR2(50), /* �浵 */
	AREA VARCHAR2(30), /* ���� */
	PUBLIC_CONV_FCLT_INFO VARCHAR2(200), /* �������ͽü� ���� */
	ACCOM_INFO VARCHAR2(200), /* ���ڽü� ���� */
	SPORTS_ENTER_FCLT_INFO VARCHAR2(200), /* � �� �����ü� ���� */
	RECREATIONAL_CULT_FCLT_INFO VARCHAR2(200), /* �޾� �� ��ȭ�ü� ���� */
	HOSPITALITY_FCLT_INFO VARCHAR2(200), /* �����ü� ���� */
	SUPPORT_FCLT_INFO VARCHAR2(200), /* �����ü� ���� */
	DSGN_DATE DATE, /* �������� */
	CAPACITY NUMBER(10), /* �����ο��� */
	AVAIL_PARKING_COUNT NUMBER(10), /* �������ɼ� */
	TOUR_DEST_INTRO VARCHAR2(255), /* �������Ұ� */
	MNG_AGC_TEL VARCHAR2(15), /* ���������ȭ��ȣ */
	MNG_AGC VARCHAR2(100), /* ������� */
	SYNC_TIME DATE /* �����ͱ������� */
);

/* �ڹ����̼��� �⺻ ���� */
CREATE TABLE MSM_ART_GLR_BASE_INFO (
	MSM_ART_GLR_NM VARCHAR2(100) NOT NULL, /* �ü��� */
	OPERATION_RULE_NM VARCHAR2(40), /* �ڹ����̼��� ���� */
	ADDR_ROAD VARCHAR2(200), /* �һ��� ���θ��ּ� */
	ADDR_JIBUN VARCHAR2(200), /* ������ �����ּ� */
	LAT VARCHAR2(50), /* ���� */
	LNG VARCHAR2(50), /* �浵 */
	OPERATION_AGC_TEL VARCHAR2(15), /* ���� ��ȭ��ȣ */
	OPERATION_AGC VARCHAR2(100), /* ���� */
	OPERATION_AGC_HOME_PAGE VARCHAR2(200), /* ���� Ȩ������ */
	CONV_FCLT_INFO VARCHAR2(200), /* ���Ǽ��� ���� */
	MSM_ART_GLR_INTRO VARCHAR2(255), /* �ڹ����̼��� �Ұ� */
	TRAFFIC_INFO VARCHAR2(200), /* ����ȳ� ���� */
	MNG_AGC_TEL VARCHAR2(15), /* ������� ��ȭ��ȣ */
	MNG_AGC VARCHAR2(100), /* ������� */
	SYNC_TIME DATE /* �����ͱ������� */
);

ALTER TABLE MSM_ART_GLR_BASE_INFO
	ADD
		CONSTRAINT PK_MSM_ART_GLR_BASE_INFO
		PRIMARY KEY (
			MSM_ART_GLR_NM
		);

/* �ڹ����̼��� � ���� */
CREATE TABLE MSM_ART_GLR_OPER_INFO (
	WEEKDAY_BEGIN_TIME DATE, /* ���� ���� ���۽ð� */
	WEEKDAY_END_TIME DATE, /* ���� ���� ����ð� */
	HOLIDAY_BEGIN_TIME DATE, /* ������ � ���۽ð� */
	HOLIDAY_END_TIME DATE, /* ������ � ����ð� */
	CLOSE_INFO VARCHAR2(200), /* �ް����� */
	MSM_ART_GLR_NM VARCHAR2(100) /* �ü��� */
);

/* �ڹ����̼��� ��� ���� */
CREATE TABLE MSM_ART_GLR_PAY_INFO (
	ADULT_ADMS_FEE NUMBER(10), /* ������� */
	YOUTH_ADMS_FEE NUMBER(10), /* ��̰����� */
	CHILD_ADMS_FEE NUMBER(10), /* û�ҳ������ */
	ADMS_FEE_OTHER_INFO VARCHAR2(200), /* �����Ÿ���� */
	MSM_ART_GLR_NM VARCHAR2(100) /* �ü��� */
);

/* ���� �⺻ ���� */
CREATE TABLE FESTIVAL_BASE_INFO (
	FESTIVAL_NM VARCHAR2(100), /* ������ */
	FESTIVAL_VENUE VARCHAR2(200), /* ������� */
	FESTIVAL_BEGIN_DATE DATE, /* ���� �������� */
	FESTIVAL_END_DATE DATE, /* ���� �������� */
	FESTIVAL_INFO VARCHAR2(255), /* ���� ���� */
	ORGANIZER_AGC VARCHAR2(100), /* �ְ���� */
	SPONSOR_AGC VARCHAR2(100), /* �Ŀ���� */
	TEL VARCHAR2(15), /* ��ȭ��ȣ */
	HOME_PAGE VARCHAR2(200), /* Ȩ�������ּ� */
	RELATED_INFO VARCHAR2(200), /* �������� */
	ADDR_ROAD VARCHAR2(200), /* ������ ���θ��ּ� */
	ADDR_JIBUN VARCHAR2(200), /* ������ �����ּ� */
	LAT VARCHAR2(50), /* ���� */
	LNG VARCHAR2(50), /* �浵 */
	SYNC_TIME DATE /* �����ͱ������� */
);

/* ��� �⺻ ���� */
CREATE TABLE EVENT_BASE_INFO (
	EVENT_NM VARCHAR2(100) NOT NULL, /* ���� */
	EVENT_VENUE VARCHAR2(200), /* ��� */
	EVENT_INFO VARCHAR2(255), /* ��系�� */
	ORGANIZER_AGC VARCHAR2(100), /* �ְ���� */
	HOST_AGC VARCHAR2(100), /* ���ֱ�� */
	HOST_AGENCY_TEL VARCHAR2(15), /* ��ȭ��ȣ */
	SPONSOR_AGC VARCHAR2(100), /* �Ŀ���� */
	SEAT_COUNT NUMBER(10), /* ������ */
	ENTER_AGE NUMBER(10), /* ���忬�� */
	NOTICE VARCHAR2(200), /* ���ǻ��� */
	HOME_PAGE VARCHAR2(200), /* Ȩ������ �ּ� */
	RSRVT_INFO VARCHAR2(200), /* ���� ���� */
	PARKING_LOT_AVAILABILITY VARCHAR2(30), /* ������ �������� */
	ADDR_ROAD VARCHAR2(200), /* ������ ���θ��ּ� */
	ADDR_JIBUN VARCHAR2(200), /* ������ �����ּ� */
	LAT VARCHAR2(50), /* ���� */
	LNG VARCHAR2(50), /* �浵 */
	SYNC_TIME DATE /* �����ͱ������� */
);

ALTER TABLE EVENT_BASE_INFO
	ADD
		CONSTRAINT PK_EVENT_BASE_INFO
		PRIMARY KEY (
			EVENT_NM
		);

/* ��� � ���� */
CREATE TABLE EVENT_OPER_INFO (
	EVENT_BEGIN_DATE DATE, /* ��� �������� */
	EVENT_END_DATE DATE, /* ��� �������� */
	EVENT_BEGIN_TIME DATE, /* ��� ���۽ð� */
	EVENT_END_TIME DATE, /* ��� ����ð� */
	EVENT_NM VARCHAR2(100) /* ���� */
);

/* ��� ��� ���� */
CREATE TABLE EVENT_PAY_INFO (
	PAY_YN VARCHAR2(30), /* ��� ���� */
	PRICE NUMBER(10), /* ���� ��� */
	DISCOUNT_INFO VARCHAR2(200), /* ���� ���� */
	EVENT_NM VARCHAR2(100) /* ���� */
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