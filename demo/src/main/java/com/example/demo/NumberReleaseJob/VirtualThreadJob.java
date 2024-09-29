/*
package com.example.demo.java_job;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadJob {

    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1522/nicuatsrv.nprodvmsubnet.dapnprodvcn.oraclevcn.com";
    private static final String DB_USER = "CCBS2";
    private static final String DB_PASSWORD = "ccbs2";

    public static void main(String[] args) throws Exception {
        new VirtualThreadJob().processPhoneNumbers();
    }

    public void processPhoneNumbers() throws Exception {
        // Open a database connection
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {

            // Fetch phone numbers in batches of 500
            String selectQuery = "SELECT PHONE_NO FROM PHONE_NO_REGISTER WHERE BLOCKED_STATUS IN ('B', 'U') AND CONNECTION_TYPE = 'V' AND LENGTH(PHONE_NO) = 9 \n" +
                    "AND PHONE_NO LIKE '7%' FETCH FIRST 10 ROWS ONLY";
            try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = selectStatement.executeQuery()) {

                List<String> phoneNumbers = new ArrayList<>();

                while (resultSet.next()) {
                    phoneNumbers.add(resultSet.getString("PHONE_NO"));
                }

                // Process each phone number using virtual threads
                try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
                    phoneNumbers.forEach(phoneNumber -> executor.submit(() -> updatePhoneNumber(phoneNumber, connection)));
                }

                // Commit updates after processing the batch
                System.out.println(phoneNumbers);
                // connection.commit();
            }
        }
    }

    private void updatePhoneNumber(String phoneNumber, Connection connection) {
        String updateQuery = "UPDATE PHONE_NO_REGISTER SET BLOCKED_STATUS = NULL, STATUS = 'N' WHERE PHONE_NO = ?";
        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
            updateStatement.setString(1, phoneNumber);
            updateStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/
