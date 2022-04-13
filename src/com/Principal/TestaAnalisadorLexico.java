
package com.Principal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.Auxiliares.AnalisadorLexico;
import com.Auxiliares.Token;

public class TestaAnalisadorLexico {

  public static void main(String[] args)  {
		
	BufferedReader bufferedReader;
	AnalisadorLexico analisadorLexico;
	Token token;

	
    System.out.println( "Analise Lexica: \n" );
	
    try {
		
      bufferedReader = new BufferedReader( new InputStreamReader( new FileInputStream( "Programa.lex" ) ) );
	  // nesse buffered, ele l� o arquivo txt, ele tem acesso agora a todas as linhas dele.

      analisadorLexico = new AnalisadorLexico( bufferedReader );
      // aqui no analisador, ele vai receber o buffered(que � o arquivo txt) e come�ar a ler ele

	  token = analisadorLexico.pegarProximoToken(); // aqui � o token


	  while ( token.getTipo() != Token.EOF ) {
				
	    System.out.println( "Token: " + token );
		
	    token = analisadorLexico.pegarProximoToken();
		
	  }
		
    }
	
    catch (Exception e) {
		
      System.err.println( "Exce��o: " + e.getMessage() );
    	
    }
	
  }

}