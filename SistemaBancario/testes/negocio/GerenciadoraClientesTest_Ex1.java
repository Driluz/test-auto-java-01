package negocio;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraClientesTest_Ex1 {

	@Test
	public void testPesquisaCliente() {
		
		//criando alguns clientes
		Cliente cliente01 = new Cliente (1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Cliente cliente02 = new Cliente (2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 1, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
	    Cliente cliente = gerClientes.pesquisaCliente(2);
		
		assertThat(cliente.getId(), is(2));
		assertThat(cliente.getEmail(), is("felipeaugusto@gmail.com"));
		assertThat(cliente.getIdade(), is(34));
		
	
	}

}
