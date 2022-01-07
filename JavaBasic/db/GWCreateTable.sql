CREATE TABLE `LOCAL_SPECIAL_ST_BASE_INFO` (
	`ID`                     MEDIUMINT     NOT NULL, -- 코드
	`LOCAL_SPECIAL_ST_NM`    VARCHAR(300)  NOT NULL, -- 지역특화거리명
	`LOCAL_SPECIAL_ST_INTRO` VARCHAR(1000) NULL,     -- 지역특화거리 소개
	`ADDR_ROAD`              VARCHAR(200)  NULL,     -- 소재지 도로명 주소
	`ADDR_JIBUN`             VARCHAR(200)  NULL,     -- 소재지 지번 주소
	`LAT`                    VARCHAR(50)   NULL,     -- 위도
	`LNG`                    VARCHAR(50)   NULL,     -- 경도
	`TTL_LNG`                MEDIUMINT     NULL,     -- 총길이
	`STORE_CNT`              MEDIUMINT     NULL,     -- 점포수
	`DSGN_YEAR`              YEAR          NULL,     -- 지정연도
	`MNG_AGC_TEL`            VARCHAR(15)   NULL,     -- 관리기관 전화번호
	`MNG_AGC_NM`             VARCHAR(300)  NULL,     -- 관리기관
	`SYNC_TIME`              DATE          NULL      -- 데이터기준일자
);

ALTER TABLE `LOCAL_SPECIAL_ST_BASE_INFO`
	ADD CONSTRAINT `PK_LOCAL_SPECIAL_ST_BASE_INFO` -- 지역특화거리 기본 정보 기본키
		PRIMARY KEY (
			`ID` -- 코드
		);

CREATE TABLE `LOCAL_CULT_HERIT_BASE_INFO` (
	`ID`                       MEDIUMINT     NOT NULL, -- 코드
	`LOCAL_CULT_HERIT_NM`      VARCHAR(300)  NULL,     -- 향토문화유적명
	`LOCAL_CULT_HERIT_CODE`    VARCHAR(300)  NOT NULL, -- 향토문화유적 지정번호
	`CLASSIFI_LOCAL_CULT_HERI` VARCHAR(30)   NULL,     -- 향토문화유적 구분
	`LOCAL_CULT_HERIT_TYPE_NM` VARCHAR(30)   NULL,     -- 황토문화유적 종류
	`ADDR_ROAD`                VARCHAR(200)  NULL,     -- 소재지 도로명주소
	`ADDR_JIBUN`               VARCHAR(200)  NULL,     -- 소재지 지번주소
	`LAT`                      VARCHAR(50)   NULL,     -- 위도
	`LNG`                      VARCHAR(50)   NULL,     -- 경도
	`DSGN_DATE`                DATE          NULL,     -- 지정일자
	`OPERATION_RULE_NM`        VARCHAR(30)   NULL,     -- 소유주체 구분
	`OWNER_NM`                 VARCHAR(300)  NULL,     -- 소유자명
	`SCALE`                    VARCHAR(30)   NULL,     -- 규모
	`ERA_CREATION`             VARCHAR(30)   NULL,     -- 조성시대
	`PHOTO`                    BLOB          NULL,     -- 이미지
	`LOCAL_CULT_HERIT_INTRO`   VARCHAR(1000) NULL,     -- 향도문화유적 소개
	`MNG_AGC_TEL`              VARCHAR(15)   NULL,     -- 관리기관 전화번호
	`MNG_AGC_NM`               VARCHAR(300)  NULL,     -- 관리기관
	`SYNC_TIME`                DATE          NULL      -- 데이터기준일자
);

ALTER TABLE `LOCAL_CULT_HERIT_BASE_INFO`
	ADD CONSTRAINT `PK_LOCAL_CULT_HERIT_BASE_INFO` -- 향토문화유적 기본 정보 기본키
		PRIMARY KEY (
			`ID` -- 코드
		);

CREATE TABLE `TOUR_DEST_BASE_INFO` (
	`ID`                          MEDIUMINT     NOT NULL, -- 코드
	`TOUR_DEST_NM`                VARCHAR(300)  NOT NULL, -- 관광지명
	`OPERATION_RULE_NM`           VARCHAR(30)   NULL,     -- 관광지 구분
	`ADDR_ROAD`                   VARCHAR(200)  NULL,     -- 소재지 도로명주소
	`ADDR_JIBUN`                  VARCHAR(200)  NULL,     -- 소재지 지번주소
	`LAT`                         VARCHAR(50)   NULL,     -- 위도
	`LNG`                         VARCHAR(50)   NULL,     -- 경도
	`AREA`                        VARCHAR(30)   NULL,     -- 면적
	`PUBLIC_CONV_FCLT_INFO`       VARCHAR(1000) NULL,     -- 공공편익시설 정보
	`ACCOM_INFO`                  VARCHAR(1000) NULL,     -- 숙박시설 정보
	`SPORTS_ENTER_FCLT_INFO`      VARCHAR(1000) NULL,     -- 운동 및 오락시설 정보
	`RECREATIONAL_CULT_FCLT_INFO` VARCHAR(1000) NULL,     -- 휴양 및 문화시설 정보
	`HOSPITALITY_FCLT_INFO`       VARCHAR(1000) NULL,     -- 접객시설 정보
	`SUPPORT_FCLT_INFO`           VARCHAR(1000) NULL,     -- 지원시설 정보
	`DSGN_DATE`                   DATE          NULL,     -- 지정일자
	`CAPACITY`                    MEDIUMINT     NULL,     -- 수용인원수
	`AVAIL_PARKING_CNT`           MEDIUMINT     NULL,     -- 주차가능수
	`TOUR_DEST_INTRO`             VARCHAR(1000) NULL,     -- 관광지소개
	`MNG_AGC_TEL`                 VARCHAR(15)   NULL,     -- 관리기관전화번호
	`MNG_AGC_NM`                  VARCHAR(300)  NULL,     -- 관리기관
	`SYNC_TIME`                   DATE          NULL      -- 데이터기준일자
);

ALTER TABLE `TOUR_DEST_BASE_INFO`
	ADD CONSTRAINT `PK_TOUR_DEST_BASE_INFO` -- 관광지 기본 정보 기본키
		PRIMARY KEY (
			`ID` -- 코드
		);

CREATE TABLE `FESTIVAL_BASE_INFO` (
	`ID`                  MEDIUMINT     NOT NULL, -- 코드
	`FESTIVAL_NM`         VARCHAR(300)  NOT NULL, -- 축제명
	`FESTIVAL_VENUE`      VARCHAR(200)  NULL,     -- 개최장소
	`FESTIVAL_BEGIN_DATE` DATE          NULL,     -- 축제 시작일자
	`FESTIVAL_END_DATE`   DATE          NULL,     -- 축제 종료일자
	`FESTIVAL_INFO`       VARCHAR(1000) NULL,     -- 축제 내용
	`MANAGE_AGC_NM`       VARCHAR(300)  NULL,     -- 주관기관
	`AUSPICE_AGC_NM`      VARCHAR(300)  NULL,     -- 주최기관
	`SPONSOR_AGC_NM`      VARCHAR(300)  NULL,     -- 후원기관
	`TEL`                 VARCHAR(15)   NULL,     -- 전화번호
	`HOME_PAGE`           VARCHAR(200)  NULL,     -- 홈페이지주소
	`RELATED_INFO`        VARCHAR(1000) NULL,     -- 관련정보
	`ADDR_ROAD`           VARCHAR(200)  NULL,     -- 소재지 도로명주소
	`ADDR_JIBUN`          VARCHAR(200)  NULL,     -- 소재지 지번주소
	`LAT`                 VARCHAR(50)   NULL,     -- 위도
	`LNG`                 VARCHAR(50)   NULL,     -- 경도
	`SYNC_TIME`           DATE          NULL      -- 데이터기준일자
);

ALTER TABLE `FESTIVAL_BASE_INFO`
	ADD CONSTRAINT `PK_FESTIVAL_BASE_INFO` -- 축제 기본 정보 기본키
		PRIMARY KEY (
			`ID` -- 코드
		);

CREATE TABLE `ARTIST_BASE_INFO` (
	`ID`                  MEDIUMINT    NOT NULL, -- 코드
	`MAIN_CLASS`          VARCHAR(30)  NULL,     -- 대분류
	`MIDDLE_CLASS`        VARCHAR(30)  NULL,     -- 중분류
	`SUB_CLASS`           VARCHAR(30)  NULL,     -- 소분류
	`NM`                  VARCHAR(300) NULL,     -- 이름
	`AFLTN_AGC_NM`        VARCHAR(300) NULL,     -- 소속협회 및 단체
	`AFLTN_AGC_TEL`       VARCHAR(25)  NULL,     -- 소속협회 및 단체 연락처
	`AFLTN_AGC_ADDR`      VARCHAR(200) NULL,     -- 소속협회 및 단체 주소
	`AFLTN_AGC_HOME_PAGE` VARCHAR(200) NULL      -- 소속협회 및 단체 온라인사이트
);

ALTER TABLE `ARTIST_BASE_INFO`
	ADD CONSTRAINT `PK_ARTIST_BASE_INFO` -- 예술인 기본 정보 기본키
		PRIMARY KEY (
			`ID` -- 코드
		);

CREATE TABLE `MSM_ART_GLR_BASE_INFO` (
	`ID`                  MEDIUMINT     NOT NULL, -- 코드
	`MSM_ART_GLR_NM`      VARCHAR(300)  NOT NULL, -- 시설명
	`OPERATION_RULE_NM`   VARCHAR(30)   NULL,     -- 박물관미술관 구분
	`ADDR_ROAD`           VARCHAR(200)  NULL,     -- 소새지도로명주소
	`ADDR_JIBUN`          VARCHAR(200)  NULL,     -- 소재지지번주소
	`LAT`                 VARCHAR(50)   NULL,     -- 위도
	`LNG`                 VARCHAR(50)   NULL,     -- 경도
	`OPERATION_AGC_TEL`   VARCHAR(15)   NULL,     -- 운영기관전화번호
	`OPERATION_AGC_NM`    VARCHAR(300)  NULL,     -- 운영기관명
	`HOME_PAGE`           VARCHAR(200)  NULL,     -- 운영홈페이지
	`CONV_FCLT_INFO`      VARCHAR(1000) NULL,     -- 편의시설정보
	`WEEKDAY_BEGIN_TIME`  TIME          NULL,     -- 평일관람시작시각
	`WEEKDAY_END_TIME`    TIME          NULL,     -- 평일관람종료시각
	`HOLIDAY_BEGIN_TIME`  TIME          NULL,     -- 공휴일관람시작시각
	`HOLIDAY_END_TIME`    TIME          NULL,     -- 공휴일관람종료시각
	`CLOSE_INFO`          VARCHAR(1000) NULL,     -- 휴관정보
	`ADULT_ADMS_FEE`      VARCHAR(100)  NULL,     -- 어른관람료
	`YOUTH_ADMS_FEE`      VARCHAR(100)  NULL,     -- 청소년관람료
	`CHILD_ADMS_FEE`      VARCHAR(100)  NULL,     -- 어린이관람료
	`ADMS_FEE_OTHER_INFO` VARCHAR(1000) NULL,     -- 관료기타정보
	`MSM_ART_GLR_INTRO`   VARCHAR(1000) NULL,     -- 박물관미술관소개
	`TRAFFIC_INFO`        VARCHAR(1000) NULL,     -- 교통안내정보
	`MNG_AGC_TEL`         VARCHAR(15)   NULL,     -- 관리기관전화번호
	`MNG_AGC_NM`          VARCHAR(300)  NULL,     -- 관리기관명
	`SYNC_TIME`           DATE          NULL      -- 데이터기준일자
);

ALTER TABLE `MSM_ART_GLR_BASE_INFO`
	ADD CONSTRAINT `PK_MSM_ART_GLR_BASE_INFO` -- 박물관미술관 기본 정보 기본키
		PRIMARY KEY (
			`ID` -- 코드
		);


CREATE TABLE `EVENT_BASE_INFO` (
	`ID`                MEDIUMINT     NOT NULL, -- 코드
	`EVENT_NM`          VARCHAR(300)  NOT NULL, -- 행사명
	`EVENT_VENUE`       VARCHAR(200)  NULL,     -- 장소
	`EVENT_INFO`        VARCHAR(1000) NULL,     -- 행사내용
	`EVENT_BEGIN_DATE`  DATE          NULL,     -- 행사시작일자
	`EVENT_END_DATE`    DATE          NULL,     -- 행사종료일자
	`EVENT_BEGIN_TIME`  TIME          NULL,     -- 행사시작시각
	`EVENT_END_TIME`    TIME          NULL,     -- 행사종료시각
	`PAY_YN`            VARCHAR(10)   NULL,     -- 요금정보
	`MANAGE_AGC_NM`     VARCHAR(300)  NULL,     -- 주관기관
	`AUSPICE_AGC_NM`    VARCHAR(300)  NULL,     -- 주최기관
	`TEL`               VARCHAR(15)   NULL,     -- 전화번호
	`SPONSOR_AGC_NM`    VARCHAR(300)  NULL,     -- 후원기관
	`SEAT_COUNT`        MEDIUMINT     NULL,     -- 객석수
	`PRICE`             VARCHAR(100)  NULL,     -- 관람요금
	`ENTER_AGE`         VARCHAR(300)  NULL,     -- 입장연령
	`DISCOUNT_INFO`     VARCHAR(1000) NULL,     -- 할인정보
	`NOTICE`            VARCHAR(1000) NULL,     -- 유의사항
	`HOME_PAGE`         VARCHAR(200)  NULL,     -- 홈페이지주소
	`RSRVT_INFO`        VARCHAR(1000) NULL,     -- 예매정보
	`PARKING_LOT_AVAIL` VARCHAR(10)   NULL,     -- 주차장보유여부
	`ADDR_ROAD`         VARCHAR(200)  NULL,     -- 소재지도로명주소
	`ADDR_JIBUN`        VARCHAR(200)  NULL,     -- 소재지지번주소
	`LAT`               VARCHAR(50)   NULL,     -- 위도
	`LNG`               VARCHAR(50)   NULL,     -- 경도
	`SYNC_TIME`         DATE          NULL      -- 데이터기준일자
);

ALTER TABLE `EVENT_BASE_INFO`
	ADD CONSTRAINT `PK_EVENT_BASE_INFO` -- 행사 기본 정보 기본키
		PRIMARY KEY (
			`ID` -- 코드
		);

CREATE TABLE `LOCAL_VISITOR_STATISTICS` (
	`ID`                  MEDIUMINT    NOT NULL, -- 코드
	`AREA_NM`             VARCHAR(300) NULL,     -- 방문지역
	`AUTONOMOUS_D`        VARCHAR(30)  NULL,     -- 자치구
	`TWO_THSND_SIXTEEN`   VARCHAR(10)  NULL,     -- 2016년
	`TWO_THSND_SEVENTEEN` VARCHAR(10)  NULL,     -- 2017년
	`TWO_THSND_EIGHTEEN`  VARCHAR(10)  NULL,     -- 2018년
	`TWO_THSND_NINETEEN`  VARCHAR(10)  NULL,     -- 2019년
	`TWO_THSND_TWENTY`    VARCHAR(10)  NULL,     -- 2020년
	`YR_ON_YR_INCRS`      VARCHAR(20)  NULL      -- 전년대비증가율
);

ALTER TABLE `LOCAL_VISITOR_STATISTICS`
	ADD CONSTRAINT `PK_LOCAL_VISITOR_STATISTICS` -- 지역방문자통계 기본키
		PRIMARY KEY (
			`ID` -- 코드
		);

CREATE TABLE `USER_LOG` (
	`PID`       MEDIUMINT   NULL, -- 코드
	`REQ_IP`    VARCHAR(16) NULL, -- 요청아이피
	`REQ_QUERY` VARCHAR(50) NULL, -- 요청쿼리
	`USE_DT`    DATETIME    NULL  -- 사용일
);
