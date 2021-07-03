package br.ufsc.lippe.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "pautaVideo")
public class PautaVideo {

	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "tema")
	private String tema;

	@Column(name = "descr")
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	@Override
	public String toString() {
		return "Pauta [id=" + id + ", descr=" + descricao
				+ ", tema=" + tema+ "]";
	}

	
}
