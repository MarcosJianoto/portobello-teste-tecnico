package com.testtechportobello.mensageria;

import org.springframework.stereotype.Service;

@Service
public class FakeMensageriaService implements MensageriaService {

	@Override
	public void enviarMensagem(String conteudo) {

		System.out.println("[FAKE RABBITMQ] Mensagem enviada: " + conteudo);
	}

}
