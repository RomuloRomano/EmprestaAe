package com.empresta.emprestaae.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity //define a classe como uma entidade do banco de dados
@NoArgsConstructor
@Table(name = "T_ENDERECO")

public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco", updatable = false)
    private Long id;

    @Column(name = "ds_logradouro", length = 80)
    private String logradouro;

    @Column(name = "ds_numero", length = 5)
    private String numero;

    @Column(name = "ds_bairro", length = 30)
    private String bairro;

    @Column(name = "ds_cidade", length = 40)
    private String cidade;

    @Column(name = "ds_estado", length = 40)
    private String estado;

    @Column(name = "ds_cep", length = 8)
    private String CEP;

    @Column(name = "ds_complemento", length = 100)
    private String complemento;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Endereco(Long id, String logradouro, String numero, String bairro, String cidade, String estado, String CEP, String complemento, Usuario usuario) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.CEP = CEP;
        this.complemento = complemento;
        this.usuario = usuario;
    }
}
