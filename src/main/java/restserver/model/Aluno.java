package restserver.model;


import restserver.helper.ValidationMessage;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Aluno extends ModelBase {

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Size(min = 3, max = 200, message = ValidationMessage.SIZE)
    private String nome;

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Size(min = 3, max = 50, message = ValidationMessage.SIZE)
    private String registroAcademico;

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Size(min = 3, max = 200, message = ValidationMessage.SIZE)
    private String email;

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Size(min = 3, max = 20, message = ValidationMessage.SIZE)
    private String fone;

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Size(min = 3, max = 20, message = ValidationMessage.SIZE)
    private String foneComercial;

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegistroAcademico() {
        return registroAcademico;
    }

    public void setRegistroAcademico(String registroAcademico) {
        this.registroAcademico = registroAcademico;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getFoneComercial() {
        return foneComercial;
    }

    public void setFoneComercial(String foneComercial) {
        this.foneComercial = foneComercial;
    }
}
