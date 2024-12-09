package cl.fabioladiaz.sistemacliente.model;

import java.util.Date;

public class ErrorModel {

    private String messege;
    private String error;
    private Date date;
    private Integer status;

    public ErrorModel(String messege, String error, Date date, Integer status) {
        this.messege = messege;
        this.error = error;
        this.date = date;
        this.status = status;
    }

    public ErrorModel() {
    }

    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Error{" +
                "messege='" + messege + '\'' +
                ", error='" + error + '\'' +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
