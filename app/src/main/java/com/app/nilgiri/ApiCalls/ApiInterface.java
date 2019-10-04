package com.app.nilgiri.ApiCalls;
import com.app.nilgiri.Common.GenericResponse;
import com.app.nilgiri.Models.AdminTdsCharge;
import com.app.nilgiri.Models.BankDetailData;
import com.app.nilgiri.Models.GetKycDetail;
import com.app.nilgiri.Models.IfscDetails;
import com.app.nilgiri.Models.Login;
import com.app.nilgiri.Models.MyTeamDirectModel;
import com.app.nilgiri.Models.MyTeamLeftModel;
import com.app.nilgiri.Models.MyTeamModel;
import com.app.nilgiri.Models.MyTeamRightModel;
import com.app.nilgiri.Models.Notification;
import com.app.nilgiri.Models.OrderHistory;
import com.app.nilgiri.Models.PayoutDetails;
import com.app.nilgiri.Models.PayoutWallet;
import com.app.nilgiri.Models.Payouts;
import com.app.nilgiri.Models.ProfileData;
import com.app.nilgiri.Models.ResponseData;
import com.app.nilgiri.Models.TreeData;
import com.app.nilgiri.Models.WalletBalance;
import com.app.nilgiri.Models.WalletData;
import com.app.nilgiri.Models.WalletDataShoppingModel;
import com.app.nilgiri.Models.WalletdataTopUpModel;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("getResponse/login")
    Call<Login> loginUser(@Field("username") String username, @Field("password") String password, @Field("api_key") String apiKey);

    @Multipart
    @POST("getResponse/update_kyc")
    Call<GenericResponse> getClientUpdateKyc(@Part("api_key") RequestBody apiKey, @Part("client_id") RequestBody clientid, @Part MultipartBody.Part upload_first_proof, @Part MultipartBody.Part upload_second_proof, @Part MultipartBody.Part upload_third_proof);


    @GET("getResponse/kycDetail/{company_id}")
    Call<GetKycDetail> getkycDetail(@Path("company_id") String company_Id, @Query("api_key") String apiKey);


    @GET("getResponse/profile/{company_id}")
    Call<ProfileData> getProfile(@Path("company_id") String company_Id, @Query("api_key") String apiKey);

    @GET("getResponse/treeView/{company_id}")
    Call<TreeData> getTreeViewData(@Path("company_id") String company_id, @Query("api_key") String apiKey);

    @GET("getResponse/team/{company_id}")
    Call<MyTeamModel> getMyTeam(@Path("company_id") String company_Id, @Query("api_key") String apiKey);

    @GET("getResponse/leftTeam/{company_id}")
    Call<MyTeamLeftModel> getLeftTeam(@Path("company_id") String company_Id, @Query("api_key") String apiKey,@Query("page") int page);

    @GET("getResponse/rightTeam/{company_id}")
    Call<MyTeamRightModel> getRightTeam(@Path("company_id") String company_Id, @Query("api_key") String apiKey);

    @GET("getResponse/directTeam/{company_id}")
    Call<MyTeamDirectModel> getDirectTeam(@Path("company_id") String company_Id, @Query("api_key") String apiKey);

    @GET("getResponse/payout/{company_id}")
    Call<PayoutDetails> getPayoutDetails(@Path("company_id") String company_Id, @Query("api_key") String apiKey);

    @GET("getResponse/payoutList/{payout_id}")
    Call<Payouts> getPayoutList(@Path("payout_id") String payoutId, @Query("api_key") String apiKey);

    @GET("getResponse/wallet/{company_id}")
    Call<WalletData> getWalletData(@Path("company_id") String payoutId, @Query("api_key") String apiKey);

    @Multipart
    @POST("getResponse/updateProfile")
    Call<ResponseData> updateUserProfile(@Part("company_id") RequestBody companyId, @Part("api_key") RequestBody apiKey, @Part("address") RequestBody address, @Part("email") RequestBody email, @Part("phone") RequestBody phone, @Part("city") RequestBody city, @Part("state") RequestBody state, @Part MultipartBody.Part image);

   /* @FormUrlEncoded
    @POST("getResponse/updateProfile")
    Call<ResponseData> updateUserProfile(@Field("company_id") String companyId, @Field("api_key") String apiKey, @Field("address") String address, @Field("email") String email, @Field("phone") String phone, @Field("city") String city, @Field("state") String state);*/

    @GET("getResponse/order_history/{company_id}")
    Call<OrderHistory> getOrderHistory(@Path("company_id") String company_id, @Query("api_key") String apiKey);

    @GET("getResponse/adminTdsCharge/{company_id}")
    Call<AdminTdsCharge> getAdminTdsCharge(@Path("company_id") String payoutId, @Query("api_key") String apiKey);

    @GET("getResponse/wallet_payout/{company_id}")
    Call<PayoutWallet> getPayoutWallet(@Path("company_id") String company_id, @Query("api_key") String apiKey);

    @GET("getResponse/wallet_shopping/{company_id}")
    Call<WalletDataShoppingModel> getShoppingWallet(@Path("company_id") String company_id, @Query("api_key") String apiKey);

    @GET("getResponse/wallet_topup/{company_id}")
    Call<WalletdataTopUpModel> getTopUpWallet(@Path("company_id") String company_id, @Query("api_key") String apiKey);

    @GET("getResponse/notification")
    Call<Notification> getNotification(@Query("api_key") String apiKey);

    @GET("getResponse/bankDetail/{company_id}")
    Call<BankDetailData> getBankDetail(@Path("company_id") String company_id, @Query("api_key") String apiKey);

    @GET("{ifsc}")
    Call<IfscDetails> getIfscDetails(@Path("ifsc") String company_id);

    @GET("getResponse/topup_balance/{company_id}")
    Call<WalletBalance> getTopupBalance(@Path("company_id") String company_id, @Query("api_key") String apiKey);

    @GET("getResponse/shopping_balance/{company_id}")
    Call<WalletBalance> getShoppingBalance(@Path("company_id") String company_id, @Query("api_key") String apiKey);

    @GET("getResponse/payout_balance/{company_id}")
    Call<WalletBalance> getPayoutBalance(@Path("company_id") String company_id, @Query("api_key") String apiKey);

    @FormUrlEncoded
    @POST("getResponse/updateBank")
    Call<ResponseData> updateBankDetails(@Field("company_id") String companyId, @Field("api_key") String apiKey, @Field("account_holder_name") String name, @Field("account_number") String account_number, @Field("ifsc_code") String account_ifsc_code);
}
