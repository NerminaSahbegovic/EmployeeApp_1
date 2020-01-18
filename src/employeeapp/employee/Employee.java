
package employeeapp.employee;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="employees")
public class Employee implements Serializable {
    
    @Id
    @Column(name="id")
    private int id;
    @Column(name="nameSurname")
    private String nameSurname;
    @Column(name="age")
    private int age;
    @Column(name="address")
    private String address;
    @Column(name="income")
    private int income;
    
    
    public int getId(){
    return id;
    }
    public void setId(int id){
    this.id = id;
    }
    public String getNameSurname(){
    return nameSurname;
    }
    public void setNameSurname(String nameSurname){
    this.nameSurname = nameSurname;
    }
    public int getAge(){
    return age;
    }
    public void setAge(int age){
    this.age = age;
    }
    public String getAddress(){
    return address;
    }
    public void setAddress(String address){
    this.address = address;
    }
    public int getIncome(){
    return income;
    }
    public void setIncome(int income){
    this.income = income;
    }
    
    public Employee(int id,String nameSurname,int age,String address,int income){
    this.id = id;
    this.nameSurname = nameSurname;
    this.age = age;
    this.address = address;
    this.income = income;
    }
    
    public Employee(){
    }
    
    @Override
    public String toString(){
    return id + "\t" + nameSurname + "\t" + age +"\t" + address + "\t" + income;
    }
}
