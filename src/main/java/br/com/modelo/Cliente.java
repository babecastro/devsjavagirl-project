package br.com.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;import javax.swing.undo.CannotUndoException;

public class Cliente {

    private Long id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;

    // TODO Analisar se deve utilizar uma Collection ou um SET.
    private Collection<Conta> contas = new ArrayList<>();

    public void setId(Long id){
        this.id = id;
    }
    public void setNome(String Nome){
        this.nome = nome;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    public Long getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }
    public String getEmail(){
        return this.email;
    }
    public LocalDate getDataNascimento(){
        return this.dataNascimento;
    }

    public Conta getContaPorTipo(TipoConta tipo){
        for (Conta c : contas){
            if (c.getTipoConta() == tipo){
                return c;
            } else {
                System.out.println("Conta existe, digite uma nova ");
            }
        }
        return null;
    }
    private void setConta(Conta conta) {
        this.contas.add(conta);
    }

    public void addConta(final Conta conta) {
        // TODO verificar se o cliente já tem uma conta para o mesmo tipo, se tiver lança uma exceção

        if(getContaPorTipo(conta.getTipoConta())!= null){
            new IllegalArgumentException();
        } else {
            this.setConta(conta);
        }
    }


}
