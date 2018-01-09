package gctraveltools.jsj.com.cn.servers1.bean;

import com.google.gson.annotations.SerializedName;

/**
 * -------- 日期 ---------- 维护人 ------------ 变更内容 --------
 * 2017/11/22	11:51	    刘泽			    新增 类
 * 2017/11/22	11:51	    刘泽			    增加yyy属性
 */

public class SkyTrainFlightBean {
    /**
     * AirlineCode : MU
     * AirlineName : 东航
     * ArrivalAirportName : 上海虹桥机场T2
     * ArrivalCity : 上海
     * ArrivalCode : SHA
     * ArrivalTerminal : T2
     * ArrivalTime : 1511489700
     * DepartureAirportName : 北京首都机场T2
     * DepartureCity : 北京
     * DepartureCode : PEK
     * DepartureTerminal : T2
     * DepartureTime : 1511481600
     * FlightStatus : 计划
     * FlightStatusCode : 0
     * Status : 0
     * <p>
     * TrainCode  火车票车次 G101
     */

    @SerializedName("AirlineCode")
    private String AirlineCode;
    @SerializedName("AirlineName")
    private String AirlineName;
    @SerializedName(value = "ArrivalAirportName", alternate = {"ArrivalStationName"})
    private String ArrivalAirportName;
    @SerializedName("ArrivalCity")
    private String ArrivalCity;
    @SerializedName("ArrivalCode")
    private String ArrivalCode;
    @SerializedName("ArrivalTerminal")
    private String ArrivalTerminal;
    @SerializedName("ArrivalTime")
    private int ArrivalTime;
    @SerializedName(value = "DepartureAirportName", alternate = {"DepartureStationName"})
    private String DepartureAirportName;
    @SerializedName("DepartureCity")
    private String DepartureCity;
    @SerializedName("DepartureCode")
    private String DepartureCode;
    @SerializedName("DepartureTerminal")
    private String DepartureTerminal;
    @SerializedName("DepartureTime")
    private int DepartureTime;
    @SerializedName("FlightStatus")
    private String FlightStatus;
    @SerializedName("FlightStatusCode")
    private int FlightStatusCode;
    @SerializedName("Status")
    private int Status;
    @SerializedName("StatusName")
    private int StatusName;
    @SerializedName("TrainCode")
    private String TrainCode;

    public void setAirlineCode(String AirlineCode) {
        this.AirlineCode = AirlineCode;
    }

    public void setAirlineName(String AirlineName) {
        this.AirlineName = AirlineName;
    }

    public void setArrivalAirportName(String ArrivalAirportName) {
        this.ArrivalAirportName = ArrivalAirportName;
    }

    public void setArrivalCity(String ArrivalCity) {
        this.ArrivalCity = ArrivalCity;
    }

    public void setArrivalCode(String ArrivalCode) {
        this.ArrivalCode = ArrivalCode;
    }

    public void setArrivalTerminal(String ArrivalTerminal) {
        this.ArrivalTerminal = ArrivalTerminal;
    }

    public void setArrivalTime(int ArrivalTime) {
        this.ArrivalTime = ArrivalTime;
    }

    public void setDepartureAirportName(String DepartureAirportName) {
        this.DepartureAirportName = DepartureAirportName;
    }

    public void setDepartureCity(String DepartureCity) {
        this.DepartureCity = DepartureCity;
    }

    public void setDepartureCode(String DepartureCode) {
        this.DepartureCode = DepartureCode;
    }

    public void setDepartureTerminal(String DepartureTerminal) {
        this.DepartureTerminal = DepartureTerminal;
    }

    public void setDepartureTime(int DepartureTime) {
        this.DepartureTime = DepartureTime;
    }

    public void setFlightStatus(String FlightStatus) {
        this.FlightStatus = FlightStatus;
    }

    public void setFlightStatusCode(int FlightStatusCode) {
        this.FlightStatusCode = FlightStatusCode;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getAirlineCode() {
        return AirlineCode;
    }

    public String getAirlineName() {
        return AirlineName;
    }

    public String getArrivalAirportName() {
        return ArrivalAirportName;
    }

    public String getArrivalCity() {
        return ArrivalCity;
    }

    public String getArrivalCode() {
        return ArrivalCode;
    }

    public String getArrivalTerminal() {
        return ArrivalTerminal;
    }

    public int getArrivalTime() {
        return ArrivalTime;
    }

    public String getDepartureAirportName() {
        return DepartureAirportName;
    }

    public String getDepartureCity() {
        return DepartureCity;
    }

    public String getDepartureCode() {
        return DepartureCode;
    }

    public String getDepartureTerminal() {
        return DepartureTerminal;
    }

    public int getDepartureTime() {
        return DepartureTime;
    }

    public String getFlightStatus() {
        return FlightStatus;
    }

    public int getFlightStatusCode() {
        return FlightStatusCode;
    }

    public int getStatus() {
        return Status;
    }

    public int getStatusName() {
        return StatusName;
    }

    public void setStatusName(int statusName) {
        StatusName = statusName;
    }

    public String getTrainCode() {
        return TrainCode;
    }

    public void setTrainCode(String trainCode) {
        TrainCode = trainCode;
    }
}
