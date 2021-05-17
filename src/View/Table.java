package View;

import Model.Employee;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Table extends JPanel  {
    private JTable table;
    private TableModel tableModel;
    private EmployeeTableListener employeeTableListener;
    private RefreshButtonListener refreshButtonListener;
    private DeleteButtonListener deleteButtonListener;
    private ResetButtonListener resetButtonListener;
    private EditButtonListener editButtonListener;


    private JButton deleteBtn;
    private JButton editBtn;
    private JButton reset;
    private JButton refresh;

    private boolean rowClick = false;


    public Table(){

        tableModel = new TableModel();
        table = new JTable(tableModel);
        setLayout(new BorderLayout());


        JScrollPane jsp = new JScrollPane(table);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.WHITE);
        panel2.setLayout(new FlowLayout());

        deleteBtn = new JButton("DELETE");
        deleteBtn.setBackground(new Color(217, 83, 79));
        deleteBtn.setForeground(Color.WHITE);
        deleteBtn.setPreferredSize(new Dimension(90,32));
        editBtn = new JButton("SAVE EDIT");
        editBtn.setPreferredSize(new Dimension(110,32));
        editBtn.setBackground(new Color(2, 117, 216));
        editBtn.setForeground(Color.WHITE);
        reset = new JButton("RESET");
        reset.setBackground(new Color(224,168,0));
        reset.setForeground(Color.WHITE);
        reset.setPreferredSize(new Dimension(90,32));
        refresh = new JButton("REFRESH");
        refresh.setBackground(new Color(23, 162, 184));
        refresh.setForeground(Color.WHITE);
        refresh.setPreferredSize(new Dimension(90,32));


        panel2.add(refresh);
        panel2.add(editBtn);
        panel2.add(deleteBtn);
        panel2.add(reset);

        refresh.addActionListener(e->{
            refreshButtonListener.refreshButtonEventOccurred();

        });


        deleteBtn.addActionListener(e -> {
            int row = table.getSelectedRow();

            int value = (int) tableModel.getValueAt(row,0);

            int action = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete?","Delete",JOptionPane.PLAIN_MESSAGE&JOptionPane.OK_CANCEL_OPTION);
            if(action == JOptionPane.OK_OPTION){
                deleteButtonListener.deleteButtonListener(value);
                if(row == -1) return;

                if(table.getRowCount() != 0){

                    if(employeeTableListener != null){
                        employeeTableListener.rowDeleted(row);
                        tableModel.fireTableRowsDeleted(row,row);
                    }

                };
            }

        });

        editBtn.addActionListener(e ->{
            int row = table.getSelectedRow();
            if(row == -1) return;
            editButtonListener.editEventOccurred(row+1);


        });

        reset.addActionListener(e->{
            resetButtonListener.resetEventOccurred();
            while(employeeTableListener!=null) {
                table.selectAll();
                int row = table.getSelectedRow();
               if(row == -1){
                   break;
               }
                if (employeeTableListener != null) {
                    employeeTableListener.rowDeleted(row);
                    tableModel.fireTableRowsDeleted(row, row);
                }
            }

        });



        add(panel2,BorderLayout.PAGE_END);
        add(jsp,BorderLayout.CENTER);

        jsp.getViewport().setBackground(new Color(226 ,232 ,246));


//        Mouse Listener
        table.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rowClick = true;
            }

        });


    }


    public boolean getRowClick(){
        return rowClick;
    }

    public JTable getTable(){
        return table;

    }

    public void setData(List<Employee> db){
        tableModel.setData(db);

    }


    public void refresh(){
        tableModel.fireTableDataChanged();
    }

    public void setEmployeeTableListener(EmployeeTableListener listener){
        this.employeeTableListener = listener;

    }

    public void setRefreshButtonListener(RefreshButtonListener refreshButtonListener){
        this.refreshButtonListener = refreshButtonListener;
    }

    public void setDeleteButtonListener(DeleteButtonListener deleteButtonListener){
        this.deleteButtonListener = deleteButtonListener;
    }

    public void setResetButtonListener(ResetButtonListener resetButtonListener){
        this.resetButtonListener = resetButtonListener;
    }
    public void setEditButtonListener(EditButtonListener editButtonListener){
        this.editButtonListener = editButtonListener;
    }



}
