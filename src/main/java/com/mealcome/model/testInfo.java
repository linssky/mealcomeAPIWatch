package com.mealcome.model;

/**
 * Created by wuchaolin on 2019/8/8.
 */
public class testInfo {
    public static final String headers="Content-Type: application/json;charset=UTF-8,sessionId: ${sessionId}";
    public static final String header="Content-Type: application/json;charset=UTF-8,sessionId: f22e51249259412584979eaeeee70ef5";
    public static final String url="http://test.mealcome.cn/professional/buyerapi/order/mq/createpurchaseorder";
    public static final String postData="{\"supplierId\":6221937,\"branchId\":6089913,\"deliveryTime\":\"${date} 23:59:59\",\"params\":[{\"materialId\":9228923,\"materialName\":\"冬瓜\",\"materialFullName\":\"冬瓜\",\"spec\":\"\",\"purchaseUnitId\":42,\"purchaseUnitName\":\"斤\",\"receiptUnitId\":42,\"receiptUnitName\":\"斤\",\"purchaseToReceiptUnitRate\":1,\"equal\":1,\"recommendationValue\":1,\"supplierMaterialId\":0,\"price\":0,\"iconPath\":\"http://120.55.195.152:8080/canzhi/api/image/p/d188ee3f5a58553b65485d887f9549bd\",\"classId\":6724058,\"referenceStockQuantity\":0,\"branchExists\":\"\",\"quantity\":\"\",\"note\":\"\",\"departmentId\":\"\",\"departmentName\":\"\",\"departmentList\":[{\"departmentId\":6211217,\"departmentName\":\"仓库\",\"purchaseUnitQuantity\":1,\"_userInputQuantity\":1}],\"status\":1,\"className\":\"\",\"_userInputQuantity\":1,\"_userInputStock\":0,\"_userNote\":\"\"}]}";


    public static final String PurchaseAPPurl="http://test.mealcome.cn/professional/buyerapi/user/login";
    public static final String PurchaseAPPPostData="{\"version\":\"1.3.-2\",\"code\":\"18676967636\",\"password\":\"1\"}";

    public static final String BossAPPurl="http://test.mealcome.cn/meallinkapi/boss/user/login";
    public static final String BossAPPPostData="{\"code\":\"18676967636\",\"password\":\"1\"}";


    public static final String WXheader="Content-Type: application/json";
    public static final String WXurl="https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=5d3c0d81-a687-44f1-9584-f4e4ba7a7e2b";
    public static final String WXpostData="{\n" +
            "            \"msgtype\": \"text\",\n" +
            "            \"text\": {\n" +
            "        \"content\": \"${content}\",\n" +
            "        \"mentioned_mobile_list\":[\"${@phone}\"]\n" +
            "    }\n" +
            "}";
//    public static final String WXpostData="{\n" +
//        "            \"msgtype\": \"markdown\",\n" +
//        "            \"markdown\": {\n" +
//        "        \"content\": \"${content}\" }";
}
