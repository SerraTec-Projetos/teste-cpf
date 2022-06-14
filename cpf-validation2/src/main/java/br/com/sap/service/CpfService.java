package br.com.sap.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.sap.exception.CpfException;
import br.com.sap.repository.ClienteRepository;

@Service
public class CpfService {

	  	@Autowired
	    private ClienteRepository clienteRepository;
	 
	  	public String validarId (String cpf) {
			    LocalDateTime firstDate = LocalDateTime.now();
			    Date date1 = Date.from(firstDate.atZone(ZoneId.systemDefault()).toInstant());
		        TimeUnit time = TimeUnit.DAYS; 
		    
		        	if(clienteRepository.findByCpf(cpf) != null) {
		        		Date secondDate = (clienteRepository.findByCpf(cpf).getDataPagamento());
			        	long diff = date1.getTime() - secondDate.getTime() ;
			        	long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
			        	
				        if (diffrence > 30) {
				        	return (date1 + " PLANO INATIVO!");
				        	
				        }else if(diffrence <= 30) {
				        	return (date1 + " PLANO ATIVO!");
				        }
		        	}
		        	 throw new CpfException("CPF NÃO ENCONTRADO OU NÃO EXISTE!");
		}

}
