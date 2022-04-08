package com.patikaDev.View;

import com.patikaDev.Helper.Config;
import com.patikaDev.Helper.Helper;
import com.patikaDev.Model.Course;
import com.patikaDev.Model.Educator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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

    private DefaultTableModel mdl_course_list;
    private Object[] row_course_list;

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
        mdl_course_list = new DefaultTableModel();
        Object[] col_course_list = {"ID", "Ders Adı", "Programlama Dili", "Patika", "Eğitmen"};
        mdl_course_list.setColumnIdentifiers(col_course_list);
        row_course_list = new Object[col_course_list.length];
        loadCourseModel();
        tbl_course_list.setModel(mdl_course_list);
        tbl_course_list.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_course_list.getTableHeader().setReorderingAllowed(false);
        loadCourseCombo();

        //## End of Panel Lesson List -1
    }

    public static void main(String[] args) {
        EducatorGUI eduGUI = new EducatorGUI(new Educator(9, "ali", "doğan", "1111", "educator"));
    }

    private void loadCourseModel(){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_course_list.getModel();
        clearModel.setRowCount(0);
        int i = 0;
        for(Course obj : Course.getList(this.educator)){
            i = 0;
            row_course_list[i++] = obj.getId();
            row_course_list[i++] = obj.getName();
            row_course_list[i++] = obj.getLang();
            row_course_list[i++] = obj.getPatika().getName();
            row_course_list[i++] = obj.getEducator().getName();
            mdl_course_list.addRow(row_course_list);
        }
    }
}
