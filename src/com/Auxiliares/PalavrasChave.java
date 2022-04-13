
package com.Auxiliares;

public class PalavrasChave {

  private static final String CHAR   = "char";
  private static final String ELSE = "else";
  private static final String FALSE = "false";
  private static final String IF   = "if";
  private static final String STATIC = "static";
  private static final String VOID   = "void";
  private static final String WHILE = "while";

  // palavras reservadas do PASCAL
  private static final String APPEND = "append"; // abre um arquivo txt para escrever no final
  private static final String ARRAY = "array"; // nome para que eu possa acessar um intervalo de posições
  private static final String ASSIGN = "asign"; // cria uma associação entre uma variavel e um txt
  private static final String BEGIN = "begin"; // é onde vai o corpo do projeto
  private static final String CLOSE = "close";
  private static final String CONST = "const";
  private static final String DO = "do";
  private static final String END = "end";
  private static final String FUNCTION = "function";
  private static final String READ = "read";
  private static final String REAL = "real";
  private static final String RESET = "reset";
  private static final String THEN = "then";
  private static final String TO = "to";
  private static final String TYPE = "type";
  private static final String VAR = "var";
  private static final String UNTIL = "until";

  // operadores aritmeticos
  private static final String DIV = "div";
  private static final String MOD = "mod";

  // operadores relacionais do PASCAL
  private static final String IN = "in";

  // operadores lógicos do PASCAL
  private static final String AND = "and";
  private static final String OR = "or";
  private static final String NOT = "not";
  private static final String XOR = "xor";

  // funções aritmeticas do PASCAL
  private static final String ABS = "abs"; // elimina sinal de um numero
  private static final String ARCTAN = "arctan"; // ARCO TANGENTE arctan(0.5) traz 0.4636
  private static final String COS = "cos"; // cosseno em radianos. EX: cos(1.4) 0.16997
  private static final String EXP = "exp"; //Exponencial neperiano (e elevado a n) Ex: exp(4)
  private static final String FRAC = "frac"; // Retorna a parte fracionaria. Ex:frac(14.58) traz 0.58
  private static final String LN = "ln"; // Logaritmo neperiano. EX: ln(5)
  private static final String SIN = "sin"; //Seno EX: sin(0.5)
  private static final String SQR = "sqr"; //Quadrado de um numero. Ex: sqr(4) traz 16.
  private static final String SQRT = "sqrt"; //Raiz quadrada. Ex: sqrt(9) traz 3.

  public static boolean isPalavraChave(StringBuffer palavra) {

    String palavra1 = palavra.toString();
	
    if ( palavra1.equals(CHAR) || palavra1.equals(ELSE) || palavra1.equals(FALSE) || palavra1.equals(IF)
      || palavra1.equals(STATIC) || palavra1.equals(VOID) || palavra1.equals(WHILE) || palavra1.equals(AND) || palavra1.equals(NOT)
    || palavra1.equals(OR) || palavra1.equals(DIV) || palavra1.equals(MOD) || palavra1.equals(XOR)
    || palavra1.equals(ABS) || palavra1.equals(ARCTAN) || palavra1.equals(COS) || palavra1.equals(EXP) || palavra1.equals(FRAC) || palavra1.equals(LN) || palavra1.equals(SIN) || palavra1.equals(SQR) || palavra1.equals(SQRT)
    || palavra1.equals(IN) || palavra1.equals(APPEND) || palavra1.equals(ARRAY) || palavra1.equals(ASSIGN)
    || palavra1.equals(BEGIN) || palavra1.equals(CLOSE) || palavra1.equals(CONST) || palavra1.equals(DO)
    || palavra1.equals(END) || palavra1.equals(FUNCTION) || palavra1.equals(READ) || palavra1.equals(REAL)
    || palavra1.equals(RESET) || palavra1.equals(THEN) || palavra1.equals(TO) || palavra1.equals(TYPE)
    || palavra1.equals(VAR) || palavra1.equals(UNTIL)
    ) {
	
      return true;
  
    }	
	
    return false;
	
  }
	
  public static int tipoPalavraChave(StringBuffer palavra) {
		
    String palavra1 = palavra.toString();
    int resultado;
	
    if ( palavra1.equals(CHAR) ) {
    	
      resultado = Token.CHAR;
      
    } else if (palavra1.equals(ELSE)) {

      resultado = Token.ELSE;

    } else if (palavra1.equals(FALSE)) {
  
      resultado = Token.FALSE;

    } else if (palavra1.equals(IF)) {
  
      resultado = Token.IF;
  	
    } else if (palavra1.equals(STATIC)) {
        
      resultado = Token.STATIC;
    	
    } else if (palavra1.equals(VOID)) {
        
      resultado = Token.VOID;
    	
    } else if (palavra1.equals(AND)){
      resultado = Token.AND;
    } else if (palavra1.equals(NOT)){
      resultado = Token.NOT;
    } else if (palavra1.equals(OR)){
      resultado = Token.OR;
    } else if (palavra1.equals(DIV)){
      resultado = Token.DIVINTEIRA;
    } else if (palavra1.equals(MOD)){
      resultado = Token.MODRESTODIVISAO;
    } else if (palavra1.equals(XOR)){
      resultado = Token.OUEXCLUSIVO;
    } else if (palavra1.equals(ABS)){
      resultado = Token.ABS;
    } else if (palavra1.equals(ARCTAN)){
      resultado = Token.ARCTAN;
    } else if (palavra1.equals(COS)){
      resultado = Token.COS;
    } else if (palavra1.equals(EXP)){
      resultado = Token.EXP;
    } else if (palavra1.equals(FRAC)){
      resultado = Token.FRAC;
    } else if (palavra1.equals(LN)){
      resultado = Token.LN;
    } else if (palavra1.equals(SIN)){
      resultado = Token.SIN;
    } else if (palavra1.equals(SQR)){
      resultado = Token.SQR;
    } else if (palavra1.equals(SQRT)){
      resultado = Token.SQRT;
    }
    else if (palavra1.equals(IN)){
      resultado = Token.IN;
    } else if (palavra1.equals(APPEND)){
      resultado = Token.APPEND;
    } else if (palavra1.equals(ARRAY)){
      resultado = Token.ARRAY;
    } else if (palavra1.equals(ASSIGN)){
      resultado = Token.ASSIGN;
    } else if (palavra1.equals(BEGIN)){
      resultado = Token.BEGIN;
    } else if (palavra1.equals(CLOSE)){
      resultado = Token.CLOSE;
    } else if (palavra1.equals(CONST)){
      resultado = Token.CONST;
    } else if (palavra1.equals(DO)){
      resultado = Token.DO;
    } else if (palavra1.equals(END)){
      resultado = Token.END;
    } else if (palavra1.equals(FUNCTION)){
      resultado = Token.FUNCTION;
    } else if (palavra1.equals(READ)){
      resultado = Token.READ;
    } else if (palavra1.equals(REAL)){
      resultado = Token.REAL;
    } else if (palavra1.equals(RESET)){
      resultado = Token.RESET;
    } else if (palavra1.equals(THEN)){
      resultado = Token.THEN;
    } else if (palavra1.equals(TO)){
      resultado = Token.TO;
    } else if (palavra1.equals(TYPE)){
      resultado = Token.TYPE;
    } else if (palavra1.equals(VAR)){
      resultado = Token.VAR;
    } else if (palavra1.equals(UNTIL)){
      resultado = Token.UNTIL;
    }
    else {
      resultado = Token.WHILE;
    }
    return resultado;
  }

}
