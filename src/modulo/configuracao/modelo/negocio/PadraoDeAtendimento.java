/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo.configuracao.modelo.negocio;

import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="padraodeatendimento", uniqueConstraints = {
    @UniqueConstraint(name="padraodeatendimento_uk", columnNames={"diadasemana_id", "horarioinicioexpediente", "horariofimexpediente"})
})
public class PadraoDeAtendimento implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "diadasemana_id", referencedColumnName = "id", nullable = false)
    private DiaDaSemana diaDaSemana;
    
    @Column(unique = true, nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private Time horarioInicioExpediente;
    
    @Column(nullable = false)
    private Time horarioFimExpediente;
    
    @Column(nullable = false)
    private int tempoMedioConsulta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DiaDaSemana getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Time getHorarioInicioExpediente() {
        return horarioInicioExpediente;
    }

    public void setHorarioInicioExpediente(Time horarioInicioExpediente) {
        this.horarioInicioExpediente = horarioInicioExpediente;
    }

    public Time getHorarioFimExpediente() {
        return horarioFimExpediente;
    }

    public void setHorarioFimExpediente(Time horarioFimExpediente) {
        this.horarioFimExpediente = horarioFimExpediente;
    }

    public int getTempoMedioConsulta() {
        return tempoMedioConsulta;
    }
    
    public void setTempoMedioConsulta(int tempoMedioConsulta) {
        this.tempoMedioConsulta = tempoMedioConsulta;
    }
    
    @Override
    public String toString(){
        return this.nome + " " + horarioInicioExpediente.toString() + " - " + horarioFimExpediente.toString();
    }
}
