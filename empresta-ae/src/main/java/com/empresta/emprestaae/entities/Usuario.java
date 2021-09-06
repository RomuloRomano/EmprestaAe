package com.empresta.emprestaae.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data //anotacao do lombok, getters, setters, hashcode and equals e to string
@Entity
@NoArgsConstructor // cria construtor sem parâmetros
@Table(name = "T_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nm_usuario", length = 80)
    private String nome;

    @Column(name = "ds_email", length = 80, unique = true)
    private String email;

    @Column(name = "ds_senha")
    private String senha;

    @Column(name = "ds_telefone", length = 13)
    private String telefone;

    @CreationTimestamp
    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dataCadastro;

    @OneToOne(mappedBy = "usuario")
    private Endereco endereco;

    @OneToMany(mappedBy = "emprestadoPor")
    private List<ItemEmprestimo> emprestimos = new ArrayList<>();

    @OneToMany(mappedBy = "emprestadoPara")
    private List<ItemEmprestimo> emprestados = new ArrayList<>();

    public Usuario(Long id, String nome, String email, String senha, Endereco endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
        this.telefone = telefone;
    }

}
