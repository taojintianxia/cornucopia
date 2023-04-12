package com.github.taojintianxia.cornucopia.gists.shardingsphere.sharding.date.pg;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DateShardingSQLGenerator {
    
    private static final String SQL1 = "create table ls_nb_histraninfo(  zh varchar(40),  hm varchar(300),  jyrq varchar(8),  jqsj varchar(30),  bzh varchar(9),  jdbz varchar(3),  ye decimal(20,2),  fse decimal(20,2),  dfzh varchar(40),  dfzhhm varchar(300),  dfzhjgmch varchar(150),  zym varchar(15),  jyjc varchar(300),  beiz varchar(300),  jgm varchar(15),  czy varchar(15),  qqfxtls varchar(80),  pzzl varchar(15),  pzh varchar(30),  jyh varchar(15),  jym varchar(15),  jyzt varchar(9),  sqczy varchar(15),  yjyrzh varchar(30),  rzh varchar(30),  rzxh varchar(20),  cpdm varchar(20),  khh varchar(30),  jffse decimal(20,2),  dffse decimal(20,2),  chhbz varchar(9),  zjhm varchar(80),  fy varchar(520),  kh varchar(40),  dfkh varchar(40),  fhy varchar(30),  jymzwmc varchar(200),  channel_no varchar(20),  xzbz varchar(10),  channel_ch varchar(120),  rksj varchar(30),  xh varchar(15),  zyjc varchar(60),  mxbc varchar(20),  zhzt varchar(15),  zhlb varchar(9),  sxrq varchar(8),  khrq varchar(8),  bxje varchar(30),  dkje varchar(30),  fhzye varchar(30),  khje varchar(30),  dlhzh varchar(10),  kmkzz varchar(30),  qxm varchar(9),  mz varchar(30),  fllsh varchar(70),  zhxz varchar(10),  kmh varchar(20),  hsjgh varchar(20),  xtbs varchar(20),  gzbh varchar(40),  gxzxh varchar(20),  czbs varchar(9),  sgrzbs varchar(9),  note1 varchar(50),  note2 varchar(100),  note3 varchar(150),  dfzhjgh varchar(20));";
    
    private static final String SQL2 = "create table t_ls_sdlsinfo( log_no varchar(22) not null, ac_dt varchar(8), txn_typ varchar(2), txn_cd varchar(50), corg_no varchar(12), rtr_svr varchar(16), rtr_cod varchar(50), txn_tm varchar(14), corg_txn_tm varchar(14), tlog_no varchar(80), ttxn_sts varchar(2), thd_chk_flg varchar(1), chk_fil_dt varchar(8), chk_bat_no varchar(19), txn_sts varchar(2), crd_no varchar(128), txn_amt decimal(13,2), ref_amt decimal(13,2), corg_fee_amt decimal(13,2), merc_fee_amt decimal(13,2), org_no varchar(10), merc_id varchar(15), corg_merc_id varchar(32), trm_no varchar(20), ctxn_dt varchar(8), ctxn_tm varchar(6), cseq_no varchar(32), corg_cseq_no varchar(32), rcorg_cseq_no varchar(32), olog_no varchar(18), merc_nm varchar(135), txn_rsv1 varchar(20), txn_cnl varchar(18), pay_cnl varchar(18), sub_code varchar(120), sub_msg varchar(255), tm_smp varchar(26), notify_url varchar(128), nod_id varchar(40), chk_flg varchar(2), currency varchar(16), mbl_no varchar(13), valid_unit varchar(2), valid_num decimal(5), product_id varchar(50), product_nm varchar(384), product_desc varchar(1536), posp_prd_no varchar(8), posp_scn_no varchar(10), ord_typ varchar(2), bus_cnl varchar(5), sys_cnl varchar(5), pay_typ varchar(4), profit_flag varchar(2), discount_amt decimal(13,2), openid varchar(128), bank_type varchar(24), buyer_user_id varchar(28), buyer_logon_id varchar(100), buyer_user_type varchar(18), agt_merc_id varchar(15), acc_no varchar(19), hld_no varchar(20), acc_nm varchar(60), id_typ varchar(5), id_no varchar(32), sms_key varchar(32), settlmt_dt varchar(8), remarks varchar(255), discount_flag varchar(1), discount_info varchar(768), discount_count decimal(2), is_discount varchar(2), crd_flg varchar(3), crd_exp_dt varchar(4), in_mod varchar(3), aut_cd varchar(6), cps_cd varchar(2), acq_no varchar(11), for_cod varchar(11), emv_flg varchar(1), emv_dat varchar(510), emv_dat_len varchar(3), pro_cod varchar(6), mcc_cd varchar(4), pos_cnd varchar(2), rsv_dat varchar(200), oran_dat varchar(200), cps_rsv varchar(100), sep_num varchar(3), bat_no varchar(16), addr_x varchar(20), addr_y varchar(20), gmt_create varchar(19), gmt_modified varchar(19), is_bond varchar(1), none_settle_amt decimal(18,2), divide_mod varchar(2), divide_inf varchar(1000), divide_result varchar(1000), score_flag varchar(1), score_info varchar(512), back_params varchar(32), merc_discount_amt decimal(13,2));";
    
    private static final String SQL3 = "create table ls_histraninfo_v2( jzzh varchar(40), zh varchar(40), hm varchar(300), jyrq varchar(15), jqsj varchar(30), bzh varchar(6), jdbz varchar(3), ye decimal(20,2), fse decimal(20,2), dfzh varchar(40), dfzhhm varchar(300), dfzhjgmch varchar(150), dfzhtemp varchar(40), zym varchar(12), jyjc varchar(300), beiz varchar(300), jgm varchar(15), czy varchar(12), qqfxtls varchar(60), pzzl varchar(6), pzh varchar(30), jyh varchar(12), jym varchar(12), jyzt varchar(3), sqczy1 varchar(12), sqczy2 varchar(12), yjyrzh varchar(30), rzh varchar(30), rzxh varchar(20), cpdm varchar(20), khh varchar(30), jffse decimal(20,2), dffse decimal(20,2), chhbz varchar(3), zjlx varchar(10), zjhm varchar(90), fy varchar(520), kh varchar(40), dfkh varchar(40), fhy varchar(12), jymzwmc varchar(200), channel_no varchar(20), xzbz varchar(15), channel_ch varchar(150), rksj varchar(30), xh varchar(15), zyjc varchar(60), mxbc varchar(30), zhzt varchar(15), zhlb varchar(3), sxrq varchar(15), khrq varchar(15), bxje varchar(30), dkje varchar(30), fhzye varchar(30), khje varchar(30), dlhzh varchar(6), kmkzz varchar(30), qxm varchar(9), mz varchar(30), fllsh varchar(70), zhxz varchar(10), cph varchar(20), jybm varchar(9), fqfxtlsh varchar(40), qqfxt varchar(15), yyf varchar(9), zhcp varchar(20), hylx varchar(10), ywbh varchar(40), bfgzh varchar(20), dshh varchar(20), dsywbh varchar(40), dshb varchar(9), dxbz varchar(9), bfjjylx varchar(9), jysxr varchar(8), sumup_flg varchar(6), print_flg varchar(6), zsbz varchar(6), jyczrq varchar(10), yjykjrq varchar(10), jyhmc varchar(300), note1 varchar(50), note2 varchar(100), note3 varchar(150), ip varchar(200), mac varchar(200), sbh varchar(200), imei varchar(200), jylsh varchar(100), jylx varchar(20), shmc varchar(100), jydz varchar(300), ms varchar(30));";
    
    private static String DS_TEMPLATE_1 = "  ds_${YEAR}:\n" +
            "    url: jdbc:postgresql://20.0.36.116:${PORT}/${DS}\n" +
            "    username: hdqpsharding\n" +
            "    password: abc@123456\n";
    
    private static String DS_TEMPLATE_2 = "  ds_${YEAR}:\n" +
            "    url: jdbc:postgresql://20.0.36.117:${PORT}/${DS}\n" +
            "    username: hdqpsharding\n" +
            "    password: abc@123456\n";
    
    private static final List<String> portList = Arrays.asList("27000", "28000", "29000", "30000");
    
    public static void main(String ... args) throws Exception {
        generateDatabaseOnMultiplePG();
    }
    
    
    private static void generateDatasource() {
        StringBuilder datasourceBuilder = new StringBuilder();
        for (int year = 1999, count = portList.size(); year <= 2027; year++, count++) {
            String port = portList.get(count % portList.size());
            String dsTemplate = DS_TEMPLATE_1;
            if (port.equals("29000") || port.equals("30000")) {
                dsTemplate = DS_TEMPLATE_2;
            }
            datasourceBuilder.append(dsTemplate.replace("${YEAR}", year + "").replace("${PORT}", port).replace("${DS}", "ds_" + year));
        }
        String result = datasourceBuilder.toString();
        System.out.println(result);
    }
    
    private static void generateDatabaseOnMultiplePG() throws IOException {
        List<String> pgList = Arrays.asList("27000", "28000", "29000", "30000");
        FileWriter writer = new FileWriter("create_table.sql");
        for (int i = 0; i < pgList.size(); i++) {
            writer.write("\n-- For " + pgList.get(i) + "\n");
            for (int year = 1999; year <= 2027; year++) {
                if (year % pgList.size() == (i + 3) % pgList.size()) {
                    writer.write("-- For database ds_" + year + "\n");
                    writer.write("\\c ds_" + year + " \n");
                    for (int month = 1; month <= 12; month++) {
                        String modifiedMonth = month < 10 ? "0" + month : month + "";
                        writer.write(SQL1.replace("ls_nb_histraninfo", "ls_nb_histraninfo_" + year + modifiedMonth) + "\n");
                        writer.write(SQL2.replace("t_ls_sdlsinfo", "t_ls_sdlsinfo_" + year + modifiedMonth) + "\n");
                        writer.write(SQL3.replace("ls_histraninfo_v2", "ls_histraninfo_v2_" + year + modifiedMonth) + "\n");
                        writer.flush();
                    }
                }
            }
        }
    }
    
    public static String formatSql(String sql) {
        return sql.replaceAll("\\s{2,}", " ");
    }
}
