package com.mealcome.Until;

import com.mealcome.model.APITestResultInfo;

import java.sql.*;
import java.util.List;

/**
 * Created by wuchaolin on 2019/5/14.
 * sql方法
 */
public class dbUntil {
    private static final String DBPATH = "APIMonitorTest";

    //创建APITestResult表
    String APITestResult = "CREATE TABLE IF NOT EXISTS APITestResult (" +
            "id integer primary key autoincrement NOT NULL," +
            "testCode integer, " +
            "testContent varchar(100), " +
            "testEnd varchar(20), " +
            "testStartTime varchar(50), " +
            "url varchar(150), " +
            "requestYype varchar(10), " +
            "requestData varchar(500), " +
            "requestTime integer, " +
            "responseTime integer, " +
            "responseCode integer, " +
            "responseData varchar(1000), " +
            "testResult varchar(100), " +
            "note varchar(100) " +
            ");";


    /**
     * 连接数据库
     * @return 连接成功返回Connection，否则置为null
     */
    private Connection connectionSQLite(){
        try {
            String dbFilePath = String.format("jdbc:sqlite:%s.db", DBPATH);
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(dbFilePath);
            connection.setAutoCommit(false);
            return connection;
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return null;
        }
    }

    /**
     * 创建数据库表
     */
    public void createTable(){
        try {
            Connection connection = this.connectionSQLite();
            Statement statement = connection.createStatement();
            statement.execute(APITestResult);//创建APITestResult表
            statement.close();
            connection.commit();
            connection.close();
        } catch (Exception e) {
            //System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            e.printStackTrace();
        }
    }

    /**
     * 向APITestResult表写入数据
     * @param apiTestResultInfos 结果信息集合
     * @return 写入成功返回True
     */
    public boolean insertTableAPIResult(List<APITestResultInfo> apiTestResultInfos){
        Connection connection = this.connectionSQLite();
        return this.insertTableAPIResult(apiTestResultInfos, connection);
    }

    private boolean insertTableAPIResult(List<APITestResultInfo> apiTestResultInfos, Connection connection){
        boolean isInsert = false;
        String insertResultSQL = "INSERT INTO APITestResult VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement taskStatement = null;
        try {
            taskStatement = connection.prepareStatement(insertResultSQL);
            // 插入占位符变量
            for (APITestResultInfo apiTestResultInfo : apiTestResultInfos){
                taskStatement.setInt(1, apiTestResultInfo.getTestCode());
                taskStatement.setString(2, apiTestResultInfo.getTestContent());
                taskStatement.setString(3, apiTestResultInfo.getTestEnd());
                taskStatement.setString(4, apiTestResultInfo.getTestStartTime());
                taskStatement.setString(5, apiTestResultInfo.getUrl());
                taskStatement.setString(6, apiTestResultInfo.getRequestYype());
                taskStatement.setString(7, apiTestResultInfo.getRequestData());
                taskStatement.setInt(8, (int) apiTestResultInfo.getRequestTime());
                taskStatement.setInt(9, (int) apiTestResultInfo.getResponseTime());
                taskStatement.setInt(10, apiTestResultInfo.getResponseCode());
                taskStatement.setString(11, apiTestResultInfo.getResponseData());
                taskStatement.setString(12, apiTestResultInfo.getTestResult());
                taskStatement.setString(13, apiTestResultInfo.getNote());
                taskStatement.addBatch();
            }
            taskStatement.executeBatch();
            isInsert =  true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.closeSQLConnection(connection, taskStatement);
        }
        return isInsert;
    }


    /**
     * 关闭数据库连接
     * @param connection
     * @param preparedStatement
     */
    private void closeSQLConnection(Connection connection, PreparedStatement preparedStatement){
        try {
            if(null != preparedStatement){
                preparedStatement.close();
            }
            if(null != connection){
                connection.commit();
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closeSQLConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        this.closeSQLConnection(connection, preparedStatement);
        try {
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
