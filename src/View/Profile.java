package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class Profile extends JPanel implements ActionListener {


    private final JLabel imageLabel;
    private final JLabel fullNameLabel;
    private final JLabel addressLabel;
    private final JLabel genderLabel;
    private final JLabel ageLabel;
    private final JLabel positionLabel;
    private final JLabel phoneNumberLabel;
    private final JLabel employeeIdNoLabel;

    private String image = "C:\\Users\\JIMBOY\\Desktop\\CRUD-in-JAVA\\src\\Icons\\icon-user-default.png";
    private String fullName;
    private String address;
    private String gender;
    private String age;
    private String position;
    private String phoneNumber;

    private Font f1 = new Font("Helvetica",Font.BOLD,14);



    public Profile() {

        imageLabel = new JLabel();
        fullNameLabel = new JLabel("Name: ");
        genderLabel = new JLabel("Gender: ");
        addressLabel = new JLabel("Address: ");
        ageLabel = new JLabel("Age: ");
        positionLabel = new JLabel("Position: ");
        phoneNumberLabel = new JLabel("Phone Number: ");
        employeeIdNoLabel = new JLabel("Employee No. ");

        ArrayList<JLabel> allInfoLabel = new ArrayList<>();
        Collections.addAll(allInfoLabel,fullNameLabel,genderLabel,employeeIdNoLabel,addressLabel,ageLabel,positionLabel,phoneNumberLabel);

        for(JLabel infoLabel:allInfoLabel){
            infoLabel.setForeground(Color.WHITE);
            infoLabel.setFont(f1);
        }


        setPreferredSize( new Dimension( 290, 400 ) );

        ArrayList<JLabel> labels = new ArrayList<>();
        Collections.addAll(labels,fullNameLabel,genderLabel,addressLabel,ageLabel,positionLabel,phoneNumberLabel);
        for(JLabel label:labels){
            label.setForeground(Color.WHITE);
        }

        setBackground(new Color(16, 56 ,108));
        //Layout
        setLayout(new GridBagLayout());

        String imageUrl = image;
        ImageIcon imgThisImg = new ImageIcon(imageUrl);

        imageLabel.setIcon(new ImageIcon(new ImageIcon(String.valueOf(imgThisImg)).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));

        layoutComponents();
    }
    private void layoutComponents() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.ipadx = 10;

        //////Row1
        constraints.gridy++;

        constraints.weightx = 0;

        constraints.fill = GridBagConstraints.NONE;

        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.FIRST_LINE_END;

        constraints.insets = new Insets(10, 0, 0, 5);
        add(imageLabel, constraints);

        //////Row2
        constraints.gridy++;
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.LAST_LINE_START;
        add(employeeIdNoLabel, constraints);


        //////Row2
        constraints.gridy++;
        constraints.weightx = 1;
        constraints.weighty = 0;

        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.LINE_START;


        add(fullNameLabel, constraints);

        //////Row3
        constraints.gridy++;
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(ageLabel, constraints);

        //////Row4
        constraints.gridy++;
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(addressLabel, constraints);

        //////Row5
        constraints.gridy++;
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(genderLabel, constraints);

        //////Row6
        constraints.gridy++;
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(positionLabel, constraints);

        //////Row7
        constraints.gridy++;
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        add(phoneNumberLabel, constraints);




    }

    public void setProfileData(int id, String image,String fullName,String gender,String address,String age,String position,String phoneNumber){

        if(image.endsWith("jfif") || image.endsWith("jpeg") || image.endsWith("jpg") || image.endsWith("gif") || image.endsWith("png") ) {
            this.image = image;
        }else{
            this.image = "C:\\Users\\JIMBOY\\Desktop\\CRUD-in-JAVA\\src\\Icons\\icon-user-default.png";
        }
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.age = age;
        this.position = position;
        this.phoneNumber = phoneNumber;

        employeeIdNoLabel.setText("Employee No. " + (id));
        fullNameLabel.setText("Name: " + fullName);
        genderLabel.setText("Gender: " + gender);
        addressLabel.setText("Address: " + address);
        ageLabel.setText("Age: " + age);
        positionLabel.setText("Position: " + position);
        phoneNumberLabel.setText("Phone Number: " + phoneNumber);


        ImageIcon imgThisImg = new ImageIcon(this.image.replace("\\","\\\\"));
        imageLabel.setIcon(new ImageIcon(new ImageIcon(String.valueOf(imgThisImg)).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
    }

    public void resetProfileData(){
        employeeIdNoLabel.setText("Employee No. ");
        fullNameLabel.setText("Name: ");
        genderLabel.setText("Gender: ");
        addressLabel.setText("Address: ");
        ageLabel.setText("Age: ");
        positionLabel.setText("Position: ");
        phoneNumberLabel.setText("Phone Number: ");

        this.image = "C:\\Users\\JIMBOY\\Desktop\\CRUD-in-JAVA\\src\\Icons\\icon-user-default.png";
        ImageIcon imgThisImg = new ImageIcon(this.image.replace("\\","\\\\"));
        imageLabel.setIcon(new ImageIcon(new ImageIcon(String.valueOf(imgThisImg)).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));

    }


    @Override
    public void actionPerformed(ActionEvent e) {




    }
}
