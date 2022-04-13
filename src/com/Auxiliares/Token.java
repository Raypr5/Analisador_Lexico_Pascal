
package com.Auxiliares;

public class Token {
	
  // Constantes para tipos de token
	
  public static final int CHAR = 0;
  public static final int ELSE = 1;
  public static final int FALSE = 2;
  public static final int IF = 3;
  public static final int STATIC  = 9;
  public static final int VOID = 10;
  public static final int WHILE = 11;
  public static final int ID = 12;
  public static final int LITERALNUMERICO = 13;
  public static final int AT = 14;
  public static final int OP = 15;
  public static final int LOG = 16;
  public static final int RELOP = 17;
  public static final int LITERALSTRING  = 18;
  public static final int LITERALCHAR = 19;
  public static final int PONTUACAO = 20;

  // operadores logicos do PASCAL
  public static final int AND = 21;
  public static final int NOTPASCAL = 22;
  public static final int ORPASCAL = 23;
  public static final int OUEXCLUSIVO = 26;
  // operadores aritmeticos do PASCAL
  public static final int DIVINTEIRA = 24;
  public static final int MODRESTODIVISAO = 25;

  // operadores relacionais do PASCAL
    public static final int IN = 38;

  // função aritmeticas do PASCAL
    public static final int ARITMETICO = 27;
    public static final int ABS = 28;
    public static final int ARCTAN = 29;
    public static final int COS = 30;
    public static final int EXP = 31;
    public static final int FRAC = 32;
    public static final int INT = 33;
    public static final int LN = 34;
    public static final int SIN = 35;
    public static final int SQR = 36;
    public static final int SQRT = 37;

    // palavras reversadas do PASCAL
    public static final int RESERVADAS = 39;
    public static final int APPEND = 40;
    public static final int ARRAY = 41;
    public static final int ASSIGN = 42;
    public static final int BEGIN = 43;
    public static final int CLOSE = 44;
    public static final int CONST = 45;
    public static final int DO = 46;
    public static final int END = 47;
    public static final int FUNCTION = 48;
    public static final int READ = 49;
    public static final int REAL = 50;
    public static final int RESET = 51;
    public static final int THEN = 52;
    public static final int TO = 53;
    public static final int TYPE = 54;
    public static final int VAR = 55;
    public static final int UNTIL = 56;
    // Valor fim de Arquivo
  public static final int EOF   = 100;

  // Valores para tokens RELOP(< > <= >=  == )

  public static final int LT = 1;
  public static final int LE = 2;
  public static final int GT = 3;
  public static final int GE = 4;
  public static final int EQ = 5;
  public static final int NE = 6;

  // Valores para tokens AUX

  public static final int ATR = 1;
  
  // Valores para tokens OP

  public static final int AD = 1;
  public static final int SUB = 2;
  public static final int DIV = 3;
  public static final int MUL = 4;
  
  // Valores para tokens LOG

  public static final int E = 1;
  public static final int OR = 2;
  public static final int NOT = 3;

  // Valores para tokens PONTUACAO
	
  public static final int AP = 1; // Abrir parenteses
  public static final int FP = 2; // fechar parenteses
  public static final int AC = 3; // Abrir chave
  public static final int FC = 4; // fechar chave
  public static final int ABCOLCHETE = 7; // abrir colchete
  public static final int FECOLCHETE = 8; // fechar colchete
  public static final int PV = 5; // ponto
  public static final int VG = 6; // virgula
  
  // Atributos
  
  private int tipo;
  private Object valor;

  // Construtores

  public Token(int tipo, Object valor) {
		
    this.tipo = tipo;
    this.valor = valor;
  
  }

  public Token(int tipo) {
		
    this( tipo, null );
  
  }

  // Métodos para criar tokens

  public static Token EOF() {
	
    return new Token(EOF);
	
  }
  
  public int getTipo() {
	  
    return this.tipo;
    
  }

  public Object getValor() {
	  
    return this.valor;
	
  }

  public String toString()  {
	 
    String valorString = "-";

    switch( tipo ) {

        case RESERVADAS: valorString = tipoReservadas( (Integer) valor);
        break;

        case ARITMETICO: valorString = tipoAritmetico( (Integer) valor);
        break;
      case RELOP: valorString = tipoRelop( (Integer) valor);
          		   break;
    
      case AT: valorString = "ATR";
               break;
     
      case OP: valorString = tipoOP( (Integer) valor );
     		   break;
     
      case LOG: valorString = tipoLog( (Integer) valor );  
	            break;  
	
      case PONTUACAO: valorString = tipoPontuacao( (Integer) valor );  
                      break;

      default: {
	
	    if( valor != null ) {
		 
	      valorString = valor.toString().trim();
	   	  
	    }
	 
      }
	
    } 
   
    return "<" + tipoString() + ", " + valorString + ">";

  }

  private String tipoString() {
	 
    String resultado = "Erro";
	
      switch ( tipo ) {

          case RESERVADAS: resultado = "palavraReservada";
          break;

          case ARITMETICO: resultado = "funcaoAritmetica";
          break;
	    case CHAR: resultado = "char";
			       break;
	
	    case ELSE: resultado = "else";
			       break;
		
	    case FALSE: resultado = "falso";
				    break;
	 
	    case IF: resultado = "if";
	             break;

	    case STATIC: resultado = "static";
	                  break;			

	    case VOID: resultado = "void";
	  			   break;	
	  
	    case WHILE: resultado = "while";
	                break;			

	    case ID: resultado = "id";
	             break;			

	    case LITERALNUMERICO: resultado = "literalNumerico";
	    		              break;			

	    case LITERALSTRING: resultado = "literalString";
					        break;
	
	    case LITERALCHAR: resultado = "literalChar";
				          break;
	
	    case AT: resultado = "at";
	    		 break;			

	    case OP: resultado = "op";
	    	     break;		

	    case LOG: resultado = "log";
	    	      break;	
	   
	    case RELOP: resultado = "relop";
	    		    break;

	    case PONTUACAO: resultado = "pontuação";
	    	        break;
      }
	
      return resultado;

  }

  private String tipoReservadas(Integer valor){

      String resultado = "Erro";
      switch (valor.intValue()){

          case APPEND: resultado = "append";
          break;

          case ARRAY: resultado = "array";
          break;

          case ASSIGN: resultado = "assign";
          break;

          case BEGIN: resultado = "begin";
          break;

          case CLOSE: resultado = "close";
          break;

          case CONST: resultado = "const";
          break;

          case DO: resultado = "do";
          break;

          case END: resultado = "end";
          break;

          case FUNCTION: resultado = "function";
          break;

          case READ: resultado = "read";
          break;

          case REAL: resultado = "real";
          break;

          case RESET: resultado = "reset";
          break;

          case THEN: resultado = "then";
          break;

          case TO: resultado = "to";
          break;

          case TYPE: resultado = "type";
          break;

          case VAR: resultado = "var";
          break;

          case UNTIL: resultado = "until";
          break;
      }
      return resultado;
  }
    private String tipoAritmetico(Integer valor2) {

        String resultado = "Erro";

        switch ( valor2.intValue() ) {

            case ABS: resultado = "abs";
            break;

            case ARCTAN: resultado = "arctan";
            break;

            case COS: resultado = "cos";
            break;

            case EXP: resultado = "exp";
            break;

            case FRAC: resultado = "frac";
            break;

            case INT: resultado = "int";
            break;

            case LN: resultado = "ln";
            break;

            case SIN: resultado = "sin";
            break;

            case SQR: resultado = "sqr";
            break;

            case SQRT: resultado = "sqrt";
            break;
        }
        return resultado;
    }
  private String tipoRelop(Integer tipo1) {
		
    String resultado = "Erro";
	
    switch ( tipo1.intValue() ) {
		
      case LT: resultado = "LT";
			   break;
	
      case LE: resultado = "LE";
			   break;
	
      case GT: resultado = "GT";
			   break;
	
      case GE: resultado = "GE";
			   break;

      case EQ: resultado = "EQ";
			   break;
	
      case NE: resultado = "NE";
			   break;

        case IN: resultado = "IN";
        break;

    }
	
    return resultado;

  }	
 
  private String tipoOP(Integer tipo1) {
	 
    String resultado = "Erro";
   
    switch ( tipo1.intValue() ) {
	
      case AD: resultado = "+";
			   break;
	
      case SUB: resultado = "-";
			    break;
	
      case MUL: resultado = "*";
			    break;
	
      case DIV: resultado = "/";
			    break;

        case DIVINTEIRA: resultado = "divinteira";
        break;

        case MODRESTODIVISAO: resultado = "restoDivisao";
        break;
    }

    return resultado;

  }

  private String tipoLog(Integer tipo1) {
	 
    String resultado = "Erro";

    switch ( tipo1.intValue() ) {

      case E: resultado = "and";
		    	break;
	
      case OR: resultado = "or";
			   break;

      case NOT: resultado = "not";
			    break;

        case AND: resultado = "and";
        break;

        case NOTPASCAL: resultado = "not";
        break;

        case ORPASCAL: resultado = "or";
        break;

        case OUEXCLUSIVO: resultado = "xor";
        break;
   }

    return resultado;

  }
 
  private String tipoPontuacao(Integer valor2) {

    String resultado = "Erro";
	
    switch ( valor2.intValue() ) {
		
	  case AP: resultado = "(";
		       break;
	
	  case FP: resultado = ")";
			   break;
		
	  case AC: resultado = "{";
			   break;
		
	  case FC: resultado = "}";
			   break;

	  case PV: resultado = ";";
	           break;

	  case VG: resultado = ",";
	           break;

        case ABCOLCHETE: resultado = "[";
        break;

        case FECOLCHETE: resultado = "]";
        break;
    }
    return resultado;
  }

}
