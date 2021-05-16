package View;

import Model.Employee;


import javax.swing.table.AbstractTableModel;
import java.util.EventListener;
import java.util.List;

public class TableModel extends AbstractTableModel {

    private List<Employee> db;

    String[] columnNames = {"ID","First Name","Last Name","Gender","Address","Age","Position","Image Path","Phone Number"};




    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }


    public void setData(List<Employee> db){
        this.db = db;

    }

    @Override
    public <T extends EventListener> T[] getListeners(Class<T> listenerType) {
        return super.getListeners(listenerType);
    }

    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee employee = db.get(rowIndex);

        switch (columnIndex){
            case 0 :
                return employee.getId();
            case 1:
                return employee.getFirstName();
            case 2:
                return employee.getLastName();
            case 3:
                return employee.getGender();
            case 4:
                return employee.getAddress();
            case 5:
                return employee.getAge();
            case 6:
                return employee.getPosition();
            case 7:
                return employee.getImgPath();
            case 8:
                return employee.getPhoneNumber();



        }
        return null;
    }
}
