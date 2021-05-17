package View;

import Controller.Controller;
import Model.Employee;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;


public class Frame extends JFrame {

    private final FormPanel formPanel;
    private final JFileChooser fileChooser;
    private final Controller controller;
    private final Table table;
    private final Profile profile;


    public Frame() {

        setLayout(new BorderLayout());
        setJMenuBar(menuBar());

        controller = new Controller();

        table = new Table();

        profile = new Profile();
        profile.setBorder(new EmptyBorder(0, 20, 10, 20));

        table.setData(controller.getEmployee());

        table.setEmployeeTableListener(new EmployeeTableListener() {
            public void rowDeleted(int row) {
                controller.removeEmployee(row);

            }

        });

        JTable tableListener = table.getTable();
        tableListener.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                int row = tableListener.rowAtPoint(evt.getPoint());
                ArrayList<Employee> employees = (ArrayList<Employee>) controller.getEmployee();

                String getFirstName = employees.get(row).getFirstName();
                String getLastName = employees.get(row).getLastName();
                String getAddress = employees.get(row).getAddress();
                String getPosition = employees.get(row).getPosition();

                String imagePath = employees.get(row).getImgPath();
                String fullName = getFirstName.substring(0, 1).toUpperCase() + getFirstName.substring(1) + " " + getLastName.substring(0, 1).toUpperCase() + getLastName.substring(1);
                String gender = employees.get(row).getGender();
                String address = getAddress.substring(0, 1).toUpperCase() + getAddress.substring(1);
                String age = employees.get(row).getAge();
                String position = getPosition.substring(0, 1).toUpperCase() + getPosition.substring(1);
                String phoneNumber = employees.get(row).getPhoneNumber();
                int id = employees.get(row).getId();


                profile.setProfileData(id, imagePath, fullName, gender, address, age, position, phoneNumber);
            }
        });

        //Form
        formPanel = new FormPanel();
        //Table

        add(formPanel, BorderLayout.WEST);
        add(table, BorderLayout.CENTER);
        add(profile, BorderLayout.EAST);


        fileChooser = new JFileChooser();

        formPanel.setFormListener(new FormListener() {

            @Override
            public void formEventOccurred(FormEvent e) {
                controller.addEmployee(e);
                table.refresh();
            }
        });
        formPanel.setEditBtnResetClick(new EditBtnResetClick() {
            @Override
            public void resetClickEventOccurred() {
                formPanel.setClickTableRow(0);
            }
        });
        formPanel.setEditFormBtnListener(new EditFormBtnListener() {
            @Override
            public void editFormBtnListener(int id ,String firstName, String lastName, String gender, String address, String age, String position, String phoneNumber, String imgPath) {

                controller.editBtn(id,firstName, lastName, gender, address, age, position, phoneNumber, imgPath);

                try {
                    controller.connect();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(Frame.this, "Cannot connect to database.", "Database Connection Problem", JOptionPane.WARNING_MESSAGE);
                }

                try {

                    controller.update();

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                table.refresh();

                try {
                    controller.connect();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(Frame.this, "Cannot connect to database.", "Database Connection Problem", JOptionPane.WARNING_MESSAGE);
                }
                try {
                    controller.save();
                    controller.load();
                } catch (SQLException throwables) {
                    JOptionPane.showMessageDialog(Frame.this, "Unable to save in database", "Database Connection Problem", JOptionPane.WARNING_MESSAGE);
                }


            }

        });

        formPanel.setEditButtonListener(new EditButtonListener() {

            @Override
            public void editEventOccurred(int id) {

            }


        });

        table.setMouseListener(new MouseListener() {
            @Override
            public void mouseEventOccurred() {
                formPanel.setClickTableRow(table.getRowClick());
            }
        });


        formPanel.setButtonListener(new AddButtonListener() {

            @Override
            public void addEventOccurred() {
                try {
                    controller.connect();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(Frame.this, "Cannot connect to database.", "Database Connection Problem", JOptionPane.WARNING_MESSAGE);
                }
                try {
                    controller.save();
                } catch (SQLException throwables) {
                    JOptionPane.showMessageDialog(Frame.this, "Unable to save in database", "Database Connection Problem", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
        table.setRefreshButtonListener(new RefreshButtonListener() {
            @Override
            public void refreshButtonEventOccurred() {
                try {
                    controller.connect();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(Frame.this, "Cannot connect to database.", "Database Connection Problem", JOptionPane.WARNING_MESSAGE);
                }

                try {
                    controller.load();
                } catch (SQLException throwables) {
                    JOptionPane.showMessageDialog(Frame.this, "Unable to load from database.", "Database Connection Problem", JOptionPane.WARNING_MESSAGE);

                }
                table.refresh();
            }
        });
        table.setDeleteButtonListener(new DeleteButtonListener() {

            @Override
            public void deleteButtonListener(int id) {
                try {
                    controller.connect();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(Frame.this, "Cannot connect to database.", "Database Connection Problem", JOptionPane.WARNING_MESSAGE);
                }

                try {
                    controller.delete(id);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                table.refresh();
            }
        });

        table.setResetButtonListener(new ResetButtonListener() {
            @Override
            public void resetEventOccurred() {
                try {
                    controller.connect();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(Frame.this, "Cannot connect to database.", "Database Connection Problem", JOptionPane.WARNING_MESSAGE);
                }


                try {
                    controller.reset();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                table.refresh();
            }
        });




    }

    private ImageIcon menuItemIcon(String path, int width, int height) {
//
        //Icon in JMenuItem
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image image = icon.getImage();
        Image newImg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImg);
        return icon;
    }


    private JMenuBar menuBar() {

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.WHITE);

        //File Menu
        JMenu file = new JMenu("File");
        menuBar.add(file);
        //File Menu Item
        JMenuItem importImage = new JMenuItem("Import Image");


        //AddIcon
        ImageIcon importIcon = menuItemIcon("/Icons/importIcon.png", 20, 20);
        importImage.setIcon(importIcon);


        //Adding events in JMenuItem
        importImage.addActionListener(e -> {
            if (fileChooser.showSaveDialog(Frame.this) == JFileChooser.APPROVE_OPTION) {
                //Set image path in form picture field
                formPanel.setImagePath(String.valueOf(fileChooser.getSelectedFile()));
            }


        });

        file.add(importImage);
        file.setMnemonic(KeyEvent.VK_F);

        //Exit Menu Item
        JMenuItem exit = new JMenuItem("Exit");
        ImageIcon exitIcon = menuItemIcon("/Icons/exitIcon.png", 14, 14);
        exit.setIcon(exitIcon);
        file.addSeparator();


        exit.setMnemonic(KeyEvent.VK_X);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        file.add(exit);

        exit.addActionListener(e -> {
            int action = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Confirm Exit", JOptionPane.PLAIN_MESSAGE & JOptionPane.OK_CANCEL_OPTION);
            if (action == JOptionPane.OK_OPTION) {
                System.exit(0);
            }

        });

        return menuBar;

    }


}
