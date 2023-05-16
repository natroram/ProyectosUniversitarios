#Nombre:
#Matrícula:
#Nro Grupo:

import ply.lex as lexico

reservadas = {"class":"CLASS", "def":"DEF", "end":"END", "begin":"BEGIN", "print":"PRINT", "and":"AND", "or":"OR", "true":"TRUE", "false":"FALSE", "not":"NOT"}

tokens = ("MAS", "MENOS", "DIV", "MULTIPLICACION", "MODULO", 
          "MENOR_QUE", "MAYOR_IGUAL",
         "IGUAL", "PAR_I", "PAR_D",
         "NOMBRE_CLASE", "MAYOR_QUE", "MENOR_IGUAL", "ENTERO", "DECIMAL", "CORCHETE_D", "CORCHETE_I", "LLAVE_D", "LLAVE_I", "AND_OP", "OR_OP", "CADENA", "VARIABLE", "LLAMA_FUNCION", "SEPARADOR", "NEGACION", "COMA", "ARROBA", "ASIGNACION_HASH") + tuple(reservadas.values())

#Definir expresiones regulares
t_MAS = r'\+'
t_MENOS = r'-'
t_MULTIPLICACION= r'\*'
t_DIV= r'/'
t_MODULO = r'%'
t_PAR_D = r'\)'
t_PAR_I = r'\('
t_IGUAL = r'='
t_MENOR_QUE = r'<'
t_MAYOR_IGUAL = r'>='
t_ignore = " \t"
t_MAYOR_QUE = r'>'
t_MENOR_IGUAL = r'<='
t_ENTERO = r'[0-9]+'
t_DECIMAL = r'[0-9]+\.[0-9]+'
t_CORCHETE_D = r'\]'
t_CORCHETE_I = r'\['
t_LLAVE_D = r'\}'
t_LLAVE_I = r'\{'
t_AND_OP = r'\&\&'
t_OR_OP = r'\|\|'
t_NEGACION = r'!'
t_LLAMA_FUNCION = r'\.'
t_SEPARADOR = r'\n'
t_COMA = r','
t_ARROBA = r'@'
t_ASIGNACION_HASH = r'=>'

def t_NOMBRE_CLASE(t):
  r'[A-Z][a-zA-Z0-9_]*'
  t.type = reservadas.get(t.value, "NOMBRE_CLASE")
  return t

def t_contadorLineas(t):
    r'\n+'
    t.lexer.lineno += t.value.count("\n")
    
def t_error(t):
    print(f"Caracter no reconocido {t.value[0]} en línea {t.lineno}")
    t.lexer.skip(1)

def t_comentario(t):
  r'\# .*'

def t_cadena(t):
  r'".*\"'
  t.type = reservadas.get(t.value, "CADENA")
  return t

def t_variable(t):
  r'([a-z]|_)[a-zA-Z0-9]*'
  t.type = reservadas.get(t.value, "VARIABLE")
  return t

validador = lexico.lex()

def getTokens(lexer):
    while True:
        tok = lexer.token()
        if not tok:
            break 
        print(tok)

linea=" "
codigo = open("source.rb")
for linea in codigo:
  validador.input(linea)
  getTokens(validador)
codigo.close()

print("Análisis terminado... :)")