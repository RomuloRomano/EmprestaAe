package com.empresta.emprestaae.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "T_ITEM_EMPRESTIMO")
public class ItemEmprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item_emprestimo")
    private Long id;

    @Column(name = "ds_descricao")
    private String descricao;

    @Column(name = "url_foto")
    private String urlFoto;

    @Column(name = "dt_dataEmprestimo", updatable = false)
    private LocalDateTime dataEmprestimo;

    @Column(name = "dt_dataDevolucao")
    private LocalDateTime dataDevolucao;

    @ManyToOne
    @JoinColumn(name = "emprestado_por")
    private Usuario emprestadoPor;

    @ManyToOne
    @JoinColumn(name = "emprestado_para")
    private Usuario emprestadoPara;

    public ItemEmprestimo(Long id, String descricao, String urlFoto, LocalDateTime dataEmprestimo, LocalDateTime dataDevolucao, Usuario emprestadoPor, Usuario emprestadoPara) {
        this.id = id;
        this.descricao = descricao;
        this.urlFoto = urlFoto;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.emprestadoPor = emprestadoPor;
        this.emprestadoPara = emprestadoPara;
    }
}
