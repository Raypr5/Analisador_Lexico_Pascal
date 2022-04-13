
package com.Auxiliares;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.Erro.LexerException;

public class AnalisadorLexico {

  // Atributos
	
  private BufferedReader reader;
  private int estado;
  private int buffer;
  private boolean bufferValid = false;

  public AnalisadorLexico(BufferedReader reader) {
		
	this.reader = reader;
	
  }
	
  public Token pegarProximoToken() throws IOException, LexerException {
			
	boolean feito = false; // aqui é para ele sair do while
	int tipoAtual = Token.EOF;
	Object valorAtual = null;
	StringBuffer sBuffer = null; // ele vai pegando aqui, caractere por caractere
	
	estado = 0; // estado começa em 0
	
	while ( !feito ) {
		
	  int caractere = pegardoBuffer(); // pega o caractere, uma string, ele vai começar a ler o arquivo
	  // o pegardoBuffer() faz isso, ele vai lendo o que tem no arquivo que foi passado, lá no main

	  if ( Character.isWhitespace(caractere) && tipoAtual == Token.EOF ) {
	    continue;
	  } else if ( caractere == -1 && tipoAtual == Token.EOF ) {
	    return Token.EOF();
	  }
	  switch (estado) {

		case 0: {
		  switch( caractere ) {
		    case '<': {
			  estado = 1;
			  tipoAtual = Token.RELOP;
			  valorAtual = new Integer( Token.LT );//less than
		    }
			break;
		    case '>': {
		      estado = 10;
		  	  tipoAtual = Token.RELOP;
		  	  valorAtual = new Integer( Token.GT );
		    }
			break;
		    case '=': {
			  estado = 4;
		      tipoAtual = Token.AT;
		      valorAtual = new Integer( Token.ATR );
		    }break;
			  // aqui é para ser a Atribuição do PASCAL
			  case ':': {
				  estado = 5;
				  tipoAtual = Token.AT;
				  valorAtual = new Integer( Token.ATR );
			  }break;
		    case '!': {
		      estado = 7;
		      tipoAtual = Token.LOG;
		      valorAtual = new Integer( Token.NOT );
		    }
			break;

			  case 'n' : {
				  estado = 33;
			  }
			  break;
		    case '+': {
		      tipoAtual = Token.OP;
		      valorAtual = new Integer( Token.AD );
		      feito = true;
		    }
			break;
		    case '-': {
		      tipoAtual = Token.OP;
			  valorAtual = new Integer( Token.SUB );
		      feito = true;
		    }
			break;
		    case '*': {
		      tipoAtual = Token.OP;
			  valorAtual = new Integer( Token.MUL );
			  feito = true;
		    }
			break;
		    case '/': {
		      estado = 24;
		    }
			break;
			  case 'm': {
				  estado = 11;
			  }break;
		    case '&': {
		      estado = 28;
		    }break;
			  case 'a' : {
				  estado = 30;
			  }break;
		    case '|': {
		      estado = 32;
		    }
			break;
			  case 'd': {
				  estado = 2;
			  }break;
			  case 'o': {
				  estado = 8;
			  }break;
			  case 'x': {
				  estado = 13;
			  }break;
			  case 'c': {
				  estado = 20;
			  }break;
			  case 'f': {
				  estado = 50;
			  }break;
			  case 'e': {
				  estado = 22;
			  }break;
			  case 'i': {
				  estado = 53;
			  }break;
			  case 'l': {
				  estado = 55;
			  }break;
			  case 's': {
				  estado = 56;
			  }break;
			  case 'b': {
				  estado = 70;
			  }break;
			  case 'r': {
				  estado = 85;
			  }break;
			  case 't': {
				  estado = 90;
			  }break;
			  case 'v': {
				  estado = 95;
			  }break;
			  case 'u': {
				  estado = 97;
			  }break;
		    case ',': {
			  tipoAtual = Token.PONTUACAO;
			  valorAtual = new Integer( Token.VG );
			  feito = true;
		    }
			break;
		    case ';': {
			  tipoAtual = Token.PONTUACAO;
			  valorAtual = new Integer( Token.PV );
			  feito = true;
		    }
			break;
		    case '(': {
			  tipoAtual = Token.PONTUACAO;
			  valorAtual = new Integer( Token.AP );
			  feito = true;
		    }break;
		    case ')': {
			  tipoAtual = Token.PONTUACAO;
			  valorAtual = new Integer( Token.FP );
			  feito = true;
		    }
			break;
		    case '{': {
			  tipoAtual = Token.PONTUACAO;
			  valorAtual = new Integer( Token.AC );
			  feito = true;
		    }
			break;
		    case '}': {
		      tipoAtual = Token.PONTUACAO;
			  valorAtual = new Integer( Token.FC );
			  feito = true;
		    }break;
			  case '[': {
				  tipoAtual = Token.PONTUACAO;
				  valorAtual = new Integer(Token.ABCOLCHETE);
				  feito = true;
			  }break;
			  case ']': {
				  tipoAtual = Token.PONTUACAO;
				  valorAtual = new Integer(Token.FECOLCHETE);
				  feito = true;
			  }break;
		    default:{
		      retoneparaBuffer( caractere );
		      estado = getProximoEstado();
		    }
		  }
		}
		break;
		case 1: {
		  if ( caractere == '=' ) {
		    valorAtual = new Integer( Token.LE );
			feito = true;
		  } else if ( caractere == '>'){
			  tipoAtual = Token.RELOP;
			  valorAtual = new Integer( Token.NE );
			  feito = true;
		  }

		  else {
		    retoneparaBuffer( caractere );
			feito = true;
		  }
		}break;

		  case 2: {
			  if (caractere == 'i'){
				  estado = 3;
			  } else if(caractere == 'o'){
				  tipoAtual = Token.RESERVADAS;
				  valorAtual = new Integer(Token.DO);
				  feito = true;
			  }
		  }break;
		  case 3: {
			  if (caractere == 'v'){
				  tipoAtual = Token.OP;
				  valorAtual = new Integer( Token.DIVINTEIRA);
				  // retoneparaBuffer( caractere );
				  feito = true;
			  }
		  }break;
		case 4: {
		  if ( caractere == '=' ) {
		    tipoAtual = Token.RELOP;
		    valorAtual = new Integer( Token.EQ );
		    feito = true;
		  } else {
		    retoneparaBuffer( caractere );
		    feito = true;
		  } 
		  
		}break;
		  // aqui é para ser a atribuição do PASCAL
		  case 5: {
			  if(caractere == '='){
				  tipoAtual = Token.AT;
				  valorAtual = new Integer(Token.ATR);
				  feito = true;
			  }else{
				  retoneparaBuffer(caractere);
				  feito = true;
			  }
		  }break;
		case 7: {
		  if ( caractere == '=' ) {
		    tipoAtual = Token.RELOP;  
			valorAtual = new Integer( Token.NE );
			feito = true;
		  } else {
		    retoneparaBuffer( caractere );
		    feito = true;
		  }
		}break;

		  case 8: {
			  if(caractere == 'r'){
				  tipoAtual = Token.LOG;
				  valorAtual = new Integer( Token.ORPASCAL );
				  feito = true;
			  }else{
				  retoneparaBuffer( caractere );
				  estado = getProximoEstado();
			  }
		  }break;
		case 10: {
			      
		  if ( caractere == '=' ) {
							
			valorAtual = new Integer( Token.GE );
			feito = true;
			
		  } else {
								
			retoneparaBuffer( caractere );
			feito = true;			
		  } 
			
		}break;
		  case 11: {
			  if(caractere == 'o'){
				  estado = 12;
			  }
		  }break;
		  case 12: {
			  if(caractere == 'd'){
				  tipoAtual = Token.OP;
				  valorAtual = new Integer( Token.MODRESTODIVISAO);
				  // retoneparaBuffer( caractere );
				  feito = true;
			  }
		  }break;

		  case 13 : {
			  if (caractere == 'o'){
				  estado = 14;
			  }
		  }break;
		  case 14 : {
			  if(caractere == 'r'){
				  tipoAtual = Token.LOG;
				  valorAtual = new Integer( Token.OUEXCLUSIVO);
				  feito = true;
			  }
		  }break;
		  case 15 : {
			  if(caractere == 's'){
				  tipoAtual = Token.ARITMETICO;
				  valorAtual = new Integer( Token.ABS);
				  feito = true;
			  }
		  }break;
		  case 16: {
			  if(caractere == 'c'){
				  estado = 17;
			  } else if(caractere == 'r'){
				  estado = 64;
			  }
		  }break;
		  case 17: {
			  if(caractere == 't'){
				  estado = 18;
			  }
		  }break;
		  case 18: {
			  if(caractere == 'a'){
				  estado = 19;
			  }
		  }break;
		  case 19: {
			  if(caractere == 'n'){
				  tipoAtual = Token.ARITMETICO;
				  valorAtual = new Integer( Token.ARCTAN);
				  feito = true;
			  }
		  }break;
		  case 20 : {
			  if(caractere == 'o'){
				  estado = 21;
			  } else if(caractere == 'l'){
				  estado = 74;
			  }
		  }break;
		  case 21: {
			  if(caractere == 's'){
				  tipoAtual = Token.ARITMETICO;
				  valorAtual = new Integer( Token.COS);
				  feito = true;
			  } else if(caractere == 'n'){
				  estado = 77;
			  }
		  }break;
		  case 22: {
			  if(caractere == 'x'){
				  estado = 23;
			  } else if( caractere == 'n'){
				  estado = 79;
			  }
		  }break;
		  case 23: {
			  if(caractere == 'p'){
				  tipoAtual = Token.ARITMETICO;
				  valorAtual = new Integer( Token.EXP);
				  feito = true;
			  }
		  }break;
		case 24: {
		  if( caractere == '/' ) {
			while( caractere != '\n' && caractere != -1 ) {
			  caractere = pegardoBuffer();
			}
			estado = 0;
		  } else if( caractere == '*' ) {
			caractere = pegardoBuffer();
		    while( caractere != '*' && caractere != -1 ) {
			  caractere = pegardoBuffer();
		    }
		    caractere = pegardoBuffer();
		    if( caractere != '/' ) {
		      estado = 24;
		    } else {
		      estado = 0;
		    }
		  } else {
            tipoAtual = Token.OP;
            valorAtual = new Integer( Token.DIV );
            
			retoneparaBuffer( caractere );
			feito = true;
			
		  }
	
		}break;

		case 28: {
		  if(caractere == '&') {
		    tipoAtual = Token.LOG;
		    valorAtual = new Integer( Token.E );
		    feito = true;
		  } else {
		    retoneparaBuffer( caractere );
		    estado = getProximoEstado();
		  }

		}break;
		
		case 29: {
			
		  if( caractere == '*' && pegardoBuffer() == '/' ) {
			  
		    valorAtual = sBuffer;
		    feito = true;
		    
		  } else {
			  
		    estado = 29;
		    
		    sBuffer.append( (char)caractere );
		    
		  }
		  
		}break;

		  case 30 : {
			  if (caractere == 'n'){
				  estado = 31;
			  } else if (caractere == 'b'){
				  estado = 15;
			  } else if (caractere == 'r'){
				  estado = 16;
			  } else if(caractere == 'p'){
				  estado = 60;
			  } else if(caractere == 's'){
				  estado = 66;
			  }
			  else {
				  estado = 35;
			  }
		  }break;
		  case 31 : {
			  if (caractere == 'd') {
				  tipoAtual = Token.LOG;
				  valorAtual = new Integer(Token.E);
				  feito = true;
			  } else {
				  retoneparaBuffer(caractere);
				  estado = getProximoEstado();
			  }
		  }break;
		case 32: {
			
		  if( caractere == '|' ) {
			   
		    tipoAtual = Token.LOG;
			valorAtual = new Integer( Token.OR );
			
		    feito = true;

		  } else {
			
		    retoneparaBuffer( caractere );
		    estado = getProximoEstado();
		 
		  }
	
		}break;

		  case 33 : {
			  if(caractere == 'o'){
				  estado = 34;
			  }else{
				  estado = 35;
			  }
		  }break;

		  case 34 : {
			  if(caractere == 't'){
				  tipoAtual = Token.LOG;
				  valorAtual = new Integer( Token.NOTPASCAL);
				  feito = true;
			  }
		  }break;
		case 35: {

		  if (Simbolos.isLetra(caractere) || caractere == '_') {
		    estado = 36;
		    tipoAtual = Token.ID;
			sBuffer = new StringBuffer();
			sBuffer.append( (char) caractere );
		  } else {
						
		    retoneparaBuffer( caractere );
			estado = getProximoEstado();
			
		  }

		}break;
				
		case 36: {
			
		  if ( Character.isLetterOrDigit( caractere ) || caractere == '_' ) {
					
			estado = 36;
			
			sBuffer.append( (char) caractere );
			
		  } else {
						
			retoneparaBuffer( caractere );
			
			if ( PalavrasChave.isPalavraChave( sBuffer) ) {
							    
			  tipoAtual = PalavrasChave.tipoPalavraChave( sBuffer );
			  valorAtual = null;
			
			} else {
							
			  valorAtual = sBuffer.toString();
			  
			}
			
			feito = true;
			
		  }

		}break;
		
		case 38: {
			
		  if ( Character.isDigit( caractere ) ) {
			    	
			estado = 39;
			
			tipoAtual = Token.LITERALNUMERICO;
			
			sBuffer = new StringBuffer();
			sBuffer.append( (char) caractere );
			
		  } else {
						
			retoneparaBuffer( caractere );
			estado = getProximoEstado();
			
		  }

		}break;
		
		case 39: {
		  
		  if ( Character.isDigit( caractere ) ) {
				
		    estado = 39;
			sBuffer.append( ( char) caractere );
			
		  }
		  /*else if(Character.isLetter(caractere)) {
			  throw new LexerException();
			  
		  }*/
		  else {

		    retoneparaBuffer( caractere );
			
		    valorAtual = new Integer( sBuffer.toString() );
			feito = true; 
			
		  }
	
		}break;
		
		case 41: {
			
		  if( caractere == '\'' ) {
			 
		    estado = 42;
		    
		    tipoAtual = Token.LITERALCHAR;
		    
		    sBuffer = new StringBuffer();
		    	
		  } else {
			  
		    retoneparaBuffer( caractere );
		    estado = getProximoEstado();
		    
		  }
		  
		}break;
		
		case 42: {
			
		  if( Simbolos.isLetraouDigito( caractere ) ) {
			  
		    estado = 44;
		    
		    sBuffer.append( (char) caractere );
		    
		  } else if ( caractere == '\\') {
				
		    estado = 43;
			
		    sBuffer.append( (char) caractere );
  
		  } else {
		
			retoneparaBuffer( caractere );
			 estado = getProximoEstado();
		  }
		  
		}break;
		
		case 43: {
			
		  if( caractere == 'r' || caractere == 'n' || caractere == 't' || caractere == '\\' ) {
			  
		    estado = 44;
		    
		    sBuffer.append( (char) caractere );
		    
		  } else {
			  
		    retoneparaBuffer( caractere );
		    estado = getProximoEstado();
		    
		  }
		  
		}break;
		
		case 44: {
			
		  if( caractere == '\'' ) {
			  
		    valorAtual = sBuffer;
		  
		    feito = true;
		    
		  } else {
			  
		    retoneparaBuffer( caractere );
		    estado = getProximoEstado();
		    
		  }
		  
		}break;
		
		case 46: {
			
	      if( caractere == '"' ) {
	    	
			estado = 47;
			
			tipoAtual = Token.LITERALSTRING;
			
			sBuffer = new StringBuffer();
			
	      } else {
					  
			retoneparaBuffer( caractere );
			
			estado = getProximoEstado();
			
	      }

		}break;
		
		case 47: {
			 
		  if( Simbolos.isLetraouDigito( caractere ) || caractere == ' ' ) {

			estado = 47;
			
			sBuffer.append( (char) caractere );
			
		  } else if( caractere == '\\' ){

			estado = 48;

			sBuffer.append( (char) caractere );
		    
		  } else {
				
		    retoneparaBuffer( caractere );
		    estado = 49;
	    
		  }
 
		}break;
		
		case 48: {

		  if( caractere == '\\' || caractere == 'r' || caractere == 't' || caractere == 'n' ) {

		    estado = 47;
		    
		    sBuffer.append( (char) caractere );
		    
		  } else {
			  
		    estado = getProximoEstado();
		    
		  }
		  
		}break;
		
		case 49: {
			
		  if( caractere == '"' ) {
			  
		    valorAtual = sBuffer;
		    feito = true;
		    
		  } else {
			
			retoneparaBuffer( caractere );
		    estado = getProximoEstado();
		    
		  }
		  
		}break;
		  case 50: {
			  if(caractere == 'r'){
				  estado = 51;
			  }else if(caractere == 'u'){
				  estado = 80;
			  }
		  }break;
		  case 51: {
			  if(caractere == 'a'){
				  estado = 52;
			  }
		  }break;
		  case 52: {
			  if(caractere == 'c'){
				  tipoAtual = Token.ARITMETICO;
				  valorAtual = new Integer( Token.FRAC);
				  feito = true;
			  }
		  }break;
		  case 53: {
			  if(caractere == 'n'){
				  tipoAtual = Token.RELOP;
				  valorAtual = new Integer( Token.IN);
				  feito = true;
			  }
		  }break;
		  case 55: {
			  if(caractere == 'n'){
				  tipoAtual = Token.ARITMETICO;
				  valorAtual = new Integer( Token.LN);
				  feito = true;
			  }
		  }break;
		  case 56: {
			  if(caractere == 'i'){
				  estado = 57;
			  } else if(caractere == 'q'){
				  estado = 58;
			  }
		  }break;
		  case 57: {
			  if(caractere == 'n'){
				  tipoAtual = Token.ARITMETICO;
				  valorAtual = new Integer( Token.SIN);
				  feito = true;
			  }
		  }break;
		  case 58: {
			  if(caractere == 'r'){
				  estado = 59;
				  tipoAtual = Token.ARITMETICO;
				  valorAtual = new Integer( Token.SQR);
			  }
		  }break;
		  case 59: {
			  if (caractere == 't') {
				  tipoAtual = Token.ARITMETICO;
				  valorAtual = new Integer(Token.SQRT);
				  feito = true;
				  break;
			  } else {
				  feito = true;
				  estado = 0;
			  }
		  }
		  case 60: {
			  if(caractere == 'p'){
				  estado = 61;
			  }
		  }break;
		  case 61: {
			  if(caractere == 'e'){
				  estado = 62;
			  }
		  }break;
		  case 62: {
			  if(caractere == 'n'){
				  estado = 63;
			  }
		  }break;
		  case 63: {
			  if(caractere == 'd'){
				  tipoAtual = Token.RESERVADAS;
				  valorAtual = new Integer(Token.APPEND);
				  feito = true;
			  }
		  }break;
		  case 64: {
			  if(caractere == 'a'){
				  estado = 65;
			  }
		  }break;
		  case 65: {
			  if(caractere == 'y'){
				  tipoAtual = Token.RESERVADAS;
				  valorAtual = new Integer(Token.ARRAY);
				  feito = true;
			  }
		  }break;
		  case 66: {
			  if(caractere == 's'){
				  estado = 67;
			  }
		  }break;
		  case 67: {
			  if(caractere == 'i'){
				  estado = 68;
			  }
		  }break;
		  case 68: {
			  if(caractere == 'g'){
				  estado = 69;
			  }
		  }break;
		  case 69: {
			  if(caractere == 'n'){
				  tipoAtual = Token.RESERVADAS;
				  valorAtual = new Integer(Token.ASSIGN);
				  feito = true;
			  }
		  }break;
		  case 70: {
			  if(caractere == 'e'){
				  estado = 71;
			  }
		  }break;
		  case 71: {
			  if(caractere == 'g'){
				  estado = 72;
			  }
		  }break;
		  case 72: {
			  if(caractere == 'i'){
				  estado = 73;
			  }
		  }break;
		  case 73: {
			  if(caractere == 'n'){
				  tipoAtual = Token.RESERVADAS;
				  valorAtual = new Integer(Token.BEGIN);
				  feito = true;
			  }
		  }break;
		  case 74: {
			  if(caractere == 'o'){
				  estado = 75;
			  }
		  }break;
		  case 75: {
			  if(caractere == 's'){
				  estado = 76;
			  }
		  }break;
		  case 76: {
			  if(caractere == 'e'){
				  tipoAtual = Token.RESERVADAS;
				  valorAtual = new Integer(Token.CLOSE);
				  feito = true;
			  }
		  }break;
		  case 77: {
			  if(caractere == 's'){
				  estado = 78;
			  }
		  }break;
		  case 78: {
			  if(caractere == 't'){
				  tipoAtual = Token.RESERVADAS;
				  valorAtual = new Integer(Token.CONST);
				  feito = true;
			  }
		  }break;
		  case 79: {
			  if(caractere == 'd'){
				  tipoAtual = Token.RESERVADAS;
				  valorAtual = new Integer(Token.END);
				  feito = true;
			  }
		  }break;
		  case 80: {
			  if(caractere == 'n'){
				  estado = 81;
			  }
		  }break;
		  case 81: {
			  if(caractere == 't'){
				  estado = 82;
			  }
		  }break;
		  case 82: {
			  if(caractere == 'i'){
				  estado = 83;
			  }
		  }break;
		  case 83: {
			  if(caractere == 'o'){
				  estado = 84;
			  }
		  }break;
		  case 84: {
			  if(caractere == 'n'){
				  tipoAtual = Token.RESERVADAS;
				  valorAtual = new Integer(Token.FUNCTION);
				  feito = true;
			  }
		  }break;
		  case 85: {
			  if(caractere == 'e'){
				  estado = 86;
			  }
		  }break;
		  case 86: {
			  if(caractere == 'a'){
				  estado = 87;
			  } else if(caractere == 's'){
				  estado = 88;
			  }
		  }break;
		  case 87: {
			  if(caractere == 'd'){
				  tipoAtual = Token.RESERVADAS;
				  valorAtual = new Integer(Token.READ);
				  feito = true;
			  } else if(caractere == 'l'){
				  tipoAtual = Token.RESERVADAS;
				  valorAtual = new Integer(Token.REAL);
				  feito = true;
			  }
		  }break;
		  case 88: {
			  if(caractere == 'e'){
				  estado = 89;
			  }
		  }break;
		  case 89: {
			  if(caractere == 't'){
				  tipoAtual = Token.RESERVADAS;
				  valorAtual = new Integer(Token.RESET);
				  feito = true;
			  }
		  }break;
		  case 90: {
			  if(caractere == 'h'){
				  estado = 91;
			  } else if(caractere == 'o'){
				  tipoAtual = Token.RESERVADAS;
				  valorAtual = new Integer(Token.TO);
				  feito = true;
			  } else if(caractere == 'y'){
				  estado = 93;
			  }
		  }break;
		  case 91: {
			  if(caractere == 'e'){
				  estado = 92;
			  }
		  }break;
		  case 92: {
			  if(caractere =='n'){
				  tipoAtual = Token.RESERVADAS;
				  valorAtual = new Integer(Token.THEN);
				  feito = true;
			  }
		  }break;
		  case 93: {
			  if(caractere == 'p'){
				  estado = 94;
			  }
		  }break;
		  case 94: {
			  if(caractere == 'e'){
				  tipoAtual = Token.RESERVADAS;
				  valorAtual = new Integer(Token.TYPE);
				  feito = true;
			  }
		  }break;
		  case 95: {
			  if(caractere == 'a'){
				  estado = 96;
			  }
		  }break;
		  case 96: {
			  if(caractere == 'r'){
				  tipoAtual = Token.RESERVADAS;
				  valorAtual = new Integer(Token.VAR);
				  feito = true;
			  }
		  }break;
		  case 97: {
			  if(caractere == 'n'){
				  estado = 98;
			  }
		  }break;
		  case 98: {
			  if(caractere == 't'){
				  estado = 99;
			  }
		  }break;
		  case 99: {
			  if(caractere == 'i'){
				  estado = 100;
			  }
		  }break;
		  case 100: {
			  if(caractere == 'l'){
				  tipoAtual = Token.RESERVADAS;
				  valorAtual = new Integer(Token.UNTIL);
				  feito = true;
			  }
		  }break;
		default: {
		  throw new Error("Estado nao esperado!!!");
		}
	  }
	}
	//System.out.println(estado);
	return new Token( tipoAtual, valorAtual );
  }
	
  private int pegardoBuffer() throws IOException {
			
	int result;
	
	if ( bufferValid ) {
	  result = buffer;
	  bufferValid = false;
	} else {
	  result = reader.read();
	  bufferValid = false;
	}
	return result;
  }
	
  private void retoneparaBuffer(int c) {
	if ( bufferValid ) {
	  throw new Error( "Buffer cheio!!" );
	}
	buffer = c;
	bufferValid = true;
  }
	
  private int getProximoEstado() throws LexerException {
			
	int resultado = 0;
	
	switch (estado) {
			
	  case 0: resultado = 35; break;
		
	  case 35: resultado = 38; break; 
		
	  case 38: resultado = 41; break; 
 
	  case 41: resultado = 46; break;
	  
	  default: throw new LexerException( "Erro Lexico: Impossível reconhecer token " );
		
	}
	
	return resultado;
	
  }

}
