package View;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class FormPanel extends JPanel implements ActionListener {

    //FormListener
    FormListener formListener;

    //ButtonListener
    AddButtonListener addButtonListener;


    //Label
    private final JLabel firstNameLabel;
    private final JLabel lastNameLabel;
    private final JLabel genderLabel;
    private final JLabel addressLabel;
    private final JLabel ageLabel;
    private final JLabel positionLabel;
    private final JLabel pictureLabel;
    private final JLabel numberLabel;

    //TextField
    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField addressField;
    private final JTextField ageField;
    private final JTextField positionField;
    private final JTextField pictureField;
    private final JTextField numberField;

    //ButtonGroup
    private final ButtonGroup radioButtonGroup;

    //RadioButton
    private final JRadioButton maleRadio;
    private final JRadioButton femaleRadio;

    //Button
    private final JButton okBtn;


    public FormPanel() {


        setBackground(new Color(16, 56 ,108));

        //Label
        firstNameLabel = new JLabel("First Name: ");
        lastNameLabel = new JLabel("Last Name: ");
        genderLabel = new JLabel("Gender: ");
        addressLabel = new JLabel("Address: ");
        ageLabel = new JLabel("Age: ");
        positionLabel = new JLabel("Position: ");
        numberLabel = new JLabel("Number: ");
        pictureLabel = new JLabel("Picture: ");

        ArrayList<JLabel> allLabel = new ArrayList<>();
        Collections.addAll(allLabel,firstNameLabel,lastNameLabel,genderLabel,addressLabel,ageLabel,positionLabel,numberLabel,pictureLabel);
        //Font
        Font f1 = new Font("Helvetica", Font.BOLD, 15);
        for(JLabel label: allLabel ){
            label.setForeground(Color.WHITE);
            label.setFont(f1);
        }

        setPreferredSize(new Dimension(250,500));

        //TextField
        firstNameField = new JTextField(10);
        lastNameField = new JTextField(10);
        addressField = new JTextField(10);
        ageField = new JTextField(10);
        positionField = new JTextField(10);
        numberField = new JTextField(10);
        pictureField = new JTextField(10);


        //RadioButton
        maleRadio = new JRadioButton("Male");
        maleRadio.setActionCommand("Male");
        maleRadio.setSelected(true);
        femaleRadio = new JRadioButton("Female");
        femaleRadio.setActionCommand("Female");

        //ButtonGroup
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(maleRadio);
        radioButtonGroup.add(femaleRadio);


        //Button
        okBtn = new JButton("ADD");
        okBtn.setPreferredSize(new Dimension(90,32));
        okBtn.setBackground(Color.WHITE);
        okBtn.setForeground(Color.DARK_GRAY);

        //EventListener Button
        okBtn.addActionListener(this);

        //Layout
        setLayout(new GridBagLayout());

        TitledBorder innerBorder = BorderFactory.createTitledBorder("Employee's Form");
        innerBorder.setTitleJustification(TitledBorder.CENTER);
        innerBorder.setTitleColor(Color.WHITE);
        innerBorder.setTitleFont(f1);

        Border outerBorder = BorderFactory.createLoweredBevelBorder();
        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));

        layoutComponents();

    }
  private void layoutComponents(){
    GridBagConstraints constraints = new GridBagConstraints();

    //////Row1
      constraints.gridy = 0;

      constraints.weightx = 0;
      constraints.weighty = 0;

      constraints.fill = GridBagConstraints.NONE;

      constraints.gridx = 0;
      constraints.anchor = GridBagConstraints.LINE_END;
      constraints.insets = new Insets(40,0,0,5);
      add(firstNameLabel,constraints);

      constraints.gridx = 1;
      constraints.anchor = GridBagConstraints.LINE_START;
      add(firstNameField,constraints);

      //////Row2
      constraints.gridy++;


      constraints.weightx = 1;
      constraints.weighty = 0;


      constraints.gridx = 0;
      constraints.anchor = GridBagConstraints.LINE_END;
      constraints.insets = new Insets(10,0,0,5);
      add(lastNameLabel,constraints);

      constraints.gridy = 1;
      constraints.gridx = 1;
      constraints.anchor = GridBagConstraints.LINE_START;
      add(lastNameField,constraints);

      //////Row3
      constraints.gridy++;


      constraints.weightx = 1;
      constraints.weighty = 0;


      constraints.gridx = 0;
      constraints.anchor = GridBagConstraints.LINE_END;
      constraints.insets = new Insets(10,0,0,5);
      add(genderLabel,constraints);

      constraints.gridx = 1;
      constraints.anchor = GridBagConstraints.LINE_START;
      add(maleRadio,constraints);


    //////Row4
      constraints.gridy++;


      constraints.weightx = 1;
      constraints.weighty = 0;

      constraints.gridx = 1;
      constraints.anchor = GridBagConstraints.LINE_START;
      add(femaleRadio,constraints);

      //////Row5
      constraints.gridy++;


      constraints.weightx = 1;
      constraints.weighty = 0;


      constraints.gridx = 0;
      constraints.anchor = GridBagConstraints.LINE_END;
      constraints.insets = new Insets(10,0,0,5);
      add(addressLabel,constraints);

      constraints.gridx = 1;
      constraints.anchor = GridBagConstraints.LINE_START;
      add(addressField,constraints);

      //////Row6
      constraints.gridy++;


      constraints.weightx = 1;
      constraints.weighty = 0;


      constraints.gridx = 0;
      constraints.anchor = GridBagConstraints.LINE_END;
      constraints.insets = new Insets(10,0,0,5);
      add(ageLabel,constraints);

      constraints.gridx = 1;
      constraints.anchor = GridBagConstraints.LINE_START;
      add(ageField,constraints);

      //////Row7
      constraints.gridy++;


      constraints.weightx = 1;
      constraints.weighty = 0;


      constraints.gridx = 0;
      constraints.anchor = GridBagConstraints.LINE_END;
      constraints.insets = new Insets(10,0,0,5);
      add(positionLabel,constraints);

      constraints.gridx = 1;
      constraints.anchor = GridBagConstraints.LINE_START;
      add(positionField,constraints);

      //////Row8
      constraints.gridy++;


      constraints.weightx = 1;
      constraints.weighty = 0;


      constraints.gridx = 0;
      constraints.anchor = GridBagConstraints.LINE_END;
      constraints.insets = new Insets(10,0,0,5);
      add(numberLabel,constraints);

      constraints.gridx = 1;
      constraints.anchor = GridBagConstraints.LINE_START;
      add(numberField,constraints);

      //////Row9
      constraints.gridy++;


      constraints.weightx = 1;
      constraints.weighty = 0;


      constraints.gridx = 0;
      constraints.anchor = GridBagConstraints.LINE_END;
      constraints.insets = new Insets(10,0,0,5);
      add(pictureLabel,constraints);

      constraints.gridx = 1;
      constraints.anchor = GridBagConstraints.LINE_START;
      add(pictureField,constraints);

      //////Row10
      constraints.gridy++;


      constraints.weightx = 1;
      constraints.weighty = 0.2;


      constraints.gridx = 1;
      constraints.anchor = GridBagConstraints.FIRST_LINE_START;
      constraints.insets = new Insets(20,0,0,5);
      add(okBtn,constraints);




  }
  public void setImagePath(String imagePath){
        pictureField.setText(imagePath);
  }
  public void setFormListener(FormListener listener){
        this.formListener = listener;
  }

    @Override
    public void actionPerformed(ActionEvent e) {

        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String address = addressField.getText();
        String ageText = ageField.getText();
        String position = positionField.getText();
        String phoneNumberText = numberField.getText();
        String picture = pictureField.getText();
        String gender = radioButtonGroup.getSelection().getActionCommand();


        ArrayList<String> form = new ArrayList<>();
        Collections.addAll(form,firstName,lastName,address,ageText,position,phoneNumberText,picture,gender);

        String errorMessage = "";

        int age = 0;
        long phoneNumber = 0;

            try{
                 age = Integer.parseInt(ageText);

            }catch (NumberFormatException error){
                errorMessage += "*Age must be a number!\n";

            }

            try{
            phoneNumber = Integer.parseInt(phoneNumberText);

            }catch (NumberFormatException error){
            errorMessage += "*Number must be a number!\n";

            }


        for(int i = 0; i<form.size();i++){
            if (form.get(i).equals("")) {
                if (i == 0) {
                    errorMessage += "*First Name must have a value.\n";
                }
                if (i == 1) {
                    errorMessage += "*Last Name must have a value.\n";

                }
                if (i == 2) {
                    errorMessage += "*Address must have a value.\n";

                }
                if (i == 3) {
                    errorMessage += "*Age must have a value.\n";

                }
                if (i == 4) {
                    errorMessage += "*Position must have a value.\n";
                }
                if (i == 5) {
                    errorMessage += "*Phone Number must have a value.\n";

                }
                if (i == 6) {
                    errorMessage += "*Picture must have a value.\n";

                }
                if (i == 7) {
                    errorMessage += "*Gender must have a value.\n";

                }   
            }

        }


        if(errorMessage.equals("")){
            FormEvent formEvent = new FormEvent(this,firstName,lastName,gender,address,String.valueOf(age),position,picture,String.valueOf(phoneNumber));

            firstNameField.setText("");
            lastNameField.setText("");
            ageField.setText("");
            addressField.setText("");
            positionField.setText("");
            numberField.setText("");
            pictureField.setText("");



            JOptionPane.showMessageDialog(null,"Successfully Added");


            if(formListener != null){
                formListener.formEventOccurred(formEvent);
            }

            addButtonListener.addEventOccurred();

        }else{

            JOptionPane.showMessageDialog(null,"Please check again.\n"+errorMessage,"Warning",JOptionPane.ERROR_MESSAGE);

        }



    }

    public void setButtonListener(AddButtonListener addButtonListener){
        this.addButtonListener = addButtonListener;

    }





}