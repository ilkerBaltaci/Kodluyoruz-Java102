package com.patikaDev.View;

import com.patikaDev.Helper.Config;
import com.patikaDev.Helper.Helper;
import com.patikaDev.Model.Educator;

import javax.swing.*;

public class EducatorGUI extends  JFrame{
    private JPanel wrapper;
    private JButton btn_logout;
    private JPanel pnl_top;
    private JTabbedPane tab_educator;
    private JPanel pnl_couse_list;
    private JTable tbl_course_list;
    private JScrollPane scrl_course_list;
    private JPanel pnl_content_edit;
    private JPanel pnl_quiz_edit;
    private JLabel lbl_lesson;
    private JComboBox cmb_lessons;
    private JTextField fld_title;
    private JTextArea txt_area_desc;
    private JTextField fld_video_link;
    private JButton btn_content_add;
    private JTextArea txt_area_question;
    private JTextField fld_answer;
    private JComboBox cmb_content;
    private JButton btn_quiz_add;

    //Custom Class Variables
    private Educator educator;

    public EducatorGUI(Educator educator){
        add(wrapper);
        setSize(400, 400);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        this.educator = educator;
        //Panel Lesson List -1


        //## End of Panel Lesson List -1
    }

    public static void main(String[] args) {
        EducatorGUI eduGUI = new EducatorGUI(new Educator(9, "ali", "doğan", "1111", "educator"));
    }
}
