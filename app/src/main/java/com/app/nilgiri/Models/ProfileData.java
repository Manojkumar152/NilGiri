package com.app.nilgiri.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProfileData {

    /**
     * data : {"id":"3","group_id":"3","group_name":"customer","customer_group_id":"1","customer_group_name":"General","name":"TPID001","father_name":"TPID","company":null,"vat_no":null,"address":"batala","city":"batala","city_text":"0","state":"punjab","state_text":"0","postal_code":"","landmark":"xyz","country":"101","country_text":"India","phone":"98989813","email":"prabh@gmail.com","pan_card":"AADDF5533D","gender":"female","step":"4","nominee":"","date_of_birth":null,"invoice_footer":null,"payment_term":null,"logo":null,"award_points":null,"deposit_amount":null,"price_group_id":"1","price_group_name":"Default","gst_no":null,"position":"1","customer_sponser_id":"TPID","username":"TPID","direct_sponser_id":"RootID","direct_sponser_username":"RootID","direct_sponser_name":null,"sponser_id":"RootID","sponser_username":"RootID","sponser_name":null,"block":"0","active_type":"Gold","package_id":"0","package_name":null,"package_amt":"0.00","package_roi":"0","sales_active":"1","sales_active_date":"2019-05-08 09:01:57","member_sale":{"member":{"left":5066,"right":1809,"direct":62},"active_member":{"left":2005,"right":211,"direct":44},"non_active_member":{"left":3061,"right":1598,"direct":18},"direct_member":{"left":29,"right":33,"direct":62},"sale":{"left":7.149374612E7,"right":18258181,"direct":10964626},"bv":{"left":55256144,"right":11442574,"self":"134300"},"gold":{"left":4.072279312E7,"right":16434493,"direct":10342000},"package":{"left":30997203,"right":1709688,"direct":622626}},"p_sender_id":"9882677403","created_at":"2018-12-09 00:00:00","updated_at":"2019-09-16 14:00:25"}
     * users : {"avatar":"bf5a7ce0ad5aa5876f3d5c89cbc88dca.jpg","company_id":"3"}
     * wallet_topup : [{"id":"118","date":"2019-07-15","company_id":"3","payout_id":"0","debit":"0.0000","credit":"1000.0000","balance":"1000.0000","note":"owner has added fund","created_by":"1","created_at":"2019-07-15 15:29:54"},{"id":"122","date":"2019-07-16","company_id":"3","payout_id":"406752","debit":"0.0000","credit":"1312.5000","balance":"2312.5000","note":"Generate Direct Income :: Rs.1,312.50 (Rs.26,250.00 X 5%) From TEST@RAVI012","created_by":"1","created_at":"2019-07-16 13:46:00"},{"id":"1536","date":"2019-07-20","company_id":"3","payout_id":"0","debit":"0.0000","credit":"27000.0000","balance":"29312.5000","note":"owner has added fund","created_by":"1","created_at":"2019-07-20 13:30:52"},{"id":"1537","date":"2019-07-20","company_id":"3","payout_id":"447692","debit":"0.0000","credit":"625.0000","balance":"29937.5000","note":"Generate Direct Income :: Rs.625.00 (Rs.12,500.00 X 5%) From tptest2","created_by":"1","created_at":"2019-07-20 23:59:59"},{"id":"4738","date":"2019-08-14","company_id":"3","payout_id":"0","debit":"110.0000","credit":"0.0000","balance":"29827.5000","note":null,"created_by":"2","created_at":"2019-08-14 11:53:45"},{"id":"4739","date":"2019-08-16","company_id":"3","payout_id":"0","debit":"100.0000","credit":"0.0000","balance":"29727.5000","note":null,"created_by":"2","created_at":"2019-08-16 15:53:02"},{"id":"4740","date":"2019-08-16","company_id":"3","payout_id":"0","debit":"100.0000","credit":"0.0000","balance":"29627.5000","note":null,"created_by":"2","created_at":"2019-08-16 16:26:09"},{"id":"4741","date":"2019-08-17","company_id":"3","payout_id":"0","debit":"28000.0000","credit":"0.0000","balance":"1627.5000","note":"owner has deducted fund","created_by":"1","created_at":"2019-08-17 15:01:57"},{"id":"4742","date":"2019-08-17","company_id":"3","payout_id":"0","debit":"1500.0000","credit":"0.0000","balance":"127.5000","note":"owner has deducted fund","created_by":"1","created_at":"2019-08-17 15:01:57"},{"id":"4743","date":"2019-08-17","company_id":"3","payout_id":"0","debit":"120.0000","credit":"0.0000","balance":"7.5000","note":null,"created_by":"2","created_at":"2019-08-17 16:26:41"},{"id":"4744","date":"2019-08-19","company_id":"3","payout_id":"0","debit":"0.0000","credit":"5000.0000","balance":"5007.5000","note":"owner has added fund","created_by":"1","created_at":"2019-08-19 14:46:29"},{"id":"4745","date":"2019-08-19","company_id":"3","payout_id":"0","debit":"120.0000","credit":"0.0000","balance":"4887.5000","note":null,"created_by":"2","created_at":"2019-08-19 15:13:14"},{"id":"4746","date":"2019-08-19","company_id":"3","payout_id":"0","debit":"120.0000","credit":"0.0000","balance":"4767.5000","note":null,"created_by":"2","created_at":"2019-08-19 18:15:26"},{"id":"4747","date":"2019-08-21","company_id":"3","payout_id":"0","debit":"120.0000","credit":"0.0000","balance":"4647.5000","note":null,"created_by":"2","created_at":"2019-08-21 12:21:48"},{"id":"4748","date":"2019-08-21","company_id":"3","payout_id":"0","debit":"120.0000","credit":"0.0000","balance":"4527.5000","note":"Transaction successful Last_used_OkeyKey: 4","created_by":"2","created_at":"2019-08-21 12:49:30"},{"id":"4749","date":"2019-08-21","company_id":"3","payout_id":"0","debit":"120.0000","credit":"0.0000","balance":"4407.5000","note":"Transaction succesful using instant withdraw netpayable amount : 108","created_by":"2","created_at":"2019-08-21 14:04:56"},{"id":"4750","date":"2019-08-27","company_id":"3","payout_id":"0","debit":"4407.5000","credit":"0.0000","balance":"0.0000","note":"We tranferred your amount to Payout Wallet","created_by":"1","created_at":"2019-08-27 23:57:34"}]
     * wallet_shopping : []
     * wallet_payout : [{"id":"4363","date":"2019-05-19","payout_id":null,"company_id":"3","debit":"1000.0000","credit":"0.0000","balance":"25798.5748","note":"Withdraw to Bank","created_by":"2","created_at":"2019-05-19 13:18:38"},{"id":"4372","date":"2019-05-20","payout_id":"46159","company_id":"3","debit":"0.0000","credit":"25388.1748","balance":"51186.7496","note":"Received amount from weekly payout","created_by":"1","created_at":"2019-05-20 17:22:10"},{"id":"4397","date":"2019-05-20","payout_id":"49657","company_id":"3","debit":"0.0000","credit":"84.3000","balance":"51271.0496","note":"Received amount from weekly payout","created_by":"1","created_at":"2019-05-20 17:47:25"},{"id":"4400","date":"2019-05-20","payout_id":"51431","company_id":"3","debit":"0.0000","credit":"84.3000","balance":"51355.3496","note":"Received amount from weekly payout","created_by":"1","created_at":"2019-05-20 18:03:10"},{"id":"4847","date":"2019-05-20","payout_id":"55031","company_id":"3","debit":"0.0000","credit":"13248.0500","balance":"64603.3996","note":"Received amount from weekly payout","created_by":"1","created_at":"2019-05-20 18:33:21"},{"id":"4874","date":"2019-05-21","payout_id":"57449","company_id":"3","debit":"0.0000","credit":"1062.5000","balance":"65665.8996","note":"Received amount from weekly payout","created_by":"1","created_at":"2019-05-21 14:30:02"},{"id":"4886","date":"2019-05-22","payout_id":"99300","company_id":"3","debit":"0.0000","credit":"485.4369","balance":"66151.3365","note":"Generate Direct Income :: Rs.485.44 (Rs.9,708.74 X 5%) From TP460548","created_by":"1","created_at":"2019-05-22 11:19:00"},{"id":"4899","date":"2019-05-23","payout_id":"62480","company_id":"3","debit":"0.0000","credit":"1941.7476","balance":"68093.0841","note":"Received amount from weekly payout","created_by":"1","created_at":"2019-05-23 08:32:13"},{"id":"4934","date":"2019-05-23","payout_id":null,"company_id":"3","debit":"0.0000","credit":"1000.0000","balance":"69093.0841","note":"Admin rejected withdraw request","created_by":"1","created_at":"2019-05-23 15:20:33"},{"id":"5085","date":"2019-05-26","payout_id":"70486","company_id":"3","debit":"0.0000","credit":"1000.0000","balance":"70093.0841","note":"Received amount from weekly payout","created_by":"1","created_at":"2019-05-26 08:32:17"},{"id":"5183","date":"2019-05-28","payout_id":null,"company_id":"3","debit":"100.0000","credit":"0.0000","balance":"69993.0841","note":"Transaction successful Last_used_OkeyKey: 5","created_by":"2","created_at":"2019-05-28 11:30:06"},{"id":"5185","date":"2019-05-28","payout_id":null,"company_id":"3","debit":"100.0000","credit":"0.0000","balance":"69893.0841","note":"Transaction successful Last_used_OkeyKey: 5","created_by":"2","created_at":"2019-05-28 11:33:05"},{"id":"5189","date":"2019-05-28","payout_id":null,"company_id":"3","debit":"100.0000","credit":"0.0000","balance":"69793.0841","note":"Transaction successful Last_used_OkeyKey: 5","created_by":"2","created_at":"2019-05-28 11:59:34"},{"id":"5299","date":"2019-05-29","payout_id":"79043","company_id":"3","debit":"0.0000","credit":"32470.0000","balance":"102263.0841","note":"Received amount from weekly payout","created_by":"1","created_at":"2019-05-29 09:02:20"},{"id":"5375","date":"2019-05-30","payout_id":"82009","company_id":"3","debit":"0.0000","credit":"11562.5000","balance":"113825.5841","note":"Received amount from weekly payout","created_by":"1","created_at":"2019-05-30 09:02:21"},{"id":"5481","date":"2019-05-31","payout_id":"85002","company_id":"3","debit":"0.0000","credit":"5000.0000","balance":"118825.5841","note":"Received amount from weekly payout","created_by":"1","created_at":"2019-05-31 09:32:26"},{"id":"6163","date":"2019-06-02","payout_id":null,"company_id":"3","debit":"100.0000","credit":"0.0000","balance":"118725.5841","note":null,"created_by":"2","created_at":"2019-06-02 17:37:57"},{"id":"6166","date":"2019-06-02","payout_id":null,"company_id":"3","debit":"100.0000","credit":"0.0000","balance":"118625.5841","note":null,"created_by":"2","created_at":"2019-06-02 17:39:49"},{"id":"6190","date":"2019-06-02","payout_id":"91077","company_id":"3","debit":"0.0000","credit":"3198.4224","balance":"121824.0065","note":"Received amount from payout on 2019-06-01","created_by":"1","created_at":"2019-06-02 18:07:18"},{"id":"6663","date":"2019-06-04","payout_id":"145970","company_id":"3","debit":"0.0000","credit":"50000.0000","balance":"171824.0065","note":"Generate Direct Income :: Rs.50,000.00 (Rs.1,000,000.00 X 5%) From Power2","created_by":"1","created_at":"2019-06-04 17:54:00"},{"id":"6664","date":"2019-06-04","payout_id":"145971","company_id":"3","debit":"0.0000","credit":"50000.0000","balance":"221824.0065","note":"Generate Direct Income :: Rs.50,000.00 (Rs.1,000,000.00 X 5%) From Power1","created_by":"1","created_at":"2019-06-04 17:53:00"},{"id":"6665","date":"2019-06-04","payout_id":"145972","company_id":"3","debit":"0.0000","credit":"50000.0000","balance":"271824.0065","note":"Generate Direct Income :: Rs.50,000.00 (Rs.1,000,000.00 X 5%) From Power3","created_by":"1","created_at":"2019-06-04 17:56:00"},{"id":"6666","date":"2019-06-04","payout_id":"145973","company_id":"3","debit":"0.0000","credit":"50000.0000","balance":"321824.0065","note":"Generate Direct Income :: Rs.50,000.00 (Rs.1,000,000.00 X 5%) From Power4","created_by":"1","created_at":"2019-06-04 17:56:00"},{"id":"6667","date":"2019-06-04","payout_id":"145974","company_id":"3","debit":"0.0000","credit":"50000.0000","balance":"371824.0065","note":"Generate Direct Income :: Rs.50,000.00 (Rs.1,000,000.00 X 5%) From Power5","created_by":"1","created_at":"2019-06-04 17:57:00"},{"id":"6670","date":"2019-06-04","payout_id":"145975","company_id":"3","debit":"0.0000","credit":"50000.0000","balance":"421824.0065","note":"Generate Direct Income :: Rs.50,000.00 (Rs.1,000,000.00 X 5%) From Power6","created_by":"1","created_at":"2019-06-04 17:58:00"},{"id":"6671","date":"2019-06-04","payout_id":"145976","company_id":"3","debit":"0.0000","credit":"50000.0000","balance":"471824.0065","note":"Generate Direct Income :: Rs.50,000.00 (Rs.1,000,000.00 X 5%) From Power7","created_by":"1","created_at":"2019-06-04 17:58:00"},{"id":"6672","date":"2019-06-04","payout_id":"145977","company_id":"3","debit":"0.0000","credit":"50000.0000","balance":"521824.0065","note":"Generate Direct Income :: Rs.50,000.00 (Rs.1,000,000.00 X 5%) From Power8","created_by":"1","created_at":"2019-06-04 17:58:00"},{"id":"6673","date":"2019-06-04","payout_id":"145978","company_id":"3","debit":"0.0000","credit":"50000.0000","balance":"571824.0065","note":"Generate Direct Income :: Rs.50,000.00 (Rs.1,000,000.00 X 5%) From Power9","created_by":"1","created_at":"2019-06-04 17:59:00"},{"id":"6675","date":"2019-06-04","payout_id":"145979","company_id":"3","debit":"0.0000","credit":"50000.0000","balance":"621824.0065","note":"Generate Direct Income :: Rs.50,000.00 (Rs.1,000,000.00 X 5%) From Power10","created_by":"1","created_at":"2019-06-04 17:59:00"},{"id":"6705","date":"2019-06-05","payout_id":"100625","company_id":"3","debit":"0.0000","credit":"50000.0000","balance":"671824.0065","note":"Received amount from payout on 2019-06-04","created_by":"1","created_at":"2019-06-05 01:47:26"},{"id":"6849","date":"2019-06-06","payout_id":"103939","company_id":"3","debit":"0.0000","credit":"3200.0000","balance":"675024.0065","note":"Received amount from payout on 2019-06-05","created_by":"1","created_at":"2019-06-06 01:52:28"},{"id":"7671","date":"2019-06-09","payout_id":"114286","company_id":"3","debit":"0.0000","credit":"14070.0000","balance":"689094.0065","note":"Received amount from payout on 2019-06-08","created_by":"1","created_at":"2019-06-09 01:51:42"},{"id":"8381","date":"2019-06-12","payout_id":"125116","company_id":"3","debit":"0.0000","credit":"2500.0000","balance":"691594.0065","note":"Received amount from payout on 2019-06-11","created_by":"1","created_at":"2019-06-12 02:01:43"},{"id":"8745","date":"2019-06-14","payout_id":"132653","company_id":"3","debit":"0.0000","credit":"7500.0000","balance":"699094.0065","note":"Received amount from payout on 2019-06-13","created_by":"1","created_at":"2019-06-14 02:06:43"},{"id":"8882","date":"2019-06-15","payout_id":"136529","company_id":"3","debit":"0.0000","credit":"8140.0000","balance":"707234.0065","note":"Received amount from payout on 2019-06-14","created_by":"1","created_at":"2019-06-15 02:06:43"},{"id":"9893","date":"2019-06-18","payout_id":"148371","company_id":"3","debit":"0.0000","credit":"2500.0000","balance":"709734.0065","note":"Received amount from payout on 2019-06-17","created_by":"1","created_at":"2019-06-18 02:16:43"},{"id":"10421","date":"2019-06-20","payout_id":"156847","company_id":"3","debit":"0.0000","credit":"50000.0000","balance":"759734.0065","note":"Received amount from payout on 2019-06-19","created_by":"1","created_at":"2019-06-20 02:26:43"},{"id":"11130","date":"2019-06-24","payout_id":"174800","company_id":"3","debit":"0.0000","credit":"16540.0000","balance":"776274.0065","note":"Received amount from payout on 2019-06-23","created_by":"1","created_at":"2019-06-24 03:41:43"},{"id":"12593","date":"2019-06-27","payout_id":"188722","company_id":"3","debit":"0.0000","credit":"750.0000","balance":"777024.0065","note":"Received amount from payout on 2019-06-26","created_by":"1","created_at":"2019-06-27 05:21:43"},{"id":"12806","date":"2019-06-28","payout_id":"193562","company_id":"3","debit":"0.0000","credit":"3250.0000","balance":"780274.0065","note":"Received amount from payout on 2019-06-27","created_by":"1","created_at":"2019-06-28 04:51:43"},{"id":"13452","date":"2019-06-30","payout_id":"203482","company_id":"3","debit":"0.0000","credit":"18415.0000","balance":"798689.0065","note":"Received amount from payout on 2019-06-29","created_by":"1","created_at":"2019-06-30 05:56:43"},{"id":"13873","date":"2019-07-02","payout_id":"213822","company_id":"3","debit":"0.0000","credit":"7760.9224","balance":"806449.9289","note":"Received amount from payout on 2019-07-01","created_by":"1","created_at":"2019-07-02 03:11:43"},{"id":"14897","date":"2019-07-03","payout_id":"219284","company_id":"3","debit":"0.0000","credit":"2500.0000","balance":"808949.9289","note":"Received amount from payout on 2019-07-02","created_by":"1","created_at":"2019-07-03 03:16:43"},{"id":"15974","date":"2019-07-06","payout_id":"236094","company_id":"3","debit":"0.0000","credit":"3562.5000","balance":"812512.4289","note":"Received amount from payout on 2019-07-05","created_by":"1","created_at":"2019-07-06 10:51:43"},{"id":"16725","date":"2019-07-10","payout_id":"253584","company_id":"3","debit":"0.0000","credit":"24732.5000","balance":"837244.9289","note":"Received amount from payout on 2019-07-09","created_by":"1","created_at":"2019-07-10 15:31:00"},{"id":"17403","date":"2019-07-11","payout_id":"259595","company_id":"3","debit":"0.0000","credit":"3430.0000","balance":"840674.9289","note":"Received amount from payout on 2019-07-10","created_by":"1","created_at":"2019-07-11 14:07:12"},{"id":"17673","date":"2019-07-12","payout_id":"265652","company_id":"3","debit":"0.0000","credit":"2500.0000","balance":"843174.9289","note":"Received amount from payout on 2019-07-11","created_by":"1","created_at":"2019-07-12 04:16:43"},{"id":"18219","date":"2019-07-13","payout_id":null,"company_id":"3","debit":"1900.0000","credit":"0.0000","balance":"841274.9289","note":"Transaction successful Last_used_OkeyKey: 5","created_by":"2","created_at":"2019-07-13 12:43:20"},{"id":"18405","date":"2019-07-14","payout_id":"277882","company_id":"3","debit":"0.0000","credit":"2500.0000","balance":"843774.9289","note":"Received amount from payout on 2019-07-13","created_by":"1","created_at":"2019-07-14 03:41:44"},{"id":"18750","date":"2019-07-16","payout_id":"290227","company_id":"3","debit":"0.0000","credit":"10000.0000","balance":"853774.9289","note":"Received amount from payout on 2019-07-15","created_by":"1","created_at":"2019-07-16 03:41:43"},{"id":"18946","date":"2019-07-17","payout_id":"296475","company_id":"3","debit":"0.0000","credit":"2500.0000","balance":"856274.9289","note":"Received amount from payout on 2019-07-16","created_by":"1","created_at":"2019-07-17 03:46:43"},{"id":"19728","date":"2019-07-19","payout_id":"309148","company_id":"3","debit":"0.0000","credit":"350.0000","balance":"856624.9289","note":"Received amount from payout on 2019-07-18","created_by":"1","created_at":"2019-07-19 12:41:56"},{"id":"19749","date":"2019-07-20","payout_id":"315579","company_id":"3","debit":"0.0000","credit":"7850.0000","balance":"864474.9289","note":"Received amount from payout on 2019-07-19","created_by":"1","created_at":"2019-07-20 03:51:44"},{"id":"19901","date":"2019-07-21","payout_id":"322040","company_id":"3","debit":"0.0000","credit":"4100.0000","balance":"868574.9289","note":"Received amount from payout on 2019-07-20","created_by":"1","created_at":"2019-07-21 03:56:43"},{"id":"19942","date":"2019-07-22","payout_id":"328521","company_id":"3","debit":"0.0000","credit":"4100.0000","balance":"872674.9289","note":"Received amount from payout on 2019-07-21","created_by":"1","created_at":"2019-07-22 03:56:43"},{"id":"20161","date":"2019-07-27","payout_id":"335011","company_id":"3","debit":"0.0000","credit":"5290.0000","balance":"877964.9289","note":"Received amount from payout on 2019-07-26","created_by":"1","created_at":"2019-07-27 04:56:44"},{"id":"20614","date":"2019-08-27","payout_id":null,"company_id":"3","debit":"0.0000","credit":"4407.5000","balance":"882372.4289","note":"You have received amount from Instant Wallet","created_by":"1","created_at":"2019-08-27 23:57:34"},{"id":"21416","date":"2019-09-04","payout_id":null,"company_id":"3","debit":"0.0000","credit":"1000.0000","balance":"1000.0000","note":"Transfer received form Payout Wallet","created_by":"1044","created_at":"2019-09-04 15:11:37"},{"id":"21418","date":"2019-09-04","payout_id":null,"company_id":"3","debit":"0.0000","credit":"1000.0000","balance":"1000.0000","note":"Transfer received form Payout Wallet","created_by":"1044","created_at":"2019-09-04 15:11:42"},{"id":"21420","date":"2019-09-04","payout_id":null,"company_id":"3","debit":"0.0000","credit":"1000.0000","balance":"1000.0000","note":"Transfer received form Payout Wallet","created_by":"1044","created_at":"2019-09-04 15:12:53"},{"id":"21422","date":"2019-09-04","payout_id":null,"company_id":"3","debit":"0.0000","credit":"1000.0000","balance":"1000.0000","note":"Transfer received form Payout Wallet","created_by":"1044","created_at":"2019-09-04 15:12:56"},{"id":"21425","date":"2019-09-04","payout_id":null,"company_id":"3","debit":"1000.0000","credit":"0.0000","balance":"0.0000","note":"Transfer to payout wallet TP728505","created_by":"2","created_at":"2019-09-04 15:19:31"},{"id":"21427","date":"2019-09-04","payout_id":null,"company_id":"3","debit":"1000.0000","credit":"0.0000","balance":"-1000.0000","note":"Transfer to payout wallet TP728505","created_by":"2","created_at":"2019-09-04 15:20:18"},{"id":"21429","date":"2019-09-04","payout_id":null,"company_id":"3","debit":"1000.0000","credit":"0.0000","balance":"-2000.0000","note":"Transfer to payout wallet TP728505","created_by":"2","created_at":"2019-09-04 15:20:22"},{"id":"21431","date":"2019-09-04","payout_id":null,"company_id":"3","debit":"3000.0000","credit":"0.0000","balance":"-5000.0000","note":"Transfer to payout wallet TP728505","created_by":"2","created_at":"2019-09-04 15:21:33"},{"id":"21432","date":"2019-09-04","payout_id":null,"company_id":"3","debit":"0.0000","credit":"1000.0000","balance":"-4000.0000","note":"Transfer received form Payout Wallet","created_by":"1044","created_at":"2019-09-04 15:21:55"},{"id":"21435","date":"2019-09-04","payout_id":null,"company_id":"3","debit":"1000.0000","credit":"0.0000","balance":"-5000.0000","note":"Transfer to payout wallet TP297597","created_by":"2","created_at":"2019-09-04 15:23:55"}]
     * message : Successfully
     * status : 1
     */

    private DataBean data;
    private UsersBean users;
    private String message;
    private int status;
    private List<WalletTopupBean> wallet_topup;
    private List<?> wallet_shopping;
    private List<WalletPayoutBean> wallet_payout;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public UsersBean getUsers() {
        return users;
    }

    public void setUsers(UsersBean users) {
        this.users = users;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<WalletTopupBean> getWallet_topup() {
        return wallet_topup;
    }

    public void setWallet_topup(List<WalletTopupBean> wallet_topup) {
        this.wallet_topup = wallet_topup;
    }

    public List<?> getWallet_shopping() {
        return wallet_shopping;
    }

    public void setWallet_shopping(List<?> wallet_shopping) {
        this.wallet_shopping = wallet_shopping;
    }

    public List<WalletPayoutBean> getWallet_payout() {
        return wallet_payout;
    }

    public void setWallet_payout(List<WalletPayoutBean> wallet_payout) {
        this.wallet_payout = wallet_payout;
    }

    public static class DataBean {
        /**
         * id : 3
         * group_id : 3
         * group_name : customer
         * customer_group_id : 1
         * customer_group_name : General
         * name : TPID001
         * father_name : TPID
         * company : null
         * vat_no : null
         * address : batala
         * city : batala
         * city_text : 0
         * state : punjab
         * state_text : 0
         * postal_code :
         * landmark : xyz
         * country : 101
         * country_text : India
         * phone : 98989813
         * email : prabh@gmail.com
         * pan_card : AADDF5533D
         * gender : female
         * step : 4
         * nominee :
         * date_of_birth : null
         * invoice_footer : null
         * payment_term : null
         * logo : null
         * award_points : null
         * deposit_amount : null
         * price_group_id : 1
         * price_group_name : Default
         * gst_no : null
         * position : 1
         * customer_sponser_id : TPID
         * username : TPID
         * direct_sponser_id : RootID
         * direct_sponser_username : RootID
         * direct_sponser_name : null
         * sponser_id : RootID
         * sponser_username : RootID
         * sponser_name : null
         * block : 0
         * active_type : Gold
         * package_id : 0
         * package_name : null
         * package_amt : 0.00
         * package_roi : 0
         * sales_active : 1
         * sales_active_date : 2019-05-08 09:01:57
         * member_sale : {"member":{"left":5066,"right":1809,"direct":62},"active_member":{"left":2005,"right":211,"direct":44},"non_active_member":{"left":3061,"right":1598,"direct":18},"direct_member":{"left":29,"right":33,"direct":62},"sale":{"left":7.149374612E7,"right":18258181,"direct":10964626},"bv":{"left":55256144,"right":11442574,"self":"134300"},"gold":{"left":4.072279312E7,"right":16434493,"direct":10342000},"package":{"left":30997203,"right":1709688,"direct":622626}}
         * p_sender_id : 9882677403
         * created_at : 2018-12-09 00:00:00
         * updated_at : 2019-09-16 14:00:25
         */

        private String id;
        private String group_id;
        private String group_name;
        private String customer_group_id;
        private String customer_group_name;
        private String name;
        private String father_name;
        private Object company;
        private Object vat_no;
        private String address;
        private String city;
        private String city_text;
        private String state;
        private String state_text;
        private String postal_code;
        private String landmark;
        private String country;
        private String country_text;
        private String phone;
        private String email;
        private String pan_card;
        private String gender;
        private String step;
        private String nominee;
        private Object date_of_birth;
        private Object invoice_footer;
        private Object payment_term;
        private Object logo;
        private Object award_points;
        private Object deposit_amount;
        private String price_group_id;
        private String price_group_name;
        private Object gst_no;
        private String position;
        private String customer_sponser_id;
        private String username;
        private String direct_sponser_id;
        private String direct_sponser_username;
        private Object direct_sponser_name;
        private String sponser_id;
        private String sponser_username;
        private Object sponser_name;
        private String block;
        private String active_type;
        private String package_id;
        private Object package_name;
        private String package_amt;
        private String package_roi;
        private String sales_active;
        private String sales_active_date;
        private MemberSaleBean member_sale;
        private String p_sender_id;
        private String created_at;
        private String updated_at;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGroup_id() {
            return group_id;
        }

        public void setGroup_id(String group_id) {
            this.group_id = group_id;
        }

        public String getGroup_name() {
            return group_name;
        }

        public void setGroup_name(String group_name) {
            this.group_name = group_name;
        }

        public String getCustomer_group_id() {
            return customer_group_id;
        }

        public void setCustomer_group_id(String customer_group_id) {
            this.customer_group_id = customer_group_id;
        }

        public String getCustomer_group_name() {
            return customer_group_name;
        }

        public void setCustomer_group_name(String customer_group_name) {
            this.customer_group_name = customer_group_name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFather_name() {
            return father_name;
        }

        public void setFather_name(String father_name) {
            this.father_name = father_name;
        }

        public Object getCompany() {
            return company;
        }

        public void setCompany(Object company) {
            this.company = company;
        }

        public Object getVat_no() {
            return vat_no;
        }

        public void setVat_no(Object vat_no) {
            this.vat_no = vat_no;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCity_text() {
            return city_text;
        }

        public void setCity_text(String city_text) {
            this.city_text = city_text;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getState_text() {
            return state_text;
        }

        public void setState_text(String state_text) {
            this.state_text = state_text;
        }

        public String getPostal_code() {
            return postal_code;
        }

        public void setPostal_code(String postal_code) {
            this.postal_code = postal_code;
        }

        public String getLandmark() {
            return landmark;
        }

        public void setLandmark(String landmark) {
            this.landmark = landmark;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCountry_text() {
            return country_text;
        }

        public void setCountry_text(String country_text) {
            this.country_text = country_text;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPan_card() {
            return pan_card;
        }

        public void setPan_card(String pan_card) {
            this.pan_card = pan_card;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getStep() {
            return step;
        }

        public void setStep(String step) {
            this.step = step;
        }

        public String getNominee() {
            return nominee;
        }

        public void setNominee(String nominee) {
            this.nominee = nominee;
        }

        public Object getDate_of_birth() {
            return date_of_birth;
        }

        public void setDate_of_birth(Object date_of_birth) {
            this.date_of_birth = date_of_birth;
        }

        public Object getInvoice_footer() {
            return invoice_footer;
        }

        public void setInvoice_footer(Object invoice_footer) {
            this.invoice_footer = invoice_footer;
        }

        public Object getPayment_term() {
            return payment_term;
        }

        public void setPayment_term(Object payment_term) {
            this.payment_term = payment_term;
        }

        public Object getLogo() {
            return logo;
        }

        public void setLogo(Object logo) {
            this.logo = logo;
        }

        public Object getAward_points() {
            return award_points;
        }

        public void setAward_points(Object award_points) {
            this.award_points = award_points;
        }

        public Object getDeposit_amount() {
            return deposit_amount;
        }

        public void setDeposit_amount(Object deposit_amount) {
            this.deposit_amount = deposit_amount;
        }

        public String getPrice_group_id() {
            return price_group_id;
        }

        public void setPrice_group_id(String price_group_id) {
            this.price_group_id = price_group_id;
        }

        public String getPrice_group_name() {
            return price_group_name;
        }

        public void setPrice_group_name(String price_group_name) {
            this.price_group_name = price_group_name;
        }

        public Object getGst_no() {
            return gst_no;
        }

        public void setGst_no(Object gst_no) {
            this.gst_no = gst_no;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getCustomer_sponser_id() {
            return customer_sponser_id;
        }

        public void setCustomer_sponser_id(String customer_sponser_id) {
            this.customer_sponser_id = customer_sponser_id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getDirect_sponser_id() {
            return direct_sponser_id;
        }

        public void setDirect_sponser_id(String direct_sponser_id) {
            this.direct_sponser_id = direct_sponser_id;
        }

        public String getDirect_sponser_username() {
            return direct_sponser_username;
        }

        public void setDirect_sponser_username(String direct_sponser_username) {
            this.direct_sponser_username = direct_sponser_username;
        }

        public Object getDirect_sponser_name() {
            return direct_sponser_name;
        }

        public void setDirect_sponser_name(Object direct_sponser_name) {
            this.direct_sponser_name = direct_sponser_name;
        }

        public String getSponser_id() {
            return sponser_id;
        }

        public void setSponser_id(String sponser_id) {
            this.sponser_id = sponser_id;
        }

        public String getSponser_username() {
            return sponser_username;
        }

        public void setSponser_username(String sponser_username) {
            this.sponser_username = sponser_username;
        }

        public Object getSponser_name() {
            return sponser_name;
        }

        public void setSponser_name(Object sponser_name) {
            this.sponser_name = sponser_name;
        }

        public String getBlock() {
            return block;
        }

        public void setBlock(String block) {
            this.block = block;
        }

        public String getActive_type() {
            return active_type;
        }

        public void setActive_type(String active_type) {
            this.active_type = active_type;
        }

        public String getPackage_id() {
            return package_id;
        }

        public void setPackage_id(String package_id) {
            this.package_id = package_id;
        }

        public Object getPackage_name() {
            return package_name;
        }

        public void setPackage_name(Object package_name) {
            this.package_name = package_name;
        }

        public String getPackage_amt() {
            return package_amt;
        }

        public void setPackage_amt(String package_amt) {
            this.package_amt = package_amt;
        }

        public String getPackage_roi() {
            return package_roi;
        }

        public void setPackage_roi(String package_roi) {
            this.package_roi = package_roi;
        }

        public String getSales_active() {
            return sales_active;
        }

        public void setSales_active(String sales_active) {
            this.sales_active = sales_active;
        }

        public String getSales_active_date() {
            return sales_active_date;
        }

        public void setSales_active_date(String sales_active_date) {
            this.sales_active_date = sales_active_date;
        }

        public MemberSaleBean getMember_sale() {
            return member_sale;
        }

        public void setMember_sale(MemberSaleBean member_sale) {
            this.member_sale = member_sale;
        }

        public String getP_sender_id() {
            return p_sender_id;
        }

        public void setP_sender_id(String p_sender_id) {
            this.p_sender_id = p_sender_id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public static class MemberSaleBean {
            /**
             * member : {"left":5066,"right":1809,"direct":62}
             * active_member : {"left":2005,"right":211,"direct":44}
             * non_active_member : {"left":3061,"right":1598,"direct":18}
             * direct_member : {"left":29,"right":33,"direct":62}
             * sale : {"left":7.149374612E7,"right":18258181,"direct":10964626}
             * bv : {"left":55256144,"right":11442574,"self":"134300"}
             * gold : {"left":4.072279312E7,"right":16434493,"direct":10342000}
             * package : {"left":30997203,"right":1709688,"direct":622626}
             */

            private MemberBean member;
            private ActiveMemberBean active_member;
            private NonActiveMemberBean non_active_member;
            private DirectMemberBean direct_member;
            private SaleBean sale;
            private BvBean bv;
            private GoldBean gold;
            @SerializedName("package")
            private PackageBean packageX;

            public MemberBean getMember() {
                return member;
            }

            public void setMember(MemberBean member) {
                this.member = member;
            }

            public ActiveMemberBean getActive_member() {
                return active_member;
            }

            public void setActive_member(ActiveMemberBean active_member) {
                this.active_member = active_member;
            }

            public NonActiveMemberBean getNon_active_member() {
                return non_active_member;
            }

            public void setNon_active_member(NonActiveMemberBean non_active_member) {
                this.non_active_member = non_active_member;
            }

            public DirectMemberBean getDirect_member() {
                return direct_member;
            }

            public void setDirect_member(DirectMemberBean direct_member) {
                this.direct_member = direct_member;
            }

            public SaleBean getSale() {
                return sale;
            }

            public void setSale(SaleBean sale) {
                this.sale = sale;
            }

            public BvBean getBv() {
                return bv;
            }

            public void setBv(BvBean bv) {
                this.bv = bv;
            }

            public GoldBean getGold() {
                return gold;
            }

            public void setGold(GoldBean gold) {
                this.gold = gold;
            }

            public PackageBean getPackageX() {
                return packageX;
            }

            public void setPackageX(PackageBean packageX) {
                this.packageX = packageX;
            }

            public static class MemberBean {
                /**
                 * left : 5066
                 * right : 1809
                 * direct : 62
                 */

                private int left;
                private int right;
                private int direct;

                public int getLeft() {
                    return left;
                }

                public void setLeft(int left) {
                    this.left = left;
                }

                public int getRight() {
                    return right;
                }

                public void setRight(int right) {
                    this.right = right;
                }

                public int getDirect() {
                    return direct;
                }

                public void setDirect(int direct) {
                    this.direct = direct;
                }
            }

            public static class ActiveMemberBean {
                /**
                 * left : 2005
                 * right : 211
                 * direct : 44
                 */

                private int left;
                private int right;
                private int direct;

                public int getLeft() {
                    return left;
                }

                public void setLeft(int left) {
                    this.left = left;
                }

                public int getRight() {
                    return right;
                }

                public void setRight(int right) {
                    this.right = right;
                }

                public int getDirect() {
                    return direct;
                }

                public void setDirect(int direct) {
                    this.direct = direct;
                }
            }

            public static class NonActiveMemberBean {
                /**
                 * left : 3061
                 * right : 1598
                 * direct : 18
                 */

                private int left;
                private int right;
                private int direct;

                public int getLeft() {
                    return left;
                }

                public void setLeft(int left) {
                    this.left = left;
                }

                public int getRight() {
                    return right;
                }

                public void setRight(int right) {
                    this.right = right;
                }

                public int getDirect() {
                    return direct;
                }

                public void setDirect(int direct) {
                    this.direct = direct;
                }
            }

            public static class DirectMemberBean {
                /**
                 * left : 29
                 * right : 33
                 * direct : 62
                 */

                private int left;
                private int right;
                private int direct;

                public int getLeft() {
                    return left;
                }

                public void setLeft(int left) {
                    this.left = left;
                }

                public int getRight() {
                    return right;
                }

                public void setRight(int right) {
                    this.right = right;
                }

                public int getDirect() {
                    return direct;
                }

                public void setDirect(int direct) {
                    this.direct = direct;
                }
            }

            public static class SaleBean {
                /**
                 * left : 7.149374612E7
                 * right : 18258181
                 * direct : 10964626
                 */

                private double left;
                private int right;
                private int direct;

                public double getLeft() {
                    return left;
                }

                public void setLeft(double left) {
                    this.left = left;
                }

                public int getRight() {
                    return right;
                }

                public void setRight(int right) {
                    this.right = right;
                }

                public int getDirect() {
                    return direct;
                }

                public void setDirect(int direct) {
                    this.direct = direct;
                }
            }

            public static class BvBean {
                /**
                 * left : 55256144
                 * right : 11442574
                 * self : 134300
                 */

                private int left;
                private int right;
                private String self;

                public int getLeft() {
                    return left;
                }

                public void setLeft(int left) {
                    this.left = left;
                }

                public int getRight() {
                    return right;
                }

                public void setRight(int right) {
                    this.right = right;
                }

                public String getSelf() {
                    return self;
                }

                public void setSelf(String self) {
                    this.self = self;
                }
            }

            public static class GoldBean {
                /**
                 * left : 4.072279312E7
                 * right : 16434493
                 * direct : 10342000
                 */

                private double left;
                private int right;
                private int direct;

                public double getLeft() {
                    return left;
                }

                public void setLeft(double left) {
                    this.left = left;
                }

                public int getRight() {
                    return right;
                }

                public void setRight(int right) {
                    this.right = right;
                }

                public int getDirect() {
                    return direct;
                }

                public void setDirect(int direct) {
                    this.direct = direct;
                }
            }

            public static class PackageBean {
                /**
                 * left : 30997203
                 * right : 1709688
                 * direct : 622626
                 */

                private int left;
                private int right;
                private int direct;

                public int getLeft() {
                    return left;
                }

                public void setLeft(int left) {
                    this.left = left;
                }

                public int getRight() {
                    return right;
                }

                public void setRight(int right) {
                    this.right = right;
                }

                public int getDirect() {
                    return direct;
                }

                public void setDirect(int direct) {
                    this.direct = direct;
                }
            }
        }
    }

    public static class UsersBean {
        /**
         * avatar : bf5a7ce0ad5aa5876f3d5c89cbc88dca.jpg
         * company_id : 3
         */

        private String avatar;
        private String company_id;

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getCompany_id() {
            return company_id;
        }

        public void setCompany_id(String company_id) {
            this.company_id = company_id;
        }
    }

    public static class WalletTopupBean {
        /**
         * id : 118
         * date : 2019-07-15
         * company_id : 3
         * payout_id : 0
         * debit : 0.0000
         * credit : 1000.0000
         * balance : 1000.0000
         * note : owner has added fund
         * created_by : 1
         * created_at : 2019-07-15 15:29:54
         */

        private String id;
        private String date;
        private String company_id;
        private String payout_id;
        private String debit;
        private String credit;
        private String balance;
        private String note;
        private String created_by;
        private String created_at;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getCompany_id() {
            return company_id;
        }

        public void setCompany_id(String company_id) {
            this.company_id = company_id;
        }

        public String getPayout_id() {
            return payout_id;
        }

        public void setPayout_id(String payout_id) {
            this.payout_id = payout_id;
        }

        public String getDebit() {
            return debit;
        }

        public void setDebit(String debit) {
            this.debit = debit;
        }

        public String getCredit() {
            return credit;
        }

        public void setCredit(String credit) {
            this.credit = credit;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public String getCreated_by() {
            return created_by;
        }

        public void setCreated_by(String created_by) {
            this.created_by = created_by;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }
    }

    public static class WalletPayoutBean {
        /**
         * id : 4363
         * date : 2019-05-19
         * payout_id : null
         * company_id : 3
         * debit : 1000.0000
         * credit : 0.0000
         * balance : 25798.5748
         * note : Withdraw to Bank
         * created_by : 2
         * created_at : 2019-05-19 13:18:38
         */

        private String id;
        private String date;
        private Object payout_id;
        private String company_id;
        private String debit;
        private String credit;
        private String balance;
        private String note;
        private String created_by;
        private String created_at;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Object getPayout_id() {
            return payout_id;
        }

        public void setPayout_id(Object payout_id) {
            this.payout_id = payout_id;
        }

        public String getCompany_id() {
            return company_id;
        }

        public void setCompany_id(String company_id) {
            this.company_id = company_id;
        }

        public String getDebit() {
            return debit;
        }

        public void setDebit(String debit) {
            this.debit = debit;
        }

        public String getCredit() {
            return credit;
        }

        public void setCredit(String credit) {
            this.credit = credit;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public String getCreated_by() {
            return created_by;
        }

        public void setCreated_by(String created_by) {
            this.created_by = created_by;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }
    }
}