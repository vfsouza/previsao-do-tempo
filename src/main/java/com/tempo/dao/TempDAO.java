package com.tempo.dao;

import com.tempo.factory.ConnectionFactory;
import com.tempo.model.LocalTemp;

import java.sql.*;
import java.text.ParseException;

public class TempDAO {
    private static final Connection con = ConnectionFactory.conectar();

    public static void insert(LocalTemp lt) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO temperature (city, temperature) VALUES ('"
                    + lt.getCity() + "', " + lt.getTemperature() + ");");
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static LocalTemp readByString(String str) {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM temperature WHERE city = '" + str + "'");
            rs.beforeFirst();
            if (rs.next()) {
                return new LocalTemp(rs.getString("city"), rs.getDouble("temperature"));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }
}
