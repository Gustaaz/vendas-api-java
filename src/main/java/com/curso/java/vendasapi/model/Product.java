package com.curso.java.vendasapi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_produtos")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String descricao;
    @Column
    private String nome;
    @Column(precision = 16, scale = 2)
    private BigDecimal preco;
    @Column
    private String sku;
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    public Product() {
        super();
    }

    public Product(String descricao, String nome, BigDecimal preco, String sku) {
        super();
        this.descricao = descricao;
        this.nome = nome;
        this.preco = preco;
        this.sku = sku;
    }

    public Product(Long id, String descricao, String nome, BigDecimal preco, String sku) {
        super();
        this.id = id;
        this.descricao = descricao;
        this.nome = nome;
        this.preco = preco;
        this.sku = sku;
    }

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", descricao=" + descricao + ", nome=" + nome + ", preco=" + preco + ", sku=" + sku
                + "]";
    }

}
