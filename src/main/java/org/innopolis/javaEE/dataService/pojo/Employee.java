package org.innopolis.javaEE.dataService.pojo;

public class Employee {
    public int id;
    public int numberOfInputs;
    public int numberOfOutputs;
    public Time meanInputTime;
    public Time meanOutputTime;

    public Employee(int id, int numberOfInputs, int numberOfOutputs, Time meanInputTime, Time meanOutputTime) {
        this.id = id;
        this.numberOfInputs = numberOfInputs;
        this.numberOfOutputs = numberOfOutputs;
        this.meanInputTime = meanInputTime;
        this.meanOutputTime = meanOutputTime;
    }

    public Employee() {
    }
}
