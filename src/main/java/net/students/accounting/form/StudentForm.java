package net.students.accounting.form;

import net.students.accounting.entity.Students;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentForm implements Serializable {
    private List<Students> items = new ArrayList<>();

    public StudentForm(List<Students> items){
        super();
        setItems(items);
    }

    public List<Students> getItems(){
        return items;
    }

    public void setItems(List<Students> items){
        this.items = items;
    }
}
