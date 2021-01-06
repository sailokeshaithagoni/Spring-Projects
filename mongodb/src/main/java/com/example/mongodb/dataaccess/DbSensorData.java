package com.example.mongodb.dataaccess;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sensor_data")
public class DbSensorData {
    @Id
    @Column(name = "column_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int column_id;
    //	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Sensor_Id")
    public int Sensor_Id;

    @Column(name = "Sensor_Name")
    public String Sensor_Name;

    @Column(name = "Sensor_Data1")
    public String Sensor_Data1;

    @Column(name = "Sensor_Data2")
    public String Sensor_Data2;

    @Column(name = "Last_Updated")
    public Timestamp Last_Updated;

    //	public int getColumn_id() {
//		return column_id;
//	}
//	public void setColumn_id(int column_id) {
//		this.column_id = column_id;
//	}
    public int getSensor_Id() {
        return Sensor_Id;
    }
    public void setSensor_Id(int sensor_Id) {
        Sensor_Id = sensor_Id;
    }
    public String getSensor_Name() {
        return Sensor_Name;
    }
    public void setSensor_Name(String sensor_Name) {
        Sensor_Name = sensor_Name;
    }
    public String getSensor_Data1() {
        return Sensor_Data1;
    }
    public void setSensor_Data1(String sensor_Data1) {
        Sensor_Data1 = sensor_Data1;
    }
    public String getSensor_Data2() {
        return Sensor_Data2;
    }
    public void setSensor_Data2(String sensor_Data2) {
        Sensor_Data2 = sensor_Data2;
    }
    public Timestamp getLast_Updated() {
        return Last_Updated;
    }
    public void setLast_Updated(Timestamp last_Updated) {
        Last_Updated = last_Updated;
    }
}
