package com.assignment.javaAdvance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class Assignment {

        public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException
        {
//            Generating Random Numbers and File IO
            FileOutputStream output = null;
            FileInputStream input = null;
            Random rand = new Random();
            try {
                output = new FileOutputStream("outputFile.txt");
                int random = rand.nextInt(100);
                while(random % 5 != 0 && random !=0) {
                    output.write(random);
                    random = rand.nextInt(100);
                }
                output.write(random);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            output.close();

            ArrayList<Integer> outputlist = new ArrayList<Integer>();
            try {
                input = new FileInputStream("outputFile.txt");
                int number;
                while ((number = input.read()) != -1) {
                    outputlist.add(number);
                }
                System.out.println(outputlist);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            input.close();


//            Stream Operation
            Integer res = outputlist.stream().filter(e-> e%5 == 0).map(e-> e*2).reduce(1,(a,b)->{return a*b;});
            System.out.println(res);

//            JDBC Connection
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://remotemysql.com:3306/sMkXvyYxZM";
            String username = "sMkXvyYxZM";
            String	passowrd = "8h9tWhCKws";

//            String username = "E2d8zFqppb";
//            String passowrd = "Ot8EQ9sTAk";

            Connection connection = DriverManager.getConnection(url, username, passowrd);
            String sql = "insert into test values (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, res);
            preparedStatement.setString(2,"Gaurang");
            preparedStatement.execute();

            ResultSet result = preparedStatement.executeQuery("select * from test");
            System.out.println("Id" + "\t" + "Name" );
            while(result.next()) {
                String id = result.getString("id");
                String name = result.getString("name");
                System.out.println(id + "\t" + name);
            }
        }
    }
