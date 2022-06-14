 package br.com.sap.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;


@Entity
public class Cliente {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id_cliente")
		private Long idCliente;
		
		 
	    @NotBlank
	    @CPF(message = "CPF Inválido")
		@Column(name = "cpf" , nullable = false , length = 14)
		private String cpf;
		
	   
		@Column(name = "plano")
		private String plano;
		
		@Column(name = "status_plano")
		private boolean statusPlano;
		
		@Column(name = "dt_pagto")
		private Date dataPagamento;
		

		public Cliente() {
		}

		public String getPlano() {
			return plano;
		}

		public void setPlano(String plano) {
			this.plano = plano;
		}

		public Long getIdCliente() {
			return idCliente;
		}

		public void setIdCliente(Long idCliente) {
			this.idCliente = idCliente;
		}

		public boolean isStatusPlano() {
			return statusPlano;
		}

		public void setStatusPlano(boolean statusPlano) {
			this.statusPlano = statusPlano;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public Date getDataPagamento() {
			return dataPagamento;
		}

		public void setDataPagamento(Date dataPagamento) {
			this.dataPagamento = dataPagamento;
		}
		
}
