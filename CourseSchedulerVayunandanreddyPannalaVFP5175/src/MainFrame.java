
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Vayunandanreddy Pannala
 */
public class MainFrame extends javax.swing.JFrame {
    private static final String appInfoFilename = "xzq789yy.txt";

    /**
     * Creates new form MainFrame
     */
    private String currentSemester;
    private String author;
    private String project;

    public MainFrame() {
        initComponents();
        setTitle("Course Scheduler");
        setLocationRelativeTo(null);
        applyModernTheme();
        checkData();
        rebuildSemesterComboBoxes();
        rebuildClassComboBoxes();
        rebuildCourseComboBoxes();
        rebuildStudentComboBoxes();
    }

    public void rebuildSemesterComboBoxes() {
        ArrayList<String> semesters = SemesterQueries.getSemesterList();
        currentSemesterComboBox.setModel(new javax.swing.DefaultComboBoxModel(semesters.toArray()));
        if (semesters.size() == 0){
            currentSemesterLabel.setText("None, add a semester.");
            currentSemester = "None";
        }
        else{
            if (currentSemester == null || !semesters.contains(currentSemester)) {
                currentSemester = semesters.get(0);
            }
            currentSemesterLabel.setText(currentSemester);
            currentSemesterComboBox.setSelectedItem(currentSemester);
        }
    }
    
    public void rebuildClassComboBoxes(){
        ArrayList<String> courses = ClassQueries.getCourseCodesByClass(currentSemester);
        scheduleClassesSelectClassComboBox.setModel(new javax.swing.DefaultComboBoxModel(courses.toArray()));
        displayStudentsCourseCodeComboBox.setModel(new javax.swing.DefaultComboBoxModel(courses.toArray()));
        adminDropCourseComboBox.setModel(new javax.swing.DefaultComboBoxModel(courses.toArray()));
    }
    
    public void rebuildCourseComboBoxes(){
        ArrayList<String> courses = CourseQueries.getCourseCodes();
        addClassCourseCodeComboBox.setModel(new javax.swing.DefaultComboBoxModel(courses.toArray()));
    }
    public void rebuildStudentComboBoxes(){
        ArrayList<String> students = StudentQueries.getStudents();
        scheduleClassesSelectStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel(students.toArray()));
        displayScheduleStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel(students.toArray()));
        
        String curr = "";
        ArrayList<StudentEntry> studentObjects = StudentQueries.getStudentObjects();
        students = new ArrayList<>();
        for (StudentEntry student: studentObjects){
            curr = student.getLastName() + "," + student.getFirstName() + " " + student.getStudentID();
            students.add(curr);
        }
        
        dropStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel(students.toArray()));
        dropClassStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel(students.toArray()));
    }
    
    public void rebuildCurrentStudentComboBox(StudentEntry student){
        ArrayList<String> classes = ScheduleQueries.getCourseCodesByStudent(currentSemester, student.getStudentID());
        dropClassComboBox.setModel(new javax.swing.DefaultComboBoxModel(classes.toArray()));
    }
    
    private void applyModernTheme() {
        Color primary = new Color(25, 118, 210);
        Color surface = new Color(248, 250, 252);
        Color heading = new Color(15, 23, 42);
        
        getContentPane().setBackground(surface);
        jLabel1.setFont(new Font("SansSerif", Font.BOLD, 28));
        jLabel1.setForeground(heading);
        currentSemesterLabel.setForeground(primary);
        
        styleButton(addSemesterSubmitButton, primary);
        styleButton(addCourseSubmitButton, primary);
        styleButton(addClassSubmitButton, primary);
        styleButton(addStudentSubmitButton, primary);
        styleButton(displayStudentsButton, primary);
        styleButton(dropStudentSubmitButton, primary);
        styleButton(adminDropCourseSubmitButton, primary);
        styleButton(displayClassesButton, primary);
        styleButton(scheduleClassesSubmitButton, primary);
        styleButton(displayScheduleButton, primary);
        styleButton(dropClassSubmitButton, primary);
        styleButton(changeSemesterButton, primary);
        styleButton(aboutButton, new Color(71, 85, 105));
        
        styleTable(displayClassesTable);
        styleTable(scheduledStudentsTable);
        styleTable(waitlistedStudentsTable);
        styleTable(displayScheduleTable);
    }
    
    private void styleButton(JButton button, Color color) {
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("SansSerif", Font.BOLD, 12));
    }
    
    private void styleTable(JTable table) {
        table.setRowHeight(24);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        table.getTableHeader().setBackground(new Color(226, 232, 240));
        table.getTableHeader().setForeground(new Color(15, 23, 42));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        typeOfPersonPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        adminOptionsPane = new javax.swing.JTabbedPane();
        addSemesterPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        addSemesterTextfield = new javax.swing.JTextField();
        addSemesterSubmitButton = new javax.swing.JButton();
        addSemesterStatusLabel = new javax.swing.JLabel();
        addCoursePanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        addCourseCodeTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        addCourseDescriptionTextField = new javax.swing.JTextField();
        addCourseSubmitButton = new javax.swing.JButton();
        addCourseStatusLabel = new javax.swing.JLabel();
        addClassPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        addClassSubmitButton = new javax.swing.JButton();
        addClassCourseCodeComboBox = new javax.swing.JComboBox<>();
        addClassSeatsSpinner = new javax.swing.JSpinner();
        addClassStatusLabel = new javax.swing.JLabel();
        addStudentPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        addStudentIDTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        addStudentFirstName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        addStudentLastName = new javax.swing.JTextField();
        addStudentSubmitButton = new javax.swing.JButton();
        addStudentStatusLabel = new javax.swing.JLabel();
        displayClassListPanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        displayStudentsCourseCodeComboBox = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        scheduledStudentsTable = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        displayStudentsButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        waitlistedStudentsTable = new javax.swing.JTable();
        dropStudentPanel = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        dropStudentComboBox = new javax.swing.JComboBox<>();
        dropStudentSubmitButton = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        dropStudentTextArea = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        adminDropCourseComboBox = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        adminDropCourseTextArea = new javax.swing.JTextArea();
        adminDropCourseSubmitButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        studentOptionsPane = new javax.swing.JTabbedPane();
        displayClassesPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        displayClassesTable = new javax.swing.JTable();
        displayClassesButton = new javax.swing.JButton();
        scheduleClassesPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        scheduleClassesSelectClassComboBox = new javax.swing.JComboBox<>();
        scheduleClassesSelectStudentComboBox = new javax.swing.JComboBox<>();
        scheduleClassesSubmitButton = new javax.swing.JButton();
        scheduleClassesStatusLabel = new javax.swing.JLabel();
        displaySchedulePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayScheduleTable = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        displayScheduleStudentComboBox = new javax.swing.JComboBox<>();
        displayScheduleButton = new javax.swing.JButton();
        dropClassPanel = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        dropClassStudentComboBox = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        dropClassComboBox = new javax.swing.JComboBox<>();
        dropClassSubmitButton = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        dropClassTextArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        currentSemesterLabel = new javax.swing.JLabel();
        currentSemesterComboBox = new javax.swing.JComboBox<>();
        changeSemesterButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Course Scheduler");

        jLabel3.setText("Semester Name:");

        addSemesterTextfield.setColumns(20);
        addSemesterTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSemesterTextfieldActionPerformed(evt);
            }
        });

        addSemesterSubmitButton.setText("Submit");
        addSemesterSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSemesterSubmitButtonActionPerformed(evt);
            }
        });

        addSemesterStatusLabel.setText("                                                   ");

        javax.swing.GroupLayout addSemesterPanelLayout = new javax.swing.GroupLayout(addSemesterPanel);
        addSemesterPanel.setLayout(addSemesterPanelLayout);
        addSemesterPanelLayout.setHorizontalGroup(
            addSemesterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSemesterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addSemesterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addSemesterStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addSemesterPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addSemesterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addSemesterSubmitButton)
                            .addComponent(addSemesterTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(383, Short.MAX_VALUE))
        );
        addSemesterPanelLayout.setVerticalGroup(
            addSemesterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSemesterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addSemesterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(addSemesterTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addSemesterSubmitButton)
                .addGap(18, 18, 18)
                .addComponent(addSemesterStatusLabel)
                .addContainerGap(269, Short.MAX_VALUE))
        );

        addSemesterSubmitButton.getAccessibleContext().setAccessibleName("OK");

        adminOptionsPane.addTab("Add Semester", addSemesterPanel);

        jLabel4.setText("Course Code:");

        addCourseCodeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseCodeTextFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Course Description:");

        addCourseDescriptionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseDescriptionTextFieldActionPerformed(evt);
            }
        });

        addCourseSubmitButton.setText("Submit");
        addCourseSubmitButton.setToolTipText("");
        addCourseSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseSubmitButtonActionPerformed(evt);
            }
        });

        addCourseStatusLabel.setText("                    ");

        javax.swing.GroupLayout addCoursePanelLayout = new javax.swing.GroupLayout(addCoursePanel);
        addCoursePanel.setLayout(addCoursePanelLayout);
        addCoursePanelLayout.setHorizontalGroup(
            addCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCoursePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(addCourseStatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(addCoursePanelLayout.createSequentialGroup()
                        .addGroup(addCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addCourseSubmitButton)
                            .addComponent(addCourseDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addCourseCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(397, Short.MAX_VALUE))
        );
        addCoursePanelLayout.setVerticalGroup(
            addCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCoursePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(addCourseCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(addCourseDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(addCourseSubmitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addCourseStatusLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addCourseSubmitButton.getAccessibleContext().setAccessibleName("ok");

        adminOptionsPane.addTab("Add Course", addCoursePanel);

        jLabel9.setText("Course Code:");

        jLabel11.setText("Seats:");

        addClassSubmitButton.setText("Submit");
        addClassSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClassSubmitButtonActionPerformed(evt);
            }
        });

        addClassStatusLabel.setText("                                 ");

        javax.swing.GroupLayout addClassPanelLayout = new javax.swing.GroupLayout(addClassPanel);
        addClassPanel.setLayout(addClassPanelLayout);
        addClassPanelLayout.setHorizontalGroup(
            addClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addClassPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addClassPanelLayout.createSequentialGroup()
                        .addGroup(addClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addClassSeatsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addClassCourseCodeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addClassPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(addClassSubmitButton))))
                    .addComponent(addClassStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(415, Short.MAX_VALUE))
        );
        addClassPanelLayout.setVerticalGroup(
            addClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addClassPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(addClassCourseCodeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addClassSeatsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(addClassSubmitButton)
                .addGap(18, 18, 18)
                .addComponent(addClassStatusLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        adminOptionsPane.addTab("Add Class", addClassPanel);

        jLabel6.setText("Student ID:");

        jLabel7.setText("First Name:");

        addStudentFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentFirstNameActionPerformed(evt);
            }
        });

        jLabel8.setText("Last Name:");

        addStudentSubmitButton.setText("Submit");
        addStudentSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentSubmitButtonActionPerformed(evt);
            }
        });

        addStudentStatusLabel.setText("                            ");

        javax.swing.GroupLayout addStudentPanelLayout = new javax.swing.GroupLayout(addStudentPanel);
        addStudentPanel.setLayout(addStudentPanelLayout);
        addStudentPanelLayout.setHorizontalGroup(
            addStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addStudentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addStudentStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addStudentPanelLayout.createSequentialGroup()
                        .addGroup(addStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addStudentSubmitButton)
                            .addComponent(addStudentIDTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(addStudentFirstName)
                            .addComponent(addStudentLastName))))
                .addContainerGap(423, Short.MAX_VALUE))
        );
        addStudentPanelLayout.setVerticalGroup(
            addStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addStudentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(addStudentIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(addStudentFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(addStudentLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(addStudentSubmitButton)
                .addGap(18, 18, 18)
                .addComponent(addStudentStatusLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        adminOptionsPane.addTab("Add Student", addStudentPanel);

        jLabel13.setText("Course Code:");

        scheduledStudentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Last Name", "First Name", "Student ID"
            }
        ));
        jScrollPane4.setViewportView(scheduledStudentsTable);

        jLabel15.setText("Scheduled Students in the Class:");

        jLabel16.setText("Waitlisted Students in the Class by Waitlist Order:");

        displayStudentsButton.setText("Display");
        displayStudentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayStudentsButtonActionPerformed(evt);
            }
        });

        waitlistedStudentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Last Name", "First Name", "Student ID"
            }
        ));
        jScrollPane5.setViewportView(waitlistedStudentsTable);

        javax.swing.GroupLayout displayClassListPanelLayout = new javax.swing.GroupLayout(displayClassListPanel);
        displayClassListPanel.setLayout(displayClassListPanelLayout);
        displayClassListPanelLayout.setHorizontalGroup(
            displayClassListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayClassListPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(displayClassListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(displayClassListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(displayClassListPanelLayout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(displayStudentsCourseCodeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(205, 205, 205)
                            .addComponent(displayStudentsButton))
                        .addComponent(jLabel15)
                        .addComponent(jLabel16)))
                .addContainerGap(211, Short.MAX_VALUE))
        );
        displayClassListPanelLayout.setVerticalGroup(
            displayClassListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayClassListPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(displayClassListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(displayStudentsCourseCodeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayStudentsButton))
                .addGap(4, 4, 4)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        adminOptionsPane.addTab("Display Class List", displayClassListPanel);

        jLabel17.setText("Choose Student:");

        dropStudentSubmitButton.setText("Submit");
        dropStudentSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropStudentSubmitButtonActionPerformed(evt);
            }
        });

        dropStudentTextArea.setColumns(20);
        dropStudentTextArea.setRows(5);
        jScrollPane6.setViewportView(dropStudentTextArea);

        javax.swing.GroupLayout dropStudentPanelLayout = new javax.swing.GroupLayout(dropStudentPanel);
        dropStudentPanel.setLayout(dropStudentPanelLayout);
        dropStudentPanelLayout.setHorizontalGroup(
            dropStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dropStudentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dropStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dropStudentPanelLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dropStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)
                        .addComponent(dropStudentSubmitButton)))
                .addContainerGap(267, Short.MAX_VALUE))
        );
        dropStudentPanelLayout.setVerticalGroup(
            dropStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dropStudentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dropStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(dropStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dropStudentSubmitButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        adminOptionsPane.addTab("Drop Student", dropStudentPanel);

        jLabel20.setText("Choose Course:");

        adminDropCourseTextArea.setColumns(20);
        adminDropCourseTextArea.setRows(5);
        jScrollPane8.setViewportView(adminDropCourseTextArea);

        adminDropCourseSubmitButton.setText("Submit");
        adminDropCourseSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminDropCourseSubmitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adminDropCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177)
                        .addComponent(adminDropCourseSubmitButton))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(226, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminDropCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(adminDropCourseSubmitButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        adminOptionsPane.addTab("Drop Class", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminOptionsPane)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(adminOptionsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        typeOfPersonPane.addTab("Admin", jPanel1);

        displayClassesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Course Code", "Description", "Seats"
            }
        ));
        jScrollPane3.setViewportView(displayClassesTable);

        displayClassesButton.setText("Display");
        displayClassesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayClassesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout displayClassesPanelLayout = new javax.swing.GroupLayout(displayClassesPanel);
        displayClassesPanel.setLayout(displayClassesPanelLayout);
        displayClassesPanelLayout.setHorizontalGroup(
            displayClassesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayClassesPanelLayout.createSequentialGroup()
                .addGroup(displayClassesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(displayClassesPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(displayClassesPanelLayout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(displayClassesButton)))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        displayClassesPanelLayout.setVerticalGroup(
            displayClassesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayClassesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(displayClassesButton)
                .addContainerGap(254, Short.MAX_VALUE))
        );

        studentOptionsPane.addTab("Display Classes", displayClassesPanel);

        jLabel10.setText("Select Class:");

        jLabel12.setText("Select Student:");

        scheduleClassesSubmitButton.setText("Submit");
        scheduleClassesSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleClassesSubmitButtonActionPerformed(evt);
            }
        });

        scheduleClassesStatusLabel.setText("                             ");

        javax.swing.GroupLayout scheduleClassesPanelLayout = new javax.swing.GroupLayout(scheduleClassesPanel);
        scheduleClassesPanel.setLayout(scheduleClassesPanelLayout);
        scheduleClassesPanelLayout.setHorizontalGroup(
            scheduleClassesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scheduleClassesPanelLayout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(scheduleClassesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scheduleClassesSelectStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(scheduleClassesPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(scheduleClassesSubmitButton)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(scheduleClassesPanelLayout.createSequentialGroup()
                .addGroup(scheduleClassesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(scheduleClassesPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scheduleClassesSelectClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(scheduleClassesPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scheduleClassesStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(408, Short.MAX_VALUE))
        );
        scheduleClassesPanelLayout.setVerticalGroup(
            scheduleClassesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scheduleClassesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scheduleClassesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(scheduleClassesSelectClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scheduleClassesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scheduleClassesSelectStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addComponent(scheduleClassesSubmitButton)
                .addGap(36, 36, 36)
                .addComponent(scheduleClassesStatusLabel)
                .addContainerGap(372, Short.MAX_VALUE))
        );

        studentOptionsPane.addTab("Schedule Classes", scheduleClassesPanel);

        displayScheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Course Code", "Status"
            }
        ));
        jScrollPane1.setViewportView(displayScheduleTable);

        jLabel14.setText("Select Student:");

        displayScheduleButton.setText("Display");
        displayScheduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayScheduleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout displaySchedulePanelLayout = new javax.swing.GroupLayout(displaySchedulePanel);
        displaySchedulePanel.setLayout(displaySchedulePanelLayout);
        displaySchedulePanelLayout.setHorizontalGroup(
            displaySchedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displaySchedulePanelLayout.createSequentialGroup()
                .addGroup(displaySchedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(displaySchedulePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(displaySchedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(displaySchedulePanelLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(displayScheduleStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(displaySchedulePanelLayout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(displayScheduleButton)))
                .addContainerGap(300, Short.MAX_VALUE))
        );
        displaySchedulePanelLayout.setVerticalGroup(
            displaySchedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displaySchedulePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(displaySchedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(displayScheduleStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(displayScheduleButton)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        studentOptionsPane.addTab("Display Schedule", displaySchedulePanel);

        jLabel18.setText("Choose Student:");

        dropClassStudentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropClassStudentComboBoxActionPerformed(evt);
            }
        });

        jLabel19.setText("Choose Class:");

        dropClassSubmitButton.setText("Submit");
        dropClassSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropClassSubmitButtonActionPerformed(evt);
            }
        });

        dropClassTextArea.setColumns(20);
        dropClassTextArea.setRows(5);
        jScrollPane7.setViewportView(dropClassTextArea);

        javax.swing.GroupLayout dropClassPanelLayout = new javax.swing.GroupLayout(dropClassPanel);
        dropClassPanel.setLayout(dropClassPanelLayout);
        dropClassPanelLayout.setHorizontalGroup(
            dropClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dropClassPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dropClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dropClassPanelLayout.createSequentialGroup()
                        .addGroup(dropClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dropClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dropClassSubmitButton)
                            .addComponent(dropClassStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dropClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        dropClassPanelLayout.setVerticalGroup(
            dropClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dropClassPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dropClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(dropClassStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dropClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dropClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addComponent(dropClassSubmitButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        studentOptionsPane.addTab("Drop Class", dropClassPanel);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(studentOptionsPane))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(studentOptionsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        studentOptionsPane.getAccessibleContext().setAccessibleDescription("");

        typeOfPersonPane.addTab("Student", jPanel2);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel2.setText("Current Semester: ");

        currentSemesterLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        currentSemesterLabel.setText("           ");

        currentSemesterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentSemesterComboBoxActionPerformed(evt);
            }
        });

        changeSemesterButton.setText("Change Semester");
        changeSemesterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeSemesterButtonActionPerformed(evt);
            }
        });

        aboutButton.setText("About");
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typeOfPersonPane)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentSemesterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentSemesterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(changeSemesterButton)
                                .addGap(31, 31, 31)
                                .addComponent(aboutButton)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(currentSemesterLabel)
                    .addComponent(currentSemesterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeSemesterButton)
                    .addComponent(aboutButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeOfPersonPane, javax.swing.GroupLayout.PREFERRED_SIZE, 551, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        // TODO add your handling code here:
        // display about information.
        JOptionPane.showMessageDialog(null, "Author: " + author + " Project: " + project);
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void currentSemesterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentSemesterComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_currentSemesterComboBoxActionPerformed

    private void displayClassesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayClassesButtonActionPerformed
        // TODO add your handling code here:
        ArrayList<ClassDescription> classes = MultiTableQueries.getAllCourseDescriptions(currentSemester);
        DefaultTableModel displayCoursesModel = (DefaultTableModel) displayClassesTable.getModel();
        
        displayCoursesModel.setNumRows(0);
        Object[] rowData = new Object[3];
        
        for (ClassDescription classEntry: classes){
            rowData[0] = classEntry.getCourseCode();
            rowData[1] = classEntry.getDescription();
            rowData[2] = classEntry.getSeats();
            displayCoursesModel.addRow(rowData);
        }
    }//GEN-LAST:event_displayClassesButtonActionPerformed

    private void displayScheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayScheduleButtonActionPerformed
        // TODO add your handling code here:
        String student = getSelectedValue(displayScheduleStudentComboBox);
        if (student == null) {
            showInputError("Select a student to display a schedule.");
            return;
        }
        String id = StudentQueries.getStudentID(student);
        if (id.isBlank()) {
            showInputError("Selected student could not be resolved.");
            return;
        }
        ArrayList<ScheduleEntry> scheduled = ScheduleQueries.getStudentSchedule(currentSemester, id);
        DefaultTableModel displayScheduleModel = (DefaultTableModel) displayScheduleTable.getModel();
        displayScheduleModel.setNumRows(0);
        Object[] rowData = new Object[2];
        
        for(ScheduleEntry entry: scheduled){
            rowData[0] = entry.getCourseCode();
            rowData[1] = entry.getStatus();
            displayScheduleModel.addRow(rowData);
        }
    }//GEN-LAST:event_displayScheduleButtonActionPerformed

    private void scheduleClassesSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleClassesSubmitButtonActionPerformed
        // TODO add your handling code here:
        String student = getSelectedValue(scheduleClassesSelectStudentComboBox);
        String course = getSelectedValue(scheduleClassesSelectClassComboBox);
        if (student == null || course == null) {
            showInputError("Select both a student and a class before scheduling.");
            return;
        }
        if ("None".equals(currentSemester)) {
            showInputError("Add a semester before scheduling classes.");
            return;
        }
        
        String id = StudentQueries.getStudentID(student);
        if (id.isBlank()) {
            showInputError("Selected student could not be resolved.");
            return;
        }
        
        if (ScheduleQueries.isStudentEnrolledInCourse(currentSemester, course, id)) {
            scheduleClassesStatusLabel.setText(student + " is already enrolled for " + course + ".");
            return;
        }
        
        String status;
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        int seats = CourseQueries.getCourseSeats(currentSemester, course);
        if (seats <= 0) {
            showInputError("Selected class has invalid seat capacity.");
            return;
        }
        
        int occupied = ScheduleQueries.getScheduledStudentsCount(currentSemester, course);
        
        if (seats > occupied){
            status = ScheduleStatus.SCHEDULED;
            scheduleClassesStatusLabel.setText(student + " has been scheduled for " + course + ".");
        }
        
        else{
            status = ScheduleStatus.WAITLISTED;
            scheduleClassesStatusLabel.setText(student + " has been waitlisted for " + course + ".");
        }
        
        ScheduleEntry schedule = new ScheduleEntry(currentSemester, course, id, status, currentTimestamp);
        ScheduleQueries.addSchedule(schedule);
        rebuildStudentComboBoxes();
    }//GEN-LAST:event_scheduleClassesSubmitButtonActionPerformed

    private void changeSemesterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeSemesterButtonActionPerformed
        // TODO add your handling code here:
        String selectedSemester = getSelectedValue(currentSemesterComboBox);
        if (selectedSemester == null) {
            showInputError("Select a semester first.");
            return;
        }
        
        currentSemester = selectedSemester;
        currentSemesterLabel.setText(currentSemester);
        rebuildSemesterComboBoxes();
        rebuildStudentComboBoxes();
        rebuildClassComboBoxes();
    }//GEN-LAST:event_changeSemesterButtonActionPerformed

    private void dropStudentSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropStudentSubmitButtonActionPerformed
        // TODO add your handling code here:
        //1) Rebuild student combo boxes
        //2) Schedule next waitlisted students in classes for each semester
        //3) Remove student from all their classes in each semester
        //4) For every action, print the result in the text area
        String selectedStudent = getSelectedValue(dropStudentComboBox);
        if (selectedStudent == null) {
            showInputError("Select a student to drop.");
            return;
        }
        
        dropStudentTextArea.setText("");
        StudentEntry currentStudent = StudentQueries.getStudent(getStudentCB(dropStudentComboBox));
        if (currentStudent == null) {
            showInputError("Selected student could not be loaded.");
            return;
        }
        
        dropStudentTextArea.append(selectedStudent + " has been dropped from the list of students.\n\n");

        for (String currSem: SemesterQueries.getSemesterList()){
            String droppedCourses = "";
            String addedStudents = "";

            for (ScheduleEntry schedule: ScheduleQueries.getStudentSchedule(currSem, currentStudent.getStudentID())){

                ScheduleQueries.dropStudentByCourse(currSem, currentStudent.getStudentID(), schedule.getCourseCode());
                droppedCourses += selectedStudent + " has been removed from " + schedule.getCourseCode() + "\n";

                ArrayList<ScheduleEntry> waitlisted = ScheduleQueries.getWaitlistedStudents(currSem, schedule.getCourseCode());

                if (!waitlisted.isEmpty()){
                    ScheduleQueries.updateStatus(currSem, waitlisted.get(0));
                    StudentEntry newStudent = StudentQueries.getStudent(waitlisted.get(0).getStudentID());
                    if (newStudent != null) {
                        addedStudents += newStudent.getLastName() + "," + newStudent.getFirstName() + " " + newStudent.getStudentID() + " has been scheduled for " + waitlisted.get(0).getCourseCode() + "\n";
                    }
                }
            }

            if (!droppedCourses.isEmpty() || !addedStudents.isEmpty()){
                dropStudentTextArea.append("For Semester: " + currSem + "\n");
                dropStudentTextArea.append(droppedCourses + "\n");
                dropStudentTextArea.append(addedStudents + "\n");
            }
        }

        StudentQueries.dropStudent(currentStudent.getStudentID());
        rebuildStudentComboBoxes();
    }//GEN-LAST:event_dropStudentSubmitButtonActionPerformed

    private void displayStudentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayStudentsButtonActionPerformed
        // TODO add your handling code here:
        //1) Get course from combo box. Call multitable query methods to get schedules of waitlisted and scheduled students
        //2) Use for loop to make an ArrayList of waitlisted and scheduled StudentEntry objects
        //3) Create Object arrays for waitlisted and scheduled students and use a for loop to add the StudentEntry objects to the table

        String courseCode = getSelectedValue(displayStudentsCourseCodeComboBox);
        if (courseCode == null) {
            showInputError("Select a course to display roster details.");
            return;
        }
        ArrayList<ScheduleEntry> scheduled = MultiTableQueries.getScheduledStudentsByCourse(currentSemester, courseCode);
        ArrayList<ScheduleEntry> waitlisted = MultiTableQueries.getWaitlistedStudentsByCourse(currentSemester, courseCode);

        ArrayList<StudentEntry> scheduledStudents = new ArrayList<>();
        ArrayList<StudentEntry> waitlistedStudents = new ArrayList<>();

        for (ScheduleEntry s: scheduled){
            StudentEntry student = StudentQueries.getStudent(s.getStudentID());
            if (student != null) {
                scheduledStudents.add(student);
            }
        }

        for (ScheduleEntry w: waitlisted){
            StudentEntry student = StudentQueries.getStudent(w.getStudentID());
            if (student != null) {
                waitlistedStudents.add(student);
            }
        }

        DefaultTableModel scheduledStudentsModel = (DefaultTableModel) scheduledStudentsTable.getModel();
        scheduledStudentsModel.setNumRows(0);

        DefaultTableModel waitlistedStudentsModel = (DefaultTableModel) waitlistedStudentsTable.getModel();
        waitlistedStudentsModel.setNumRows(0);

        Object[] rowData = new Object[3];

        for (StudentEntry s: scheduledStudents){
            rowData[1] = s.getFirstName();
            rowData[0] = s.getLastName();
            rowData[2] = s.getStudentID();
            scheduledStudentsModel.addRow(rowData);
        }

        rowData = new Object[3];

        for (StudentEntry w: waitlistedStudents){
            rowData[1] = w.getFirstName();
            rowData[0] = w.getLastName();
            rowData[2] = w.getStudentID();
            waitlistedStudentsModel.addRow(rowData);
        }
    }//GEN-LAST:event_displayStudentsButtonActionPerformed

    private void addStudentSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentSubmitButtonActionPerformed
        // TODO add your handling code here:
        String studentID = normalize(addStudentIDTextField.getText());
        String first = normalize(addStudentFirstName.getText());
        String last = normalize(addStudentLastName.getText());
        
        if (studentID.isBlank() || first.isBlank() || last.isBlank()) {
            showInputError("Student ID, first name, and last name are required.");
            return;
        }
        
        if (StudentQueries.exists(studentID)) {
            showInputError("A student with this ID already exists.");
            return;
        }
        
        StudentQueries.addStudent(new StudentEntry(studentID, first, last));
        addStudentStatusLabel.setText(last + "," + first + " has been added.");
        addStudentIDTextField.setText("");
        addStudentFirstName.setText("");
        addStudentLastName.setText("");
        rebuildStudentComboBoxes();
    }//GEN-LAST:event_addStudentSubmitButtonActionPerformed

    private void addStudentFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addStudentFirstNameActionPerformed

    private void addClassSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClassSubmitButtonActionPerformed
        // TODO add your handling code here:
        String courseCode = getSelectedValue(addClassCourseCodeComboBox);
        if (courseCode == null) {
            showInputError("Select a course code before creating a class.");
            return;
        }
        
        if ("None".equals(currentSemester)) {
            showInputError("Add a semester before creating classes.");
            return;
        }
        
        int seats = (int) addClassSeatsSpinner.getValue();
        if (seats <= 0) {
            showInputError("Seat count must be greater than zero.");
            return;
        }
        
        if (ClassQueries.exists(currentSemester, courseCode)) {
            showInputError("This class already exists in the selected semester.");
            return;
        }
        
        ClassQueries.addClass(new ClassEntry(currentSemester, courseCode, seats));
        addClassStatusLabel.setText(courseCode + " has been added.");
        rebuildClassComboBoxes();
    }//GEN-LAST:event_addClassSubmitButtonActionPerformed

    private void addCourseSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseSubmitButtonActionPerformed
        // TODO add your handling code here:
        String courseCode = normalize(addCourseCodeTextField.getText()).toUpperCase();
        String description = normalize(addCourseDescriptionTextField.getText());
        if (!courseCode.isBlank() && !description.isBlank()){
            if (CourseQueries.exists(courseCode)) {
                showInputError("This course code already exists.");
                return;
            }
            
            CourseQueries.addCourse(new CourseEntry(courseCode, description));
            addCourseStatusLabel.setText(courseCode + " has been added.");
            addCourseCodeTextField.setText("");
            addCourseDescriptionTextField.setText("");
            rebuildCourseComboBoxes();
        } else {
            showInputError("Course code and description are required.");
        }
    }//GEN-LAST:event_addCourseSubmitButtonActionPerformed

    private void addCourseDescriptionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseDescriptionTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addCourseDescriptionTextFieldActionPerformed

    private void addCourseCodeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseCodeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addCourseCodeTextFieldActionPerformed

    private void addSemesterSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSemesterSubmitButtonActionPerformed
        String semester = normalize(addSemesterTextfield.getText()).toUpperCase();
        if (semester.isBlank()) {
            showInputError("Semester name is required.");
            return;
        }
        
        if (SemesterQueries.exists(semester)) {
            showInputError("This semester already exists.");
            return;
        }
        
        SemesterQueries.addSemester(semester);
        addSemesterStatusLabel.setText("Semester " + semester + " has been added.");
        addSemesterTextfield.setText("");
        currentSemester = semester;
        rebuildSemesterComboBoxes();
    }//GEN-LAST:event_addSemesterSubmitButtonActionPerformed

    private void dropClassSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropClassSubmitButtonActionPerformed
        // TODO add your handling code here:
        String selectedStudent = getSelectedValue(dropClassStudentComboBox);
        String selectedCourse = getSelectedValue(dropClassComboBox);
        if (selectedStudent == null || selectedCourse == null) {
            showInputError("Select both a student and course to drop.");
            return;
        }
        
        StudentEntry currentStudent = StudentQueries.getStudent(getStudentCB(dropClassStudentComboBox));
        if (currentStudent == null) {
            showInputError("Selected student could not be loaded.");
            return;
        }
        
        dropClassTextArea.setText("");
        String droppedCourses = "";
        String addedStudents = "";

            ScheduleQueries.dropStudentByCourse(currentSemester, currentStudent.getStudentID(), selectedCourse);
            droppedCourses += selectedStudent + " has been removed from " + selectedCourse + "\n";

            ArrayList<ScheduleEntry> waitlisted = ScheduleQueries.getWaitlistedStudents(currentSemester, selectedCourse);

            if (!waitlisted.isEmpty()){
                ScheduleQueries.updateStatus(currentSemester, waitlisted.get(0));
                StudentEntry newStudent = StudentQueries.getStudent(waitlisted.get(0).getStudentID());
                if (newStudent != null) {
                    addedStudents += newStudent.getLastName() + "," + newStudent.getFirstName() + " " + newStudent.getStudentID() + " has been scheduled for " + waitlisted.get(0).getCourseCode() + "\n";
                }
            }

        if (!droppedCourses.isEmpty() || !addedStudents.isEmpty()){
            dropClassTextArea.append("For Semester: " + currentSemester + "\n");
            dropClassTextArea.append(droppedCourses + "\n");
            dropClassTextArea.append(addedStudents + "\n");
        }
        
        rebuildCurrentStudentComboBox(currentStudent);
    }//GEN-LAST:event_dropClassSubmitButtonActionPerformed

    private void dropClassStudentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropClassStudentComboBoxActionPerformed
        // TODO add your handling code here:
        StudentEntry currentStudent = StudentQueries.getStudent(getStudentCB(dropClassStudentComboBox));
        if (currentStudent != null) {
            rebuildCurrentStudentComboBox(currentStudent);
        }
    }//GEN-LAST:event_dropClassStudentComboBoxActionPerformed

    private void adminDropCourseSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminDropCourseSubmitButtonActionPerformed
        // TODO add your handling code here:
        String selectedCourse = getSelectedValue(adminDropCourseComboBox);
        if (selectedCourse == null) {
            showInputError("Select a course to drop.");
            return;
        }
        
        adminDropCourseTextArea.setText("");
        String scheduledStudents = "Scheduled students dropped from the course:\n\n";
        String waitlistedStudents = "\nWaitlisted students dropped from the course:\n\n";
        
        for (ScheduleEntry schedule: MultiTableQueries.getScheduledStudentsByCourse(currentSemester, selectedCourse)){
            StudentEntry currentStudent = StudentQueries.getStudent(schedule.getStudentID());
            if (currentStudent != null) {
                scheduledStudents += currentStudent.getLastName() + "," + currentStudent.getFirstName() + " " + currentStudent.getStudentID()
                                     + " has been dropped from " + selectedCourse + "\n";
            }
        }
        
        for (ScheduleEntry schedule: MultiTableQueries.getWaitlistedStudentsByCourse(currentSemester, selectedCourse)){
            StudentEntry currentStudent = StudentQueries.getStudent(schedule.getStudentID());
            if (currentStudent != null) {
                waitlistedStudents += currentStudent.getLastName() + "," + currentStudent.getFirstName() + " " + currentStudent.getStudentID() + 
                        " has been dropped from " + selectedCourse + "\n";
            }
        }
        
        ScheduleQueries.dropStudentsByCourse(currentSemester, selectedCourse);
        ClassQueries.dropClass(currentSemester, selectedCourse);
        rebuildClassComboBoxes();
        adminDropCourseTextArea.append(scheduledStudents);
        adminDropCourseTextArea.append(waitlistedStudents);
    }//GEN-LAST:event_adminDropCourseSubmitButtonActionPerformed

    private void addSemesterTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSemesterTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addSemesterTextfieldActionPerformed

    private String getStudentCB(javax.swing.JComboBox<String> input){
        String selectedValue = getSelectedValue(input);
        if (selectedValue == null) {
            return "";
        }
        
        String[] result = selectedValue.trim().split("\\s+");
        return result[result.length - 1];
    }
    
    private String getSelectedValue(javax.swing.JComboBox<String> input) {
        if (input == null || input.getSelectedItem() == null) {
            return null;
        }
        
        String value = input.getSelectedItem().toString().trim();
        if (value.isBlank()) {
            return null;
        }
        return value;
    }
    
    private String normalize(String input) {
        if (input == null) {
            return "";
        }
        return input.trim();
    }
    
    private void showInputError(String message) {
        JOptionPane.showMessageDialog(this, message, "Input Required", JOptionPane.WARNING_MESSAGE);
    }
    
    private void checkData() {
        try {
            FileReader reader = new FileReader(appInfoFilename);
            BufferedReader breader = new BufferedReader(reader);

            String encodedAuthor = breader.readLine();
            String encodedProject = breader.readLine();
            byte[] decodedAuthor = Base64.getDecoder().decode(encodedAuthor);
            author = new String(decodedAuthor);
            byte[] decodedProject = Base64.getDecoder().decode(encodedProject);
            project = new String(decodedProject);
            reader.close();

        } catch (FileNotFoundException e) {
            //get user info and create file
            author = "Vayu Pannala";
            project = "Course Scheduler Fall 2024";

            //write data to the data file.
            try {
                FileWriter writer = new FileWriter(appInfoFilename, true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);

                // encode the output data.
                String encodedAuthor = Base64.getEncoder().encodeToString(author.getBytes());

                bufferedWriter.write(encodedAuthor);
                bufferedWriter.newLine();

                String encodedProject = Base64.getEncoder().encodeToString(project.getBytes());
                bufferedWriter.write(encodedProject);

                bufferedWriter.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
                System.exit(1);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private javax.swing.JComboBox<String> addClassCourseCodeComboBox;
    private javax.swing.JPanel addClassPanel;
    private javax.swing.JSpinner addClassSeatsSpinner;
    private javax.swing.JLabel addClassStatusLabel;
    private javax.swing.JButton addClassSubmitButton;
    private javax.swing.JTextField addCourseCodeTextField;
    private javax.swing.JTextField addCourseDescriptionTextField;
    private javax.swing.JPanel addCoursePanel;
    private javax.swing.JLabel addCourseStatusLabel;
    private javax.swing.JButton addCourseSubmitButton;
    private javax.swing.JPanel addSemesterPanel;
    private javax.swing.JLabel addSemesterStatusLabel;
    private javax.swing.JButton addSemesterSubmitButton;
    private javax.swing.JTextField addSemesterTextfield;
    private javax.swing.JTextField addStudentFirstName;
    private javax.swing.JTextField addStudentIDTextField;
    private javax.swing.JTextField addStudentLastName;
    private javax.swing.JPanel addStudentPanel;
    private javax.swing.JLabel addStudentStatusLabel;
    private javax.swing.JButton addStudentSubmitButton;
    private javax.swing.JComboBox<String> adminDropCourseComboBox;
    private javax.swing.JButton adminDropCourseSubmitButton;
    private javax.swing.JTextArea adminDropCourseTextArea;
    private javax.swing.JTabbedPane adminOptionsPane;
    private javax.swing.JButton changeSemesterButton;
    private javax.swing.JComboBox<String> currentSemesterComboBox;
    private javax.swing.JLabel currentSemesterLabel;
    private javax.swing.JPanel displayClassListPanel;
    private javax.swing.JButton displayClassesButton;
    private javax.swing.JPanel displayClassesPanel;
    private javax.swing.JTable displayClassesTable;
    private javax.swing.JButton displayScheduleButton;
    private javax.swing.JPanel displaySchedulePanel;
    private javax.swing.JComboBox<String> displayScheduleStudentComboBox;
    private javax.swing.JTable displayScheduleTable;
    private javax.swing.JButton displayStudentsButton;
    private javax.swing.JComboBox<String> displayStudentsCourseCodeComboBox;
    private javax.swing.JComboBox<String> dropClassComboBox;
    private javax.swing.JPanel dropClassPanel;
    private javax.swing.JComboBox<String> dropClassStudentComboBox;
    private javax.swing.JButton dropClassSubmitButton;
    private javax.swing.JTextArea dropClassTextArea;
    private javax.swing.JComboBox<String> dropStudentComboBox;
    private javax.swing.JPanel dropStudentPanel;
    private javax.swing.JButton dropStudentSubmitButton;
    private javax.swing.JTextArea dropStudentTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel scheduleClassesPanel;
    private javax.swing.JComboBox<String> scheduleClassesSelectClassComboBox;
    private javax.swing.JComboBox<String> scheduleClassesSelectStudentComboBox;
    private javax.swing.JLabel scheduleClassesStatusLabel;
    private javax.swing.JButton scheduleClassesSubmitButton;
    private javax.swing.JTable scheduledStudentsTable;
    private javax.swing.JTabbedPane studentOptionsPane;
    private javax.swing.JTabbedPane typeOfPersonPane;
    private javax.swing.JTable waitlistedStudentsTable;
    // End of variables declaration//GEN-END:variables
}
