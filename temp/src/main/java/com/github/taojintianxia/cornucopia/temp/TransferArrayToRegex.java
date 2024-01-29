package com.github.taojintianxia.cornucopia.temp;

public class TransferArrayToRegex {
    
    public static String[] RULES = new String[]{
            "汉族",
            "柯尔克孜族",
            "蒙古族",
            "土族",
            "回族",
            "达斡尔族",
            "藏族",
            "仫佬族",
            "维吾尔族",
            "羌族",
            "苗族",
            "布朗族",
            "彝族",
            "撒拉族",
            "壮族",
            "毛南族",
            "布依族",
            "仡佬族",
            "朝鲜族",
            "锡伯族",
            "满族",
            "阿昌族",
            "侗族",
            "普米族",
            "瑶族",
            "塔吉克族",
            "白族",
            "怒族",
            "土家族",
            "乌孜别克族",
            "哈尼族",
            "俄罗斯族",
            "哈萨克族",
            "鄂温克族",
            "傣族",
            "德昂族",
            "黎族",
            "保安族",
            "傈僳族",
            "裕固族",
            "佤族",
            "京族",
            "畲族",
            "塔塔尔族",
            "高山族",
            "独龙族",
            "拉祜族",
            "鄂伦春族",
            "水族",
            "赫哲族",
            "东乡族",
            "门巴族",
            "纳西族",
            "珞巴族",
            "景颇族",
            "基诺族"
    };
    
    public static void main(String... args) {
        StringBuilder stringBuilder = new StringBuilder("^(");
        for (int i = 0; i < RULES.length; i++) {
            stringBuilder.append(RULES[i]);
            if (i != RULES.length - 1) {
                stringBuilder.append("|");
            }
        }
        stringBuilder.append(")$");
        String regex = stringBuilder.toString();
        System.out.println(regex);
    }
}
