/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Faganello
 */
@Entity
@Table(name = "JOGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jogo.findAll", query = "SELECT j FROM Jogo j"),
    @NamedQuery(name = "Jogo.findByIdJogo", query = "SELECT j FROM Jogo j WHERE j.idJogo = :idJogo"),
    @NamedQuery(name = "Jogo.findByNome", query = "SELECT j FROM Jogo j WHERE j.nome = :nome"),
    @NamedQuery(name = "Jogo.findByProdutora", query = "SELECT j FROM Jogo j WHERE j.produtora = :produtora"),
    @NamedQuery(name = "Jogo.findByLancamento", query = "SELECT j FROM Jogo j WHERE j.lancamento = :lancamento"),
    @NamedQuery(name = "Jogo.findByDescricao", query = "SELECT j FROM Jogo j WHERE j.descricao = :descricao")})
public class Jogo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_JOGO")
    private Integer idJogo;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @Column(name = "PRODUTORA")
    private String produtora;
    @Basic(optional = false)
    @Column(name = "LANCAMENTO")
    private int lancamento;
    @Column(name = "DESCRICAO")
    private String descricao;
    @JoinTable(name = "MEMBROS_HAS_JOGO", joinColumns = {
        @JoinColumn(name = "ID_JOGO", referencedColumnName = "ID_JOGO")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_MEMBRO", referencedColumnName = "ID_MEMBRO")})
    @ManyToMany
    private List<Membro> membroList;
    @ManyToMany(mappedBy = "jogoList")
    private List<Genero> generoList;
    @OneToMany(mappedBy = "jogoIdJogo")
    private List<Noticia> noticiaList;

    public Jogo() {
    }

    public Jogo(Integer idJogo) {
        this.idJogo = idJogo;
    }

    public Jogo(Integer idJogo, String nome, String produtora, int lancamento) {
        this.idJogo = idJogo;
        this.nome = nome;
        this.produtora = produtora;
        this.lancamento = lancamento;
    }

    public Integer getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Integer idJogo) {
        this.idJogo = idJogo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    public int getLancamento() {
        return lancamento;
    }

    public void setLancamento(int lancamento) {
        this.lancamento = lancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Membro> getMembroList() {
        return membroList;
    }

    public void setMembroList(List<Membro> membroList) {
        this.membroList = membroList;
    }

    @XmlTransient
    public List<Genero> getGeneroList() {
        return generoList;
    }

    public void setGeneroList(List<Genero> generoList) {
        this.generoList = generoList;
    }

    @XmlTransient
    public List<Noticia> getNoticiaList() {
        return noticiaList;
    }

    public void setNoticiaList(List<Noticia> noticiaList) {
        this.noticiaList = noticiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJogo != null ? idJogo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jogo)) {
            return false;
        }
        Jogo other = (Jogo) object;
        if ((this.idJogo == null && other.idJogo != null) || (this.idJogo != null && !this.idJogo.equals(other.idJogo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.model.entities.Jogo[ idJogo=" + idJogo + " ]";
    }
    
}
