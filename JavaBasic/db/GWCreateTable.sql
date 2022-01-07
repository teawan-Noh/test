CREATE TABLE `LOCAL_SPECIAL_ST_BASE_INFO` (
	`ID`                     MEDIUMINT     NOT NULL, -- �ڵ�
	`LOCAL_SPECIAL_ST_NM`    VARCHAR(300)  NOT NULL, -- ����Ưȭ�Ÿ���
	`LOCAL_SPECIAL_ST_INTRO` VARCHAR(1000) NULL,     -- ����Ưȭ�Ÿ� �Ұ�
	`ADDR_ROAD`              VARCHAR(200)  NULL,     -- ������ ���θ� �ּ�
	`ADDR_JIBUN`             VARCHAR(200)  NULL,     -- ������ ���� �ּ�
	`LAT`                    VARCHAR(50)   NULL,     -- ����
	`LNG`                    VARCHAR(50)   NULL,     -- �浵
	`TTL_LNG`                MEDIUMINT     NULL,     -- �ѱ���
	`STORE_CNT`              MEDIUMINT     NULL,     -- ������
	`DSGN_YEAR`              YEAR          NULL,     -- ��������
	`MNG_AGC_TEL`            VARCHAR(15)   NULL,     -- ������� ��ȭ��ȣ
	`MNG_AGC_NM`             VARCHAR(300)  NULL,     -- �������
	`SYNC_TIME`              DATE          NULL      -- �����ͱ�������
);

ALTER TABLE `LOCAL_SPECIAL_ST_BASE_INFO`
	ADD CONSTRAINT `PK_LOCAL_SPECIAL_ST_BASE_INFO` -- ����Ưȭ�Ÿ� �⺻ ���� �⺻Ű
		PRIMARY KEY (
			`ID` -- �ڵ�
		);

CREATE TABLE `LOCAL_CULT_HERIT_BASE_INFO` (
	`ID`                       MEDIUMINT     NOT NULL, -- �ڵ�
	`LOCAL_CULT_HERIT_NM`      VARCHAR(300)  NULL,     -- ���乮ȭ������
	`LOCAL_CULT_HERIT_CODE`    VARCHAR(300)  NOT NULL, -- ���乮ȭ���� ������ȣ
	`CLASSIFI_LOCAL_CULT_HERI` VARCHAR(30)   NULL,     -- ���乮ȭ���� ����
	`LOCAL_CULT_HERIT_TYPE_NM` VARCHAR(30)   NULL,     -- Ȳ�乮ȭ���� ����
	`ADDR_ROAD`                VARCHAR(200)  NULL,     -- ������ ���θ��ּ�
	`ADDR_JIBUN`               VARCHAR(200)  NULL,     -- ������ �����ּ�
	`LAT`                      VARCHAR(50)   NULL,     -- ����
	`LNG`                      VARCHAR(50)   NULL,     -- �浵
	`DSGN_DATE`                DATE          NULL,     -- ��������
	`OPERATION_RULE_NM`        VARCHAR(30)   NULL,     -- ������ü ����
	`OWNER_NM`                 VARCHAR(300)  NULL,     -- �����ڸ�
	`SCALE`                    VARCHAR(30)   NULL,     -- �Ը�
	`ERA_CREATION`             VARCHAR(30)   NULL,     -- �����ô�
	`PHOTO`                    BLOB          NULL,     -- �̹���
	`LOCAL_CULT_HERIT_INTRO`   VARCHAR(1000) NULL,     -- �⵵��ȭ���� �Ұ�
	`MNG_AGC_TEL`              VARCHAR(15)   NULL,     -- ������� ��ȭ��ȣ
	`MNG_AGC_NM`               VARCHAR(300)  NULL,     -- �������
	`SYNC_TIME`                DATE          NULL      -- �����ͱ�������
);

ALTER TABLE `LOCAL_CULT_HERIT_BASE_INFO`
	ADD CONSTRAINT `PK_LOCAL_CULT_HERIT_BASE_INFO` -- ���乮ȭ���� �⺻ ���� �⺻Ű
		PRIMARY KEY (
			`ID` -- �ڵ�
		);

CREATE TABLE `TOUR_DEST_BASE_INFO` (
	`ID`                          MEDIUMINT     NOT NULL, -- �ڵ�
	`TOUR_DEST_NM`                VARCHAR(300)  NOT NULL, -- ��������
	`OPERATION_RULE_NM`           VARCHAR(30)   NULL,     -- ������ ����
	`ADDR_ROAD`                   VARCHAR(200)  NULL,     -- ������ ���θ��ּ�
	`ADDR_JIBUN`                  VARCHAR(200)  NULL,     -- ������ �����ּ�
	`LAT`                         VARCHAR(50)   NULL,     -- ����
	`LNG`                         VARCHAR(50)   NULL,     -- �浵
	`AREA`                        VARCHAR(30)   NULL,     -- ����
	`PUBLIC_CONV_FCLT_INFO`       VARCHAR(1000) NULL,     -- �������ͽü� ����
	`ACCOM_INFO`                  VARCHAR(1000) NULL,     -- ���ڽü� ����
	`SPORTS_ENTER_FCLT_INFO`      VARCHAR(1000) NULL,     -- � �� �����ü� ����
	`RECREATIONAL_CULT_FCLT_INFO` VARCHAR(1000) NULL,     -- �޾� �� ��ȭ�ü� ����
	`HOSPITALITY_FCLT_INFO`       VARCHAR(1000) NULL,     -- �����ü� ����
	`SUPPORT_FCLT_INFO`           VARCHAR(1000) NULL,     -- �����ü� ����
	`DSGN_DATE`                   DATE          NULL,     -- ��������
	`CAPACITY`                    MEDIUMINT     NULL,     -- �����ο���
	`AVAIL_PARKING_CNT`           MEDIUMINT     NULL,     -- �������ɼ�
	`TOUR_DEST_INTRO`             VARCHAR(1000) NULL,     -- �������Ұ�
	`MNG_AGC_TEL`                 VARCHAR(15)   NULL,     -- ���������ȭ��ȣ
	`MNG_AGC_NM`                  VARCHAR(300)  NULL,     -- �������
	`SYNC_TIME`                   DATE          NULL      -- �����ͱ�������
);

ALTER TABLE `TOUR_DEST_BASE_INFO`
	ADD CONSTRAINT `PK_TOUR_DEST_BASE_INFO` -- ������ �⺻ ���� �⺻Ű
		PRIMARY KEY (
			`ID` -- �ڵ�
		);

CREATE TABLE `FESTIVAL_BASE_INFO` (
	`ID`                  MEDIUMINT     NOT NULL, -- �ڵ�
	`FESTIVAL_NM`         VARCHAR(300)  NOT NULL, -- ������
	`FESTIVAL_VENUE`      VARCHAR(200)  NULL,     -- �������
	`FESTIVAL_BEGIN_DATE` DATE          NULL,     -- ���� ��������
	`FESTIVAL_END_DATE`   DATE          NULL,     -- ���� ��������
	`FESTIVAL_INFO`       VARCHAR(1000) NULL,     -- ���� ����
	`MANAGE_AGC_NM`       VARCHAR(300)  NULL,     -- �ְ����
	`AUSPICE_AGC_NM`      VARCHAR(300)  NULL,     -- ���ֱ��
	`SPONSOR_AGC_NM`      VARCHAR(300)  NULL,     -- �Ŀ����
	`TEL`                 VARCHAR(15)   NULL,     -- ��ȭ��ȣ
	`HOME_PAGE`           VARCHAR(200)  NULL,     -- Ȩ�������ּ�
	`RELATED_INFO`        VARCHAR(1000) NULL,     -- ��������
	`ADDR_ROAD`           VARCHAR(200)  NULL,     -- ������ ���θ��ּ�
	`ADDR_JIBUN`          VARCHAR(200)  NULL,     -- ������ �����ּ�
	`LAT`                 VARCHAR(50)   NULL,     -- ����
	`LNG`                 VARCHAR(50)   NULL,     -- �浵
	`SYNC_TIME`           DATE          NULL      -- �����ͱ�������
);

ALTER TABLE `FESTIVAL_BASE_INFO`
	ADD CONSTRAINT `PK_FESTIVAL_BASE_INFO` -- ���� �⺻ ���� �⺻Ű
		PRIMARY KEY (
			`ID` -- �ڵ�
		);

CREATE TABLE `ARTIST_BASE_INFO` (
	`ID`                  MEDIUMINT    NOT NULL, -- �ڵ�
	`MAIN_CLASS`          VARCHAR(30)  NULL,     -- ��з�
	`MIDDLE_CLASS`        VARCHAR(30)  NULL,     -- �ߺз�
	`SUB_CLASS`           VARCHAR(30)  NULL,     -- �Һз�
	`NM`                  VARCHAR(300) NULL,     -- �̸�
	`AFLTN_AGC_NM`        VARCHAR(300) NULL,     -- �Ҽ���ȸ �� ��ü
	`AFLTN_AGC_TEL`       VARCHAR(25)  NULL,     -- �Ҽ���ȸ �� ��ü ����ó
	`AFLTN_AGC_ADDR`      VARCHAR(200) NULL,     -- �Ҽ���ȸ �� ��ü �ּ�
	`AFLTN_AGC_HOME_PAGE` VARCHAR(200) NULL      -- �Ҽ���ȸ �� ��ü �¶��λ���Ʈ
);

ALTER TABLE `ARTIST_BASE_INFO`
	ADD CONSTRAINT `PK_ARTIST_BASE_INFO` -- ������ �⺻ ���� �⺻Ű
		PRIMARY KEY (
			`ID` -- �ڵ�
		);

CREATE TABLE `MSM_ART_GLR_BASE_INFO` (
	`ID`                  MEDIUMINT     NOT NULL, -- �ڵ�
	`MSM_ART_GLR_NM`      VARCHAR(300)  NOT NULL, -- �ü���
	`OPERATION_RULE_NM`   VARCHAR(30)   NULL,     -- �ڹ����̼��� ����
	`ADDR_ROAD`           VARCHAR(200)  NULL,     -- �һ������θ��ּ�
	`ADDR_JIBUN`          VARCHAR(200)  NULL,     -- �����������ּ�
	`LAT`                 VARCHAR(50)   NULL,     -- ����
	`LNG`                 VARCHAR(50)   NULL,     -- �浵
	`OPERATION_AGC_TEL`   VARCHAR(15)   NULL,     -- ������ȭ��ȣ
	`OPERATION_AGC_NM`    VARCHAR(300)  NULL,     -- ������
	`HOME_PAGE`           VARCHAR(200)  NULL,     -- �Ȩ������
	`CONV_FCLT_INFO`      VARCHAR(1000) NULL,     -- ���ǽü�����
	`WEEKDAY_BEGIN_TIME`  TIME          NULL,     -- ���ϰ������۽ð�
	`WEEKDAY_END_TIME`    TIME          NULL,     -- ���ϰ�������ð�
	`HOLIDAY_BEGIN_TIME`  TIME          NULL,     -- �����ϰ������۽ð�
	`HOLIDAY_END_TIME`    TIME          NULL,     -- �����ϰ�������ð�
	`CLOSE_INFO`          VARCHAR(1000) NULL,     -- �ް�����
	`ADULT_ADMS_FEE`      VARCHAR(100)  NULL,     -- �������
	`YOUTH_ADMS_FEE`      VARCHAR(100)  NULL,     -- û�ҳ������
	`CHILD_ADMS_FEE`      VARCHAR(100)  NULL,     -- ��̰�����
	`ADMS_FEE_OTHER_INFO` VARCHAR(1000) NULL,     -- �����Ÿ����
	`MSM_ART_GLR_INTRO`   VARCHAR(1000) NULL,     -- �ڹ����̼����Ұ�
	`TRAFFIC_INFO`        VARCHAR(1000) NULL,     -- ����ȳ�����
	`MNG_AGC_TEL`         VARCHAR(15)   NULL,     -- ���������ȭ��ȣ
	`MNG_AGC_NM`          VARCHAR(300)  NULL,     -- ���������
	`SYNC_TIME`           DATE          NULL      -- �����ͱ�������
);

ALTER TABLE `MSM_ART_GLR_BASE_INFO`
	ADD CONSTRAINT `PK_MSM_ART_GLR_BASE_INFO` -- �ڹ����̼��� �⺻ ���� �⺻Ű
		PRIMARY KEY (
			`ID` -- �ڵ�
		);


CREATE TABLE `EVENT_BASE_INFO` (
	`ID`                MEDIUMINT     NOT NULL, -- �ڵ�
	`EVENT_NM`          VARCHAR(300)  NOT NULL, -- ����
	`EVENT_VENUE`       VARCHAR(200)  NULL,     -- ���
	`EVENT_INFO`        VARCHAR(1000) NULL,     -- ��系��
	`EVENT_BEGIN_DATE`  DATE          NULL,     -- ����������
	`EVENT_END_DATE`    DATE          NULL,     -- �����������
	`EVENT_BEGIN_TIME`  TIME          NULL,     -- �����۽ð�
	`EVENT_END_TIME`    TIME          NULL,     -- �������ð�
	`PAY_YN`            VARCHAR(10)   NULL,     -- �������
	`MANAGE_AGC_NM`     VARCHAR(300)  NULL,     -- �ְ����
	`AUSPICE_AGC_NM`    VARCHAR(300)  NULL,     -- ���ֱ��
	`TEL`               VARCHAR(15)   NULL,     -- ��ȭ��ȣ
	`SPONSOR_AGC_NM`    VARCHAR(300)  NULL,     -- �Ŀ����
	`SEAT_COUNT`        MEDIUMINT     NULL,     -- ������
	`PRICE`             VARCHAR(100)  NULL,     -- �������
	`ENTER_AGE`         VARCHAR(300)  NULL,     -- ���忬��
	`DISCOUNT_INFO`     VARCHAR(1000) NULL,     -- ��������
	`NOTICE`            VARCHAR(1000) NULL,     -- ���ǻ���
	`HOME_PAGE`         VARCHAR(200)  NULL,     -- Ȩ�������ּ�
	`RSRVT_INFO`        VARCHAR(1000) NULL,     -- ��������
	`PARKING_LOT_AVAIL` VARCHAR(10)   NULL,     -- �����庸������
	`ADDR_ROAD`         VARCHAR(200)  NULL,     -- ���������θ��ּ�
	`ADDR_JIBUN`        VARCHAR(200)  NULL,     -- �����������ּ�
	`LAT`               VARCHAR(50)   NULL,     -- ����
	`LNG`               VARCHAR(50)   NULL,     -- �浵
	`SYNC_TIME`         DATE          NULL      -- �����ͱ�������
);

ALTER TABLE `EVENT_BASE_INFO`
	ADD CONSTRAINT `PK_EVENT_BASE_INFO` -- ��� �⺻ ���� �⺻Ű
		PRIMARY KEY (
			`ID` -- �ڵ�
		);

CREATE TABLE `LOCAL_VISITOR_STATISTICS` (
	`ID`                  MEDIUMINT    NOT NULL, -- �ڵ�
	`AREA_NM`             VARCHAR(300) NULL,     -- �湮����
	`AUTONOMOUS_D`        VARCHAR(30)  NULL,     -- ��ġ��
	`TWO_THSND_SIXTEEN`   VARCHAR(10)  NULL,     -- 2016��
	`TWO_THSND_SEVENTEEN` VARCHAR(10)  NULL,     -- 2017��
	`TWO_THSND_EIGHTEEN`  VARCHAR(10)  NULL,     -- 2018��
	`TWO_THSND_NINETEEN`  VARCHAR(10)  NULL,     -- 2019��
	`TWO_THSND_TWENTY`    VARCHAR(10)  NULL,     -- 2020��
	`YR_ON_YR_INCRS`      VARCHAR(20)  NULL      -- ������������
);

ALTER TABLE `LOCAL_VISITOR_STATISTICS`
	ADD CONSTRAINT `PK_LOCAL_VISITOR_STATISTICS` -- �����湮����� �⺻Ű
		PRIMARY KEY (
			`ID` -- �ڵ�
		);

CREATE TABLE `USER_LOG` (
	`PID`       MEDIUMINT   NULL, -- �ڵ�
	`REQ_IP`    VARCHAR(16) NULL, -- ��û������
	`REQ_QUERY` VARCHAR(50) NULL, -- ��û����
	`USE_DT`    DATETIME    NULL  -- �����
);
