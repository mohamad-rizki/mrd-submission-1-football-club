package com.dafian.android.submissionfootballclub.data.api

import com.dafian.android.submissionfootballclub.data.entity.EventResponse
import com.dafian.android.submissionfootballclub.data.entity.LeagueResponse
import com.dafian.android.submissionfootballclub.data.entity.TeanResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface SportService {

    @GET("/api/v1/json/1/all_leagues.php")
    fun findLeagueAll(): Flowable<LeagueResponse>

    @GET("/api/v1/json/1/eventspastleague.php")
    fun findPastMatchAllByLeague(@Query("id") id: String): Flowable<EventResponse>

    @GET("/api/v1/json/1/eventsnextleague.php")
    fun findNextMatchAllByLeague(@Query("id") id: String): Flowable<EventResponse>

    @GET("/api/v1/json/1/lookupevent.php")
    fun lookUpMatchByEvent(@Query("id") id: String): Flowable<EventResponse>

    @GET("/api/v1/json/1/lookupteam.php")
    fun searchTeamById(@Query("id") id: String): Flowable<TeanResponse>
}