package br.com.cisbrasil.found.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Cost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    public int id;
    public String description;
    public ApprovalPhase approval;
    public Date sendDate;
    public Date dueDate;
    public boolean isPayed;
    public double value;
    public int invoiceNumber;

    @Override
    public String toString() {
        return "Cost{" +
                "ID=" + id +
                ", Descrição='" + description + '\'' +
                ", Aprovação=" + approval +
                ", Data de ENvio=" + sendDate +
                ", Data de Vencimentp=" + dueDate +
                ", FOi pago=" + isPayed +
                ", Valor=" + value +
                ", Número da NF=" + invoiceNumber +
                '}';
    }
}
