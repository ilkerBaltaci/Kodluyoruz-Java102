package com.patikaDev.View;

import com.patikaDev.Helper.Config;
import com.patikaDev.Helper.Helper;
import com.patikaDev.Model.Operator;
import com.patikaDev.Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class OperatorGUI extends JFrame {
    private JPanel wrapper;

    private final Operator operator;
    private JTabbedPane tab_operator;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JPanel pnl_userList;
    private JScrollPane scrl_user_list;
    private JTable tbl_user_list;
    private DefaultTableModel mdl_user_list;
    private Object[] row_user_list;

    public OperatorGUI(Operator operator) {
        this.operator = operator;

        add(wrapper);
        setSize(1000, 500);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        lbl_welcome.setText("Hoşgeldin : " + operator.getName());

        // ModelUserList
        mdl_user_list = new DefaultTableModel();
        Object[] col_user_list = {"ID", "Ad Soyad", "Kullanıcı Adı", "Şifre", "Üyelik Tipi"};
        mdl_user_list.setColumnIdentifiers(col_user_list);
        /*
        Object[] firstRow = {"1", "Mustafa Çetindağ", "mustafa", "123", "operator"};
        mdl_user_list.addRow(firstRow);
         */

        for(User obj : User.getList()){
            Object[] row = new Object[col_user_list.length];
            row[0] = obj.getId();
            row[1] = obj.getName();
            row[2] = obj.getUname();
            row[3] = obj.getPass();
            row[4] = obj.getType();
            mdl_user_list.addRow(row);
        }

        tbl_user_list.setModel(mdl_user_list);
        tbl_user_list.getTableHeader().setReorderingAllowed(false);
    }

    public static void main(String[] args) {

        Helper.setLayout();
        Operator op = new Operator();
        op.setId(1);
        op.setName("Mustafa çetindağ");
        op.setPass("1234");
        op.setType("operator");
        op.setUname("mustafa");
        OperatorGUI opGUI = new OperatorGUI(op);

         /*
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connect = null;

        try {
            connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/patika", "postgres", "kastamonu37");
            Statement statement = connect.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM public.user");
            while (result.next()){
                System.out.println(result.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

         */

    }
}
