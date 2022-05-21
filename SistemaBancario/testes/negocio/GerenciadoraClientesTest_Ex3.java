package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraClientesTest_Ex3 {

	private GerenciadoraClientes gerClientes;

	@Test
	public void testPesquisaCliente() {

		/* ========== Montagem do cenário ========== */
		
		// criando alguns clientes
		Cliente cliente01 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 1, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);

		/* ========== Execuçãp ========== */
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		/* ========== Verificões ========== */
		assertThat(cliente.getId(), is(1));
		
	}
	
	@Test
	public void testRemoveCliente() {

		/* ========== Montagem do cenário ========== */
		
		// criando alguns clientes
		Cliente cliente01 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 1, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		/* ========== Execuções ========== */
		boolean clienteRemovido = gerClientes.removeCliente(2);
		
		/* ========== Verificações ========== */
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(2));
		
	}
		
	    private GerenciadoraContas gerContas;
		@Test
		public void testTransferValor() {

			/* ========== Montagem do cenário ========== */
			
			// criando alguns clientes
			ContaCorrente conta01 = new ContaCorrente(1, 200, true);
			ContaCorrente conta02 = new ContaCorrente(2, 0, true);
			
			
			// inserindo os clientes criados na lista de clientes do banco
			List<ContaCorrente> contasDoBanco = new ArrayList<>();
			contasDoBanco.add(conta01);
			contasDoBanco.add(conta02);
			
			gerContas = new GerenciadoraContas(contasDoBanco);
			
			/* ========== Execuções ========== */
			gerContas.transfereValor (1,100,2);
			
			/* ========== Verificações ========== */
			assertThat(conta02.getSaldo(), is(100.0));	
			assertThat(conta01.getSaldo(), is(100.0));
	}
	
}
