package fr.free.nrw.commons.notification

import io.reactivex.Observable
import org.wikipedia.dataclient.Service
import org.wikipedia.dataclient.mwapi.MwQueryResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface NotificationInterface {

    @Headers("Cache-Control: no-cache")
    @GET(Service.MW_API_PREFIX + "action=query&meta=notifications&notformat=model&notlimit=max")
    fun getAllNotifications(
        @Query("notwikis") wikiList: String?,
        @Query("notfilter") filter: String?,
        @Query("notcontinue") continueStr: String?
    ): Observable<MwQueryResponse?>

    @FormUrlEncoded
    @Headers("Cache-Control: no-cache")
    @POST(Service.MW_API_PREFIX + "action=echomarkread")
    fun markRead(
        @Field("token") token: String,
        @Field("list") readList: String?,
        @Field("unreadlist") unreadList: String?
    ): Observable<MwQueryResponse?>
}