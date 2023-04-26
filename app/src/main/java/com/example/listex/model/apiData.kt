package com.example.listex.model

import com.google.gson.annotations.SerializedName

/**
 *  key	          문자열(필수)   발급받은키 값을 입력합니다.
    targetDt	  문자열(필수)   조회하고자 하는 날짜를 yyyymmdd 형식으로 입력합니다.
    itemPerPage	  문자열	결과    ROW 의 개수를 지정합니다.(default : “10”, 최대 : “10“)
    multiMovieYn  문자열	       다양성 영화/상업영화를 구분지어 조회할 수 있습니다.
                               “Y” : 다양성 영화 “N” : 상업영화 (default : 전체)
    repNationCd	  문자열	       한국/외국 영화별로 조회할 수 있습니다.
                               “K: : 한국영화 “F” : 외국영화 (default : 전체)
    wideAreaCd    문자열        상영지역별로 조회할 수 있으며, 지역코드는 공통코드 조회 서비스에서 “0105000000” 로서 조회된 지역코드입니다. (default : 전체)
 */


data class apiData(
    @SerializedName("key")
    val key : String,

    @SerializedName("targetDt")
    val targetDt : String,

    @SerializedName("itemPerPage")
    val itemPerPage : String,

    @SerializedName("multiMovieYn")
    val multiMovieYn : String,

    @SerializedName("repNationCd")
    val repNationCd : String,

    @SerializedName("wideAreaCd")
    val wideAreaCd : String

)
