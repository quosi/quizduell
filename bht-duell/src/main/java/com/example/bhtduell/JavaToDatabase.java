package com.example.bhtduell;

import java.sql.*; //Any source file that uses JDBC needs to import the java.sql package
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JavaToDatabase {
    // function that returns data to establish connection to postgres DB
    public static Vector connectData() {
        // database connection
        // with postgres user and password
        // return Vector with 0:url, 1:user, 2:password
        Vector data = new Vector<>();
        String url = "jdbc:postgresql://localhost:5432/postgres"; // follow schema: jdbc:postgresql://host:port/database
        String user = "postgres";
        String pwd = "BHT2023";

        data.add(url);
        data.add(user);
        data.add(pwd);
        return data;

    }

    public static void writePlayerToDB(String username_1, String username_2) {

        // set up for db
        /*String url = "jdbc:postgresql://localhost:5432/postgres"; // follow schema: jdbc:postgresql://host:port/database
        String user = "postgres";
        String pwd = "BHT2023";*/
        Vector DBConnectData = connectData();
        String url = (String) DBConnectData.get(0);
        String user = (String) DBConnectData.get(1);
        String pwd = (String) DBConnectData.get(2);

        String playername_1 = username_1;
        String playername_2 = username_2;

        // the query
        String query = "INSERT INTO game.\"Player\" (player_username) VALUES (?)";


        try (Connection connection = DriverManager.getConnection(url, user, pwd);
             PreparedStatement prepared = connection.prepareStatement(query)) {
            // for player1
            prepared.setString(1, playername_1);
            prepared.executeUpdate();

            // for player2
            prepared.setString(1, playername_2);
            prepared.executeUpdate();
            System.out.println("Action was successful!");


        } catch (SQLException except) {
            Logger logger = Logger.getLogger(JavaToDatabase.class.getName());
            logger.log(Level.SEVERE, except.getMessage(), except);
        }
    }

    public static Vector getQuestion(int question_counter) {

        // db connection
        /*String url = "jdbc:postgresql://localhost:5432/postgres"; // follow schema: jdbc:postgresql://host:port/database
        String user = "postgres";
        String pwd = "BHT2023";*/
        Vector DBConnectData = connectData();
        String url = (String) DBConnectData.get(0);
        String user = (String) DBConnectData.get(1);
        String pwd = (String) DBConnectData.get(2);

        String query_question = "SELECT \"qu_ID\", \"qu_text\" FROM game.\"Questions\"\n" +
                "WHERE \"qu_ID\"=?;";
        System.out.println(query_question);
        try (Connection connection = DriverManager.getConnection(url, user, pwd);
             // Get question from DB
             PreparedStatement prepared = connection.prepareStatement(query_question)) {
            // get question and answer text from db
            // question_counter is in this case also id of question in database
            prepared.setInt(1, question_counter); // one is the question mark in query
            ResultSet rs = prepared.executeQuery();

            // Vector class implements a growable array of objects
            // we use it to add results from ResultSet to it => the results from db query
            // because ResultSet is difficult to access after
            // Vector for question
            Vector questionVector = new Vector();

            while (rs.next()) {
                System.out.print("Column 1 returned ");
                System.out.println(rs.getString("qu_text"));
                // add column w question text to vector
                questionVector.addElement(new String(rs.getString(1)));
                questionVector.addElement(new String(rs.getString(2)));

            }

            rs.close();
            prepared.close();


            return questionVector;


        } catch (SQLException except) {
            Logger logger = Logger.getLogger(JavaToDatabase.class.getName());
            logger.log(Level.SEVERE, except.getMessage(), except);
            return null;
        }
    }
    public static Vector getAnswers ( int qu_counter){
        Vector DBConnectData = connectData();
        String url = (String) DBConnectData.get(0);
        String user = (String) DBConnectData.get(1);
        String pwd = (String) DBConnectData.get(2);
        // get answers from DB
        String query_answer = "SELECT \"asw_text\" FROM game.\"Answers\"\n" +
                "WHERE \"asw_qu_ID\"=?;";
        System.out.println(query_answer);
        try (Connection connection = DriverManager.getConnection(url, user, pwd);
             // Get answers from DB
             PreparedStatement prepared = connection.prepareStatement(query_answer)) {
            // get answer text from db
            // question_counter is in this case also id of question in database
            prepared.setInt(1, qu_counter); // one is the question mark in query
            ResultSet rs = prepared.executeQuery();

            // Vector class implements a growable array of objects
            // we use it to add results from ResultSet to it => the results from db query
            // because ResultSet is difficult to access after
            // Vector for question
            Vector answerVector = new Vector();

            while (rs.next()) {
                System.out.print("Column 1 returned ");
                System.out.println(rs.getString("asw_text"));
                // add column w question text to vector
                answerVector.addElement(new String(rs.getString(1)));

            }

            rs.close();
            prepared.close();


            return answerVector;


        } catch (SQLException except) {
            Logger logger = Logger.getLogger(JavaToDatabase.class.getName());
            logger.log(Level.SEVERE, except.getMessage(), except);
            return null;
        }


        }

    public static Boolean answerTrueFalse(String answer_text, int primaryKey){
        System.out.println("answerTrueFalse");
        Vector DBConnectData = connectData();
        String url = (String) DBConnectData.get(0);
        String user = (String) DBConnectData.get(1);
        String pwd = (String) DBConnectData.get(2);
        // get answers from DB
        String query_bool = "SELECT \"asw_is_correct\" FROM game.\"Answers\"\n" +
                "WHERE \"asw_text\"=? AND \"asw_qu_ID\"=?;";
        System.out.println(query_bool);
        try (Connection connection = DriverManager.getConnection(url, user, pwd);
             // Get answers from DB
             PreparedStatement prepared = connection.prepareStatement(query_bool)) {
            // get answer text from db
            // question_counter is in this case also id of question in database
            prepared.setString(1, answer_text); // one is the question mark in query
            prepared.setInt(2, primaryKey); // one is the question mark in query
            ResultSet rs = prepared.executeQuery();

            // Vector class implements a growable array of objects
            // we use it to add results from ResultSet to it => the results from db query
            // because ResultSet is difficult to access after
            // Vector for question
            while (rs.next()) {
                System.out.print("Column 1 returned ");
                System.out.print(rs.getBoolean("asw_is_correct"));
                return rs.getBoolean("asw_is_correct");

            }

            rs.close();
            prepared.close();

        } catch (SQLException except) {
            Logger logger = Logger.getLogger(JavaToDatabase.class.getName());
            logger.log(Level.SEVERE, except.getMessage(), except);
            return null;
        }

        return null;
    }



















    }
//}

    //}

//}
