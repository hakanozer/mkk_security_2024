package com.works.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Service
@RequiredArgsConstructor
public class AdminService {

    final DB db;

    public boolean login(String username, String password) {
        try {
            String sql = "select * from admin where email = ? and password = ?";
            PreparedStatement pre = db.dataSource().getConnection().prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            return rs.next();
        }catch (Exception ex) {
            System.err.println("login error" + ex);
        }
        return false;
    }

}
